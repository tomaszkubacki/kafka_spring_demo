package org.kafkaspring.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.kafkaspring.demo.configuration.KafkaTopicConfig.JOB_TOPIC;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class JobController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("/job/{key}/{data}")
    public String hello(@PathVariable String key, @PathVariable String data) {
        kafkaTemplate.send(JOB_TOPIC, key, data);
        return String.format("publishing on topic %s on key %s data: %s", JOB_TOPIC, key, data);
    }

}
