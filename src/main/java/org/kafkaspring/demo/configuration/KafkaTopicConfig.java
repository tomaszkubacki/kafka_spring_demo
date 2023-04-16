package org.kafkaspring.demo.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration

public class KafkaTopicConfig {

    public static final String JOB_TOPIC = "job-topic";

    @Bean
    public NewTopic jobTopic() {
        return TopicBuilder.name(JOB_TOPIC)
                .partitions(2)
                .compact()
                .replicas(1)
                .build();
    }

}
