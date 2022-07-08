package com.javastudio.tutorial.mapping.decorators.mapper;

import com.javastudio.tutorial.mapping.decorators.model.Person;
import com.javastudio.tutorial.mapping.decorators.model.PersonDto;
import org.mapstruct.Mapper;

public abstract class PersonMapperDecorator implements PersonMapper {

    private final PersonMapper delegate;

    public PersonMapperDecorator(PersonMapper delegate) {
        this.delegate = delegate;
    }


    @Override
    public PersonDto map(Person person) {
        PersonDto dto = delegate.map(person);
        dto.setFullName(person.getFirstName() + " " + person.getLastName());
        return dto;
    }


}
