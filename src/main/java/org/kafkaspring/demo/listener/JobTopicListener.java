package org.kafkaspring.demo.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import static org.kafkaspring.demo.configuration.KafkaTopicConfig.JOB_TOPIC;

@Component
@Slf4j
public class JobTopicListener {
    public static final String GROUP_ID = "my-app";

    @KafkaListener(groupId = GROUP_ID, topics = JOB_TOPIC)
    public void getJobMessage(String data) {
        log.info(data);
    }
}
