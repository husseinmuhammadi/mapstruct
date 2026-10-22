package com.javastudio.tutorial.mapping.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.math.BigDecimal

@Entity
@Table(name = "order_line")
class OrderLineEntity(
    @Id
    var id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "order_id", nullable = false)
    var order: OrderEntity? = null,

    @Column(name = "product_name", nullable = false)
    var productName: String? = null,

    @Column(nullable = false)
    var quantity: Int? = null,

    @Column(nullable = false)
    var price: BigDecimal? = null,
) {
    override fun toString() =
        "OrderLineEntity(id=$id, productName=$productName, quantity=$quantity, price=$price)"
}
