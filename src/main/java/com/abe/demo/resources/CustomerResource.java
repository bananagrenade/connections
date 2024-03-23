package com.abe.demo.resources;

import com.abe.demo.assemblers.CustomerModelAssembler;
import com.abe.demo.domains.Customer;
import com.abe.demo.repositories.CustomerRepository;
import com.abe.demo.services.CustomerService.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Slf4j
@RestController
@RequestMapping("/customers")
@AllArgsConstructor
public class CustomerResource {

    private final CustomerRepository customerRepository;
    private final CustomerModelAssembler customerModelAssembler;
    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<?> newCustomer(@RequestBody @Valid Customer customer) {

        log.info("Creating customer");

        EntityModel<Customer> savedCustomer = customerModelAssembler
                .toModel(
                        customerService.createCustomer(customer));

        log.info("Created customer with customerId={}", customer.getId());

        return ResponseEntity
                .created(savedCustomer.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(savedCustomer);
    }

    @GetMapping("/{id}")
    public EntityModel<Customer> one(@PathVariable UUID id) {

        log.info("Fetching customer by customerId={}", id);

        Customer customer = customerService.getCustomerByCustomerId(id);

        return customerModelAssembler.toModel(customer);
    }

    @GetMapping
    public CollectionModel<EntityModel<Customer>> all() {

        List<EntityModel<Customer>> customers = customerRepository.findAll().stream()
                .map(customerModelAssembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(customers, linkTo(methodOn(CustomerResource.class).all()).withSelfRel());
    }
//    @DeleteMapping("/{id}")
//    ResponseEntity<?> deleteCustomer(@PathVariable String id) {
//
//        customerRepository.deleteById(id);
//
//        return ResponseEntity.noContent().build();
//    }
//
//    @DeleteMapping
//    ResponseEntity<?> deleteAllCustomers() {
//
//        customerRepository.deleteAll();
//
//        return ResponseEntity.noContent().build();
//    }

}
