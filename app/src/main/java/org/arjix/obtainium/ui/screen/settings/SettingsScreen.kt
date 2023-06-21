package org.arjix.obtainium.ui.screen.settings

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import org.arjix.obtainium.ui.screen.Screen

val loggedIn by lazy { mutableStateOf(true) }

@Composable
fun SettingsScreen(
    viewModel: SettingsViewModel = hiltViewModel(),
    navController: NavHostController
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text="Nothing to see here :^)")
        Button(onClick = {
            loggedIn.value = true

            val options = NavOptions.Builder()
                .setPopUpTo(Screen.Settings.route, inclusive = true)
                .build()

            navController.navigate(
                Screen.Apps.route,
                options
            )
        }) {
            Text(text="Go back")
        }
    }
}
