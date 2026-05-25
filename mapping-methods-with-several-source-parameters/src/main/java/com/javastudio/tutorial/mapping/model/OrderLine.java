package com.javastudio.tutorial.mapping.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderLine {
    Long id;
    Product product;
    Integer quantity;
}
