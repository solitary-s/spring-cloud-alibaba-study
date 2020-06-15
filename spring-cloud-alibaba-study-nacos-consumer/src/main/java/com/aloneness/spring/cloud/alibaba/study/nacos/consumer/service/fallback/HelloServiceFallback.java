package com.aloneness.spring.cloud.alibaba.study.nacos.consumer.service.fallback;

import com.aloneness.spring.cloud.alibaba.study.nacos.consumer.service.HelloService;
import org.springframework.stereotype.Component;

@Component
public class HelloServiceFallback implements HelloService {

    @Override
    public String hello(String message) {
        return "Hello Fallback";
    }
}
