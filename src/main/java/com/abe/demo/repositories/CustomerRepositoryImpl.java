package com.abe.demo.repositories;


import com.abe.demo.domains.Customer;
import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;

import java.util.UUID;

public class CustomerRepositoryImpl<T extends Customer>
        extends SimpleMongoRepository<T, UUID> implements CustomerRepository<T> {

    @Override
    public <S extends T> S save(S entity) {
        generateId(entity);
        return super.save(entity);
    }

}
