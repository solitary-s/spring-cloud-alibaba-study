package com.aloneness.spring.cloud.alibaba.nacos.provider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private ConfigurableApplicationContext applicationContext;


    @GetMapping(value = "/user/name")
    public String sayHi() {
        return "Hello " + applicationContext.getEnvironment().getProperty("user.name");
    }

    @GetMapping("/hello/{message}")
    public String hello(@PathVariable("message") String message) {
        return String.format("Hello, Nocas %s", message);
    }

}
