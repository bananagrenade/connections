package com.abe.connections.validators;

import com.abe.connections.annotations.ValidCountryCode;
import com.abe.connections.annotations.ValidEmail;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Pattern;

import static java.util.Locale.getISOCountries;

public class CountryCodeValidator implements ConstraintValidator<ValidCountryCode, String> {

    @Override
    public void initialize(ValidCountryCode constraintAnnotation) {
    }

    @Override
    public boolean isValid(String countryCode, ConstraintValidatorContext constraintValidatorContext) {
        Set<String> countryCodes = getISOCountries(Locale.IsoCountryCode.PART1_ALPHA3);
        return countryCode != null && countryCodes.contains(countryCode);
    }
}
