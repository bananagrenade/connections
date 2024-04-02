package com.abe.connections.resources;

import com.abe.connections.assemblers.UserModelAssembler;
import com.abe.connections.models.domains.persons.User;
import com.abe.connections.services.UserService.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserResource {

    private final UserService userService;
    private final UserModelAssembler userModelAssembler;

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody @Valid User user) {

        log.info("Creating a new {}", user.getUserType());

        User savedUser = userService.createUser(user);
        EntityModel<User> savedUserEntityModel = userModelAssembler.toModel(userService.createUser(user));

        log.info("Created a new {} with id={}",
                savedUser.getUserType(),
                savedUser.getUserId());

        return ResponseEntity
                .created(savedUserEntityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(savedUser);
    }

//    @GetMapping("/{id}")
//    public EntityModel<Customer> one(@PathVariable UUID id) {
//
//        log.info("Fetching customer by customerId={}", id);
//
//        Customer customer = userService.getCustomerById(id);
//
//        return userModelAssembler.toModel(custousermer);
//    }

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
