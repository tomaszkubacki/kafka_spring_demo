package org.kafkaspring.demo.controller

import org.kafkaspring.demo.customer.infra.web.CustomerController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class CustomerControllerSpec extends Specification {

    @Autowired
    CustomerController messageController

    def "context test"() {
        expect:
        messageController != null
    }
}
