package com.javastudio.tutorial.mapping;

import com.javastudio.tutorial.mapping.entity.OrderEntity;
import com.javastudio.tutorial.mapping.entity.OrderLineEntity;

import java.math.BigDecimal;
import java.time.LocalDate;

public final class TestData {

    private TestData() {
    }

    public static OrderEntity orderWithTwoLines() {
        OrderEntity order = new OrderEntity();
        order.setId(1L);
        order.setCustomerName("Alice");
        order.setOrderDate(LocalDate.of(2026, 10, 1));
        order.addOrderLine(line(1L, "Keyboard", 1, "49.90"));
        order.addOrderLine(line(2L, "Mouse", 2, "19.95"));
        return order;
    }

    private static OrderLineEntity line(Long id, String product, int quantity, String price) {
        OrderLineEntity line = new OrderLineEntity();
        line.setId(id);
        line.setProductName(product);
        line.setQuantity(quantity);
        line.setPrice(new BigDecimal(price));
        return line;
    }
}
