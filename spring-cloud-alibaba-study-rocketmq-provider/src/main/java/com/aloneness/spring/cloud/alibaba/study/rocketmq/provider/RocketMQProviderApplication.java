package com.aloneness.spring.cloud.alibaba.study.rocketmq.provider;

import org.apache.rocketmq.common.message.MessageConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EnableBinding(value = {Source.class})
public class RocketMQProviderApplication implements CommandLineRunner {

    @Autowired
    private MessageChannel output;

    public static void main(String[] args) {
        SpringApplication.run(RocketMQProviderApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put(MessageConst.PROPERTY_KEYS, "tagStr");
        Message<String> message = MessageBuilder.createMessage("hello rocketMQ", new MessageHeaders(map));
        output.send(message);
    }
}