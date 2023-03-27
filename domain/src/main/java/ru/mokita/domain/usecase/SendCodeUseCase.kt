package ru.mokita.domain.usecase

import ru.mokita.domain.repository.AuthorizationRepository

class SendCodeUseCase(private val authorizationRepository: AuthorizationRepository) {

    suspend fun execute(email: String) = authorizationRepository.sendCode(email)

}