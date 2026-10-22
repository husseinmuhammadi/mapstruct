package com.javastudio.tutorial.mapping.entity

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Convert
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.OrderBy
import jakarta.persistence.Table
import java.time.LocalDate

@Entity
@Table(name = "orders")
class OrderEntity(
    @Id
    var id: Long? = null,

    @Column(name = "customer_name", nullable = false)
    var customerName: String? = null,

    @Convert(converter = LocalDateStringConverter::class)
    @Column(name = "order_date", nullable = false)
    var orderDate: LocalDate? = null,

    @OrderBy("id")
    @OneToMany(mappedBy = "order", cascade = [CascadeType.ALL], orphanRemoval = true)
    var orderLines: MutableList<OrderLineEntity> = mutableListOf(),
) {
    fun addOrderLine(orderLine: OrderLineEntity) {
        orderLines.add(orderLine)
        orderLine.order = this
    }

    override fun toString() = "OrderEntity(id=$id, customerName=$customerName, orderDate=$orderDate)"
}
