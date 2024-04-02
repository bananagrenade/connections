package com.abe.connections.models.domains.persons;

import com.abe.connections.models.enums.PersonType;
import lombok.Data;

@Data
public abstract class Person {

    public abstract PersonType getPersonType();
}
