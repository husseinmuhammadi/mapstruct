package com.javastudio.tutorial.mapping.mapper

import com.javastudio.tutorial.mapping.entity.OrderEntity
import com.javastudio.tutorial.mapping.entity.OrderLineEntity
import com.javastudio.tutorial.mapping.model.Order
import com.javastudio.tutorial.mapping.model.OrderLine
import org.mapstruct.Context
import org.mapstruct.Mapper
import org.mapstruct.Named
import org.mapstruct.factory.Mappers

@Mapper
interface OrderMapper {

    fun toDto(entity: OrderEntity, @Context context: CycleAvoidingMappingContext): Order

    fun toDto(entity: OrderLineEntity, @Context context: CycleAvoidingMappingContext): OrderLine

    fun toDtos(entities: List<OrderEntity>, @Context context: CycleAvoidingMappingContext): List<Order>

    @Named("map")
    fun map(entity: OrderEntity): Order = toDto(entity, CycleAvoidingMappingContext())

    @Named("mapAll")
    fun mapAll(entities: List<OrderEntity>): List<Order> = toDtos(entities, CycleAvoidingMappingContext())

    companion object {
        @JvmField
        val INSTANCE: OrderMapper = Mappers.getMapper(OrderMapper::class.java)
    }
}
