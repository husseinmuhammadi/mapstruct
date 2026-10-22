package com.javastudio.tutorial.mapping

import com.javastudio.tutorial.mapping.entity.OrderEntity
import com.javastudio.tutorial.mapping.entity.OrderLineEntity
import java.math.BigDecimal
import java.time.LocalDate

object TestData {

    fun orderWithTwoLines(): OrderEntity =
        OrderEntity(id = 1L, customerName = "Alice", orderDate = LocalDate.of(2026, 10, 1)).apply {
            addOrderLine(line(1L, "Keyboard", 1, "49.90"))
            addOrderLine(line(2L, "Mouse", 2, "19.95"))
        }

    private fun line(id: Long, product: String, quantity: Int, price: String) =
        OrderLineEntity(id = id, productName = product, quantity = quantity, price = BigDecimal(price))
}
