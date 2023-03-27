package ru.mokita.domain.repository

import ru.mokita.domain.model.Profile


interface ProfileRepository {
    suspend fun createProfile(firstName: String, lastName: String, middleName: String, birthday: String, gender: String): Profile
}