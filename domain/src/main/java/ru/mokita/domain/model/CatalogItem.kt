package ru.mokita.domain.model

data class CatalogItem(
    val id: Int,
    val name: String,
    val description: String,
    val price: String,
    val category: String,
    val timeResult: String,
    val preparation: String,
    val bio: String,
)