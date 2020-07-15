package com.aloneness.spring.cloud.alibaba.sso.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello/{name}")
    public String say(@PathVariable("name") String name) {
        return String.format("Hello, %s", name);
    }

}
