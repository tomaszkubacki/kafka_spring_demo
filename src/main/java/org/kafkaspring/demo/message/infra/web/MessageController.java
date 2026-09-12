package org.kafkaspring.demo.message.infra.web;

import lombok.RequiredArgsConstructor;
import org.kafkaspring.demo.message.domain.Message;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/message")
@RequiredArgsConstructor
public class MessageController {

    @PostMapping()
    public Message addMessage(@RequestBody Message message) {
        return  message;
    }

}
