package com.abe.demo.repositories;

import com.abe.demo.domains.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface CustomerRepository<T extends BaseEntity> extends MongoRepository<T, Long> {
    List<Customer> findAll();

}