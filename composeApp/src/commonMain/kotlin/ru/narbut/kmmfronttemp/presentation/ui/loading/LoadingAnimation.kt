package ru.narbut.kmmfronttemp.presentation.ui.loading

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import ru.narbut.kmmfronttemp.presentation.theme.composableDimens
import ru.narbut.kmmfronttemp.presentation.ui.text.LoadingText

/**
 * To show a rotating icon at the center and blinking text at the bottom of the screen
 */
@Composable
fun LoadingAnimation(
    bitmap: ImageBitmap? = null,
    painter: Painter? = null,
    size: Int = composableDimens().progressLargeSize,
    message: String
) {

    var progress by remember { mutableStateOf(0.1f) }
    val animatedProgress = animateFloatAsState(
        targetValue = progress,
        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
    )


    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        if (painter != null && bitmap != null) {
            Image(
                modifier = Modifier
                    .rotate(animatedProgress.value)
                    .align(Alignment.Center)
                    .size(size.dp),
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary),
                bitmap = bitmap,
                contentDescription = ""
            )
        } else {
            CircularProgressIndicator(
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(size.dp)
            )
        }


        LoadingText(
            modifier = Modifier.align(Alignment.BottomCenter),
            message = message
        )
    }

    LaunchedEffect(Unit) {
        // Ignite the animation
        if (progress < 1f) progress += 0.1f
    }
}

