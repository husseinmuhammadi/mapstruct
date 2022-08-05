package com.javastudio.tutorial.mapping.model;

import lombok.Data;

import java.util.Date;

@Data
public class CarDTO {
    String model;
    Date manufacturedDate;
    PersonDTO owner;
    String description;
    String address;
}
