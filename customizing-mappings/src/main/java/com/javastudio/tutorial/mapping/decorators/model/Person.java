package com.javastudio.tutorial.mapping.decorators.model;

import lombok.Data;

@Data
public class Person {

    String firstName;
    String lastName;

    Address address;

}
