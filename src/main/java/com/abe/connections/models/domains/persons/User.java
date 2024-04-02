package com.abe.connections.models.domains.persons;

import com.abe.connections.annotations.ValidEmail;
import com.abe.connections.annotations.ValidName;
import com.abe.connections.annotations.ValidPhoneNumber;
import com.abe.connections.models.enums.PersonType;
import com.abe.connections.models.enums.UserType;
import com.abe.connections.models.internal.InternationalAddress;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.springframework.hateoas.EntityModel;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "userType")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Admin.class, name = "admin"),
        @JsonSubTypes.Type(value = Agent.class, name = "agent"),
        @JsonSubTypes.Type(value = Customer.class, name = "customer"),
        @JsonSubTypes.Type(value = Employee.class, name = "employee"),
})
public abstract class User extends Person {

//    @ToString.Exclude
//    @ValidUsername
//    private String username;

    private UUID userId;

    private UserType userType;

    @ToString.Exclude
    @NotBlank
    private String password;

    @ToString.Exclude
    @ValidName
    private String firstName;

    @ToString.Exclude
    @ValidName
    private String lastName;

    @ToString.Exclude
    @ValidEmail
    private String email;

    @ToString.Exclude
    private InternationalAddress mailingAddress;

    @ToString.Exclude
    private InternationalAddress physicalAddress;

    @ToString.Exclude
    @NotBlank
    @ValidPhoneNumber
    private String mobilePhoneNumber;

    @ToString.Exclude
    @ValidPhoneNumber
    private String workPhoneNumber;

    public abstract UserType getUserType();

    @Override
    public PersonType getPersonType() {
        return PersonType.USER;
    }

    public abstract EntityModel<User> toModel();

}
