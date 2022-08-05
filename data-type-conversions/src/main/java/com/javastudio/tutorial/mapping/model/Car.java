package com.javastudio.tutorial.mapping.model;

import lombok.Data;

import java.util.Date;

@Data
public class Car {
    String model;
    Date manufacturedDate;
    Person owner;
}
