package org.kafkaspring.demo.customer.infra.db;

import org.jspecify.annotations.NonNull;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<CustomerEntity, Long> {

    @NonNull List<CustomerEntity> findAll();
}
