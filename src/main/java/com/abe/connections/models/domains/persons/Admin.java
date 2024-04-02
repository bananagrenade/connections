package com.abe.connections.models.domains.persons;

import com.abe.connections.models.enums.UserType;
import com.abe.connections.resources.UserResource;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.springframework.hateoas.EntityModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@JsonTypeName("admin")
public class Admin extends User {
    @Override
    public UserType getUserType() {
        return UserType.ADMIN;
    }

    @Override
    public EntityModel<User> toModel() {
        EntityModel<User> userModel = EntityModel.of(this);
        userModel.add(linkTo(methodOn(UserResource.class).createUser(this)).withSelfRel());
        return userModel;
    }
}
