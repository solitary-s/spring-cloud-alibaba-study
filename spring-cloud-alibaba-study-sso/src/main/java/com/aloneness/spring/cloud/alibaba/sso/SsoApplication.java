package com.aloneness.spring.cloud.alibaba.sso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * SSO
 *
 * @author aloneness
 * @date 2020/7/2
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class SsoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SsoApplication.class, args);
    }
}
