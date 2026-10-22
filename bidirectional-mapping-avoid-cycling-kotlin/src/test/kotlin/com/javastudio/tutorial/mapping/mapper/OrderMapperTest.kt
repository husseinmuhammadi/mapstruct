package com.javastudio.tutorial.mapping.mapper

import com.javastudio.tutorial.mapping.TestData
import com.javastudio.tutorial.mapping.model.OrderLine
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.time.LocalDate

class OrderMapperTest {

    private val mapper = OrderMapper.INSTANCE

    @Test
    fun mapsBidirectionalGraphWithoutCycling() {
        val order = mapper.map(TestData.orderWithTwoLines())

        assertThat(order.id).isEqualTo(1L)
        assertThat(order.customerName).isEqualTo("Alice")
        assertThat(order.orderDate).isEqualTo(LocalDate.of(2026, 10, 1))
        assertThat(order.orderLines)
            .extracting<String> { it.productName }
            .containsExactly("Keyboard", "Mouse")
        assertThat(order.orderLines)
            .allSatisfy { line: OrderLine -> assertThat(line.order).isSameAs(order) }
    }

    @Test
    fun sharesContextAcrossListMapping() {
        val orders = mapper.mapAll(listOf(TestData.orderWithTwoLines()))

        assertThat(orders).hasSize(1)
        val order = orders[0]
        assertThat(order.orderLines)
            .allSatisfy { line: OrderLine -> assertThat(line.order).isSameAs(order) }
    }
}
