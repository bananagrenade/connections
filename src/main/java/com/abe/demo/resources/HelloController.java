package com.abe.demo.resources;

import com.abe.demo.domains.Customer;
import com.abe.demo.domains.Person;
import com.abe.demo.domains.Studio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {

    @GetMapping("/")
    public List<?> index() {


        List<Customer> customerList = new ArrayList<>();

        Person person = new Person();
        person.setId("123");
        person.setFirstName("firstName");
        person.setLastName("lastName");

        Studio studio = new Studio();
        studio.setId("123");
        studio.setName("studio name");

        customerList.add(person);
        customerList.add(studio);

        System.out.println(customerList);
        return customerList;
    }

}