package com.aloneness.spring.cloud.alibaba.study.rocketmq.provider.service;

import com.aloneness.spring.cloud.alibaba.study.rocketmq.provider.config.MySource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

public class ProviderService {

    @Autowired
    private MySource source;

    public void send(String message) {
        source.output1().send(MessageBuilder.withPayload(message).build());
    }
}
