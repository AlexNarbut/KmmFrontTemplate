package ru.narbut.kmmfronttemp.presentation.theme

val DEFAULT_APP_DIMENS = AppDimensEnum.LARGE


enum class AppDimensEnum (val type : Int) {
    SMALL(0),MEDIUM(1), LARGE(2);

    fun getDimensClass(): DimensImpl {
        return when (this) {
            SMALL -> smallDimens
            MEDIUM -> mediumDimens
            LARGE -> largeDimens
        }
    }

    companion object {
        fun fromInt(value1: Int): AppDimensEnum {
            val value = entries.firstOrNull { it.type == value1 }
            return value?: DEFAULT_APP_DIMENS
        }
        fun fromString(value1: String): AppDimensEnum {
            val intValue = value1.toIntOrNull()?: DEFAULT_APP_DIMENS.type
            return fromInt(intValue)
        }
    }
}

class DimensImpl(
    val windowWidth: Int,
    val windowHeight: Int,

    val maxContentWidth: Int,
    val contentWidthRation: Float,

    val dialogWidth: Int,
    val dialogHeight: Int,

    val notificationWidth: Int,

    val displayLarge: Int,
    val displayMedium: Int,
    val displaySmall: Int,

    val headlineLarge: Int,
    val headlineMedium: Int,
    val headlineSmall: Int,

    val titleLarge: Int,
    val titleMedium: Int,
    val titleSmall: Int,

    val bodyLarge: Int,
    val bodyMedium: Int,
    val bodySmall: Int,

    val labelLarge: Int,
    val labelMedium: Int,
    val labelSmall: Int,

    val marginXXTinySize: Int,
    val marginXTinySize: Int,
    val marginTinySize: Int,
    val marginSmallSize: Int,
    val marginMediumSize: Int,
    val marginLargeSize: Int,
    val marginXLargeSize: Int,
    val marginXXLargeSize: Int,

    val iconXXTinySize: Int,
    val iconXTinySize: Int,
    val iconTinySize: Int,
    val iconSmallSize: Int,
    val iconMediumSize: Int,
    val iconLargeSize: Int,
    val iconXLargeSize: Int,
    val iconXXLargeSize: Int,

    val progressSmallSize: Int,
    val progressMediumSize: Int,
    val progressLargeSize: Int,
    val progressStrokeWidth: Int,

    val cardBorderStrokeWidth: Int,
    val cardCornerRadius: Int,

    val scrollbarThickness: Int,
    val scrollbarHeight: Int,

    val dividerThickness: Int,

    val statusBarHeight: Int,

    val buttonVerticalPadding: Int,
    val buttonHorizontalPadding: Int,

    val toolbarHeight: Int,
    val toolbarSmallHeight: Int,
) {

    companion object {
        const val DESKTOP_TEXT_SIZE_COEF = 1.2f
    }
}

val smallDimens = DimensImpl(
    windowWidth = 1100,
    windowHeight = 700,

    maxContentWidth = 800,
    contentWidthRation = 1f / 2,

    dialogWidth = 200,
    dialogHeight = 150,

    notificationWidth = 350,

    displayLarge = 60,
    displayMedium = 48,
    displaySmall = 38,

    headlineLarge = 32,
    headlineMedium = 28,
    headlineSmall = 24,

    titleLarge = 22,
    titleMedium = 16,
    titleSmall = 14,

    bodyLarge = 16,
    bodyMedium = 14,
    bodySmall = 12,

    labelLarge = 14,
    labelMedium = 12,
    labelSmall = 10,

    marginXXTinySize = 1,
    marginXTinySize = 2,
    marginTinySize = 4,
    marginSmallSize = 6,
    marginMediumSize = 9,
    marginLargeSize = 12,
    marginXLargeSize = 18,
    marginXXLargeSize = 24,

    iconXXTinySize = 4,
    iconXTinySize = 8,
    iconTinySize = 12,
    iconSmallSize = 18,
    iconMediumSize = 24,
    iconLargeSize = 36,
    iconXLargeSize = 48,
    iconXXLargeSize = 84,

    progressSmallSize = 24,
    progressMediumSize = 36,
    progressLargeSize = 48,
    progressStrokeWidth = 2,

    cardBorderStrokeWidth = 2,
    cardCornerRadius = 4,

    scrollbarThickness = 8,
    scrollbarHeight = 4,

    dividerThickness = 1,

    statusBarHeight = 24,


    buttonVerticalPadding = 4,
    buttonHorizontalPadding = 8,

    toolbarHeight = 42,
    toolbarSmallHeight = 26
)

