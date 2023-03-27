package ru.mokita.data.repository

import ru.mokita.domain.model.News
import ru.mokita.domain.repository.NewsRepository

class NewsRepositoryImpl: NewsRepository {
    override suspend fun getNews(): List<News> {
        TODO("Not yet implemented")
    }
}