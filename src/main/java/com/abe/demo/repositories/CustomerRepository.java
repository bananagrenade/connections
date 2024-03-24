package com.abe.demo.repositories;

import com.abe.demo.domains.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

public interface CustomerRepository extends MongoRepository<Customer, UUID> {
    List<Customer> findAll();

}