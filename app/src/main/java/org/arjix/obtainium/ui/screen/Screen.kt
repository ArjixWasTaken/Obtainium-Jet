package org.arjix.obtainium.ui.screen

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import org.arjix.obtainium.R

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Intro : Screen("intro")
    object Apps : Screen("apps")
    object AddApp : Screen("add_app")
    object ImportExport : Screen("import/export")
    object Settings : Screen("settings")
}

sealed class NaviBarScreens(val route: String, @StringRes val resourceId: Int, @DrawableRes val icon: Int) {
    object Apps : NaviBarScreens(Screen.Apps.route, R.string.nav_apps, R.drawable.apps)
    object AddApp : NaviBarScreens(Screen.AddApp.route, R.string.nav_add_app, R.drawable.add)
    object ImportExport : NaviBarScreens(Screen.ImportExport.route, R.string.nav_import_export, R.drawable.import_export)
    object Settings : NaviBarScreens(Screen.Settings.route, R.string.nav_settings, R.drawable.settings)
}