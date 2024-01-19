package ru.narbut.kmmfronttemp.presentation.ui.buttons

import MainText
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import ru.narbut.kmmfronttemp.presentation.theme.composableDimens
import ru.narbut.kmmfronttemp.presentation.ui.spacer.VerticalSpacer

@Composable
fun CardButton(
    imageVector: ImageVector,
    text: String,
    onClick: () -> Unit,
    iconSize: Int = composableDimens().iconXLargeSize,
    modifier: Modifier = Modifier
){
    Card(modifier = modifier.clickable { onClick() }) {
        Box{
            Column(Modifier.align(Alignment.Center), horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(
                    imageVector = imageVector,
                    contentDescription = null,
                    modifier = Modifier.size(iconSize.dp),
                    tint = MaterialTheme.colorScheme.primary
                )
                VerticalSpacer(composableDimens().marginSmallSize)
                MainText(text)
            }
        }
    }
}