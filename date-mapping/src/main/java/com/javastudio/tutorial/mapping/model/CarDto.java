package com.javastudio.tutorial.mapping.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarDto {
    private String manufacturingDate;

    private int year;
    private int month;
    private int dayOfMonth;
}
