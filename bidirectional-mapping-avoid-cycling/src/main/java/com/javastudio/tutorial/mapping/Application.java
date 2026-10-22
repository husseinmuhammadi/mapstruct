package com.javastudio.tutorial.mapping;

import com.javastudio.tutorial.mapping.entity.OrderEntity;
import com.javastudio.tutorial.mapping.json.OrderJsonWriter;
import com.javastudio.tutorial.mapping.mapper.OrderMapper;
import com.javastudio.tutorial.mapping.model.Order;
import com.javastudio.tutorial.mapping.persistence.DatabaseInitializer;
import com.javastudio.tutorial.mapping.persistence.JpaSupport;
import com.javastudio.tutorial.mapping.repository.OrderRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) throws IOException {
        Path dbFile = Path.of("target", "orders.db");
        Files.createDirectories(dbFile.getParent());
        String jdbcUrl = "jdbc:sqlite:" + dbFile;

        new DatabaseInitializer(jdbcUrl).initialize("schema.sql", "data.sql");

        try (EntityManagerFactory emf = JpaSupport.createEntityManagerFactory(jdbcUrl);
             EntityManager em = emf.createEntityManager()) {
            List<OrderEntity> entities = new OrderRepository(em).findAll();
            List<Order> orders = OrderMapper.INSTANCE.mapAll(entities);
            LOGGER.info("Orders:\n{}", new OrderJsonWriter().toJson(orders).toString(2));
        }
    }
}
