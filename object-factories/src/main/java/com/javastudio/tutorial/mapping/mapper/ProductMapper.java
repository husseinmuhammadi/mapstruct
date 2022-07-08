package com.javastudio.tutorial.mapping.mapper;

import com.javastudio.tutorial.mapping.factory.DtoFactory;
import com.javastudio.tutorial.mapping.factory.EntityFactory;
import com.javastudio.tutorial.mapping.model.Product;
import com.javastudio.tutorial.mapping.model.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {DtoFactory.class, EntityFactory.class})
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductEntity map(Product product);

    Product map(ProductEntity productEntity);
}
