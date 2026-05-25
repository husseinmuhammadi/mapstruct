package com.javastudio.tutorial.mapping.mapper;

import com.javastudio.tutorial.mapping.model.OrderLine;
import com.javastudio.tutorial.mapping.model.OrderLineEntity;
import com.javastudio.tutorial.mapping.model.Product;
import com.javastudio.tutorial.mapping.model.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface OrderLineMapper {

    @Mapping(target = "orderId", source = "orderId")
    @Mapping(target = "packageWeight", source = "orderLine.weight")
    OrderLineEntity map(OrderLine orderLine, Long orderId);

    @Mapping(target = "productPrice", source = "price")
    ProductEntity map(Product product);
}
