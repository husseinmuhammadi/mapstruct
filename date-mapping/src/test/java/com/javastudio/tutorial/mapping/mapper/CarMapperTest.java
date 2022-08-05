package com.javastudio.tutorial.mapping.mapper;

import com.javastudio.tutorial.mapping.model.Car;
import com.javastudio.tutorial.mapping.model.CarDto;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CarMapperTest {

    CarMapper mapper = Mappers.getMapper(CarMapper.class);

    @Test
    void mapCarToCarDto(){
        Car car = new Car();
        car.setManufacturingDate(LocalDate.of(2012, 5, 21));
        CarDto carDto =  mapper.mapToCarDto(car);
        assertEquals("21.05.2012", carDto.getManufacturingDate());
    }


}