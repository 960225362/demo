package com.example.demo.huyue.dubbo.spi.loader;

import com.example.demo.huyue.dubbo.spi.annotation.MySPI;
import com.example.demo.huyue.dubbo.spi.utils.Holder;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Pattern;

/**
 * @author huyue01@sinovatech.com 2020/1/5 16:47
 */
public class MyExtensionLoader<T> {

    /**
     * 定义SPI文件的扫描路径，源码中设置了多个，这里我们只设置一个就行
     */
    private static final String SPI_DIRECTORY = "META-INF/my/";

    /**
     * 分割SPI上默认拓展点字符串用的
     */
    private static final Pattern NAME_SEPARATOR = Pattern.compile("\\s*[,]+\\s*");

    /**
     * 扩展点加载器的缓存
     */
    private static final ConcurrentHashMap<Class<?>, MyExtensionLoader<?>> EXTENSION_LOADERS = new ConcurrentHashMap<>();

    /**
     * 拓展点的缓存
     */
    private static final ConcurrentMap<Class<?>, Object> EXTENSION_INSTANCES = new ConcurrentHashMap<>();

    /**
     * 接口的class
     */
    private final Class<?> type;

    /**
     * 接口SPI默认的实现名
     */
    private String cacheDefaultName;

    /**
     * 异常记录
     */
    private Map<String, IllegalStateException> exceptions = new ConcurrentHashMap<>();

    //这两个缓存文字比较难描述,debug或者搜索一下调用就知道是缓存什么的了
    private final Holder<Map<String, Class<?>>> cachedClasses = new Holder<Map<String, Class<?>>>();
    private final ConcurrentMap<String, Holder<Object>> cachedInstances = new ConcurrentHashMap<String, Holder<Object>>();

    public MyExtensionLoader(Class<?> type) {
        this.type = type;
    }

    /**
     * 获取加载器
     *
     * @param type
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> MyExtensionLoader<T> getExtensionLoader(Class<T> type) {
        //判读扩展点是否为空
        if (null == type) {
            throw new IllegalArgumentException("Extension type == null");
        }
        //判断扩展点是不是接口
        if (!type.isInterface()) {
            throw new IllegalArgumentException("Extension type(" + type + ") is not interface!");
        }
        //校验是否添加SPI注解
        if (!type.isAnnotationPresent(MySPI.class)) {
            throw new IllegalArgumentException("Extension type(" + type +
                    ") is not extension, because WITHOUT @" + MySPI.class.getSimpleName() + " Annotation!");
        }
        //获取缓存中的加载器，如果不存在就新创建并加入缓存
        //每一个拓展点有且只有一个加载器与之对应
        MyExtensionLoader<T> loader = (MyExtensionLoader<T>) EXTENSION_LOADERS.get(type);
        if (null == loader) {
            EXTENSION_LOADERS.putIfAbsent(type, new MyExtensionLoader<>(type));
            loader = (MyExtensionLoader<T>) EXTENSION_LOADERS.get(type);
        }
        return loader;
    }


    @SuppressWarnings("unchecked")
    public T getExtension(String name) {
        if (StringUtils.isEmpty(name)) {
            throw new IllegalArgumentException("Extension name == null");
        }
        if ("true".equals(name)) {
            return getDefaultExtension();
        }

        Holder<Object> holder = cachedInstances.get(name);
        if (null == holder) {
            cachedInstances.putIfAbsent(name, new Holder<>());
            holder = cachedInstances.get(name);
        }
        Object instance = holder.getValue();
        if (null == instance) {
            synchronized (holder) {
                instance = holder.getValue();
                if (null == instance) {
                    instance = createExtension(name);
                    holder.setValue(instance);
                }
            }
        }
        return (T) instance;

    }

    /**
     * 根据获取到的拓展点class实例化成对象返回
     *
     * @param name
     * @return
     */
    @SuppressWarnings("unchecked")
    private T createExtension(String name) {
        Class<?> clazz = getExtensionClasses().get(name);
        if (null == clazz) {
            throw findException(name);
        }

        try {
            T instance = (T) EXTENSION_INSTANCES.get(clazz);
            if (null == instance) {
                EXTENSION_INSTANCES.putIfAbsent(clazz, clazz.newInstance());
                instance = (T) EXTENSION_INSTANCES.get(clazz);
            }
            return instance;
        } catch (Throwable t) {
            throw new IllegalStateException("Extension instance(name: " + name + ", class: " +
                    type + ")  could not be instantiated: " + t.getMessage(), t);
        }
    }

