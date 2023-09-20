package org.kafkaspring.demo.service;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.streams.state.ReadOnlyKeyValueStore;
import org.springframework.kafka.config.StreamsBuilderFactoryBean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.apache.kafka.streams.StoreQueryParameters.fromNameAndType;
import static org.apache.kafka.streams.state.QueryableStoreTypes.keyValueStore;
import static org.kafkaspring.demo.config.Stores.CURRENCY_STORE;

@Service
@RequiredArgsConstructor
public class CurrencyService {

    final StreamsBuilderFactoryBean streamsBuilderFactoryBean;

    public List<String> getCurrencies() {
        ReadOnlyKeyValueStore<String, String> store = streamsBuilderFactoryBean
                .getKafkaStreams()
                .store(fromNameAndType(CURRENCY_STORE, keyValueStore()));
        List<String> result = new ArrayList<>();
        store.all().forEachRemaining(r -> result.add(r.value));
        return result;
    }
}
