package org.kafkaspring.demo.message.infra.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.kafkaspring.demo.customer.api.CustomerCreated;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;


@Service
@Slf4j
@RequiredArgsConstructor
public class MessageListeners {

    final KafkaTemplate<String, String> kafkaTemplate;

    @Async
    @TransactionalEventListener
    public void on(CustomerCreated event) {
        log.info("Received event {}", event);
        kafkaTemplate.send("customer-added", event.toString());
    }

}
