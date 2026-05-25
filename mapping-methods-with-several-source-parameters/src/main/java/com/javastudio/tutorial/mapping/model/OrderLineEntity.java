package com.javastudio.tutorial.mapping.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderLineEntity {
    Long id;
    Long orderId;
    ProductEntity product;
    Integer quantity;
}

