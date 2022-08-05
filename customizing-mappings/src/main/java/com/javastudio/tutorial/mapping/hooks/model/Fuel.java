package com.javastudio.tutorial.mapping.hooks.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Fuel {
    final Integer tankCapacity;
    final String fuelType;
}
