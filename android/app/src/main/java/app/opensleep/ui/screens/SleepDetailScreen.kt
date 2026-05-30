package app.opensleep.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import app.opensleep.data.local.SleepSession
import app.opensleep.ui.components.GlassCard
import app.opensleep.ui.components.SleepHypnogram
import app.opensleep.ui.components.SleepRingChart
import app.opensleep.ui.components.SleepStageLegend
import app.opensleep.ui.theme.*
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

@Composable
fun SleepDetailScreen(session: SleepSession, onBack: () -> Unit) {
    val fmt = SimpleDateFormat("EEEE, MMMM d", Locale.getDefault())
    val timeFmt = SimpleDateFormat("h:mm a", Locale.getDefault())
    val hours = TimeUnit.MILLISECONDS.toHours(session.durationMs())
    val minutes = TimeUnit.MILLISECONDS.toMinutes(session.durationMs()) % 60
    val stages = session.stageDurations()
    val stageList = session.stages()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(NavyDeep)
            .verticalScroll(rememberScrollState())
    ) {
        // Top bar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onBack) {
                Icon(Icons.Default.ArrowBack, null, tint = IndigoLight)
            }
            Text(
                text = fmt.format(Date(session.startTimeMs)),
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.SemiBold, color = TextPrimary
                )
            )
        }

        Spacer(Modifier.height(8.dp))

        // Summary card
        GlassCard(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                StatChip("Bedtime", timeFmt.format(Date(session.startTimeMs)))
                StatChip("Wake up", timeFmt.format(Date(session.endTimeMs ?: 0L)))
                StatChip("Duration", "${hours}h ${minutes}m")
            }
        }

        Spacer(Modifier.height(20.dp))

        // Donut ring
        GlassCard(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Sleep Stages", style = MaterialTheme.typography.titleLarge, color = TextPrimary)
                Spacer(Modifier.height(16.dp))
                SleepRingChart(
                    stageDurations = stages,
                    modifier = Modifier
                        .size(200.dp)
                        .align(Alignment.CenterHorizontally)
                )
                Spacer(Modifier.height(16.dp))
                SleepStageLegend(stageDurations = stages)
            }
        }

        Spacer(Modifier.height(20.dp))

        // Hypnogram
        GlassCard(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)) {
            Column {
                Text("Sleep Pattern", style = MaterialTheme.typography.titleLarge, color = TextPrimary)
                Spacer(Modifier.height(8.dp))
                Text(
                    "Awake · REM · Light · Deep  (top → bottom)",
                    style = MaterialTheme.typography.labelSmall,
                    color = TextTertiary
                )
                Spacer(Modifier.height(12.dp))
                SleepHypnogram(
                    stages = stageList,
                    totalDurationMs = session.durationMs(),
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        Spacer(Modifier.height(32.dp))
    }
}

@Composable
private fun StatChip(label: String, value: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(label, style = MaterialTheme.typography.labelSmall, color = TextSecondary)
        Spacer(Modifier.height(4.dp))
        Text(value, style = MaterialTheme.typography.bodyLarge.copy(
            fontWeight = FontWeight.SemiBold, color = TextPrimary
        ))
    }
}
