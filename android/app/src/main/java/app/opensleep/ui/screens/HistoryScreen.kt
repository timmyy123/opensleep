package app.opensleep.ui.screens

import androidx.compose.animation.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.opensleep.R
import app.opensleep.data.local.SleepSession
import app.opensleep.data.local.SleepStageType
import app.opensleep.ui.components.GlassCard
import app.opensleep.ui.components.SleepHypnogram
import app.opensleep.ui.components.SleepStageLegend
import app.opensleep.ui.components.stageColor
import app.opensleep.ui.theme.*
import app.opensleep.viewmodel.HistoryViewModel
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

enum class ChartTab { DAY, WEEK, MONTH, YEAR }

data class AndroidChartStagePoint(
    val label: String,
    val yStart: Float, // Hours since 6 PM of reference evening
    val yEnd: Float,   // Hours since 6 PM of reference evening
    val type: SleepStageType
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HistoryScreen(
    viewModel: HistoryViewModel,
    onSessionClick: (String) -> Unit
) {
    val sessions by viewModel.sessions.collectAsState()
    
    // Select & Delete States
    var isMultiSelectActive by remember { mutableStateOf(false) }
    val selectedSessionIds = remember { mutableStateListOf<String>() }
    var sessionsToDelete by remember { mutableStateOf<List<String>>(emptyList()) }
    var showDeleteAlert by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(NavyDeep)
            .padding(horizontal = 16.dp)
    ) {
        Spacer(Modifier.height(24.dp))
        
        // Header with Select/Cancel Toggle
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(R.string.history_title),
                style = MaterialTheme.typography.headlineMedium.copy(
                    color = TextPrimary, fontWeight = FontWeight.Bold
                )
            )
            
            if (sessions.filter { it.endTimeMs != null }.isNotEmpty()) {
                Text(
                    text = if (isMultiSelectActive) stringResource(R.string.cancel) else stringResource(R.string.select),
                    style = MaterialTheme.typography.titleMedium.copy(
                        color = IndigoLight,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier.clickable {
                        isMultiSelectActive = !isMultiSelectActive
                        if (!isMultiSelectActive) {
                            selectedSessionIds.clear()
                        }
                    }
                )
            }
        }
        
        Spacer(Modifier.height(16.dp))

        if (sessions.filter { it.endTimeMs != null }.isEmpty()) {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(
                    text = stringResource(R.string.no_sessions),
                    style = MaterialTheme.typography.bodyLarge,
                    color = TextTertiary
                )
            }
        } else {
            Box(modifier = Modifier.fillMaxSize()) {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier.fillMaxSize()
                ) {
                    // Breakdown Chart
                    item {
                        SleepBreakdownChart(sessions = sessions.filter { it.endTimeMs != null })
                        Spacer(Modifier.height(8.dp))
                    }
                    
                    items(sessions.filter { it.endTimeMs != null }, key = { it.id }) { session ->
                        if (isMultiSelectActive) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable {
                                        if (selectedSessionIds.contains(session.id)) {
                                            selectedSessionIds.remove(session.id)
                                        } else {
                                            selectedSessionIds.add(session.id)
                                        }
                                    },
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Checkbox(
                                    checked = selectedSessionIds.contains(session.id),
                                    onCheckedChange = { checked ->
                                        if (checked == true) {
                                            selectedSessionIds.add(session.id)
                                        } else {
                                            selectedSessionIds.remove(session.id)
                                        }
                                    },
                                    colors = CheckboxDefaults.colors(
                                        checkedColor = IndigoAccent,
                                        uncheckedColor = TextTertiary
                                    )
                                )
                                Spacer(Modifier.width(8.dp))
                                SleepSessionCard(
                                    session = session,
                                    onClick = {
                                        if (selectedSessionIds.contains(session.id)) {
                                            selectedSessionIds.remove(session.id)
                                        } else {
                                            selectedSessionIds.add(session.id)
                                        }
                                    }
                                )
                            }
                        } else {
                            val dismissState = rememberSwipeToDismissBoxState(
                                confirmValueChange = { value ->
                                    if (value == SwipeToDismissBoxValue.EndToStart) {
                                        sessionsToDelete = listOf(session.id)
                                        showDeleteAlert = true
                                    }
                                    false
                                }
                            )

                            SwipeToDismissBox(
                                state = dismissState,
                                backgroundContent = {
                                    val isDismissed = dismissState.dismissDirection == SwipeToDismissBoxValue.EndToStart
                                    val color = if (isDismissed) {
                                        Color.Red.copy(alpha = 0.8f)
                                    } else {
                                        Color.Transparent
                                    }
                                    Box(
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .background(color, shape = RoundedCornerShape(16.dp))
                                            .padding(horizontal = 24.dp),
                                        contentAlignment = Alignment.CenterEnd
                                    ) {
                                        if (isDismissed) {
                                            Icon(
                                                imageVector = Icons.Default.Delete,
                                                contentDescription = "Delete",
                                                tint = Color.White,
                                                modifier = Modifier.size(28.dp)
                                            )
                                        }
                                    }
                                },
                                content = {
                                    SleepSessionCard(
                                        session = session,
                                        onClick = { onSessionClick(session.id) }
                                    )
                                },
                                enableDismissFromStartToEnd = false
                            )
                        }
                    }
                    
                    item {
                        Spacer(Modifier.height(if (isMultiSelectActive) 100.dp else 80.dp))
                    }
                }
                
                // Sticky multi-select action bar
                if (isMultiSelectActive) {
                    Box(
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .padding(bottom = 12.dp)
                    ) {
                        GlassCard(modifier = Modifier.fillMaxWidth()) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 16.dp, vertical = 12.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "${selectedSessionIds.size} Selected",
                                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
                                    color = TextPrimary
                                )
                                Button(
                                    onClick = {
                                        if (selectedSessionIds.isNotEmpty()) {
                                            sessionsToDelete = selectedSessionIds.toList()
                                            showDeleteAlert = true
                                        }
                                    },
                                    enabled = selectedSessionIds.isNotEmpty(),
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = Color.Red,
                                        disabledContainerColor = TextTertiary.copy(alpha = 0.3f)
                                    )
                                ) {
                                    Text(stringResource(R.string.delete_confirm), color = TextPrimary)
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    // Delete confirmation alert dialog
    if (showDeleteAlert) {
        AlertDialog(
            onDismissRequest = {
                showDeleteAlert = false
                sessionsToDelete = emptyList()
            },
            title = { Text(stringResource(R.string.delete_session_title)) },
            text = {
                Text(
                    if (sessionsToDelete.size > 1) {
                        "This will permanently delete the ${sessionsToDelete.size} selected sleep sessions and their synced health data."
                    } else {
                        stringResource(R.string.delete_session_message)
                    }
                )
            },
            confirmButton = {
                TextButton(onClick = {
                    sessionsToDelete.forEach { id ->
                        viewModel.deleteSession(id)
                    }
                    showDeleteAlert = false
                    isMultiSelectActive = false
                    selectedSessionIds.clear()
                    sessionsToDelete = emptyList()
                }) {
                    Text(stringResource(R.string.delete_confirm), color = MaterialTheme.colorScheme.error)
                }
            },
            dismissButton = {
                TextButton(onClick = {
                    showDeleteAlert = false
                    sessionsToDelete = emptyList()
                }) {
                    Text(stringResource(R.string.cancel))
                }
            }
        )
    }
}

