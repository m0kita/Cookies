package ru.mokita.domain.model

data class Profile(
    val id: Int = 0,
    val userId: Int = 0,
    var firstName: String = "",
    var lastName: String = "",
    var middleName: String = "",
    var gender: String = "",
    val createdAt: String = "",
    val updatedAt: String = "",
    var bithday: String = ""
)