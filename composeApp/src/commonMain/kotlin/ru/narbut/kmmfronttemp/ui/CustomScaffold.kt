package ru.narbut.kmmfronttemp.ui

import MainText
import TitleText
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ru.narbut.kmmfronttemp.theme.composableDimens
import ru.narbut.kmmfronttemp.ui.spacer.HorizontalSpacer

//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun CustomScaffold(
//    modifier: Modifier = Modifier.fillMaxSize(),
//    title: String,
//    subTitle: String? = null,
//    containerColor: Color = MaterialTheme.colorScheme.background,
//    titleContentColor: Color = contentColorFor(containerColor),
//    navigationIconContentColor: Color = contentColorFor(containerColor),
//    navigationIcon: (@Composable () -> Unit) = {},
//    actions: @Composable RowScope.() -> Unit = {},
//    content: @Composable BoxScope.() -> Unit
//) {
//    Scaffold(
//        modifier = modifier,
//        topBar = {
////            TopAppBar(
////                title = {
////                    Column {
////                        TitleText(
////                            text = title,
////                            color = MaterialTheme.colorScheme.onPrimary
////                        )
////
////                        if (!subTitle.isNullOrEmpty()) {
////                            SubText(
////                                text = subTitle,
////                                color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.5f)
////                            )
////                        }
////                    }
////                },
//////                colors = TopAppBarDefaults.topAppBarColors(
//////                    containerColor = containerColor,
//////                    //titleContentColor = titleContentColor,
//////                    navigationIconContentColor = navigationIconContentColor
//////                ),
////                navigationIcon = navigationIcon,
////                actions = actions
////            )
//        },
//    ) { padding ->
//        Box(
//            modifier = Modifier.padding(
//                horizontal = composableDimens().marginSmallSize.dp,
//                vertical = composableDimens().marginSmallSize.dp,
//            )
//        ) {
//            content()
//        }
//    }
//}

@Composable
fun CustomScaffold(
    title: String,
    subTitle: String? = null,
    modifier: Modifier = Modifier.fillMaxSize(),
    onBackClicked: (() -> Unit)? = null,
    topRightSlot: (@Composable () -> Unit)? = null,
    bottomGradient: Boolean = false,
    content: @Composable BoxScope.() -> Unit
) {
    CustomScaffold(
        title = {
            Column {
                TitleText(
                    text = title,
                )
                if (!subTitle.isNullOrEmpty()) {
                    MainText(
                        text = subTitle,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
                    )
                }
            }
        },
        modifier,
        onBackClicked,
        topRightSlot,
        bottomGradient,
        content
    )
}

@Composable
fun CustomScaffold(
    title: @Composable () -> Unit,
    modifier: Modifier = Modifier.fillMaxSize(),
    onBackClicked: (() -> Unit)? = null,
    topRightSlot: (@Composable () -> Unit)? = null,
    bottomGradient: Boolean = false,
    content: @Composable BoxScope.() -> Unit
) {
    Column(
        modifier = modifier,
    ) {
        // Header
        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Back button
            if (onBackClicked != null) {
                IconButton(
                    onClick = onBackClicked,
                ) {
                    Icon(
                        modifier = Modifier.size(composableDimens().iconMediumSize.dp),
                        imageVector = Icons.Outlined.ArrowBack,
                        contentDescription = ""
                    )
                }
            } else {
                HorizontalSpacer(composableDimens().marginMediumSize)
            }

            title()

            // Right slot (Search, Icons etc)
            if (topRightSlot != null) {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.CenterEnd
                ) {
                    topRightSlot()
                }
            }
        }

        Spacer(
            modifier = Modifier.height(composableDimens().marginTinySize.dp)
        )

        Box {
            // Content slot
            content()

            if (bottomGradient) {
                BottomGradient()
            }
        }

    }
}

val BOTTOM_GRADIENT_HEIGHT = 50.dp

@Composable
fun BoxScope.BottomGradient() {
    // Bottom gradient
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(BOTTOM_GRADIENT_HEIGHT)
            .align(Alignment.BottomCenter)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.Transparent,
                        MaterialTheme.colorScheme.primary
                    )
                )
            )
    )
}
