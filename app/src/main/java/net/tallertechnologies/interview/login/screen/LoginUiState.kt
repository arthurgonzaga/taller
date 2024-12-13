package net.tallertechnologies.interview.login.screen

import java.io.Serializable

data class LoginUiState(
    val username: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val error: String? = null
): Serializable
