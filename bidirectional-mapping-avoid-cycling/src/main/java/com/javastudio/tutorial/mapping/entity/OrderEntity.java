package com.javastudio.tutorial.mapping.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "orders")
public class OrderEntity {

    @Id
    private Long id;

    @Column(name = "customer_name", nullable = false)
    private String customerName;

    @Convert(converter = LocalDateStringConverter.class)
    @Column(name = "order_date", nullable = false)
    private LocalDate orderDate;

    @ToString.Exclude
    @OrderBy("id")
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderLineEntity> orderLines = new ArrayList<>();

    public void addOrderLine(OrderLineEntity orderLine) {
        orderLines.add(orderLine);
        orderLine.setOrder(this);
    }
}
