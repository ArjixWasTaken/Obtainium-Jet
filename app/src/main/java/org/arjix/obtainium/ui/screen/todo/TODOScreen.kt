package org.arjix.obtainium.ui.screen.todo

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

@Composable
fun TODOScreen(
    viewModel: TODOViewModel = hiltViewModel(),
    navController: NavHostController
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text="Nothing to see here :^)")
        Button(onClick = {
            navController.popBackStack()
            navController.navigate(Screen.Apps.route)
        }) {
            Text(text="Go back")
        }
    }
}
