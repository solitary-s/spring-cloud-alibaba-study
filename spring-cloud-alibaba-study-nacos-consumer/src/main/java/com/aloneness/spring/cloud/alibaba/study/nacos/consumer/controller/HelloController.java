package com.aloneness.spring.cloud.alibaba.study.nacos.consumer.controller;

import com.aloneness.spring.cloud.alibaba.study.nacos.consumer.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping("/hi")
    public String hello() {
        return helloService.hello("Hi Feign Consumer");
    }
}
