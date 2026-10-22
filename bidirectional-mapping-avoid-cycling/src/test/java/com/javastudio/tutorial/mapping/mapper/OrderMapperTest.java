package com.javastudio.tutorial.mapping.mapper;

import com.javastudio.tutorial.mapping.TestData;
import com.javastudio.tutorial.mapping.entity.OrderEntity;
import com.javastudio.tutorial.mapping.model.Order;
import com.javastudio.tutorial.mapping.model.OrderLine;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OrderMapperTest {

    private final OrderMapper mapper = OrderMapper.INSTANCE;

    @Test
    void mapsBidirectionalGraphWithoutCycling() {
        OrderEntity entity = TestData.orderWithTwoLines();

        Order order = mapper.map(entity);

        assertThat(order.getId()).isEqualTo(1L);
        assertThat(order.getCustomerName()).isEqualTo("Alice");
        assertThat(order.getOrderDate()).isEqualTo(LocalDate.of(2026, 10, 1));
        assertThat(order.getOrderLines())
                .extracting(OrderLine::getProductName)
                .containsExactly("Keyboard", "Mouse");
        assertThat(order.getOrderLines())
                .allSatisfy(line -> assertThat(line.getOrder()).isSameAs(order));
    }

    @Test
    void sharesContextAcrossListMapping() {
        List<Order> orders = mapper.mapAll(List.of(TestData.orderWithTwoLines()));

        assertThat(orders).hasSize(1);
        Order order = orders.get(0);
        assertThat(order.getOrderLines()).allSatisfy(line -> assertThat(line.getOrder()).isSameAs(order));
    }
}