fun getReferenceEvening(startTimeMs: Long): Long {
    val calendar = Calendar.getInstance()
    calendar.timeInMillis = startTimeMs
    val hour = calendar.get(Calendar.HOUR_OF_DAY)
    
    // If user went to sleep between midnight and noon, use the previous calendar day
    if (hour < 12) {
        calendar.add(Calendar.DAY_OF_YEAR, -1)
    }
    
    calendar.set(Calendar.HOUR_OF_DAY, 18) // 6:00 PM
    calendar.set(Calendar.MINUTE, 0)
    calendar.set(Calendar.SECOND, 0)
    calendar.set(Calendar.MILLISECOND, 0)
    return calendar.timeInMillis
}

fun getHoursSinceReference(timeMs: Long, refEveningMs: Long): Float {
    val diffMs = timeMs - refEveningMs
    val hours = diffMs.toFloat() / (1000f * 60f * 60f)
    return hours.coerceIn(0f, 24f)
}

fun formatYAxisLabel(hours: Float): String {
    val calendar = Calendar.getInstance()
    calendar.set(Calendar.HOUR_OF_DAY, 18) // 6:00 PM
    calendar.set(Calendar.MINUTE, 0)
    calendar.set(Calendar.SECOND, 0)
    calendar.set(Calendar.MILLISECOND, 0)
    calendar.add(Calendar.MINUTE, (hours * 60).toInt())
    
    val sdf = SimpleDateFormat("h a", Locale.getDefault())
    return sdf.format(calendar.time).lowercase()
}

