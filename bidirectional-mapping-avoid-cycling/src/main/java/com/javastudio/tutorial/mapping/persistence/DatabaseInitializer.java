package com.javastudio.tutorial.mapping.persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Creates and seeds the SQLite database with plain JDBC before JPA is bootstrapped.
 */
public class DatabaseInitializer {

    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseInitializer.class);

    private final String jdbcUrl;

    public DatabaseInitializer(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    public void initialize(String... scripts) {
        try (Connection connection = DriverManager.getConnection(jdbcUrl);
             Statement statement = connection.createStatement()) {
            for (String script : scripts) {
                LOGGER.info("Running {} against {}", script, jdbcUrl);
                for (String sql : readScript(script).split(";")) {
                    if (!sql.isBlank()) {
                        statement.execute(sql);
                    }
                }
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Database initialization failed", e);
        }
    }

    private static String readScript(String script) {
        try (InputStream in = DatabaseInitializer.class.getClassLoader().getResourceAsStream(script)) {
            if (in == null) {
                throw new IllegalArgumentException("Script not found on classpath: " + script);
            }
            return new String(in.readAllBytes(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
