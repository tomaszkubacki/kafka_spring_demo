package org.kafkaspring.demo.dto;

import io.confluent.kafka.schemaregistry.annotations.Schema;

import java.time.LocalDateTime;
import java.util.UUID;

@Schema(value = """
        {
          "$schema": "http://json-schema.org/draft-07/schema#",
          "$id": "http://json-schema.org/draft-07/schema#",
         
          "properties": {
            "id": {
              "type": "string",
              "format": "uuid"
            },
             "userName": {
              "type": "string"
            },
             "dateTime": {
              "type": "string"
            }
          }
        }""", refs = {})
public record UserAdded(UUID id, String userName, LocalDateTime dateTime) {

}

