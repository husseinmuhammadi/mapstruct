package com.javastudio.tutorial.mapping.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class OrderLine {
    private Long id;

    @ToString.Exclude
    private Order order;

    private String productName;
    private Integer quantity;
    private BigDecimal price;
}
