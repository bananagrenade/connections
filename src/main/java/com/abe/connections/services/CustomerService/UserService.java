package com.abe.connections.services.CustomerService;

import com.abe.connections.models.domains.persons.User;

import java.util.UUID;

public interface UserService {

    User createUser(User user);

    User getUserById(UUID id);

}
