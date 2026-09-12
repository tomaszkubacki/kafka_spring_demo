package org.kafkaspring.demo.listener

import org.apache.avro.Schema
import org.apache.avro.generic.GenericData
import org.apache.avro.generic.GenericDatumWriter
import org.apache.avro.io.EncoderFactory
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.kafkaspring.demo.customer.infra.listener.CustomerListeners
import spock.lang.Specification

class CustomerListenersSpec extends Specification {

    CustomerListeners customerListeners = new CustomerListeners()

    def "should deserialize raw avro byte array payload"() {
        given:
        String schemaJson = """
            {
              "type": "record",
              "name": "Customer",
              "namespace": "org.kafkaspring.demo.customer",
              "fields": [
                {"name": "name", "type": "string"},
                {"name": "email", "type": "string"}
              ]
            }
            """
        Schema schema = new Schema.Parser().parse(schemaJson)
        GenericData.Record record = new GenericData.Record(schema)
        record.put("name", "John Doe")
        record.put("email", "john@example.com")

        ByteArrayOutputStream out = new ByteArrayOutputStream()
        var encoder = EncoderFactory.get().binaryEncoder(out, null)
        var writer = new GenericDatumWriter<>(schema)
        writer.write(record, encoder)
        encoder.flush()

        byte[] payload = out.toByteArray()
        ConsumerRecord<String, byte[]> consumerRecord = new ConsumerRecord<>("customer-added", 0, 0L, "cust-1", payload)

        when:
        customerListeners.customerAddedListener(consumerRecord)

        then:
        noExceptionThrown()
    }
}
