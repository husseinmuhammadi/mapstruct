package com.javastudio.tutorial.mapping.mapper;


import java.time.LocalDate;

@DateConvertor
public class DateMapper {

    @DateToYearConvertor
    public int getYear(LocalDate date){
        return date.getYear();
    }

    @DateToMonthConvertor
    public int getMonth(LocalDate date){
        return date.getMonthValue();
    }

    @DateToDayOfMonthConvertor
    public int getDayOfMonth(LocalDate date){
        return date.getDayOfMonth();
    }
}
