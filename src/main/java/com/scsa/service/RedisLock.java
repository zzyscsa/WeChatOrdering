package com.scsa.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * Redis锁
 * @Author: SCSA
 * @Date: 2020/8/6 17:54
 */
@Component
@Slf4j
public class RedisLock {

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 加锁
     * @param key
     * @param value 时间：当前时间+超时时间
     * @return
     */
    public boolean lock(String key, String value) {
        if (redisTemplate.opsForValue().setIfAbsent(key, value)){
            //setnx，可设置就返回true
            return true;
        }

        //如果这个锁没办法解锁的处理
        String currentValue = redisTemplate.opsForValue().get(key);
        //如果锁过期，因为对应的value值就是到期时间，小于当前时间说明过期
        if (!StringUtils.isEmpty(currentValue) && Long.parseLong(currentValue) < System.currentTimeMillis()) {
            //获取上一个锁的时间，并且把新的锁加上去
            String oldValue = redisTemplate.opsForValue().getAndSet(key, value);
            //这里如果有两个线程同时抢这个锁，就只有一个线程能够锁上，
            //因为第二个线程获得的oldValue就是第一个线程刚刚set的value,必不会等于currentValue
            if (!StringUtils.isEmpty(oldValue) && oldValue.equals(currentValue)) {
                return true;
            }
        }

        return false;
    }


    /**
     * 解锁
     * @param key
     * @param value
     */
    public void unlock(String key, String value) {
        try {
            String currentValue = redisTemplate.opsForValue().get(key);
            if (!StringUtils.isEmpty(currentValue) && currentValue.equals(value)) {
                redisTemplate.opsForValue().getOperations().delete(key);
            }
        } catch (Exception e) {
            log.error("【redis分布式锁】解锁异常，{}", e);
        }
    }
}
