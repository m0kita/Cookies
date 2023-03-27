package ru.mokita.domain.repository

import ru.mokita.domain.model.CatalogItem

interface CatalogRepository {
    suspend fun getCatalog(): List<CatalogItem>
}