package com.abe.connections.models.domains;

import com.abe.connections.models.enums.UserType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;


@Data
@Document(collection = "customers")
@EqualsAndHashCode(callSuper = true)
public class Customer extends User {

    @Id
    private UUID customerId;

    @Override
    public UUID getId() {
        return this.getCustomerId();
    }

    @Override
    public UserType getUserType() {
        return UserType.CUSTOMER;
    }
}