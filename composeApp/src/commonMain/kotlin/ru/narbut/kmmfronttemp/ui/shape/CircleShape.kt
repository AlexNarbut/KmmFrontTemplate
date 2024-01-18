package ru.narbut.kmmfronttemp.ui.shape

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color

@Composable
fun CustomCircle(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onPrimary,
    isBlur : Boolean = true
) {

    Box(
      modifier = modifier
          .clip(shape = CircleShape)
          .background(color)
    )
}