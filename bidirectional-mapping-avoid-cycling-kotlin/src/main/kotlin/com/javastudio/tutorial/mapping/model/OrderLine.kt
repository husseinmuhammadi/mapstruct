package com.javastudio.tutorial.mapping.model

import java.math.BigDecimal

class OrderLine {
    var id: Long? = null
    var order: Order? = null
    var productName: String? = null
    var quantity: Int? = null
    var price: BigDecimal? = null

    override fun toString() =
        "OrderLine(id=$id, productName=$productName, quantity=$quantity, price=$price)"
}
