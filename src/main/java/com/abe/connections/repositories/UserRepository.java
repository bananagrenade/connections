package com.abe.connections.repositories;

import com.abe.connections.models.domains.persons.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface UserRepository extends MongoRepository<User, UUID> {
}