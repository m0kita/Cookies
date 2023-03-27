package ru.mokita.smartlab.ui.login.createcard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.mokita.data.repository.ProfileRepositoryImpl
import ru.mokita.domain.model.Profile
import ru.mokita.domain.usecase.CreateProfileUseCase

class CreateCardViewModel : ViewModel() {
    private val createProfileUseCase = CreateProfileUseCase(ProfileRepositoryImpl())
    private var _profile = MutableStateFlow(Profile())
    val profile get() = _profile.asStateFlow()


    fun createProfile(firstName: String, lastName: String, middleName: String, birthday: String, gender: String) {
        viewModelScope.launch {
            _profile.value = createProfileUseCase.execute(firstName, lastName, middleName, birthday, gender)
        }
    }
}