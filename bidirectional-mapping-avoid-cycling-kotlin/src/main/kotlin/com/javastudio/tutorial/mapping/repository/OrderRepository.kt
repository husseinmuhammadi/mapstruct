package com.javastudio.tutorial.mapping.repository

import com.javastudio.tutorial.mapping.entity.OrderEntity
import jakarta.persistence.EntityManager

class OrderRepository(private val entityManager: EntityManager) {

    fun findAll(): List<OrderEntity> =
        entityManager.createQuery(
            "select distinct o from OrderEntity o left join fetch o.orderLines order by o.id",
            OrderEntity::class.java,
        ).resultList

    fun findById(id: Long): OrderEntity? =
        entityManager.createQuery(
            "select o from OrderEntity o left join fetch o.orderLines where o.id = :id",
            OrderEntity::class.java,
        )
            .setParameter("id", id)
            .resultList
            .firstOrNull()
}
