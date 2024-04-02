package com.abe.connections.models.domains.persons;

import com.abe.connections.models.domains.businesses.Business;
import com.abe.connections.models.enums.UserType;

import java.util.HashSet;

// A customer can optionally own a business
public class Customer extends User {
    private HashSet<Business> ownedBusinesses;
    // businesses that have a relationship with the customer
    private HashSet<Business> connectedBusinesses;
    private UserType currentUserType;

    @Override
    public UserType getUserType() {
        return UserType.CUSTOMER;
    }
}
