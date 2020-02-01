//package com.example.demo.common.lock;
//
//import org.redisson.api.RLock;
//import org.redisson.api.RedissonClient;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.concurrent.TimeUnit;
//
///**
// * 基于redission的分布式实现
// *
// * @author huyue01@sinovatech.com 2019/7/7 15:20
// */
//@Component
//public class RedissonDistributedLocker {
//    @Autowired
//    private RedissonClient redissonClient;
//
//    /**
//     * 加锁
//     *
//     * @param lockKey
//     * @return
//     */
//    public RLock lock(String lockKey) {
//        RLock lock = redissonClient.getLock(lockKey);
//        lock.lock();
//        return lock;
//    }
//
//
//    /**
//     * 加锁，过期自动释放
//     *
//     * @param lockKey
//     * @param leaseTime
//     * @return
//     */
//    public RLock lock(String lockKey, long leaseTime) {
//        RLock lock = redissonClient.getLock(lockKey);
//        lock.lock(leaseTime, TimeUnit.SECONDS);
//        return lock;
//    }
//
//    /**
//     * 加锁，过期自动释放，传入时间单位
//     *
//     * @param lockKey
//     * @param leaseTime
//     * @param unit
//     * @return
//     */
//    public RLock lock(String lockKey, long leaseTime, TimeUnit unit) {
//        RLock lock = redissonClient.getLock(lockKey);
//        lock.lock(leaseTime, unit);
//        return lock;
//    }
//
//    /**
//     * 尝试获取锁，传入时间单位
//     *
//     * @param lockKey
//     * @param unit
//     * @param waitTime
//     * @param leaseTime
//     * @return
//     */
//    public boolean tryLock(String lockKey, TimeUnit unit, long waitTime, long leaseTime) {
//        RLock lock = redissonClient.getLock(lockKey);
//        try {
//            return lock.tryLock(waitTime, leaseTime, unit);
//        } catch (InterruptedException e) {
//            return false;
//        }
//    }
//
//    /**
//     * 尝试获取锁
//     *
//     * @param lockKey
//     * @param waitTime
//     * @param leaseTime
//     * @return
//     */
//    public boolean tryLock(String lockKey, long waitTime, long leaseTime) {
//        RLock lock = redissonClient.getLock(lockKey);
//        try {
//            return lock.tryLock(waitTime, leaseTime, TimeUnit.SECONDS);
//        } catch (InterruptedException e) {
//            return false;
//        }
//    }
//
//    /**
//     * 释放锁，传入key
//     *
//     * @param lockKey
//     */
//    public void unlock(String lockKey) {
//        redissonClient.getLock(lockKey).unlock();
//    }
//
//    /**
//     * 释放锁，传入lock
//     *
//     * @param lock
//     */
//    public void unlock(RLock lock) {
//        lock.unlock();
//    }
//}
