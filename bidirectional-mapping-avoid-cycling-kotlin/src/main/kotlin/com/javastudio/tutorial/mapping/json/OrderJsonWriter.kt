package com.javastudio.tutorial.mapping.json

import com.javastudio.tutorial.mapping.model.Order
import com.javastudio.tutorial.mapping.model.OrderLine
import org.json.JSONArray
import org.json.JSONObject

/**
 * Serializes the DTO graph with org.json. The back-reference [OrderLine.order]
 * is written as `orderId` to keep the JSON acyclic.
 */
class OrderJsonWriter {

    fun toJson(orders: List<Order>): JSONArray = JSONArray().apply {
        orders.forEach { put(toJson(it)) }
    }

    fun toJson(order: Order): JSONObject {
        val lines = JSONArray()
        order.orderLines?.forEach { lines.put(toJson(it)) }
        return JSONObject()
            .put("id", order.id)
            .put("customerName", order.customerName)
            .put("orderDate", order.orderDate?.toString() ?: JSONObject.NULL)
            .put("orderLines", lines)
    }

    fun toJson(line: OrderLine): JSONObject = JSONObject()
        .put("id", line.id)
        .put("orderId", line.order?.id ?: JSONObject.NULL)
        .put("productName", line.productName)
        .put("quantity", line.quantity)
        .put("price", line.price)
}
