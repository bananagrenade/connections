package com.abe.connections.models.domains.persons;

import com.abe.connections.models.domains.businesses.Business;
import com.abe.connections.models.enums.UserType;
import com.abe.connections.resources.UserResource;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.springframework.hateoas.EntityModel;

import java.util.HashSet;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@JsonTypeName("customer")
public class Customer extends User {
    private HashSet<Business> ownedBusinesses;
    private HashSet<Business> connectedBusinesses;
    private UserType currentUserType;

    @Override
    public UserType getUserType() {
        return UserType.CUSTOMER;
    }

    @Override
    public EntityModel<User> toModel() {
        EntityModel<User> userModel = EntityModel.of(this);
        userModel.add(linkTo(methodOn(UserResource.class).createUser(this)).withSelfRel());
        return userModel;
    }
}
