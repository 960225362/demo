//package com.example.demo.common.lock;
//
//import lombok.extern.slf4j.Slf4j;
//import org.apache.zookeeper.*;
//import org.apache.zookeeper.data.Stat;
//
//import java.util.concurrent.CountDownLatch;
//import java.util.concurrent.TimeUnit;
//
///**
// * zookeeper创建临时 znode
// *
// * @author huyue01@sinovatech.com 2019/7/7 17:06
// */
//@Slf4j
//public class ZookeeperLocker {
//    private static CountDownLatch connectedSemaphore = new CountDownLatch(1);
//    private ZooKeeper zooKeeper;
//    private CountDownLatch latch;
//
//    private ZookeeperLocker() {
//        try {
//            this.zooKeeper = new ZooKeeper("", 50000, new ZooKeeperWatcher());
//            connectedSemaphore.await();
//            log.info("zookeeper is init finish");
//        } catch (Exception e) {
//            log.error("zookeeper init error msg:{}", e.getMessage());
//        }
//    }
//
//
//    /**
//     * 获取锁
//     *
//     * @param productId
//     * @return
//     */
//    public boolean acquireDistributedLock(long productId) {
//        String path = "/product-lock-" + productId;
//        try {
//            zooKeeper.create(path, "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
//            return true;
//        } catch (Exception e) {
//            while (true) {
//
//                try {
//
//                    Stat stat = zooKeeper.exists(path, true);
//                    if (null != stat) {
//                        this.latch = new CountDownLatch(1);
//                        this.latch.await(3000, TimeUnit.MICROSECONDS);
//                        zooKeeper.create(path, "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
//                        return true;
//                    }
//                } catch (Exception er) {
//                    log.error("acquireDistributedLock error msg:{}", er.getMessage());
//                }
//            }
//        }
//    }
//
//
//    /**
//     * 释放锁
//     *
//     * @param productId
//     */
//    public void releaseDistributedLock(long productId) {
//        String path = "/product-lock-" + productId;
//        try {
//            zooKeeper.delete(path, -1);
//            log.info("release the lock for product[id=" + productId + "]......");
//        } catch (Exception e) {
//            log.info("releaseDistributedLock error msg：{}", e.getMessage());
//        }
//    }
//
//
//    /**
//     * 监听器（内部类）
//     */
//    private class ZooKeeperWatcher implements Watcher {
//        @Override
//        public void process(WatchedEvent event) {
//            log.info("Receive watched event: " + event.getState());
//            if (Event.KeeperState.SyncConnected == event.getState()) {
//                connectedSemaphore.countDown();
//            }
//            if (new ZookeeperLocker().latch != null) {
//                new ZookeeperLocker().latch.countDown();
//            }
//        }
//    }
//
//
//    /**
//     * 获取单例
//     */
//    private static class Singleton {
//        private static ZookeeperLocker instance;
//
//        static {
//            instance = new ZookeeperLocker();
//        }
//
//        private static ZookeeperLocker getInstance() {
//            return instance;
//        }
//    }
//
//    public static ZookeeperLocker getInstance() {
//        return Singleton.getInstance();
//    }
//
//
//}
