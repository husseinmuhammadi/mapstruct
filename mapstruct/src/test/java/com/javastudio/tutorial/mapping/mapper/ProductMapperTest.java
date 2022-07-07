package com.javastudio.tutorial.mapping.mapper;

import com.javastudio.tutorial.mapping.model.Product;
import com.javastudio.tutorial.mapping.model.ProductCategory;
import com.javastudio.tutorial.mapping.model.Tip;
import com.javastudio.tutorial.mapping.model.TipOverview;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductMapperTest {

    ProductMapper mapper = Mappers.getMapper(ProductMapper.class);

    @Test
    void name() {
        TipOverview tipOverview = new TipOverview();
        tipOverview.setTips(List.of(new Tip("Hello", "en")));

        assertEquals("Hello", mapper.map(tipOverview, "en").getText());
        assertEquals("", mapper.map(tipOverview, "fr").getText());
    }

    @Test
    void convertFrom() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("Computer");
        Product product = mapper.toProduct(productCategory, "Acer");
        assertEquals("Computer", product.getProductType());
        assertEquals("Acer", product.getManufacturer());
    }


}