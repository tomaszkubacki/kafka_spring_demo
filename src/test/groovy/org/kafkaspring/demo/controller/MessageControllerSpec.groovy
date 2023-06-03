package org.kafkaspring.demo.controller


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class MessageControllerSpec extends Specification {

    @Autowired
    MessageController messageController

    def "context test"() {
        expect:
        messageController != null
    }
}
