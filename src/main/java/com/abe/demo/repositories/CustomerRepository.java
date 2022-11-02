package com.abe.demo.repositories;

import java.util.List;

import com.abe.demo.domains.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {

    List<Customer> findAll();

}