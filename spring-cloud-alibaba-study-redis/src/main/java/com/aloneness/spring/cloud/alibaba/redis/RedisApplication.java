package com.aloneness.spring.cloud.alibaba.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 *
 * @author aloneness
 * @date 2020/7/1
 */
@SpringBootApplication
@EnableDiscoveryClient
public class RedisApplication {
    public static void main(String[] args) {
        SpringApplication.run(RedisApplication.class, args);
    }
}
