import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import ru.narbut.kmmfronttemp.presentation.ui.addHoverEffect

@Composable
fun TitleText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onBackground,
    overflow: TextOverflow = TextOverflow.Clip,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE,
) {
    Text(
        modifier = modifier,
        text = text,
        color = color,
        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
        overflow = overflow,
        textAlign = textAlign,
        maxLines = maxLines
    )
}

@Composable
fun SubTitleText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onBackground,
    needHover : Boolean = false,
    hoverColor: Color = MaterialTheme.colorScheme.primary,
    overflow: TextOverflow = TextOverflow.Clip,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE,
) {
    val isHovered = remember { mutableStateOf(false) }
    Text(
        modifier = modifier.addHoverEffect {isHovered.value = it},
        text = text,
        style = MaterialTheme.typography.titleSmall,
        color = if(needHover && isHovered.value)hoverColor else color,
        overflow = overflow,
        textAlign = textAlign,
        maxLines = maxLines
    )
}


@Composable
fun MainText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onBackground,
    needHover : Boolean = false,
    hoverColor: Color = MaterialTheme.colorScheme.primary,
    overflow: TextOverflow = TextOverflow.Clip,
    textAlign: TextAlign = TextAlign.Start,
    maxLines: Int = Int.MAX_VALUE
) {
    val isHovered = remember { mutableStateOf(false) }
    Text(
        modifier = modifier.addHoverEffect {isHovered.value = it},
        text = text,
        color = if(needHover && isHovered.value)hoverColor else color,
        style = MaterialTheme.typography.bodyMedium,
        overflow = overflow,
        textAlign = textAlign,
        maxLines = maxLines
    )
}

@Composable
fun MainPrimaryText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.primary,
    overflow: TextOverflow = TextOverflow.Clip,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE
) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.bodyMedium,
        color = color,
        overflow = overflow,
        textAlign = textAlign,
        maxLines = maxLines
    )
}

@Composable
fun SubText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onSurface,
    overflow: TextOverflow = TextOverflow.Clip,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE
) {
    Text(
        modifier = modifier,
        text = text,
        color = color,
        style = MaterialTheme.typography.bodySmall,
        overflow = overflow,
        textAlign = textAlign,
        maxLines = maxLines
    )
}


@Composable
fun MainCustomText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onBackground,
    overflow: TextOverflow = TextOverflow.Clip,
    textAlign: TextAlign? = null,
    textStyle : TextStyle = MaterialTheme.typography.bodyMedium,
    singleLine: Boolean = false,
    maxLines: Int = Int.MAX_VALUE
) {
    Text(
        modifier = modifier,
        text = text,
        style = textStyle,
        color = color,
        overflow = overflow,
        textAlign = textAlign,
        maxLines = maxLines,
    )
}

@Composable
fun ResizableTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    leadingIcon: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
    placeholderText: String = "",
    singleLine : Boolean = true,
    fontSize: TextUnit = MaterialTheme.typography.bodyMedium.fontSize
) {
    BasicTextField(modifier = modifier
        .background(
            MaterialTheme.colorScheme.surface,
            MaterialTheme.shapes.small,
        )
        .fillMaxWidth(),
        value = value,
        onValueChange = {
            onValueChange(it)
        },
        singleLine = singleLine,
        cursorBrush = SolidColor(MaterialTheme.colorScheme.primary),
        textStyle = LocalTextStyle.current.copy(
            color = MaterialTheme.colorScheme.onSurface,
            fontSize = fontSize
        ),
        decorationBox = { innerTextField ->
            Row(
                modifier,
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (leadingIcon != null) leadingIcon()
                Box(Modifier.weight(1f)) {
                    if (value.isEmpty()) Text(
                        placeholderText,
                        style = LocalTextStyle.current.copy(
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.3f),
                            fontSize = fontSize
                        ),
                        maxLines = 1
                    )
                    innerTextField()
                }
                if (trailingIcon != null) trailingIcon()
            }
        }
    )
}

