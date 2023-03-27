package ru.mokita.domain.repository

interface AuthorizationRepository {
    suspend fun sendCode(email: String): Boolean

    suspend fun signIn(email: String, code: String): String

}