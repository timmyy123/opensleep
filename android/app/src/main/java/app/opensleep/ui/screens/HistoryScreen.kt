package app.opensleep.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import app.opensleep.R
import app.opensleep.data.local.SleepSession
import app.opensleep.ui.components.SleepRingChart
import app.opensleep.ui.components.SleepStageLegend
import app.opensleep.ui.components.SleepHypnogram
import app.opensleep.ui.components.GlassCard
import app.opensleep.ui.theme.*
import app.opensleep.viewmodel.HistoryViewModel
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

@Composable
fun HistoryScreen(
    viewModel: HistoryViewModel,
    onSessionClick: (String) -> Unit
) {
    val sessions by viewModel.sessions.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(NavyDeep)
            .padding(horizontal = 16.dp)
    ) {
        Spacer(Modifier.height(24.dp))
        Text(
            text = stringResource(R.string.history_title),
            style = MaterialTheme.typography.headlineMedium.copy(
                color = TextPrimary, fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.padding(horizontal = 8.dp)
        )
        Spacer(Modifier.height(16.dp))

        if (sessions.isEmpty()) {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(
                    text = stringResource(R.string.no_sessions),
                    style = MaterialTheme.typography.bodyLarge,
                    color = TextTertiary
                )
            }
        } else {
            LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                items(sessions.filter { it.endTimeMs != null }, key = { it.id }) { session ->
                    SleepSessionCard(
                        session = session,
                        onClick = { onSessionClick(session.id) },
                        onDelete = { viewModel.deleteSession(session.id) }
                    )
                }
                item { Spacer(Modifier.height(80.dp)) }
            }
        }
    }
}

@Composable
fun SleepSessionCard(
    session: SleepSession,
    onClick: () -> Unit,
    onDelete: () -> Unit
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
                Row {
                    IconButton(onClick = onDelete) {
                        Icon(Icons.Default.Delete, null, tint = ColorAwake.copy(alpha = 0.7f))
                    }
                    Icon(Icons.Default.ChevronRight, null, tint = TextTertiary)
                }
            }

            Spacer(Modifier.height(12.dp))

            // Mini hypnogram
            SleepHypnogram(
                stages = session.stages(),
                totalDurationMs = session.durationMs(),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(Modifier.height(8.dp))
            SleepStageLegend(stageDurations = stageDurations)
        }
    }
}
