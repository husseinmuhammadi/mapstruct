package com.javastudio.tutorial.mapping.mapper;

import com.javastudio.tutorial.mapping.model.Car;
import com.javastudio.tutorial.mapping.model.CarDTO;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Locale;

@Mapper(uses = PersonMapper.class)
public interface CarMapper {

    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    Car map(CarDTO dto);

    CarDTO map(Car car);

//    @Mapping(target = "description", source = "desc")
//    CarDTO map(Car car, String desc, String address);

    CarDTO map(Car car, @Context Locale locale);
}
