package com.abe.connections.models.domains.persons;

import com.abe.connections.models.enums.UserType;

public class Agent extends User {
    @Override
    public UserType getUserType() {
        return UserType.AGENT;
    }
}
