package org.kafkaspring.demo.customer.domain;


import lombok.RequiredArgsConstructor;
import org.kafkaspring.demo.customer.api.CustomerCreated;
import org.kafkaspring.demo.customer.infra.db.CustomerEntity;
import org.kafkaspring.demo.customer.infra.db.CustomerRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    final CustomerRepository customerRepository;
    final ApplicationEventPublisher applicationEventPublisher;

    public List<Customer> findAll() {
        return customerRepository
                .findAll()
                .stream()
                .map(c -> new Customer(c.getId(), c.getName(), c.getEmail())).toList();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public long createCustomer(String name, String email) {
        var customer = customerRepository.save(new CustomerEntity(null, name, email));
        applicationEventPublisher.publishEvent(new CustomerCreated(customer.getId(), customer.getName(), customer.getEmail()));
        return customer.getId();

    }

}
