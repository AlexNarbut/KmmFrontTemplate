package ru.narbut.kmmfronttemp.presentation.ui.text

import MainText
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha

@Composable
fun LoadingText(
    blinkPeriod: Int = 200,
    modifier: Modifier = Modifier,
    message: @Composable () -> Unit
) {
    var enabled by remember { mutableStateOf(true) }

    val alpha = if (enabled) {
        1f
    } else {
        0.2f
    }

    val animatedAlpha by animateFloatAsState(
        targetValue = alpha,
        animationSpec = tween(blinkPeriod),
        finishedListener = {
            enabled = !enabled
        }
    )

    Box(modifier.alpha(animatedAlpha)) {
        message()
    }

    LaunchedEffect(Unit) {
        enabled = !enabled
    }
}

@Composable
fun LoadingText(
    message: String,
    modifier: Modifier = Modifier
) {
    var enabled by remember { mutableStateOf(true) }

    val alpha = if (enabled) {
        1f
    } else {
        0.2f
    }

    val animatedAlpha by animateFloatAsState(
        targetValue = alpha,
        animationSpec = tween(200),
        finishedListener = {
            enabled = !enabled
        }
    )

    MainText(
        text = message,
        modifier = modifier.alpha(animatedAlpha)
    )

    LaunchedEffect(Unit) {
        enabled = !enabled
    }
}