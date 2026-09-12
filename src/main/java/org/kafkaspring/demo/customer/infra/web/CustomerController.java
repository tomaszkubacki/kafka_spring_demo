package org.kafkaspring.demo.customer.infra.web;

import lombok.RequiredArgsConstructor;
import org.kafkaspring.demo.customer.domain.Customer;
import org.kafkaspring.demo.customer.domain.CreateCustomer;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class CustomerController {

    @GetMapping
    public String getUser(){
        return "Users";
    }

    @PostMapping()
    public Customer createUser(@RequestBody CreateCustomer createCustomer) {
        return new Customer(createCustomer.name(), createCustomer.email());
    }

}
