package com.javastudio.tutorial.mapping.hooks.model;

import lombok.Data;

@Data
public class Car extends AbstractVehicle {

    public Car() {
        System.out.println("Car ctor");
    }
}
