package org.kafkaspring.demo.customer.infra.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericDatumReader;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.BinaryDecoder;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DecoderFactory;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
public class CustomerListeners {

    private static final String CUSTOMER_SCHEMA_JSON = """
            {
              "type": "record",
              "name": "Customer",
              "namespace": "org.kafkaspring.demo.customer",
              "fields": [
                {"name": "name", "type": "string"},
                {"name": "email", "type": "string"}
              ]
            }
            """;

    private final Schema schema = new Schema.Parser().parse(CUSTOMER_SCHEMA_JSON);
    private final DatumReader<GenericRecord> messageReader = new GenericDatumReader<>(schema);

    @KafkaListener(topics = "customer-added")
    public void customerAddedListener(ConsumerRecord<String, byte[]> record) {
        byte[] payload = record.value();
        log.info("customer listener received key: {}", record.key());
        if (payload != null) {
            try {
                int offset = (payload.length > 5 && payload[0] == 0) ? 5 : 0;
                BinaryDecoder decoder = DecoderFactory.get().binaryDecoder(payload, offset, payload.length - offset, null);
                GenericRecord avroRecord = messageReader.read(null, decoder);
                log.info("customer listener deserialized record: {}", avroRecord);
            } catch (IOException e) {
                log.error("Failed to deserialize Avro record", e);
            }
        }
    }

}

