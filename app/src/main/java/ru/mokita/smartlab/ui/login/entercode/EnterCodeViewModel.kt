package ru.mokita.smartlab.ui.login.entercode

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.mokita.data.repository.AuthorizationRepositoryImpl
import ru.mokita.domain.usecase.SignInUseCase

class EnterCodeViewModel : ViewModel() {
    private val signInUseCase = SignInUseCase(AuthorizationRepositoryImpl())
    private var _isCorrect = MutableStateFlow(false)
    val isCorrect get() = _isCorrect.asStateFlow()

    fun signIn(email: String, code: String) {
        viewModelScope.launch {
            _isCorrect.value = signInUseCase.execute(
                email,
                code
            ) != "Оибка в логине или пароле."
        }
    }

}