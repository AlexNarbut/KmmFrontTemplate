package ru.narbut.kmmfronttemp.ui.loading

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.ColorFilter
import org.jetbrains.compose.resources.painterResource

@Composable
fun ProgressImage(
    modifier: Modifier = Modifier,
    iconPath: String,
    iconColorFilter: ColorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary),
) {
    var currentRotation by remember { mutableStateOf(0f) }
    val rotation = remember { Animatable(currentRotation) }
    Image(
        modifier = modifier.rotate(rotation.value),
        contentDescription = "",
        painter = painterResource(iconPath),
        colorFilter = iconColorFilter,

    )

    LaunchedEffect(Unit){
        rotation.animateTo(
            targetValue = currentRotation + 360f,
            animationSpec = infiniteRepeatable(
                animation = tween(3000, easing = LinearEasing),
                repeatMode = RepeatMode.Restart
            )
        ) {
            currentRotation = value
        }
    }
}