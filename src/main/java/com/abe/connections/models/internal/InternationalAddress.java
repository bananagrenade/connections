package com.abe.connections.models.internal;

import com.abe.connections.annotations.ValidCountryCode;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Locale;

@Data
@NoArgsConstructor
// todo: add validations
public class InternationalAddress {

    @ToString.Exclude
    private String streetAddress;

    @ToString.Exclude
    private String city;

    @ToString.Exclude
    private String stateProvince;

    @ToString.Exclude
    private String postalCode;

    @ToString.Exclude
    @ValidCountryCode
    private Locale.IsoCountryCode country;

}
