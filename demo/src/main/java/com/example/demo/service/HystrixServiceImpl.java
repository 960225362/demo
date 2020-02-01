package com.example.demo.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author huyue01@sinovatech.com 2019/9/14 18:05
 */
@Service
@Slf4j
public class HystrixServiceImpl {

    @HystrixCommand(
            fallbackMethod = "fallBackTestHystrix",
            threadPoolProperties = {  //10个核心线程池,超过20个的队列外的请求被拒绝; 当一切都是正常的时候，线程池一般仅会有1到2个线程激活来提供服务
                    @HystrixProperty(name = "coreSize", value = "10"),
                    @HystrixProperty(name = "maxQueueSize", value = "100"),
                    @HystrixProperty(name = "queueSizeRejectionThreshold", value = "20")},
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "500"), //命令执行超时时间
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "2"), //若干10s一个窗口内失败三次, 则达到触发熔断的最少请求量
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000") //断路30s后尝试执行, 默认为5s
            })

//    @HystrixCommand(fallbackMethod = "fallBackTestHystrix",
//    commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "500"),
//            @HystrixProperty(name = "execution.isolation.semaphore.maxConcurrentRequests", value = "9"),
//            @HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "20"),
//            @HystrixProperty(name = "execution.isolation.strategy", value ="SEMAPHORE")
//    })


//    @HystrixCommand(fallbackMethod = "hiFail", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "500")
//    },
//            threadPoolProperties = {
//                    @HystrixProperty(name = "coreSize", value = "10"),
//                    @HystrixProperty(name = "maxQueueSize", value = "20"),
//                    @HystrixProperty(name = "keepAliveTimeMinutes", value = "0"),
//                    @HystrixProperty(name = "queueSizeRejectionThreshold", value = "15"),
//                    @HystrixProperty(name = "metrics.rollingStats.numBuckets", value = "12"),
//                    @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "1440")
//            })
    public String testHystrix(){
        try {
            log.info("开始睡眠");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("is commom testHystrix");
        return "is commom testHystrix";
    }


    public String fallBackTestHystrix(){
        log.info("走降级策略");
        return "is fallBackTestHystrix";
    }
}
