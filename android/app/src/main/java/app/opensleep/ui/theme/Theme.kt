package app.opensleep.ui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = IndigoAccent,
    onPrimary = TextPrimary,
    primaryContainer = NavyMid,
    onPrimaryContainer = IndigoLight,
    secondary = CyanAccent,
    onSecondary = NavyDeep,
    secondaryContainer = SurfaceVariant,
    onSecondaryContainer = TextPrimary,
    tertiary = PurpleGlow,
    background = NavyDeep,
    onBackground = TextPrimary,
    surface = SurfaceContainer,
    onSurface = TextPrimary,
    surfaceVariant = SurfaceVariant,
    onSurfaceVariant = TextSecondary,
    outline = GlassWhiteBorder,
    error = ColorAwake
)

@Composable
fun OpenSleepTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = DarkColorScheme,
        typography = OpenSleepTypography,
        content = content
    )
}