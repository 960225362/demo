//package com.example.demo.common.lock;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import redis.clients.jedis.Jedis;
//import redis.clients.jedis.JedisPool;
//
///**
// * @author  2019/7/7 15:49
// */
//public class RedisLocker {
//    @Autowired
//    private JedisPool jedisPool;
//
//    /**
//     * 获取锁
//     *
//     * @param key
//     * @param value
//     * @param leaseTime 过期时间
//     * @return
//     */
//    public boolean tryLock(String key, String value, long leaseTime) {
//        try (Jedis jedis = jedisPool.getResource()) {
//            if (jedis == null) {
//                return false;
//            }
//            String result = jedis.set(key, value, "NX", "PX", leaseTime);
//            return "OK".equalsIgnoreCase(result);
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    /**
//     * 释放锁 0：释放失败
//     * @param key
//     * @param value
//     * @return
//     */
//    public int unlock(String key, String value) {
//        try (Jedis jedis = jedisPool.getResource()) {
//            if (jedis == null) {
//                return 0;
//            }
//            StringBuilder builder = new StringBuilder();
//            builder.append("if redis.call('get','")
//                    .append(key)
//                    .append("')")
//                    .append("=='")
//                    .append(" then ")
//                    .append("  return redis.call('del','")
//                    .append(key)
//                    .append("')")
//                    .append(" else ")
//                    .append(" return 0")
//                    .append(" end");
//            return Integer.valueOf(jedis.eval(builder.toString()).toString());
//        }catch (Exception e){
//            return 0;
//        }
//    }
//
//
//}
