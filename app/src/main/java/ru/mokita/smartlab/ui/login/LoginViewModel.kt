package ru.mokita.smartlab.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.mokita.data.repository.AuthorizationRepositoryImpl
import ru.mokita.domain.repository.AuthorizationRepository
import ru.mokita.domain.usecase.SendCodeUseCase
import ru.mokita.smartlab.R

class LoginViewModel(): ViewModel() {
    private val sendCodeUseCase = SendCodeUseCase(AuthorizationRepositoryImpl())
    private var _success: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val success get() = _success.asStateFlow()

    fun sendCode(email: String) {
        viewModelScope.launch {
            _success.value = sendCodeUseCase.execute(email)
        }
    }
}