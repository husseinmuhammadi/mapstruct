package com.javastudio.tutorial.mapping.date;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class LocalDateTest {

    @Test
    void extractYear(){
        LocalDate now=LocalDate.now();
        System.out.println(now.getYear());

    }
}
