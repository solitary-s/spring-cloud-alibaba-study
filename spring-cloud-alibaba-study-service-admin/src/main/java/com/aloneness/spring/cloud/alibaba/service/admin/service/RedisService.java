package com.aloneness.spring.cloud.alibaba.service.admin.service;

import com.aloneness.spring.cloud.alibaba.service.admin.service.fallback.RedisServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Redis
 *
 * @author aloneness
 * @date 2020/7/2
 */
@FeignClient(value = "redis-service", fallback = RedisServiceFallback.class)
public interface RedisService {

    @PostMapping(value = "/put")
    public String put(@RequestParam(value = "key") String key,
                      @RequestParam(value = "value") String value,
                      @RequestParam(value = "seconds") long seconds);

    @GetMapping(value = "/get")
    public String get(@RequestParam(value = "key") String key);
}