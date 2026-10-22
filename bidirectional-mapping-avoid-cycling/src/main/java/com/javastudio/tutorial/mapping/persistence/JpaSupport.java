package com.javastudio.tutorial.mapping.persistence;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Map;

public final class JpaSupport {

    public static final String PERSISTENCE_UNIT = "orders";

    private JpaSupport() {
    }

    public static EntityManagerFactory createEntityManagerFactory(String jdbcUrl) {
        return Persistence.createEntityManagerFactory(PERSISTENCE_UNIT,
                Map.of("jakarta.persistence.jdbc.url", jdbcUrl));
    }
}
