package com.javastudio.tutorial.mapping.model

import java.time.LocalDate

class Order {
    var id: Long? = null
    var customerName: String? = null
    var orderDate: LocalDate? = null
    var orderLines: MutableList<OrderLine>? = null

    override fun toString() =
        "Order(id=$id, customerName=$customerName, orderDate=$orderDate, orderLines=$orderLines)"
}
