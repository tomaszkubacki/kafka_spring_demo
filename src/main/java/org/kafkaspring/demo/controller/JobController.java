package org.kafkaspring.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class JobController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("/job/start/{topic}/{key}/{data}")
    public String hello(@PathVariable String topic, @PathVariable String key, @PathVariable String data) {
        kafkaTemplate.send(topic, key, data);
        return String.format("publishing on topic %s on key %s data: %s", topic, key, data);
    }

}
