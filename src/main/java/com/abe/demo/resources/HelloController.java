package com.abe.demo.resources;

import com.abe.demo.domains.Customer;
import com.abe.demo.domains.Person;
import com.abe.demo.domains.Studio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class HelloController {

    @GetMapping("/")
    public List<?> index() {


        List<Customer> customerList = new ArrayList<>();

        Person person = new Person();
        person.setId(UUID.randomUUID());
        person.setFirstName("firstName");
        person.setLastName("lastName");

        Studio studio = new Studio();
        studio.setId(UUID.randomUUID());
        studio.setName("studio name");

        customerList.add(person);
        customerList.add(studio);

        System.out.println(customerList);
        return customerList;
    }

}