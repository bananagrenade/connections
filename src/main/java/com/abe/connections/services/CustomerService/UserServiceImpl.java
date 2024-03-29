package com.abe.connections.services.CustomerService;

import com.abe.connections.models.domains.Business;
import com.abe.connections.models.domains.Customer;
import com.abe.connections.models.domains.User;
import com.abe.connections.repositories.BusinessRepository;
import com.abe.connections.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final CustomerRepository customerRepository;
    private final BusinessRepository businessRepository;


    @Autowired
    public UserServiceImpl(CustomerRepository customerRepository,
                           BusinessRepository businessRepository) {

        this.customerRepository = customerRepository;
        this.businessRepository = businessRepository;
    }

    public User createUser(User user) {
        switch (user.getUserType()) {
            case BUSINESS:
                Business business = (Business) user;
                business.setBusinessId(UUID.randomUUID());

                return businessRepository.save(business);
            case CUSTOMER:
                Customer customer = (Customer) user;
                customer.setCustomerId(UUID.randomUUID());

                return customerRepository.save(customer);
            case GUEST:
            default:
                throw new RuntimeException(String.format("userType=%s is currently unsupported", user.getUserType()));
        }
    }

    public User getUserById(UUID id) {
        return customerRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }
}
