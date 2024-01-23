package ru.narbut.kmmfronttemp.presentation.ui.image

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import dev.icerock.moko.resources.ImageResource
import dev.icerock.moko.resources.compose.painterResource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext


@Composable
fun <T> AsyncImage(
    load: suspend () -> T,
    painterFor: @Composable (T) -> Painter,
    contentDescription: String,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Fit,
) {
    val image: T? by produceState<T?>(null) {
        value = withContext(Dispatchers.IO) {
            try {
                load()
            } catch (e: Exception) {
                e.printStackTrace()
                null
            }
        }
    }

    if (image != null) {
        Image(
            painter = painterFor(image!!),
            contentDescription = contentDescription,
            contentScale = contentScale,
            modifier = modifier
        )
    }
}

/*fun loadImageBitmap(file: File): ImageBitmap =
    file.inputStream().buffered().use(::loadImageBitmap)

fun loadSvgPainter(file: File, density: Density): Painter =
    file.inputStream().buffered().use { loadSvgPainter(it, density) }

fun loadXmlImageVector(file: File, density: Density): ImageVector =
    file.inputStream().buffered().use { loadXmlImageVector(InputSource(it), density) }*/

@Composable
fun SvgImage(
    res: ImageResource,
    colorFilter: ColorFilter? = null,
    contentDescription: String = "",
    modifier: Modifier = Modifier,
) {
    Image(
        contentDescription = contentDescription,
        painter = painterResource(res),
        colorFilter = colorFilter,
        modifier = modifier,
    )
}

@Composable
fun RemoteUrlImage(
    imageUrl: String,
    modifier: Modifier = Modifier,
    contentDescription: String = "",
    onSuccess: @Composable (() -> Unit)? = null,
    onLoading: @Composable (() -> Unit)? = null,
    onFailure: @Composable ((Throwable) -> Unit)? = null,
) {
    if (imageUrl.isEmpty()) return

    /*val image = lazyPainterResource(imageUrl, filterQuality = FilterQuality.Medium){
        requestBuilder {
            cacheControl(CacheControl.MAX_AGE)
        }
    }

    KamelImage(
        modifier = modifier,
        resource = image,
        contentDescription = contentDescription,
        crossfade = true,
        onLoading = {
            if (onLoading != null) {
                onLoading()
            }
        },
        onFailure = {
            if (onFailure != null) {
                onFailure(it)
            }
        },


    )*/
}

