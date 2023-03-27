package ru.mokita.data.repository

import ru.mokita.domain.model.OrdersItem
import ru.mokita.domain.repository.OrderRepository

class OrderRepositoryImpl: OrderRepository {
    override suspend fun createOrder(): Int {
        TODO("Not yet implemented")
    }

    override suspend fun getOrders(): List<OrdersItem> {
        TODO("Not yet implemented")
    }
}