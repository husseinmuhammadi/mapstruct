package com.javastudio.tutorial.mapping.factory;

import com.javastudio.tutorial.mapping.model.BaseEntity;
import com.javastudio.tutorial.mapping.model.ProductEntity;
import org.mapstruct.TargetType;

public class EntityFactory {
//    public <T extends BaseEntity> T createEntity(@TargetType Class<T> entityClass) {
//        return null;
//    }

    public ProductEntity createProductEntity() {
        return new ProductEntity();
    }
}
