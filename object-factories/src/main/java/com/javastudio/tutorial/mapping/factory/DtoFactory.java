package com.javastudio.tutorial.mapping.factory;

import com.javastudio.tutorial.mapping.model.Product;

public class DtoFactory {
    public Product createProductDto() {
        return new Product();
    }
}
