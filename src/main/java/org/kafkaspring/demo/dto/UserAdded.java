package org.kafkaspring.demo.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record UserAdded(UUID id, String userName, LocalDateTime dateTime) {

}

