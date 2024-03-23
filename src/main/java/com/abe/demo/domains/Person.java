package com.abe.demo.domains;

import com.abe.demo.enums.PersonType;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonTypeName("person")
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "personType"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Instructor.class, name = "INSTRUCTOR"),
        @JsonSubTypes.Type(value = Student.class, name = "STUDENT"),
})
@EqualsAndHashCode(callSuper = true)
public class Person extends Customer {

    @ToString.Exclude
    @NotBlank(message = "First name must not be empty")
    @Size(max = 32, min = 2)
    public String firstName;

    @ToString.Exclude
    @NotBlank(message = "Last name must not be empty")
    @Size(max = 32, min = 2)
    public String lastName;

    public List<PersonType> roles;

    public List<Business> businesses;

    public List<Student> students;

    public List<Instructor> instructors;
}

