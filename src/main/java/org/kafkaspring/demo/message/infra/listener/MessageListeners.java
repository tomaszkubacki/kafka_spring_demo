package org.kafkaspring.demo.message.infra.listener;

import lombok.extern.slf4j.Slf4j;
import org.kafkaspring.demo.customer.api.CustomerCreated;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;


@Component
@Slf4j
public class MessageListeners {


    @Async
    @TransactionalEventListener
    public void on(CustomerCreated event) {
        log.info("Received event {}", event);
    }

}
