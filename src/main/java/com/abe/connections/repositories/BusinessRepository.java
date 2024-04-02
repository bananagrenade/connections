package com.abe.connections.repositories;

import com.abe.connections.models.domains.businesses.Business;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

public interface BusinessRepository extends MongoRepository<Business, UUID> {
    List<Business> findAll();

}