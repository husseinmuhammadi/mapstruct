package com.javastudio.tutorial.mapping.hooks.mapper;

import com.javastudio.tutorial.mapping.hooks.model.Car;
import com.javastudio.tutorial.mapping.hooks.model.CarDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

class VehicleMapperTest {

    VehicleMapper mapper;

    @BeforeEach
    void setUp() {
        mapper= Mappers.getMapper(VehicleMapper.class);
    }

    @Test
    void mapCarToCarDto(){
        assertNotNull(mapper);

        Car car = new Car();
        car.setFuelType("Diesel");
        car.setTankCapacity(100);

        CarDto dto = mapper.map(car);

    }

}