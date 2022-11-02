package com.abe.demo.domains;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeName("studio")
@EqualsAndHashCode(callSuper = true)
public class Studio extends Customer {

    @ToString.Exclude
    @NotBlank(message = "Name must not be empty")
    @Size(max = 32, min = 2)
    public String name;

}