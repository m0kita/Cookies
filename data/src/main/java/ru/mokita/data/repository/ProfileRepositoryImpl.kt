package ru.mokita.data.repository

import ru.mokita.data.model.Profile as DataProfile
import ru.mokita.data.network.SmartLabClient
import ru.mokita.domain.model.Profile
import ru.mokita.domain.repository.ProfileRepository

class ProfileRepositoryImpl: ProfileRepository {
    private val client = SmartLabClient.client

    override suspend fun createProfile(firstName: String, lastName: String, middleName: String, birthday: String, gender: String): Profile = fromDataToDomain(client.createProfile(firstName, lastName, middleName, birthday, gender))

    private fun fromDataToDomain(profile: DataProfile) = Profile(firstName = profile.firstName, lastName = profile.lastName, middleName = profile.middleName, bithday = profile.bithday, gender = profile.gender)

}