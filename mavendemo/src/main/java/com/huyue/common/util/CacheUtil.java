package com.huyue.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.*;
import java.util.concurrent.TimeUnit;


/**
 * redis工具类
 *
 * @author .com 2019/3/24 23:10
 */
@SuppressWarnings("unchecked")
public class CacheUtil {
    private static final Logger log = LoggerFactory.getLogger(CacheUtil.class);
    private static RedisTemplate<String, Object> redisTemplate = CacheContextUtil.getBean("redisTemplate", RedisTemplate.class);
    private static StringRedisTemplate stringRedisTemplate = CacheContextUtil.getBean("stringRedisTemplate", StringRedisTemplate.class);
    private static String CACHE_PROFIX;
    private static boolean CACHE_CLOSED;

    public CacheUtil() {
    }

    private static boolean isEmpty(Object object) {
        if (object == null) {
            return true;
        }
        if (object instanceof String) {
            String string = object.toString();
            if ("".equals(string.trim())) {
                return true;
            }
            return false;
        }
        if (object instanceof List) {
            List<Object> list = (List<Object>) object;
            if (list.isEmpty()) {
                return true;
            }
            return false;
        }
        if (object instanceof Map) {
            Map map = (Map) object;
            if (map.isEmpty()) {
                return true;
            }
            return false;
        }
        if (object instanceof Set) {
            Set set = (Set) object;
            if (set.isEmpty()) {
                return true;
            }
            return false;
        }
        if (object instanceof Object[]) {
            Object[] objects = (Object[]) object;
            if (objects.length <= 0) {
                return true;
            }
            return false;
        }
        return false;
    }

    /**
     * 构建缓存key
     *
     * @param key
     * @return
     */
    private static String buildKey(String key) {
        if (CACHE_PROFIX == null || "".equals(CACHE_PROFIX)) {
            return key;
        }
        return CACHE_PROFIX + ":" + key;
    }

    /**
     * 返回缓存前缀
     *
     * @return
     */
    public static String getCacheProfix() {
        return CACHE_PROFIX;
    }

    /**
     * 设置缓存前缀
     *
     * @param cacheProfix
     */
    public static void setCacheProfix(String cacheProfix) {
        if (cacheProfix != null && !"".equals(cacheProfix.trim())) {
            CACHE_PROFIX = cacheProfix.trim();
        }
    }

    /**
     * 关闭缓存
     *
     * @return
     */
    public static boolean close() {
        log.info("=====cache closed=====");
        CACHE_CLOSED = true;
        return true;
    }

    /**
     * 打开缓存
     *
     * @return
     */
    public static boolean open() {
        log.info("=====cache open=====");
        CACHE_CLOSED = false;
        return true;
    }

    /**
     * 检查缓存是否开启
     *
     * @return
     */
    public static boolean isClose() {
        return CACHE_CLOSED;
    }

