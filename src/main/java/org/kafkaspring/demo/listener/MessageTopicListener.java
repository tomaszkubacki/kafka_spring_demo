package org.kafkaspring.demo.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import static org.kafkaspring.demo.configuration.KafkaTopicConfig.MESSAGE_TOPIC;

@Component
@Slf4j
public class MessageTopicListener {
    public static final String GROUP_ID = "my-app";

    @KafkaListener(groupId = GROUP_ID, topics = MESSAGE_TOPIC)
    public void getMessage1(String data) {
        log.info("listener 1: {}", data);
    }

    @KafkaListener(groupId = GROUP_ID, topics = MESSAGE_TOPIC)
    public void getMessage2(String data) {
        log.info("listener 2: {}", data);
    }

    @KafkaListener(groupId = GROUP_ID, topics = MESSAGE_TOPIC)
    public void getMessage3(String data) {
        log.info("listener 3: {}", data);
    }
}
