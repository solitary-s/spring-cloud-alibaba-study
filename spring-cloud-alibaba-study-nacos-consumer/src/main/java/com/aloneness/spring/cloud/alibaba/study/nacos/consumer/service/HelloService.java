package com.aloneness.spring.cloud.alibaba.study.nacos.consumer.service;

import com.aloneness.spring.cloud.alibaba.study.nacos.consumer.service.fallback.HelloServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "nacos-provider", fallback = HelloServiceFallback.class)
public interface HelloService {

    @GetMapping(value = "/hello/{message}")
    public String hello(@PathVariable("message") String message);
}
