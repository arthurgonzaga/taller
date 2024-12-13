package net.tallertechnologies.interview.login

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import net.tallertechnologies.interview.MainActivity
import net.tallertechnologies.interview.login.screen.LoginScreen
import net.tallertechnologies.interview.login.screen.LoginViewModel

class LoginActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            val viewModel = viewModel<LoginViewModel>()

            val uiState by viewModel.uiState


            LaunchedEffect(viewModel.navigateToWelcomeScreen) {
                startActivity(Intent(applicationContext, MainActivity::class.java))
                finish()
            }

            LoginScreen(
                uiState = uiState,
                onUsernameChange = viewModel::updateUsername,
                onPasswordChange = viewModel::updatePassword,
                login = {
                    viewModel.login()
                }
            )
        }
    }
}