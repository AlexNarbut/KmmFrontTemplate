package ru.narbut.kmmfronttemp.ui.shape

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection

class BottomLineShape (
    val lineWidth : Float
) : Shape {


    override fun createOutline(size: Size, layoutDirection: LayoutDirection, density: Density): Outline {
        return Outline.Generic(
            // Draw your custom path here
            path = drawTicketPath(
                size = size,
                lineWidth = lineWidth
            )
        )
    }

    fun drawTicketPath(size: Size,
                       lineWidth : Float): Path {
        return Path().apply {
            moveTo(0f,size.height)
            lineTo(0f, size.height - lineWidth)
            lineTo(size.width, size.height - lineWidth)
            lineTo(size.width, size.height)
            lineTo(0f, size.height)
            /*moveTo(0f,size.height)
            lineTo(0f, size.height - lineWidth)
            lineTo(size.width, size.height - size.height - lineWidth)
            lineTo(size.width, size.height)
            lineTo(0f, size.height)*/

            // 2)
            //lineTo(size.width, size.height)

            // 3)
            //lineTo(0f, size.height)

            // Top left arc
            /*arcTo(
                rect = Rect(
                    left = size.width - cornerRadius,
                    top = size.height - cornerRadius,
                    right = size.width + cornerRadius,
                    bottom = size.height + cornerRadius
                ),
                startAngleDegrees = 270.0f,
                sweepAngleDegrees = -90.0f,
                forceMoveTo = true
            )*/
            //lineTo(x = size.width, y = 0f)
            //lineTo(x = size.width - cornerRadius, y = 0f)

            //lineTo(x = size.width - cornerRadius, y = 0f)
            // Top right arc
            /*arcTo(
                rect = Rect(
                    left = -cornerRadius,
                    top = size.height - cornerRadius,
                    right = cornerRadius,
                    bottom = size.height + cornerRadius
                ),
                startAngleDegrees = 0.0f,
                sweepAngleDegrees = -90.0f,
                forceMoveTo = true
            )*/
            //lineTo(x = size.width, y = size.height - cornerRadius)
            // Bottom right arc
            /*arcTo(
                rect = Rect(
                    left = -cornerRadius,
                    top = -cornerRadius,
                    right = cornerRadius,
                    bottom = cornerRadius
                ),
                startAngleDegrees = 90.0f,
                sweepAngleDegrees = -90.0f,
                forceMoveTo = true
            )*/

            //lineTo(x = cornerRadius, y = size.height)
            // Bottom left arc
            /*arcTo(
                rect = Rect(
                    left = size.width - cornerRadius,
                    top = -cornerRadius,
                    right = size.width + cornerRadius,
                    bottom = cornerRadius
                ),
                startAngleDegrees = 180.0f,
                sweepAngleDegrees = -90.0f,
                forceMoveTo = true
            )*/

            //lineTo(x = 0f, y = cornerRadius)
            close()
        }
    }

}