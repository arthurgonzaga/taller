package net.tallertechnologies.interview.login.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import net.tallertechnologies.interview.login.LoginUiState

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    uiState: LoginUiState,
    onUsernameChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    login: () -> Unit
) {
    Column {
        TextField(
            uiState.username,
            onValueChange = onUsernameChange
        )
        TextField(
            uiState.password,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password
            ),
            onValueChange = onPasswordChange
        )
        Button(
            onClick = login
        ) {
            Text("Login")
        }
    }
}