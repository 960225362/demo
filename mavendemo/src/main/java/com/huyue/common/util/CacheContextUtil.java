package com.huyue.common.util;

import javafx.application.Application;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Context工具类
 *
 * @author .com 2019/3/24 23:17
 */
@Component
public class CacheContextUtil implements ApplicationContextAware {
    private static ApplicationContext context;

    @SuppressWarnings("AccessStaticViaInstance")
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    public static Object getBean(String beanId) {
        return context.getBean(beanId);
    }

    public static <T> T getBean(String beanId, Class<T> clazz) {
        return context.getBean(beanId, clazz);
    }
}
