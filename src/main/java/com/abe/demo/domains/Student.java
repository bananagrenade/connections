package com.abe.demo.domains;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;


@Data
@EqualsAndHashCode(callSuper = true)
public class Student extends Person {

    public List<Topic> interestedTopics;

    public List<Topic> enrolledTopics;

}