package com.aloneness.spring.cloud.alibaba.sso.service.fallback;

import com.aloneness.spring.cloud.alibaba.sso.service.RedisService;
import org.springframework.stereotype.Component;

/**
 * @author aloneness
 * @date 2020/7/2
 */
@Component
public class RedisServiceFallback implements RedisService {
    @Override
    public String put(String key, String value, long seconds) {
        System.out.println("put fallback");
        return null;
    }

    @Override
    public String get(String key) {
        System.out.println("get fallback");
        return null;
    }
}
