package ru.mokita.domain.usecase

import ru.mokita.domain.repository.AuthorizationRepository
import ru.mokita.domain.repository.ProfileRepository

class CreateProfileUseCase(private val profileRepository: ProfileRepository) {

    suspend fun execute(firstName: String, lastName: String, middleName: String, birthday: String, gender: String) = profileRepository.createProfile(firstName, lastName, middleName, birthday, gender)
}