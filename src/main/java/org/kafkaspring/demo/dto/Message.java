package org.kafkaspring.demo.dto;

import jakarta.annotation.Nullable;

public record Message(String topic, @Nullable Integer partition, @Nullable String key, String value) {
}

