package com.abe.connections.repositories;

import com.abe.connections.models.domains.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

public interface CustomerRepository extends MongoRepository<Customer, UUID> {
    List<Customer> findAll();

}