package com.abe.connections.models.domains;

import com.abe.connections.models.enums.BusinessType;
import com.abe.connections.models.enums.UserType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;


@Data
@Document(collection = "businesses")
@EqualsAndHashCode(callSuper = true)
public class Business extends User {

    @Id
    private UUID businessId;

    private BusinessType businessType;

    @Override
    public UUID getId() {
        return this.getBusinessId();
    }

    @Override
    public UserType getUserType() {
        return UserType.BUSINESS;
    }
}
