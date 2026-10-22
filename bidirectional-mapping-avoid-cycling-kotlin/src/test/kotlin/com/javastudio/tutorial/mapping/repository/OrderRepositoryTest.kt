package com.javastudio.tutorial.mapping.repository

import com.javastudio.tutorial.mapping.mapper.OrderMapper
import com.javastudio.tutorial.mapping.model.OrderLine
import com.javastudio.tutorial.mapping.persistence.DatabaseInitializer
import com.javastudio.tutorial.mapping.persistence.JpaSupport
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir
import java.nio.file.Path

class OrderRepositoryTest {

    @TempDir
    lateinit var tempDir: Path

    @Test
    fun fetchesOrdersFromSqliteAndMapsThem() {
        val jdbcUrl = "jdbc:sqlite:${tempDir.resolve("orders.db")}"
        DatabaseInitializer(jdbcUrl).initialize("schema.sql", "data.sql")

        JpaSupport.createEntityManagerFactory(jdbcUrl).use { emf ->
            emf.createEntityManager().use { em ->
                val repository = OrderRepository(em)

                val entities = repository.findAll()
                assertThat(entities.map { it.id }).containsExactly(1L, 2L)
                assertThat(repository.findById(1L)?.orderLines).hasSize(2)

                val first = OrderMapper.INSTANCE.mapAll(entities)[0]
                assertThat(first.orderLines).hasSize(2)
                    .allSatisfy { line: OrderLine -> assertThat(line.order).isSameAs(first) }
            }
        }
    }
}
