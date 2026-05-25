package com.javastudio.tutorial.mapping.mapper;

import com.javastudio.tutorial.mapping.model.OrderLine;
import com.javastudio.tutorial.mapping.model.OrderLineEntity;
import com.javastudio.tutorial.mapping.model.Product;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

class OrderLineMapperTest {

    private final OrderLineMapper orderLineMapper = Mappers.getMapper(OrderLineMapper.class);

    @Test
    void map() {
        Long orderId = 1L;

        OrderLine orderLine = new OrderLine();
        orderLine.setId(1L);

        Product product = new Product();
        product.setId(1L);
        product.setProductName("Test Product");
        product.setPrice(10.0);
        orderLine.setProduct(product);

        orderLine.setQuantity(5);
        orderLine.setWeight(2.0);

        OrderLineEntity orderLineEntity = orderLineMapper.map(orderLine, orderId);

        assertNotNull(orderLineEntity);
        assertEquals(orderLine.getId(), orderLineEntity.getId());
        assertEquals(orderId, orderLineEntity.getOrderId());
        assertNotNull(orderLineEntity.getProduct());
        assertEquals(product.getId(), orderLineEntity.getProduct().getId());
        assertEquals(product.getProductName(), orderLineEntity.getProduct().getProductName());
        assertEquals(product.getPrice(), orderLineEntity.getProduct().getProductPrice());
        assertEquals(orderLine.getQuantity(), orderLineEntity.getQuantity());
        assertEquals(orderLine.getWeight(), orderLineEntity.getPackageWeight());
    }
}
