package com.aloneness.spring.cloud.alibaba.redis.service.impl;

import com.aloneness.spring.cloud.alibaba.redis.service.IRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * Redis Service Impl
 *
 * @author aloneness
 * @date 2020/7/1
 */
@Service
public class RedisServiceImpl implements IRedisService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void set(String key, Object object, long seconds) {
        redisTemplate.opsForValue().set(key, object, seconds, TimeUnit.SECONDS);
    }

    @Override
    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    @Override
    public Object getAll() {
        return null;
    }
}
