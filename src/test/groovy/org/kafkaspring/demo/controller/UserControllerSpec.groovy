package org.kafkaspring.demo.controller


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class UserControllerSpec extends Specification {

    @Autowired
    UserController messageController

    def "context test"() {
        expect:
        messageController != null
    }
}
