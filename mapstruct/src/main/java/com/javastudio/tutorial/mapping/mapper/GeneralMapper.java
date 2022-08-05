package com.javastudio.tutorial.mapping.mapper;

import com.javastudio.tutorial.mapping.model.Employee;
import com.javastudio.tutorial.mapping.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Date;

@Mapper
public abstract class GeneralMapper {

    abstract Person toPerson(Employee employee);

    @Mapping(source = "startDate", target = "employmentDate")
    abstract Employee toEmployee(Person person, Date startDate);
}
