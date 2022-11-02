package com.abe.demo.assemblers;

import com.abe.demo.domains.Customer;
import com.abe.demo.resources.CustomerResource;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class CustomerModelAssembler implements RepresentationModelAssembler<Customer, EntityModel<Customer>> {

    @Override
    public EntityModel<Customer> toModel(Customer customer) {

        return EntityModel.of(customer,
                linkTo(methodOn(CustomerResource.class).one(customer.getId())).withSelfRel(),
                linkTo(methodOn(CustomerResource.class).all()).withRel("customers"));
    }
}
