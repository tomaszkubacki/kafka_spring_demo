package org.kafkaspring.demo.stream;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.utils.Bytes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.GlobalKTable;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.state.KeyValueStore;
import org.kafkaspring.demo.config.Topics;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import static org.kafkaspring.demo.config.Stores.CURRENCY_STORE;

@Configuration
public class CurrencyStreamConfig {
    @Bean
    public GlobalKTable<String, String> currencyStream(StreamsBuilder builder){
       return builder.globalTable(Topics.SETTINGS_CDC_CURRENCY,
               Materialized.<String, String, KeyValueStore<Bytes, byte[]>>as(CURRENCY_STORE)
               .withKeySerde(Serdes.String())
               .withValueSerde(Serdes.String()));
    }

}
