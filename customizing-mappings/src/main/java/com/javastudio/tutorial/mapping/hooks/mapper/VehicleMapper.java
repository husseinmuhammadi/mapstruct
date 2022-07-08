package com.javastudio.tutorial.mapping.hooks.mapper;

import com.javastudio.tutorial.mapping.hooks.model.*;
import org.mapstruct.AfterMapping;
import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public abstract class VehicleMapper {

    @BeforeMapping
    protected void flushEntity(AbstractVehicle vehicle) {
        // I would call my entity manager's flush() method here to make sure my entity
        // is populated with the right @Version before I let it map into the DTO
        System.out.println("Before mapping --> flush entity abstract vehicle");
    }

    @AfterMapping
    protected void fillTank(AbstractVehicle vehicle, @MappingTarget AbstractVehicleDto result) {
        System.out.print("After mapping --> ");
        result.fuelUp( new Fuel( vehicle.getTankCapacity(), vehicle.getFuelType() ) );
    }

    public abstract CarDto map(Car car);
}
