package com.abe.demo.domains;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import org.springframework.data.annotation.Id;


@Data
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "customerType"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Person.class, name = "person"),
        @JsonSubTypes.Type(value = Studio.class, name = "studio"),
})
public abstract class Customer {

    @Id
    public String id;

}