package com.javastudio.tutorial.mapping.mapper;

import com.javastudio.tutorial.mapping.model.Person;
import com.javastudio.tutorial.mapping.model.PersonDTO;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Locale;

@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    Person map(PersonDTO dto);

    PersonDTO map(Person person);

    PersonDTO map(Person person, @Context Locale locale);

}
