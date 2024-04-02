package com.abe.connections.models.domains.persons;

import com.abe.connections.models.enums.PersonType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Guest extends Person {

    @Override
    public PersonType getPersonType() {
        return PersonType.GUEST;
    }
}
