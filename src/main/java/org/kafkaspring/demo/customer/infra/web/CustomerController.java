package org.kafkaspring.demo.customer.infra.web;

import lombok.RequiredArgsConstructor;
import org.kafkaspring.demo.customer.domain.CreateCustomer;
import org.kafkaspring.demo.customer.domain.Customer;
import org.kafkaspring.demo.customer.domain.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class CustomerController {
    final CustomerService customerRepository;


    @GetMapping
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @PostMapping()
    public long crateCustomer(@RequestBody CreateCustomer createCustomer) {
        return customerRepository.createCustomer(createCustomer.name(), createCustomer.email());
    }

}
