package ru.narbut.kmmfronttemp.ui.switch

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchColors
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

@Composable
fun MainSwitch(
    checked: Boolean,
    onCheckedChange: ((Boolean) -> Unit)?,
    modifier: Modifier = Modifier,
    colors: SwitchColors = SwitchDefaults.colors(
        checkedThumbColor = MaterialTheme.colorScheme.primary
    ),
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    Switch(
        checked = checked,
        onCheckedChange = onCheckedChange,
        modifier = modifier,
        colors = colors,
        interactionSource = interactionSource
    )
}