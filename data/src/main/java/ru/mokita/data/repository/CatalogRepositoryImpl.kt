package ru.mokita.data.repository

import ru.mokita.domain.model.CatalogItem
import ru.mokita.domain.repository.CatalogRepository

class CatalogRepositoryImpl: CatalogRepository {
    override suspend fun getCatalog(): List<CatalogItem> {
        TODO("Not yet implemented")
    }
}