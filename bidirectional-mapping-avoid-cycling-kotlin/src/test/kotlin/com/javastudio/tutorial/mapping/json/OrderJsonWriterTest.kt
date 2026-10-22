package com.javastudio.tutorial.mapping.json

import com.javastudio.tutorial.mapping.TestData
import com.javastudio.tutorial.mapping.mapper.OrderMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class OrderJsonWriterTest {

    private val writer = OrderJsonWriter()

    @Test
    fun writesOrderWithLinesReferencingParentById() {
        val order = OrderMapper.INSTANCE.map(TestData.orderWithTwoLines())

        val json = writer.toJson(order)

        assertThat(json.getLong("id")).isEqualTo(1L)
        assertThat(json.getString("customerName")).isEqualTo("Alice")
        assertThat(json.getString("orderDate")).isEqualTo("2026-10-01")

        val lines = json.getJSONArray("orderLines")
        assertThat(lines.length()).isEqualTo(2)
        val first = lines.getJSONObject(0)
        assertThat(first.getLong("orderId")).isEqualTo(1L)
        assertThat(first.getString("productName")).isEqualTo("Keyboard")
        assertThat(first.has("order")).isFalse()
    }
}
