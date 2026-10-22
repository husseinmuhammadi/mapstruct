package com.javastudio.tutorial.mapping.json;

import com.javastudio.tutorial.mapping.model.Order;
import com.javastudio.tutorial.mapping.model.OrderLine;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

/**
 * Serializes the DTO graph with org.json. The back-reference
 * {@link OrderLine#getOrder()} is written as {@code orderId} to keep the JSON acyclic.
 */
public class OrderJsonWriter {

    public JSONArray toJson(List<Order> orders) {
        JSONArray array = new JSONArray();
        orders.forEach(order -> array.put(toJson(order)));
        return array;
    }

    public JSONObject toJson(Order order) {
        JSONArray lines = new JSONArray();
        if (order.getOrderLines() != null) {
            order.getOrderLines().forEach(line -> lines.put(toJson(line)));
        }
        return new JSONObject()
                .put("id", order.getId())
                .put("customerName", order.getCustomerName())
                .put("orderDate", order.getOrderDate() == null ? JSONObject.NULL : order.getOrderDate().toString())
                .put("orderLines", lines);
    }

    public JSONObject toJson(OrderLine line) {
        return new JSONObject()
                .put("id", line.getId())
                .put("orderId", line.getOrder() == null ? JSONObject.NULL : line.getOrder().getId())
                .put("productName", line.getProductName())
                .put("quantity", line.getQuantity())
                .put("price", line.getPrice());
    }
}