@Composable
fun SleepBreakdownChart(
    sessions: List<SleepSession>,
    modifier: Modifier = Modifier
) {
    var selectedTab by remember { mutableStateOf(ChartTab.DAY) }
    
    val chartData = remember(sessions, selectedTab) {
        val sorted = sessions.sortedBy { it.startTimeMs }
        if (sorted.isEmpty()) return@remember emptyList<AndroidChartStagePoint>()
        
        val selectedSessions = when (selectedTab) {
            ChartTab.DAY -> sorted.takeLast(7)
            ChartTab.WEEK -> sorted.takeLast(14)
            ChartTab.MONTH -> sorted.takeLast(30)
            ChartTab.YEAR -> sorted.takeLast(90)
        }
        
        val points = mutableListOf<AndroidChartStagePoint>()
        val df = when (selectedTab) {
            ChartTab.DAY, ChartTab.WEEK -> SimpleDateFormat("E d", Locale.getDefault())
            ChartTab.MONTH -> SimpleDateFormat("d", Locale.getDefault())
            ChartTab.YEAR -> SimpleDateFormat("MMM", Locale.getDefault())
        }
        
        selectedSessions.forEach { session ->
            val label = df.format(Date(session.startTimeMs))
            val refEvening = getReferenceEvening(session.startTimeMs)
            
            session.stages().forEach { stage ->
                val yStart = getHoursSinceReference(stage.startMs, refEvening)
                val yEnd = getHoursSinceReference(stage.endMs, refEvening)
                if (yEnd > yStart) {
                    points.add(
                        AndroidChartStagePoint(
                            label = label,
                            yStart = yStart,
                            yEnd = yEnd,
                            type = stage.type
                        )
                    )
                }
            }
        }
        points
    }

    GlassCard(modifier = modifier.fillMaxWidth()) {
        Column(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
            // Tab Selector Row
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(NavyDeep.copy(alpha = 0.6f), RoundedCornerShape(12.dp))
                    .padding(2.dp)
            ) {
                ChartTab.entries.forEach { tab ->
                    val isSelected = selectedTab == tab
                    val labelRes = when (tab) {
                        ChartTab.DAY -> R.string.chart_day
                        ChartTab.WEEK -> R.string.chart_week
                        ChartTab.MONTH -> R.string.chart_month
                        ChartTab.YEAR -> R.string.chart_year
                    }
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .background(
                                color = if (isSelected) IndigoAccent.copy(alpha = 0.6f) else Color.Transparent,
                                shape = RoundedCornerShape(12.dp)
                            )
                            .clickable { selectedTab = tab }
                            .padding(vertical = 8.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = stringResource(labelRes),
                            style = MaterialTheme.typography.bodyMedium.copy(
                                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium
                            ),
                            color = if (isSelected) TextPrimary else TextSecondary
                        )
                    }
                }
            }

            Spacer(Modifier.height(16.dp))

            // Canvas Bar Chart
            if (chartData.isEmpty()) {
                Box(
                    modifier = Modifier.fillMaxWidth().height(200.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(stringResource(R.string.no_sessions), color = TextSecondary)
                }
            } else {
                val textMeasurer = rememberTextMeasurer()
                val uniqueLabels = remember(chartData) { chartData.map { it.label }.distinct() }
                
                Canvas(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                ) {
                    val canvasWidth = size.width
                    val canvasHeight = size.height
                    val bottomPadding = 30.dp.toPx()
                    val chartHeight = canvasHeight - bottomPadding
                    
                    // Draw horizontal dashed grid lines (every 4 hours from 0 to 24)
                    val ticks = listOf(0f, 4f, 8f, 12f, 16f, 20f, 24f)
                    ticks.forEach { tick ->
                        val y = chartHeight * (tick / 24f)
                        drawLine(
                            color = TextTertiary.copy(alpha = 0.2f),
                            start = Offset(0f, y),
                            end = Offset(canvasWidth, y),
                            strokeWidth = 1.dp.toPx(),
                            pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
                        )
                        
                        // Draw grid numbers
                        drawText(
                            textMeasurer = textMeasurer,
                            text = formatYAxisLabel(tick),
                            style = androidx.compose.ui.text.TextStyle(
                                color = TextSecondary,
                                fontSize = 9.sp
                            ),
                            topLeft = Offset(4f, y + 2.dp.toPx())
                        )
                    }
                    
                    // Draw floating bars for each label
                    val barCount = uniqueLabels.size
                    val spacing = 16.dp.toPx()
                    val totalSpacing = spacing * (barCount + 1)
                    val barWidth = (canvasWidth - totalSpacing) / maxOf(1f, barCount.toFloat())
                    
                    uniqueLabels.forEachIndexed { idx, label ->
                        val x = spacing + idx * (barWidth + spacing)
                        
                        // Draw stages for this label
                        val stagesForLabel = chartData.filter { it.label == label }
                        stagesForLabel.forEach { stage ->
                            val yStartPx = chartHeight * (stage.yStart / 24f)
                            val yEndPx = chartHeight * (stage.yEnd / 24f)
                            val barHeight = yEndPx - yStartPx
                            
                            if (barHeight > 0f) {
                                drawRoundRect(
                                    color = stageColor(stage.type).copy(alpha = 0.85f),
                                    topLeft = Offset(x, yStartPx),
                                    size = Size(barWidth, barHeight),
                                    cornerRadius = CornerRadius(4.dp.toPx(), 4.dp.toPx())
                                )
                            }
                        }
                        
                        // Draw x-axis label centered
                        val layoutResult = textMeasurer.measure(
                            text = label,
                            style = androidx.compose.ui.text.TextStyle(
                                color = TextSecondary,
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Medium
                            )
                        )
                        drawText(
                            textLayoutResult = layoutResult,
                            topLeft = Offset(
                                x + (barWidth - layoutResult.size.width) / 2,
                                chartHeight + 8.dp.toPx()
                            )
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun SleepSessionCard(
    session: SleepSession,
    onClick: () -> Unit
) {
    val fmt = SimpleDateFormat("EEE, MMM d · h:mm a", Locale.getDefault())
    val hours = TimeUnit.MILLISECONDS.toHours(session.durationMs())
    val minutes = TimeUnit.MILLISECONDS.toMinutes(session.durationMs()) % 60
    val stageDurations = session.stageDurations()

    GlassCard(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        innerPadding = 16.dp
    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = fmt.format(Date(session.startTimeMs)),
                        style = MaterialTheme.typography.bodyMedium,
                        color = TextSecondary
                    )
                    Text(
                        text = "${hours}h ${minutes}m",
                        style = MaterialTheme.typography.headlineMedium.copy(
                            fontWeight = FontWeight.SemiBold, color = TextPrimary
                        )
                    )
                }
                Icon(Icons.Default.ChevronRight, null, tint = TextTertiary)
            }

            Spacer(Modifier.height(12.dp))

            // Mini hypnogram
            SleepHypnogram(
                stages = session.stages(),
                sessionStartMs = session.startTimeMs,
                totalDurationMs = session.durationMs(),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(Modifier.height(8.dp))
            SleepStageLegend(stageDurations = stageDurations)
        }
    }
}
