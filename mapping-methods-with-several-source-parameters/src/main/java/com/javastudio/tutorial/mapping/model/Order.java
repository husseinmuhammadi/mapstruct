package com.javastudio.tutorial.mapping.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Order {
    Long id;
    List<OrderLine> orderLines;

}
