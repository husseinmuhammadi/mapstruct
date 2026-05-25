package com.javastudio.tutorial.mapping.mapper;

import com.javastudio.tutorial.mapping.model.OrderLine;
import com.javastudio.tutorial.mapping.model.OrderLineEntity;
import com.javastudio.tutorial.mapping.model.Product;
import com.javastudio.tutorial.mapping.model.ProductEntity;
import org.mapstruct.Mapper;

@Mapper
public interface OrderLineMapper {

    OrderLineEntity map(OrderLine orderLine);
    ProductEntity map(Product product);
}
