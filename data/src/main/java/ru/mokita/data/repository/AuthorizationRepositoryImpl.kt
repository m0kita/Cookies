package ru.mokita.data.repository

import ru.mokita.data.network.SmartLabClient
import ru.mokita.domain.repository.AuthorizationRepository

class AuthorizationRepositoryImpl: AuthorizationRepository {

    private val client = SmartLabClient.client
    override suspend fun sendCode(email: String): Boolean = client.sendCode(email).message == "Успешно код отправлен"

    override suspend fun signIn(email: String, code: String): String = client.signIn(email, code).token

}