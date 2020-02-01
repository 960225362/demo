package com.example.demo.common.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author huyue01@sinovatech.com 2019/7/21 16:17
 */
@Data
@Component
@ConfigurationProperties(prefix = "curator")
public class WrapperZk {
    private int retryCount;
    private int elapsedTimeMs;
    private String connectString;
    private int sessionTimeoutMs;
    private int connectionTimeoutMs;
}
