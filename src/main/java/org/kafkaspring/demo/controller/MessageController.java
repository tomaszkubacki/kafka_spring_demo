package org.kafkaspring.demo.controller;

import lombok.RequiredArgsConstructor;
import org.kafkaspring.demo.dto.Message;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import static org.kafkaspring.demo.configuration.KafkaTopicConfig.MESSAGE_TOPIC;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MessageController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping("/message")
    public String publishMessage(@RequestBody Message message) {
        String key = message.key() != null ? message.key() : "";
        if (message.partition() != null) {
            kafkaTemplate.send(MESSAGE_TOPIC, message.partition(), key, message.value());
        } else {
            kafkaTemplate.send(MESSAGE_TOPIC, key, message.value());
        }
        return String.format("publishing on topic %s on key %s data: %s", MESSAGE_TOPIC, key, message.value());
    }

}
