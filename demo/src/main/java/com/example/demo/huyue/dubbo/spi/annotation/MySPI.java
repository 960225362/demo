package com.example.demo.huyue.dubbo.spi.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @author huyue01@sinovatech.com 2020/1/5 16:44
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MySPI {
    /**
     * 缺省值为空
     *
     * @return
     */
    String value() default "";
}