    /**
     * 判断key值是否存在
     *
     * @param key
     * @return
     */
    public static boolean hasKey(String key) {
        log.info(" haskey key:" + key);
        try {
            if (isClose() || isEmpty(key)) {
                return false;
            }
            return redisTemplate.hasKey(buildKey(key));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return false;
    }

    /**
     * 匹配符合正则的key
     *
     * @param patterKey
     * @return
     */
    public static Set<String> keys(String patterKey) {
        log.info("keys key:" + patterKey);
        try {
            if (isClose() || isEmpty(patterKey)) {
                return Collections.emptySet();
            }
            return redisTemplate.keys(patterKey);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return Collections.emptySet();
    }

    /**
     * 根据key删除缓存
     *
     * @param key
     * @return
     */
    public static boolean delete(String... key) {
        log.info("delete key:" + key.toString());
        try {
            if (isClose() || isEmpty(key)) {
                return false;
            }
            Set<String> keySet = new HashSet<String>();
            for (String str : key) {
                keySet.add(buildKey(str));
            }
            redisTemplate.delete(keySet);
            return true;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return false;
    }

    /**
     * 根据key删除缓存
     *
     * @param key
     * @return
     */
    public static boolean delete(String key) {
        log.info("delete key:" + key);
        try {
            if (isClose() || isEmpty(key)) {
                return false;
            }
            redisTemplate.delete(redisTemplate.keys(buildKey(key)));
            return true;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return false;
    }

    /**
     * 删除一组key值
     *
     * @param keys
     * @return
     */
    public static boolean delete(Set<String> keys) {
        log.info("delete key:" + keys.toString());
        try {
            if (isClose() || isEmpty(keys)) {
                return false;
            }
            Set<String> keySet = new HashSet<String>();
            for (String str : keys) {
                keySet.add(buildKey(str));
            }
            redisTemplate.delete(keySet);
            return true;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return false;
    }

    /**
     * 设置过期时间
     *
     * @param key
     * @param seconds
     * @return
     */
    public static boolean setExp(String key, long seconds) {
        log.info("setExp key:" + key + " seconds:" + seconds);
        try {
            if (isClose() || isEmpty(key) || seconds <= 0) {
                return false;
            }
            return redisTemplate.expire(buildKey(key), seconds, TimeUnit.SECONDS);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return false;
    }

    /**
     * 查询过期时间
     *
     * @param key
     * @return
     */
    public static Long getExpire(String key) {
        log.info(" getExpire key:" + key);
        try {
            if (isClose() || isEmpty(key)) {
                return 0L;
            }
            return redisTemplate.getExpire(buildKey(key), TimeUnit.SECONDS);
        } catch (Exception e) {
            log.info(e.getMessage(), e);
        }
        return 0L;
    }

    /**
     * 缓存存入key—value
     *
     * @param key
     * @param value
     * @return
     */
    public static boolean setString(String key, String value) {
        log.info("setString key:" + key + " value:" + value);
        try {
            if (isClose() || isEmpty(key) || isEmpty(value)) {
                return false;
            }
            stringRedisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return false;
    }

    /**
     * 缓存存入key—value
     *
     * @param key
     * @param value
     * @param seconds
     * @return
     */
    public static boolean setString(String key, String value, long seconds) {
        log.info("setString key:" + key + " value:" + value + " seconds:" + seconds);
        try {
            if (isClose() || isEmpty(key) || isEmpty(value)) {
                return false;
            }
            stringRedisTemplate.opsForValue().set(key, value, seconds);
            return true;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return false;
    }

    /**
     * 根据key取出String value
     *
     * @param key
     * @return
     */
    public static String getString(String key) {
        log.info("getString key:" + key);
        try {
            if (isClose() || isEmpty(key)) {
                return null;
            }
            return stringRedisTemplate.opsForValue().get(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * 去的缓存中的最大值并+1
     *
     * @param key 缓存key值
     * @return long    缓存中的最大值+1
     */
    public static long incr(String key) {
        log.debug(" incr key :{}", key);
        try {
            if (isClose() || isEmpty(key)) {
                return 0;
            }
            key = buildKey(key);
            return redisTemplate.opsForValue().increment(key, 1);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return 0;
    }

    /**
     * 缓存中存入序列化的Object对象
     *
     * @param key 缓存key
     * @param obj 存入的序列化对象
     * @return true:成功 false:失败
     */
    public static boolean set(String key, Object obj) {
        log.debug(" set key :{}, value:{}", key, obj);
        try {
            if (isClose() || isEmpty(key) || isEmpty(obj)) {
                return false;
            }
            key = buildKey(key);
            redisTemplate.opsForValue().set(key, obj);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return false;
    }

    /**
     * 缓存中存入序列化的Object对象
     *
     * @param key 缓存key
     * @param obj 存入的序列化对象
     * @return true:成功 false:失败
     */
    public static boolean setObj(String key, Object obj, long seconds) {
        log.debug(" set key :{}, value:{}, seconds:{}", key, obj, seconds);
        try {
            if (isClose() || isEmpty(key) || isEmpty(obj)) {
                return false;
            }
            key = buildKey(key);
            redisTemplate.opsForValue().set(key, obj);
            if (seconds > 0) {
                redisTemplate.expire(key, seconds, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return false;
    }

    /**
     * 取出缓存中存储的序列化对象
     *
     * @param key   缓存key
     * @param clazz 对象类
     * @return <T>	序列化对象
     */
    public static <T> T getObj(String key, Class<T> clazz) {
        log.debug(" get key :{}", key);
        try {
            if (isClose() || isEmpty(key)) {
                return null;
            }
            key = buildKey(key);
            return (T) redisTemplate.opsForValue().get(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * 存入Map数组
     *
     * @param <T>
     * @param key 缓存key
     * @param map 缓存map
     * @return true:成功 false:失败
     */
    public static <T> boolean setMap(String key, Map<String, T> map) {
        try {
            if (isClose() || isEmpty(key) || isEmpty(map)) {
                return false;
            }
            key = buildKey(key);
            redisTemplate.opsForHash().putAll(key, map);
            return true;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return false;
    }

    /**
     * 取出缓存的map
     *
     * @param key 缓存key
     * @return map    缓存的map
     */
    @SuppressWarnings("rawtypes")
    public static Map getMap(String key) {
        log.debug(" getMap key :{}", key);
        try {
            if (isClose() || isEmpty(key)) {
                return null;
            }
            key = buildKey(key);
            return redisTemplate.opsForHash().entries(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * 查询缓存的map的集合大小
     *
     * @param key 缓存key
     * @return int    缓存map的集合大小
     */
    public static long getMapSize(String key) {
        log.debug(" getMap key :{}", key);
        try {
            if (isClose() || isEmpty(key)) {
                return 0;
            }
            key = buildKey(key);
            return redisTemplate.opsForHash().size(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return 0;
    }


    /**
     * 根据key以及hashKey取出对应的Object对象
     *
     * @param key     缓存key
     * @param hashKey 对应map的key
     * @return object    map中的对象
     */
    public static Object getMapKey(String key, String hashKey) {
        log.debug(" getMapkey :{}, hashKey:{}", key, hashKey);
        try {
            if (isClose() || isEmpty(key) || isEmpty(hashKey)) {
                return null;
            }
            key = buildKey(key);
            return redisTemplate.opsForHash().get(key, hashKey);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * 取出缓存中map的所有key值
     *
     * @param key 缓存key
     * @return Set<String> map的key值合集
     */
    public static Set<Object> getMapKeys(String key) {
        log.debug(" getMapKeys key :{}", key);
        try {
            if (isClose() || isEmpty(key)) {
                return null;
            }
            key = buildKey(key);
            return redisTemplate.opsForHash().keys(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * 删除map中指定的key值
     *
     * @param key     缓存key
     * @param hashKey map中指定的hashKey
     * @return true:成功 false:失败
     */
    public static boolean delMapKey(String key, String hashKey) {
        log.debug(" delMapKey key :{}, hashKey:{}", key, hashKey);
        try {
            if (isClose() || isEmpty(key) || isEmpty(hashKey)) {
                return false;
            }
            key = buildKey(key);
            redisTemplate.opsForHash().delete(key, hashKey);
            return true;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return false;
    }

    /**
     * 存入Map数组
     *
     * @param <T>
     * @param key     缓存key
     * @param map     缓存map
     * @param seconds 秒数
     * @return true:成功 false:失败
     */
    public static <T> boolean setMapExp(String key, Map<String, T> map, long seconds) {
        log.debug(" setMapExp key :{}, value: {}, seconds:{}", key, map, seconds);
        try {
            if (isClose() || isEmpty(key) || isEmpty(map)) {
                return false;
            }
            key = buildKey(key);
            redisTemplate.opsForHash().putAll(key, map);
            redisTemplate.expire(key, seconds, TimeUnit.SECONDS);
            return true;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return false;
    }

    /**
     * map中加入新的key
     *
     * @param <T>
     * @param key     缓存key
     * @param hashKey map的Key值
     * @param value   map的value值
     * @return true:成功 false:失败
     */
    public static <T> boolean addMap(String key, String hashKey, T value) {
        log.debug(" addMap key :{}, hashKey: {}, value:{}", key, hashKey, value);
        try {
            if (isClose() || isEmpty(key) || isEmpty(hashKey) || isEmpty(value)) {
                return false;
            }
            key = buildKey(key);
            redisTemplate.opsForHash().put(key, hashKey, value);
            return true;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return false;
    }

    /**
     * 缓存存入List
     *
     * @param <T>
     * @param key  缓存key
     * @param list 缓存List
     * @return true:成功 false:失败
     */
    public static <T> boolean setList(String key, List<T> list) {
        log.debug(" setList key :{}, list: {}", key, list);
        try {
            if (isClose() || isEmpty(key) || isEmpty(list)) {
                return false;
            }
            key = buildKey(key);
            redisTemplate.opsForList().leftPushAll(key, list.toArray());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return false;
    }

    /**
     * 根据key值取出对应的list合集
     *
     * @param key 缓存key
     * @return List<Object> 缓存中对应的list合集
     */
    public static <V> List<V> getList(String key) {
        log.debug(" getList key :{}", key);
        try {
            if (isClose() || isEmpty(key)) {
                return null;
            }
            key = buildKey(key);
            return (List<V>) redisTemplate.opsForList().range(key, 0, -1);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * 根据key值截取对应的list合集
     *
     * @param key   缓存key
     * @param start 开始位置
     * @param end   结束位置
     * @return
     */
    public static void trimList(String key, int start, int end) {
        log.debug(" trimList key :{}", key);
        try {
            if (isClose() || isEmpty(key)) {
                return;
            }
            key = buildKey(key);
            redisTemplate.opsForList().trim(key, start, end);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    /**
     * 取出list合集中指定位置的对象
     *
     * @param key   缓存key
     * @param index 索引位置
     * @return Object    list指定索引位置的对象
     */
    public static Object getIndexList(String key, int index) {
        log.debug(" getIndexList key :{}, index:{}", key, index);
        try {
            if (isClose() || isEmpty(key) || index < 0) {
                return null;
            }
            key = buildKey(key);
            return redisTemplate.opsForList().index(key, index);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * Object存入List
     *
     * @param key   缓存key
     * @param value List中的值
     * @return true:成功 false:失败
     */
    public static boolean addList(String key, Object value) {
        log.debug(" addList key :{}, value:{}", key, value);
        try {
            if (isClose() || isEmpty(key) || isEmpty(value)) {
                return false;
            }
            key = buildKey(key);
            redisTemplate.opsForList().leftPush(key, value);
            return true;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return false;
    }

    /**
     * 缓存存入List
     *
     * @param <T>
     * @param key     缓存key
     * @param list    缓存List
     * @param seconds 秒数
     * @return true:成功 false:失败
     */
    public static <T> boolean setList(String key, List<T> list, long seconds) {
        log.debug(" setList key :{}, value:{}, seconds:{}", key, list, seconds);
        try {
            if (isClose() || isEmpty(key) || isEmpty(list)) {
                return false;
            }
            key = buildKey(key);
            redisTemplate.opsForList().leftPushAll(key, list.toArray());
            if (seconds > 0) {
                redisTemplate.expire(key, seconds, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return false;
    }

    /**
     * set集合存入缓存
     *
     * @param <T>
     * @param key 缓存key
     * @param set 缓存set集合
     * @return true:成功 false:失败
     */
    public static <T> boolean setSet(String key, Set<T> set) {
        log.debug(" setSet key :{}, value:{}", key, set);
        try {
            if (isClose() || isEmpty(key) || isEmpty(set)) {
                return false;
            }
            key = buildKey(key);
            redisTemplate.opsForSet().add(key, set.toArray());
            return true;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return false;
    }

    /**
     * set集合中增加value
     *
     * @param key   缓存key
     * @param value 增加的value
     * @return true:成功 false:失败
     */
    public static boolean addSet(String key, Object value) {
        log.debug(" addSet key :{}, value:{}", key, value);
        try {
            if (isClose() || isEmpty(key) || isEmpty(value)) {
                return false;
            }
            key = buildKey(key);
            redisTemplate.opsForSet().add(key, value);
            return true;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return false;
    }

    /**
     * set集合存入缓存
     *
     * @param <T>
     * @param key     缓存key
     * @param set     缓存set集合
     * @param seconds 秒数
     * @return true:成功 false:失败
     */
    public static <T> boolean setSet(String key, Set<T> set, long seconds) {
        log.debug(" setSet key :{}, value:{}, seconds:{}", key, set, seconds);
        try {
            if (isClose() || isEmpty(key) || isEmpty(set)) {
                return false;
            }
            key = buildKey(key);
            redisTemplate.opsForSet().add(key, set.toArray());
            if (seconds > 0) {
                redisTemplate.expire(key, seconds, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return false;
    }

    /**
     * 取出缓存中对应的set合集
     *
     * @param <T>
     * @param key 缓存key
     * @return Set<Object> 缓存中的set合集
     */
    public static <T> Set<T> getSet(String key) {
        log.debug(" getSet key :{}", key);
        try {
            if (isClose() || isEmpty(key)) {
                return null;
            }
            key = buildKey(key);
            return (Set<T>) redisTemplate.opsForSet().members(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * 有序集合存入数值
     *
     * @param key   缓存key
     * @param value 缓存value
     * @param score 评分
     * @return
     */
    public static boolean addZSet(String key, Object value, double score) {
        log.debug(" addZSet key :{},value:{}, score:{}", key, value, score);
        try {
            if (isClose() || isEmpty(key) || isEmpty(value)) {
                return false;
            }
            key = buildKey(key);
            return redisTemplate.opsForZSet().add(key, value, score);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return false;
    }

    /**
     * 从有序集合中删除指定值
     *
     * @param key   缓存key
     * @param value 缓存value
     * @return
     */
    public static boolean removeZSet(String key, Object value) {
        log.debug(" removeZSet key :{},value:{}", key, value);
        try {
            if (isClose() || isEmpty(key) || isEmpty(value)) {
                return false;
            }
            key = buildKey(key);
            redisTemplate.opsForZSet().remove(key, value);
            return true;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return false;
    }

    /**
     * 从有序集合中删除指定位置的值
     *
     * @param key   缓存key
     * @param start 起始位置
     * @param end   结束为止
     * @return
     */
    public static boolean removeZSet(String key, long start, long end) {
        log.debug(" removeZSet key :{},start:{}, end:{}", key, start, end);
        try {
            if (isClose() || isEmpty(key)) {
                return false;
            }
            key = buildKey(key);
            redisTemplate.opsForZSet().removeRange(key, start, end);
            return true;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return false;
    }

    /**
     * 从有序集合中获取指定位置的值
     *
     * @param key   缓存key
     * @param start 起始位置
     * @param end   结束为止
     * @return
     */
    public static <T> Set<T> getZSet(String key, long start, long end) {
        log.debug(" getZSet key :{},start:{}, end:{}", key, start, end);
        try {
            if (isClose() || isEmpty(key)) {
                return Collections.emptySet();
            }
            key = buildKey(key);
            return (Set<T>) redisTemplate.opsForZSet().range(key, start, end);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return Collections.emptySet();
    }


}
