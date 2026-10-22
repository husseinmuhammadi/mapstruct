package com.javastudio.tutorial.mapping.repository;

import com.javastudio.tutorial.mapping.entity.OrderEntity;
import com.javastudio.tutorial.mapping.mapper.OrderMapper;
import com.javastudio.tutorial.mapping.model.Order;
import com.javastudio.tutorial.mapping.persistence.DatabaseInitializer;
import com.javastudio.tutorial.mapping.persistence.JpaSupport;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.Path;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OrderRepositoryTest {

    @TempDir
    Path tempDir;

    @Test
    void fetchesOrdersFromSqliteAndMapsThem() {
        String jdbcUrl = "jdbc:sqlite:" + tempDir.resolve("orders.db");
        new DatabaseInitializer(jdbcUrl).initialize("schema.sql", "data.sql");

        try (EntityManagerFactory emf = JpaSupport.createEntityManagerFactory(jdbcUrl);
             EntityManager em = emf.createEntityManager()) {
            OrderRepository repository = new OrderRepository(em);

            List<OrderEntity> entities = repository.findAll();
            assertThat(entities).extracting(OrderEntity::getId).containsExactly(1L, 2L);
            assertThat(repository.findById(1L)).hasValueSatisfying(o -> assertThat(o.getOrderLines()).hasSize(2));

            List<Order> orders = OrderMapper.INSTANCE.mapAll(entities);
            Order first = orders.get(0);
            assertThat(first.getOrderLines()).hasSize(2)
                    .allSatisfy(line -> assertThat(line.getOrder()).isSameAs(first));
        }
    }
}
