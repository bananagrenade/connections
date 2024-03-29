package com.abe.connections.assemblers;

import com.abe.connections.models.domains.Customer;
import com.abe.connections.models.domains.User;
import com.abe.connections.resources.UserResource;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class UserModelAssembler implements RepresentationModelAssembler<User, EntityModel<User>> {

    @Override
    public EntityModel<User> toModel(User user) {

        return EntityModel.of(user,
                linkTo(methodOn(UserResource.class).newCustomer((Customer) user)).withSelfRel(),
                linkTo(methodOn(UserResource.class).one(user.getId())).withSelfRel());
    }

}
