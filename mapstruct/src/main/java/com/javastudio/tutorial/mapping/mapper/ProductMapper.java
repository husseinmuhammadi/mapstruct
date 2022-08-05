package com.javastudio.tutorial.mapping.mapper;

import com.javastudio.tutorial.mapping.model.Product;
import com.javastudio.tutorial.mapping.model.ProductCategory;
import com.javastudio.tutorial.mapping.model.Tip;
import com.javastudio.tutorial.mapping.model.TipOverview;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Mapper
public interface ProductMapper {

    default Tip map(TipOverview productOverview, @Context String language) {
        return productOverview.getTips().stream()
                .filter(tip -> Objects.equals(tip.getLanguage(), language))
                .findAny().orElse(new Tip("", language));
    }

//    Tip map(TipOverview tipOverview);

    ArrayList<Tip> map(List<TipOverview> productOverview, @Context String language);

    @Mapping(target = "productType", source = "productCategory.categoryName")
    @Mapping(target = "manufacturer", source = "manufacturer")
    Product toProduct(ProductCategory productCategory, @Context String manufacturer);
}
