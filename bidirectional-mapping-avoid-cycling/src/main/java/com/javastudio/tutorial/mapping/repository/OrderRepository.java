package com.javastudio.tutorial.mapping.repository;

import com.javastudio.tutorial.mapping.entity.OrderEntity;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class OrderRepository {

    private final EntityManager entityManager;

    public OrderRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<OrderEntity> findAll() {
        return entityManager.createQuery(
                        "select distinct o from OrderEntity o left join fetch o.orderLines order by o.id",
                        OrderEntity.class)
                .getResultList();
    }

    public Optional<OrderEntity> findById(Long id) {
        return entityManager.createQuery(
                        "select o from OrderEntity o left join fetch o.orderLines where o.id = :id",
                        OrderEntity.class)
                .setParameter("id", id)
                .getResultStream()
                .findFirst();
    }
}
