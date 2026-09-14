package org.kafkaspring.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class KafkaSpringDemoApplication {

    static void main(String[] args) {
        SpringApplication.run(KafkaSpringDemoApplication.class, args);
    }

}
