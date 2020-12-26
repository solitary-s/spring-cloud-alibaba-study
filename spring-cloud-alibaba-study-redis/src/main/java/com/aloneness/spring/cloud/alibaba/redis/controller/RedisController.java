package com.aloneness.spring.cloud.alibaba.redis.controller;

import com.aloneness.spring.cloud.alibaba.redis.service.IRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Redis Controller
 *
 * @author aloneness
 * @date 2020/7/1
 */
@RestController
public class RedisController {

    @Autowired
    private IRedisService redisService;

    @PostMapping("/put")
    public String put(String key, String value, long seconds) {
        redisService.set(key, value, seconds);
        return "OK";
    }

    @GetMapping("/get")
    public String get(String key) {
        String json = null;
        Object obj = redisService.get(key);
        if (obj != null) {
            json = (String) redisService.get(key);
            return json;
        }
        return null;
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
