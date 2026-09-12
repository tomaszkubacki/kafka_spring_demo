package org.kafkaspring.demo.message.infra.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class MessageListeners {

    @KafkaListener(topics = "message-received")
    public void messageReceivedListener(String data) {
        log.info("message listener: {}", data);
    }

}
