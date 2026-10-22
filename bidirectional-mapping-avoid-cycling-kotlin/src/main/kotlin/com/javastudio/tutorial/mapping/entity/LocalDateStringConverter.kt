package com.javastudio.tutorial.mapping.entity

import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter
import java.time.LocalDate

/**
 * SQLite has no native date type; dates are stored as ISO-8601 text.
 */
@Converter
class LocalDateStringConverter : AttributeConverter<LocalDate?, String?> {

    override fun convertToDatabaseColumn(attribute: LocalDate?): String? = attribute?.toString()

    override fun convertToEntityAttribute(dbData: String?): LocalDate? = dbData?.let(LocalDate::parse)
}
