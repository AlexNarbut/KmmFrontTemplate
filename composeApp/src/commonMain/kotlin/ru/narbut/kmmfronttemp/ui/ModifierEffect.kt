package ru.narbut.kmmfronttemp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ru.narbut.kmmfronttemp.theme.composableDimens
import ru.narbut.kmmfronttemp.ui.shape.LineRoundedCornerShape

@Composable
fun Modifier.addHoverEffect(
    onClicked: () -> Unit,
    normalColor: Color = MaterialTheme.colorScheme.secondary,
    normalAlpha: Float = 0f,
    hoverAlpha: Float = 0.5f,
    needAlwaysHover : Boolean = false,
    hoverShape : Shape = LineRoundedCornerShape(composableDimens().cardBorderStrokeWidth.dp.value,composableDimens().cardCornerRadius.dp.value),
    alwaysHoverShape : Shape = RoundedCornerShape( composableDimens().cardCornerRadius.dp)
): Modifier {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()
    val backgroundAlpha = if (needAlwaysHover || isHovered) hoverAlpha else normalAlpha


    return this
        .hoverable(interactionSource)
        .background(normalColor.copy(alpha = backgroundAlpha), if (needAlwaysHover) alwaysHoverShape else hoverShape)
        .clickable {
            onClicked()
        }

}

@Composable
fun Modifier.addHoverEffect(
    onHover: (isHovered : Boolean) -> Unit,
): Modifier {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()
    if(isHovered){
        onHover(true)
    }else onHover(false)
    return this.hoverable(interactionSource)
}

//@Composable
//fun Modifier.addHoverLineEffect(
//    onClicked: () -> Unit,
//    needAlwaysHover : Boolean = false,
//    width : Dp = Dimens.CARD_STROKE_BORDER_WIDTH.dp,
//    normalColor: Color = MaterialTheme.colors.secondary,
//    normalAlpha: Float = 0f,
//    hoverAlpha: Float = 0.5f,
//    cornerRadius: Dp = Dimens.CARD_CORNER_RADIUS.dp
//): Modifier {
//    var isHovered by remember { mutableStateOf(false) }
//    val backgroundAlpha = if (isHovered) {
//        hoverAlpha
//    } else {
//        normalAlpha
//    }
//
//    return this
//        .background(normalColor.copy(alpha = if(needAlwaysHover) hoverAlpha else backgroundAlpha), LineRoundedCornerShape(width.value,cornerRadius.value))
//        .clickable {
//            onClicked()
//        }
//        .pointerMoveFilter(
//            onEnter = {
//                isHovered = true
//                false
//            },
//            onExit = {
//                isHovered = false
//                false
//            }
//        )
//}

//@Composable
//fun Modifier.addUnderscoreEffect(
//    onClicked: () -> Unit,
//    needAlwaysHover : Boolean = false,
//    width : Dp = Dimens.CARD_STROKE_BORDER_WIDTH.dp,
//    normalColor: Color = MaterialTheme.colors.secondary,
//    normalAlpha: Float = 0f,
//    hoverAlpha: Float = 0.5f
//): Modifier {
//    var isHovered by remember { mutableStateOf(false) }
//    val backgroundAlpha = if (isHovered) {
//        hoverAlpha
//    } else {
//        normalAlpha
//    }
//
//    return this
//        .background(normalColor.copy(alpha = if(needAlwaysHover) hoverAlpha else backgroundAlpha), BottomLineShape(width.value))
//        .clickable {
//            onClicked()
//        }
//        .pointerMoveFilter(
//            onEnter = {
//                isHovered = true
//                false
//            },
//            onExit = {
//                isHovered = false
//                false
//            }
//        )
//}

@Composable
fun Modifier.addCardEffect(
    color: Color = MaterialTheme.colorScheme.secondary,
    cornerRadius: Dp = composableDimens().cardCornerRadius.dp
): Modifier {
    return this.background(color, RoundedCornerShape(cornerRadius))
}


//@Composable
//fun Modifier.simpleVerticalScrollbar(
//    state: LazyListState,
//    width: Dp = 8.dp
//): Modifier {
//    val targetAlpha = if (state.isScrollInProgress) 1f else 0f
//    val duration = if (state.isScrollInProgress) 150 else 500
//
//    val alpha by animateFloatAsState(
//        targetValue = targetAlpha,
//        animationSpec = tween(durationMillis = duration)
//    )
//
//    return drawWithContent {
//        drawContent()
//
//        val firstVisibleElementIndex = state.layoutInfo.visibleItemsInfo.firstOrNull()?.index
//        val needDrawScrollbar = state.isScrollInProgress || alpha > 0.0f
//
//        // Draw scrollbar if scrolling or if the animation is still running and lazy column has content
//        if (needDrawScrollbar && firstVisibleElementIndex != null) {
//            val elementHeight = this.size.height / state.layoutInfo.totalItemsCount
//            val scrollbarOffsetY = firstVisibleElementIndex * elementHeight
//            val scrollbarHeight = state.layoutInfo.visibleItemsInfo.size * elementHeight
//
//            drawRect(
//                color = Color.Red,
//                topLeft = Offset(this.size.width - width.toPx(), scrollbarOffsetY),
//                size = Size(width.toPx(), scrollbarHeight),
//                alpha = alpha
//            )
//        }
//    }
//}