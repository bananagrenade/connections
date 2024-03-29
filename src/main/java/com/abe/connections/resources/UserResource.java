package com.abe.connections.resources;

import com.abe.connections.assemblers.UserModelAssembler;
import com.abe.connections.models.domains.Customer;
import com.abe.connections.models.domains.User;
import com.abe.connections.services.CustomerService.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserResource {

    private final UserService userService;
    private final UserModelAssembler userModelAssembler;

    @PostMapping
    public ResponseEntity<?> newCustomer(@RequestBody @Valid Customer customer) {

        log.info("Creating a new customer={}", customer.getUserType());

        User savedUser = userService.createUser(customer);
        EntityModel<User> savedUserEntityModel = userModelAssembler.toModel(userService.createUser(customer));

        log.info("Created {} with id={}",
                savedUser.getUserType(),
                savedUser.getId());

        return ResponseEntity
                .created(savedUserEntityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(savedUser);
    }

    @GetMapping("/{id}")
    public EntityModel<User> one(@PathVariable UUID id) {

        log.info("Fetching customer by customerId={}", id);

        User user = userService.getUserById(id);

        return userModelAssembler.toModel(user);
    }

//    @GetMapping
//    public CollectionModel<EntityModel<Customer>> all() {
//
//        List<EntityModel<Customer>> customers = customerRepository.findAll().stream()
//                .map(userModelAssembler::toModel)
//                .collect(Collectors.toList());
//
//        return CollectionModel.of(customers, linkTo(methodOn(UserResource.class).all()).withSelfRel());
//    }

}
