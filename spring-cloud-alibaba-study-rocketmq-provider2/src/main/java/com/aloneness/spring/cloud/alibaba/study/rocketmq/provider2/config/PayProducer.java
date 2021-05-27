package com.aloneness.spring.cloud.alibaba.study.rocketmq.provider2.config;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.stereotype.Component;

@Component
public class PayProducer {

    /**
     * 生产组，生产者必须在生产组内
     */
    private String producerGroup = "broker-a";

    /**
     * 端口
     */
    private String nameServer = "1.14.135.143:9876";

    private DefaultMQProducer producer;

    public PayProducer() {
        producer = new DefaultMQProducer(producerGroup);
        producer.setNamesrvAddr(nameServer);
        start();

    }

    public DefaultMQProducer getProducer() {
        return producer;
    }

    public void start() {
        try {
            this.producer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }
    }

    public void shutdown() {
        producer.shutdown();
    }
}
