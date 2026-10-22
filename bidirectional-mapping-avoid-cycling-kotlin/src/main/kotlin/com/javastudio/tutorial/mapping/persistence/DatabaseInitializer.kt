package com.javastudio.tutorial.mapping.persistence

import org.slf4j.LoggerFactory
import java.sql.DriverManager
import java.sql.SQLException

/**
 * Creates and seeds the SQLite database with plain JDBC before JPA is bootstrapped.
 */
class DatabaseInitializer(private val jdbcUrl: String) {

    fun initialize(vararg scripts: String) {
        try {
            DriverManager.getConnection(jdbcUrl).use { connection ->
                connection.createStatement().use { statement ->
                    for (script in scripts) {
                        LOGGER.info("Running {} against {}", script, jdbcUrl)
                        readScript(script).split(";")
                            .filter { it.isNotBlank() }
                            .forEach { statement.execute(it) }
                    }
                }
            }
        } catch (e: SQLException) {
            throw IllegalStateException("Database initialization failed", e)
        }
    }

    private fun readScript(script: String): String =
        DatabaseInitializer::class.java.classLoader.getResourceAsStream(script)
            ?.use { String(it.readAllBytes(), Charsets.UTF_8) }
            ?: throw IllegalArgumentException("Script not found on classpath: $script")

    private companion object {
        private val LOGGER = LoggerFactory.getLogger(DatabaseInitializer::class.java)
    }
}
