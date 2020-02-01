package com.example.demo.common.configuration;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryNTimes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

/**
 * @author huyue01@sinovatech.com 2019/7/21 16:19
 */
public class ZkConfiguration {
    @Autowired
    WrapperZk wrapperZk;

    @Bean(initMethod = "start")
    public CuratorFramework curatorFramework() {
        return CuratorFrameworkFactory.newClient(wrapperZk.getConnectString(), wrapperZk.getSessionTimeoutMs(), wrapperZk.getConnectionTimeoutMs(), new RetryNTimes(wrapperZk.getRetryCount(), wrapperZk.getElapsedTimeMs()));
    }


}
