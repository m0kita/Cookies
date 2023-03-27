package ru.mokita.domain.repository

import ru.mokita.domain.model.News

interface NewsRepository {
    suspend fun getNews(): List<News>
}