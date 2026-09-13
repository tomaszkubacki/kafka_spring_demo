package org.kafkaspring.demo.message.infra.web;

import lombok.RequiredArgsConstructor;
import org.kafkaspring.demo.message.domain.Message;
import org.kafkaspring.demo.message.infra.db.MessageEntity;
import org.kafkaspring.demo.message.infra.db.MessageRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/message")
@RequiredArgsConstructor
public class MessageController {

    final MessageRepository messageRepository;

    @PostMapping()
    public Message addMessage(@RequestBody Message message) {
        messageRepository.save(new MessageEntity(null, message.data(), LocalDateTime.now()));
        return message;
    }

    @GetMapping
    public List<MessageEntity> getMessages(){
        return messageRepository.findAllByOrderByTimestampDesc();
    }
}
