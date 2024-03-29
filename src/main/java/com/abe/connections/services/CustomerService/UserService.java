package com.abe.connections.services.CustomerService;

import com.abe.connections.models.domains.Customer;
import com.abe.connections.models.domains.User;

import java.util.UUID;

public interface UserService {

    User createUser(User user);

    Customer getCustomerById(UUID id);

}
