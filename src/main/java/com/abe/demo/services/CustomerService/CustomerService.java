package com.abe.demo.services.CustomerService;

import com.abe.demo.domains.Customer;

import java.util.UUID;

public interface CustomerService {

    Customer createCustomer(Customer customer);
    Customer getCustomerByCustomerId(UUID customerId);

}
