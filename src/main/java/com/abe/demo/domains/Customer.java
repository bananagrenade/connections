package com.abe.demo.domains;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;


@Data
@Document(collection = "customers")
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "customerType"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Person.class, name = "PERSON"),
        @JsonSubTypes.Type(value = Studio.class, name = "STUDIO"),
})
public abstract class Customer {

    @Id
    public UUID id;

}