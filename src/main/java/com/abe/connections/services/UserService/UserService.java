package com.abe.connections.services.UserService;

import com.abe.connections.models.domains.persons.User;

import java.util.UUID;

public interface UserService {

    User createUser(User user);

    User getUserById(UUID id);

}
