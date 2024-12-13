package net.tallertechnologies.interview.login

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.seconds

class LoginViewModel(
    //savedStateHandle: SavedStateHandle // TODO: i would use this
): ViewModel(){

    private var _uiState = mutableStateOf(LoginUiState())
    val uiState: State<LoginUiState>
        get() = _uiState

    private var _navigateToWelcomeScreen by mutableStateOf(false)
    val navigateToWelcomeScreen: Boolean
        get() = _navigateToWelcomeScreen

    fun updateUsername(username: String) {
        _uiState.value = _uiState.value.copy(username = username)
    }

    fun updatePassword(password: String) {
        _uiState.value = _uiState.value.copy(password = password)
    }

    fun login() {
        if (uiState.value.username.isBlank() || uiState.value.password.isBlank()) {
            _uiState.value = _uiState.value.copy(
                error = "Username and password must not be empty"
            )
            return
        }


        viewModelScope.launch {
            _uiState.value = uiState.value.copy(isLoading = true)
            delay(1.seconds)
            val success = uiState.value.username == "admin" && uiState.value.password == "admin"

            _uiState.value = uiState.value.copy(
                isLoading = false,
                error = if (!success) {
                    "Invalid username or password"
                } else {
                    null
                }
            )
        }
    }

    fun clearError() {
        _uiState.value = _uiState.value.copy(error = null)
    }
}