    /**
     * 异常展示
     *
     * @param name
     * @return
     */
    private IllegalStateException findException(String name) {
        for (Map.Entry<String, IllegalStateException> entry : exceptions.entrySet()) {
            if (entry.getKey().toLowerCase().contains(name.toLowerCase())) {
                return entry.getValue();
            }
        }
        StringBuilder buf = new StringBuilder("No such extension " + type.getName() + " by name " + name);

        int i = 1;
        for (Map.Entry<String, IllegalStateException> entry : exceptions.entrySet()) {
            if (i == 1) {
                buf.append(", possible causes: ");
            }

            buf.append("\r\n(");
            buf.append(i++);
            buf.append(") ");
            buf.append(entry.getKey());
            buf.append(":\r\n");
            buf.append(entry.getValue().toString());
        }
        return new IllegalStateException(buf.toString());
    }

    /**
     * 获取默认拓展点
     *
     * @return
     */
    public T getDefaultExtension() {
        getExtensionClasses();
        if (null == cacheDefaultName || cacheDefaultName.length() == 0
                || "true".equals(cacheDefaultName)) {
            return null;
        }
        return getExtension(cacheDefaultName);
    }

    /**
     * 获取拓展点Class并缓存
     *
     * @return
     */
    private Map<String, Class<?>> getExtensionClasses() {
        Map<String, Class<?>> classes = cachedClasses.getValue();
        if (null == classes) {
            synchronized (cachedClasses) {
                classes = cachedClasses.getValue();
                if (null == classes) {
                    classes = loadExtensionClasses();
                    cachedClasses.setValue(classes);
                }
            }
        }
        return classes;
    }


    /**
     * 设置接口默认的实现类名并加载文件
     *
     * @return
     */
    private Map<String, Class<?>> loadExtensionClasses() {
        final MySPI defaultAnnotation = type.getAnnotation(MySPI.class);
        if (null != defaultAnnotation) {
            String value = defaultAnnotation.value().trim();
            if (value.length() > 0) {
                String[] names = NAME_SEPARATOR.split(value);
                if (names.length > 1) {
                    throw new IllegalStateException("more than 1 default extension name on extension " + type.getName()
                            + ": " + Arrays.toString(names));
                }
                if (names.length == 1) {
                    cacheDefaultName = names[0];
                }
            }
        }
        Map<String, Class<?>> extensionClasses = new HashMap<>();
        loadFile(extensionClasses, SPI_DIRECTORY);
        return extensionClasses;
    }

    /**
     * 加载SPI配置文件并加入缓存
     *
     * @param extensionClasses
     * @param dir
     */
    private void loadFile(Map<String, Class<?>> extensionClasses, String dir) {
        String fileName = dir + type.getName();
        try {
            Enumeration<URL> urls;
            ClassLoader classLoader = findClassLoader();
            if (classLoader != null) {
                urls = classLoader.getResources(fileName);
            } else {
                urls = ClassLoader.getSystemResources(fileName);
            }
            if (urls != null) {
                while (urls.hasMoreElements()) {
                    java.net.URL url = urls.nextElement();
                    try {
                        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), "utf-8"))) {
                            String line = null;
                            while ((line = reader.readLine()) != null) {
                                final int ci = line.indexOf('#');
                                if (ci >= 0) line = line.substring(0, ci);
                                line = line.trim();
                                if (line.length() > 0) {
                                    try {
                                        String name = null;
                                        int i = line.indexOf('=');
                                        if (i > 0) {
                                            name = line.substring(0, i).trim();
                                            line = line.substring(i + 1).trim();
                                        }
                                        if (line.length() > 0) {
                                            Class<?> clazz = Class.forName(line, true, classLoader);
                                            if (!type.isAssignableFrom(clazz)) {
                                                throw new IllegalStateException("Error when load extension class(interface: " +
                                                        type + ", class line: " + clazz.getName() + "), class "
                                                        + clazz.getName() + "is not subtype of interface.");
                                            }
                                            extensionClasses.put(name, clazz);//加入缓存
                                        }//源码中还有其他的判断,这个版本暂不实现
                                    } catch (Throwable t) {
                                        IllegalStateException e = new IllegalStateException("Failed to load extension class(interface: " + type + ", class line: " + line + ") in " + url + ", cause: " + t.getMessage(), t);
                                        exceptions.put(line, e);
                                    }
                                }
                            } // end of while read lines
                        }
                    } catch (Throwable t) {
                        //logger.error("Exception when load extension class(interface: " +
                        //        type + ", class file: " + url + ") in " + url, t);
                    }
                } // end of while urls
            }
        } catch (Throwable e) {
            //logger.error("Exception when load extension class(interface: " + type + ", description file: " + fileName + ").", e);
        }

    }

    /**
     * 获取类加载器
     */
    private static ClassLoader findClassLoader() {
        return MyExtensionLoader.class.getClassLoader();
    }

}
