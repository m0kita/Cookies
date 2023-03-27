package ru.mokita.domain.usecase

import ru.mokita.domain.repository.AuthorizationRepository

class SignInUseCase(private val authorizationRepository: AuthorizationRepository) {

    suspend fun execute(email: String, code: String) = authorizationRepository.signIn(email, code)
}