val mediumDimens = DimensImpl(
    windowWidth = 1100,
    windowHeight = 700,

    maxContentWidth = 800,
    contentWidthRation = 1f / 2,

    dialogWidth = 200,
    dialogHeight = 150,

    notificationWidth = 350,

    displayLarge = 62,
    displayMedium = 50,
    displaySmall = 40,

    headlineLarge = 36,
    headlineMedium = 32,
    headlineSmall = 28,

    titleLarge = 26,
    titleMedium = 20,
    titleSmall = 18,

    bodyLarge = 20,
    bodyMedium = 18,
    bodySmall = 16,

    labelLarge = 17,
    labelMedium = 14,
    labelSmall = 12,

    marginXXTinySize = 2,
    marginXTinySize = 4,
    marginTinySize = 8,
    marginSmallSize = 12,
    marginMediumSize = 16,
    marginLargeSize = 24,
    marginXLargeSize = 36,
    marginXXLargeSize = 48,

    iconXXTinySize = 8,
    iconXTinySize = 12,
    iconTinySize = 16,
    iconSmallSize = 24,
    iconMediumSize = 30,
    iconLargeSize = 44,
    iconXLargeSize = 64,
    iconXXLargeSize = 100,

    progressSmallSize = 32,
    progressMediumSize = 48,
    progressLargeSize = 64,
    progressStrokeWidth = 2,

    cardBorderStrokeWidth = 2,
    cardCornerRadius = 4,

    scrollbarThickness = 8,
    scrollbarHeight = 4,

    dividerThickness = 1,

    buttonVerticalPadding = 8,
    buttonHorizontalPadding = 12,

    statusBarHeight = 24,

    toolbarHeight = 60,
    toolbarSmallHeight = 32
)

val largeDimens = DimensImpl(
    windowWidth = 1100,
    windowHeight = 700,

    maxContentWidth = 800,
    contentWidthRation = 1f / 2,

    dialogWidth = 200,
    dialogHeight = 150,

    notificationWidth = 350,

    displayLarge = 65,
    displayMedium = 53,
    displaySmall = 43,

    headlineLarge = 39,
    headlineMedium = 35,
    headlineSmall = 31,

    titleLarge = 26,
    titleMedium = 23,
    titleSmall = 19,

    bodyLarge = 23,
    bodyMedium = 21,
    bodySmall = 18,

    labelLarge = 19,
    labelMedium = 15,
    labelSmall = 12,

    marginXXTinySize = 2,
    marginXTinySize = 4,
    marginTinySize = 8,
    marginSmallSize = 12,
    marginMediumSize = 16,
    marginLargeSize = 24,
    marginXLargeSize = 36,
    marginXXLargeSize = 48,

    iconXXTinySize = 12,
    iconXTinySize = 16,
    iconTinySize = 20,
    iconSmallSize = 28,
    iconMediumSize = 36,
    iconLargeSize = 54,
    iconXLargeSize = 72,
    iconXXLargeSize = 116,

    progressSmallSize = 40,
    progressMediumSize = 54,
    progressLargeSize = 72,
    progressStrokeWidth = 2,

    cardBorderStrokeWidth = 2,
    cardCornerRadius = 4,

    scrollbarThickness = 10,
    scrollbarHeight = 4,

    dividerThickness = 1,

    buttonVerticalPadding = 8,
    buttonHorizontalPadding = 12,

    statusBarHeight = 24,

    toolbarHeight = 60,
    toolbarSmallHeight = 40
)
