package com.abe.connections.models.domains;

import com.abe.connections.annotations.ValidEmail;
import com.abe.connections.annotations.ValidName;
import com.abe.connections.annotations.ValidUsername;
import com.abe.connections.models.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class User {

    @ToString.Exclude
    @ValidUsername
    private String username;

    private UserType userType;

    @ToString.Exclude
//    @NotBlank
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
//
//    @ToString.Exclude
//    private InternationalAddress mailingAddress;
//
//    @ToString.Exclude
//    private InternationalAddress physicalAddress;
//
//    @ToString.Exclude
//    @ValidPhoneNumber
//    private String mobilePhoneNumber;
//
//    @ToString.Exclude
//    @ValidPhoneNumber
//    private String workPhoneNumber;

    public abstract UUID getId();

    public abstract UserType getUserType();
}
