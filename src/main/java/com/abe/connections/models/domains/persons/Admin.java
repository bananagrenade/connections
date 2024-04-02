package com.abe.connections.models.domains.persons;

import com.abe.connections.models.enums.UserType;

public class Admin extends User {
    @Override
    public UserType getUserType() {
        return UserType.ADMIN;
    }
}
