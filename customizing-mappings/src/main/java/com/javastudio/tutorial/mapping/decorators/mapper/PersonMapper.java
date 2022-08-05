package com.javastudio.tutorial.mapping.decorators.mapper;

import com.javastudio.tutorial.mapping.decorators.model.Address;
import com.javastudio.tutorial.mapping.decorators.model.AddressDto;
import com.javastudio.tutorial.mapping.decorators.model.Person;
import com.javastudio.tutorial.mapping.decorators.model.PersonDto;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
@DecoratedWith(PersonMapperDecorator.class)
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    PersonDto map(Person person);

    AddressDto map(Address address);
}
