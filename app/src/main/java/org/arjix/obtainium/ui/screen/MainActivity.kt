package org.arjix.obtainium.ui.screen

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

// Screens
import org.arjix.obtainium.ui.screen.splash.SplashScreen
import org.arjix.obtainium.ui.screen.apps.*
import org.arjix.obtainium.ui.screen.settings.SettingsScreen
import org.arjix.obtainium.ui.screen.todo.TODOScreen


import org.arjix.obtainium.ui.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn
import org.arjix.obtainium.ui.composable.NetworkStatusBar
import org.arjix.obtainium.ui.composable.connectedToInternet
import org.arjix.obtainium.util.network.hasNetwork
import kotlin.time.Duration.Companion.seconds


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()

    // TODO: Use shared preferences to check if this is the first time running the app.
    private val firstLaunch = false;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        flow {
            while (true) {
                if (connectedToInternet.value) {
                    delay(3.seconds)
                } else {
                    delay(1.seconds)
                }

                connectedToInternet.value = hasNetwork(this@MainActivity)
                delay(1.seconds)
                emit(Unit)
            }
        }.launchIn(viewModel.viewModelScope)

        setContent {
            AppTheme {
                Surface {
                    AppNavigation()
                }
            }
        }
    }

    @Composable
    private fun currentRoute(navController: NavHostController): String? {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        return navBackStackEntry?.destination?.route
    }

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    @Composable
    private fun AppNavigation() {
        val navController = rememberNavController()

        Scaffold(
            topBar = { NetworkStatusBar(connectedToInternet.value) },
            bottomBar = {
                val route = currentRoute(navController)

                if (!listOf(
                        Screen.Splash.route,
                        Screen.Intro.route
                    ).contains(route)
                ) {
                    Column {
                        when (route) {
                            Screen.Apps.route -> Toolbar()
                        }

                        BottomNavigation(
                            navController,
                            listOf(
                                NaviBarScreens.Apps,
                                NaviBarScreens.AddApp,
                                NaviBarScreens.ImportExport,
                                NaviBarScreens.Settings,
                            )
                        )
                    }
                }
            },
        ) {
            NavHost(navController = navController, startDestination = Screen.Splash.route) {
                // Splash
                composable(Screen.Splash.route) {
                    SplashScreen(
                        onSplashFinished = {
                            val options = NavOptions.Builder()
                                .setPopUpTo(Screen.Splash.route, inclusive = true)
                                .build()

                            navController.navigate(
                                if (firstLaunch) { Screen.Intro.route }
                                else { Screen.Apps.route },
                                options
                            )
                        }
                    )
                }

                composable(Screen.Apps.route) {
                    AppsScreen()
                }

                composable(Screen.AddApp.route) {
                    TODOScreen(navController = navController)
                }

                composable(Screen.ImportExport.route) {
                    TODOScreen(navController = navController)
                }

                composable(Screen.Settings.route) {
                    SettingsScreen(navController = navController)
                }
            }
        }
    }
}
