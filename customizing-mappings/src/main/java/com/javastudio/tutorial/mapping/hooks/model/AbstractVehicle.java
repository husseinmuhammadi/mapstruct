package com.javastudio.tutorial.mapping.hooks.model;

public abstract class AbstractVehicle {
    private Integer tankCapacity;
    private String fuelType;

    public AbstractVehicle() {
        System.out.println("AbstractVehicle ctor");
    }

    public Integer getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(Integer tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }
}
