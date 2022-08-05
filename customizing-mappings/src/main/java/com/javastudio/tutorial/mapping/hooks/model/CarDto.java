package com.javastudio.tutorial.mapping.hooks.model;

import lombok.Data;

@Data
public class CarDto extends AbstractVehicleDto {

    String fuelType;
    Integer tankCapacity;

    String description;

    Object context;

    @Override
    public void fuelUp(Fuel fuel) {
        System.out.println("fueling up");
        this.fuelType = fuel.fuelType;
        this.tankCapacity = fuel.tankCapacity;
    }
}
