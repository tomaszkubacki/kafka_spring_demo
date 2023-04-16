package org.kafkaspring.demo.controller


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class JobControllerSpec extends Specification {

    @Autowired
    JobController greetingController

    def "context test"() {
        expect:
        greetingController != null
    }
}
