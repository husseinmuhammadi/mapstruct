package com.javastudio.tutorial.mapping.mapper;

import com.javastudio.tutorial.mapping.model.Car;
import com.javastudio.tutorial.mapping.model.CarDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.TargetType;

import java.lang.ref.Reference;

@Mapper(uses = DateMapper.class)
public interface CarMapper {

    @Mapping(target = "manufacturingDate", source = "manufacturingDate", dateFormat = "dd.MM.yyyy")
    @Mapping(target = "year", source = "manufacturingDate", qualifiedBy = {DateConvertor.class, DateToYearConvertor.class})
    CarDto mapToCarDto(Car car);


}
