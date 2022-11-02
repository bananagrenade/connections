package com.abe.demo.domains;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;

import java.util.List;


@Data
@EqualsAndHashCode(callSuper = true)
public class Instructor extends Person {

    public List<String> topics;

}