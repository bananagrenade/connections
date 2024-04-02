package com.abe.connections.models.domains.businesses;

import com.abe.connections.models.domains.persons.User;
import com.abe.connections.models.enums.BusinessType;
import com.abe.connections.models.internal.InternationalAddress;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;


@Data
@Document(collection = "businesses")
public abstract class Business {

    @Id
    private UUID businessId;

    private List<User> customers;

    private BusinessType businessType;

    private String businessName;

    private List<InternationalAddress> businessLocations;

    private List<Comment> comments;

    private Review reviews;

}
