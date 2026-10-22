package com.javastudio.tutorial.mapping.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
public class Order {
    private Long id;
    private String customerName;
    private LocalDate orderDate;
    private List<OrderLine> orderLines;
}
