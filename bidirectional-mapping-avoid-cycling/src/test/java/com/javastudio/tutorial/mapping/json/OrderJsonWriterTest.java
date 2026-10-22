package com.javastudio.tutorial.mapping.json;

import com.javastudio.tutorial.mapping.TestData;
import com.javastudio.tutorial.mapping.mapper.OrderMapper;
import com.javastudio.tutorial.mapping.model.Order;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OrderJsonWriterTest {

    private final OrderJsonWriter writer = new OrderJsonWriter();

    @Test
    void writesOrderWithLinesReferencingParentById() {
        Order order = OrderMapper.INSTANCE.map(TestData.orderWithTwoLines());

        JSONObject json = writer.toJson(order);

        assertThat(json.getLong("id")).isEqualTo(1L);
        assertThat(json.getString("customerName")).isEqualTo("Alice");
        assertThat(json.getString("orderDate")).isEqualTo("2026-10-01");

        JSONArray lines = json.getJSONArray("orderLines");
        assertThat(lines.length()).isEqualTo(2);
        JSONObject first = lines.getJSONObject(0);
        assertThat(first.getLong("orderId")).isEqualTo(1L);
        assertThat(first.getString("productName")).isEqualTo("Keyboard");
        assertThat(first.has("order")).isFalse();
    }
}
