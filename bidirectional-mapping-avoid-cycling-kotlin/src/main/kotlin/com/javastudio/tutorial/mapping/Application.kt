package com.javastudio.tutorial.mapping

import com.javastudio.tutorial.mapping.json.OrderJsonWriter
import com.javastudio.tutorial.mapping.mapper.OrderMapper
import com.javastudio.tutorial.mapping.persistence.DatabaseInitializer
import com.javastudio.tutorial.mapping.persistence.JpaSupport
import com.javastudio.tutorial.mapping.repository.OrderRepository
import org.slf4j.LoggerFactory
import java.nio.file.Files
import java.nio.file.Path

private val LOGGER = LoggerFactory.getLogger("com.javastudio.tutorial.mapping.Application")

fun main() {
    val dbFile = Path.of("target", "orders.db")
    Files.createDirectories(dbFile.parent)
    val jdbcUrl = "jdbc:sqlite:$dbFile"

    DatabaseInitializer(jdbcUrl).initialize("schema.sql", "data.sql")

    JpaSupport.createEntityManagerFactory(jdbcUrl).use { emf ->
        emf.createEntityManager().use { em ->
            val entities = OrderRepository(em).findAll()
            val orders = OrderMapper.INSTANCE.mapAll(entities)
            LOGGER.info("Orders:\n{}", OrderJsonWriter().toJson(orders).toString(2))
        }
    }
}
