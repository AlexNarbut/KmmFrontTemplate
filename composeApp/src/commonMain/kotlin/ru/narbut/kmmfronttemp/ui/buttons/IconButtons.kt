package ru.narbut.kmmfronttemp.ui.buttons

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import ru.narbut.kmmfronttemp.theme.composableDimens

@Composable
fun SmallIconButton(
    imageVector: ImageVector,
    onClick: () -> Unit,
    size: Int = composableDimens().iconSmallSize,
    modifier: Modifier = Modifier
) {
    Box(modifier) {
        Icon(
            modifier = Modifier
                .size(size.dp)
                .clickable { onClick() },
            imageVector = imageVector,
            contentDescription = "",
            tint = MaterialTheme.colorScheme.onBackground
        )
    }
}

@Composable
fun DefaultIconButton(
    imageVector: ImageVector,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(onClick = onClick, modifier) {
        Icon(
            modifier = Modifier.size(composableDimens().iconMediumSize.dp),
            imageVector = imageVector,
            contentDescription = "",
            tint = MaterialTheme.colorScheme.onSurface
        )
    }
}