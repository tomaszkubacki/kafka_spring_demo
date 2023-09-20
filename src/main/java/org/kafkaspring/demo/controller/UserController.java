package org.kafkaspring.demo.controller;

import lombok.RequiredArgsConstructor;
import org.kafkaspring.demo.dto.CreateUser;
import org.kafkaspring.demo.dto.UserAdded;
import org.kafkaspring.demo.service.UserService;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    private final KafkaTemplate<String, UserAdded> userAddedTemplate;
    private final UserService userService;

    @GetMapping
    public String getUser(){

        return "Users";
    }

    @PostMapping()
    public UUID createUser(@RequestBody CreateUser createUser) {
        return userService.publishUserAddedInJson(createUser);
    }


    @PostMapping("/avro-message")
    public String publishAvroMessage(@RequestBody CreateUser createUser) {

    }

}
