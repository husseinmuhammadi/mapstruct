package com.javastudio.tutorial.mapping.model;

import lombok.Data;

@Data
public class ProductEntity extends BaseEntity<Long> {
    Long id;
    String name;
}
