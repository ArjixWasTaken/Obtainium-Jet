package org.arjix.obtainium.ui.composable

import androidx.compose.animation.*
import androidx.compose.animation.core.keyframes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign

val connectedToInternet by lazy { mutableStateOf(true) }

@Composable
fun AnimatedVisibilityMark2(visible: Boolean, delayMillis: Int, durationMillis: Int, content: @Composable () -> Unit) {
    AnimatedVisibility(
        visible = visible,
        enter = slideInVertically(
            animationSpec = keyframes {
                this.delayMillis = delayMillis
                this.durationMillis = durationMillis
            },
            initialOffsetY = { -it }
        ),
        exit = slideOutVertically(
            animationSpec = keyframes {
                this.delayMillis = delayMillis
                this.durationMillis = durationMillis
            },
            targetOffsetY = { -it }
        )
    ){
        content()
    }
}

@Composable
fun NetworkStatusBar(hasInternet: Boolean) {
    AnimatedVisibilityMark2(!hasInternet, 500, 800) {
        Text(
            text = if (hasInternet) {"Back online"} else {"No connection"},
            textAlign = TextAlign.Center,
            modifier=Modifier
                .background(
                    if (hasInternet) { Color(45, 165, 65) }
                    else { Color.Gray }
                )
                .fillMaxWidth()
        )
    }
}
