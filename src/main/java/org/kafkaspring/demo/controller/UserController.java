package org.kafkaspring.demo.controller;

import lombok.RequiredArgsConstructor;
import org.kafkaspring.demo.dto.CreateUser;
import org.kafkaspring.demo.dto.UserAdded;
import org.kafkaspring.demo.service.UserService;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;




@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    private final KafkaTemplate<String, UserAdded> userAddedTemplate;
    private final UserService userService;


    @PostMapping()
    public UUID publishMessage(@RequestBody CreateUser createUser) {
        return userService.addUser(createUser);
    }


//    @PostMapping("/avro-message")
//    public String publishAvroMessage(@RequestBody CreateUser createUser) {
////        new Message(MESSAGE_TOPIC,0,"key","value")
//        String key = "key1";
//        String userSchema = """
//                    {
//                      "type":"record",
//                      "name":"myrecord",
//                      "fields": [ {"name":"f1", "type":"string"},{"name":"f2","type":"string"}]
//                    }
//                """;
//        Schema.Parser parser = new Schema.Parser();
//        Schema schema = parser.parse(userSchema);
//        GenericRecord avroRecord = new GenericData.Record(schema);
//        avroRecord.put("f1", "value1");
//        avroRecord.put("f2", "zxczc");
//        avroKafkaTemplate.send(MESSAGE_TOPIC, avroRecord);
//        return String.format("publishing on topic %s on key %s data: %s", MESSAGE_TOPIC, "key", avroRecord);
//    }

}
