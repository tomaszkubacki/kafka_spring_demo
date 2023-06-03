package org.kafkaspring.demo.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration

public class KafkaTopicConfig {

    public static final String MESSAGE_TOPIC = "message-topic";

    @Bean
    public NewTopic messageTopic() {
        return TopicBuilder.name(MESSAGE_TOPIC)
                .partitions(2)
//                .compact()  // how many brokers should have topic replica ?
                .replicas(1)
                .build();
    }

}
