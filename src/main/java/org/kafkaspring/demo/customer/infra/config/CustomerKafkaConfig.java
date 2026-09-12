package org.kafkaspring.demo.customer.infra.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class CustomerKafkaConfig {

    @Bean
    public NewTopic customerAddedTopic() {
        return TopicBuilder.name("customer-added")
                .partitions(6)
                .replicas(1)
                .build();
    }

}
