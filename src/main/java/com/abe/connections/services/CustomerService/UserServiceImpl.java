package com.abe.connections.services.CustomerService;

import com.abe.connections.models.domains.persons.User;
import com.abe.connections.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepository userRepository;

    public User createUser(User user) {
        user.setUserId(UUID.randomUUID());
        return userRepository.insert(user);
    }

    public User getUserById(UUID id) {
        return userRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }
}
