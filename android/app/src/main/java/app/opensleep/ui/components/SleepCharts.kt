package app.opensleep.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.res.stringResource
import app.opensleep.R
import app.opensleep.data.local.SleepStageType
import app.opensleep.ui.theme.*
import java.util.concurrent.TimeUnit

fun stageNameRes(type: SleepStageType): Int = when (type) {
    SleepStageType.AWAKE -> R.string.stage_awake
    SleepStageType.LIGHT -> R.string.stage_light
    SleepStageType.DEEP -> R.string.stage_deep
    SleepStageType.REM -> R.string.stage_rem
}

fun stageColor(type: SleepStageType): Color = when (type) {
    SleepStageType.AWAKE -> ColorAwake
    SleepStageType.LIGHT -> ColorLight
    SleepStageType.DEEP -> ColorDeep
    SleepStageType.REM -> ColorREM
}

/**
 * Donut chart showing proportion of each sleep stage.
 */
@Composable
fun SleepRingChart(
    stageDurations: Map<SleepStageType, Long>,
    modifier: Modifier = Modifier
) {
    val totalMs = stageDurations.values.sum().takeIf { it > 0 } ?: return
    val nonZero = stageDurations.filter { it.value > 0 }
    val angles = nonZero.map { (type, ms) ->
        type to (ms.toFloat() / totalMs * 360f)
    }

    val strokeWidth = 28.dp

    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val diameter = minOf(size.width, size.height)
            val strokePx = strokeWidth.toPx()
            val topLeft = Offset(
                (size.width - diameter) / 2 + strokePx / 2,
                (size.height - diameter) / 2 + strokePx / 2
            )
            val arcSize = Size(diameter - strokePx, diameter - strokePx)

            var startAngle = -90f
            angles.forEach { (type, sweep) ->
                drawArc(
                    color = stageColor(type),
                    startAngle = startAngle,
                    sweepAngle = sweep,
                    useCenter = false,
                    topLeft = topLeft,
                    size = arcSize,
                    style = Stroke(width = strokePx, cap = androidx.compose.ui.graphics.StrokeCap.Butt)
                )
                startAngle += sweep
            }
        }

        // Center text — total sleep hours
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            val hours = TimeUnit.MILLISECONDS.toHours(totalMs)
            val minutes = TimeUnit.MILLISECONDS.toMinutes(totalMs) % 60
            Text(
                text = "${hours}h ${minutes}m",
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = TextPrimary
                )
            )
            Text(
                text = stringResource(R.string.total_sleep),
                style = MaterialTheme.typography.labelSmall.copy(color = TextSecondary)
            )
        }
    }
}

/**
 * Horizontal hypnogram — time-series strip chart showing sleep stages over the night.
 */
@Composable
fun SleepHypnogram(
    stages: List<app.opensleep.data.local.SleepStage>,
    sessionStartMs: Long? = null,
    totalDurationMs: Long,
    modifier: Modifier = Modifier
) {
    if (stages.isEmpty() || totalDurationMs <= 0) return

    val stageOrder = listOf(
        SleepStageType.AWAKE to 0f,
        SleepStageType.REM to 0.33f,
        SleepStageType.LIGHT to 0.66f,
        SleepStageType.DEEP to 1f
    )

    val finalStartMs = sessionStartMs ?: stages.firstOrNull()?.startMs ?: System.currentTimeMillis()
    val finalEndMs = finalStartMs + totalDurationMs

    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Canvas(modifier = Modifier.height(80.dp).fillMaxWidth()) {
            val totalWidth = size.width
            val height = size.height
            val trackHeight = height / stageOrder.size

            // Draw background dotted vertical grid lines (25%, 50%, 75% marks)
            val gridLines = 3
            for (i in 1..gridLines) {
                val fraction = i.toFloat() / (gridLines + 1)
                val gx = fraction * totalWidth
                drawLine(
                    color = TextTertiary.copy(alpha = 0.15f),
                    start = Offset(gx, 0f),
                    end = Offset(gx, height),
                    strokeWidth = 1.dp.toPx(),
                    pathEffect = androidx.compose.ui.graphics.PathEffect.dashPathEffect(floatArrayOf(5f, 10f), 0f)
                )
            }

            stages.forEach { stage ->
                val x = ((stage.startMs - finalStartMs).toFloat() / totalDurationMs) * totalWidth
                val w = ((stage.endMs - stage.startMs).toFloat() / totalDurationMs) * totalWidth
                val yIdx = stageOrder.indexOfFirst { it.first == stage.type }
                val y = yIdx * trackHeight

                drawRect(
                    color = stageColor(stage.type).copy(alpha = 0.85f),
                    topLeft = Offset(x, y),
                    size = Size(w.coerceAtLeast(2f), trackHeight - 2f)
                )
            }
        }

        // Time axis labels
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 4.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            val sdf = java.text.SimpleDateFormat("h:mm a", java.util.Locale.getDefault())
            val startTimeStr = sdf.format(java.util.Date(finalStartMs)).lowercase()
            val midTimeStr = sdf.format(java.util.Date(finalStartMs + totalDurationMs / 2)).lowercase()
            val endTimeStr = sdf.format(java.util.Date(finalEndMs)).lowercase()

            Text(
                text = startTimeStr,
                style = MaterialTheme.typography.labelSmall,
                color = TextSecondary
            )
            Text(
                text = midTimeStr,
                style = MaterialTheme.typography.labelSmall,
                color = TextTertiary
            )
            Text(
                text = endTimeStr,
                style = MaterialTheme.typography.labelSmall,
                color = TextSecondary
            )
        }
    }
}

/**
 * Legend row for sleep stages.
 */
@Composable
fun SleepStageLegend(
    stageDurations: Map<SleepStageType, Long>,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        SleepStageType.entries.forEach { type ->
            val ms = stageDurations[type] ?: 0L
            val minutes = TimeUnit.MILLISECONDS.toMinutes(ms)
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .padding(bottom = 2.dp)
                ) {
                    Canvas(modifier = Modifier.fillMaxSize()) {
                        drawCircle(color = stageColor(type))
                    }
                }
                Spacer(Modifier.height(4.dp))
                Text(
                    text = stringResource(stageNameRes(type)),
                    style = MaterialTheme.typography.labelSmall,
                    color = stageColor(type)
                )
                Text(
                    text = "${minutes}m",
                    style = MaterialTheme.typography.labelSmall,
                    color = TextSecondary
                )
            }
        }
    }
}
