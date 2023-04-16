package org.kafkaspring.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MessageController {

    @GetMapping("/streams/start/{producerName}/{topic}/{message}")
    public String hello(@PathVariable String producerName, @PathVariable String topic, @PathVariable String message) {
        return String.format("Started %s publishing on topic %s message: %s", producerName, topic, message);
    }

}
