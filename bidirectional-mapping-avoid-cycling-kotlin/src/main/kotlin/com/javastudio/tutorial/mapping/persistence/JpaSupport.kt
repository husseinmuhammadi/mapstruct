package com.javastudio.tutorial.mapping.persistence

import jakarta.persistence.EntityManagerFactory
import jakarta.persistence.Persistence

object JpaSupport {

    const val PERSISTENCE_UNIT = "orders"

    fun createEntityManagerFactory(jdbcUrl: String): EntityManagerFactory =
        Persistence.createEntityManagerFactory(
            PERSISTENCE_UNIT,
            mapOf("jakarta.persistence.jdbc.url" to jdbcUrl),
        )
}
