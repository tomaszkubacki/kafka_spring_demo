package org.kafkaspring.demo.service;

import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.kafkaspring.demo.dto.CreateUser;
import org.kafkaspring.demo.dto.UserAdded;
import org.springframework.stereotype.Service;

import java.util.Properties;
import java.util.UUID;

import static java.time.LocalDateTime.now;
import static org.kafkaspring.demo.config.Topics.USER_FCT_USER_ADDED;

@Service
public class UserService {

    private KafkaAvroSerializer avroProducer;


    public UUID publishUserAddedInJson(CreateUser createUser) {
        var userAdded = new UserAdded(UUID.randomUUID(), createUser.userName(), now());
        Producer<String, UserAdded> producer = getUserAddedProducer();
        String topic = USER_FCT_USER_ADDED;
        String key = userAdded.id().toString();
        ProducerRecord<String, UserAdded> record = new ProducerRecord<>(topic, key, userAdded);
        producer.send(record);
        producer.close();
        return userAdded.id();
    }
// https://github.com/confluentinc/examples/blob/7.5.0-post/clients/avro/src/main/java/io/confluent/examples/clients/basicavro/ProducerExample.java
//    public String publishAvroMessage(){
//        String key = "key1";
//        String userSchema = """
//                    {
//                      "type":"record",
//                      "name":"user",
//                      "fields": [ {"name":"Alfred", "type":"string"},{"surname":"Tarski","type":"string"}]
//                    }
//                """;
//        Schema.Parser parser = new Schema.Parser();
//        Schema schema = parser.parse(userSchema);
//        GenericRecord avroRecord = new GenericData.Record(schema);
//        avroRecord.put("f1", "f1");
//        avroRecord.put("f2", "f2");
//        avroKafkaTemplate.send(MESSAGE_TOPIC, avroRecord);
//        return String.format("publishing on topic %s on key %s data: %s", MESSAGE_TOPIC, "key", avroRecord);
//    }

    private static Producer<String, UserAdded> getUserAddedProducer() {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:29092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.StringSerializer");
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                "io.confluent.kafka.serializers.json.KafkaJsonSchemaSerializer");
        props.put("schema.registry.url", "http://localhost:8085");

        return new KafkaProducer<>(props);
    }



}
