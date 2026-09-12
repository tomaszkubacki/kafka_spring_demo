package org.kafkaspring.demo.customer.infra.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;



@Component
@Slf4j
public class CustomerListeners {

    @KafkaListener(topics = "customer-added")
    public void customerAddedListener(String data) {
        log.info("customer listener: {}", data);
    }

}
