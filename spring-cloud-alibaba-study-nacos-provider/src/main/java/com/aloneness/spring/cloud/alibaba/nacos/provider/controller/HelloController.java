package com.aloneness.spring.cloud.alibaba.nacos.provider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello/{message}")
    public String hello(@PathVariable("message") String message) {
        return String.format("Hello, Nocas %s", message);
    }

}
