package org.kafkaspring.demo.message.infra.db;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity(name = "message")
public class MessageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String data;

    private LocalDateTime timestamp;

    public Long getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public MessageEntity(Long id, String data, LocalDateTime timestamp) {
        this.id = id;
        this.data = data;
        this.timestamp = timestamp;
    }

    public MessageEntity() {}
}