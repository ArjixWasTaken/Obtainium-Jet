package org.arjix.obtainium.ui.screen.apps

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun AppsScreen(
    viewModel: AppsViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 5.dp, vertical = 10.dp),
    ) {
        Text(text="Apps", style = MaterialTheme.typography.h4)
    }
}

@Composable
fun Toolbar(viewModel: AppsViewModel = hiltViewModel()) {
    Row {
        Icon(
            painter = painterResource(id = org.arjix.obtainium.R.drawable.select_all),
            contentDescription = null
        )
        Text("0")
    }
}