package ru.mokita.domain.repository

import ru.mokita.domain.model.OrdersItem

interface OrderRepository {
    suspend fun createOrder(): Int

    suspend fun getOrders(): List<OrdersItem>
}