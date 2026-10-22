package com.javastudio.tutorial.mapping.mapper;

import com.javastudio.tutorial.mapping.entity.OrderEntity;
import com.javastudio.tutorial.mapping.entity.OrderLineEntity;
import com.javastudio.tutorial.mapping.model.Order;
import com.javastudio.tutorial.mapping.model.OrderLine;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    Order toDto(OrderEntity entity, @Context CycleAvoidingMappingContext context);

    OrderLine toDto(OrderLineEntity entity, @Context CycleAvoidingMappingContext context);

    List<Order> toDtos(List<OrderEntity> entities, @Context CycleAvoidingMappingContext context);

    @Named("map")
    default Order map(OrderEntity entity) {
        return toDto(entity, new CycleAvoidingMappingContext());
    }

    @Named("mapAll")
    default List<Order> mapAll(List<OrderEntity> entities) {
        return toDtos(entities, new CycleAvoidingMappingContext());
    }
}
