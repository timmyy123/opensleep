package app.opensleep.ui.screens

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.clickable
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bedtime
import androidx.compose.material.icons.filled.Stop
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.opensleep.R
import app.opensleep.data.local.SleepStageType
import app.opensleep.ui.components.GlassCard
import app.opensleep.ui.components.SleepRingChart
import app.opensleep.ui.components.SleepStageLegend
import app.opensleep.ui.theme.*
import app.opensleep.viewmodel.HomeViewModel
import java.util.concurrent.TimeUnit

@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    val context = LocalContext.current
    val isSleeping by viewModel.isSleeping.collectAsState()
    val activeSession by viewModel.activeSession.collectAsState()
    val elapsedSeconds by viewModel.elapsedSeconds.collectAsState()
 
    var areNotificationsEnabled by remember {
        mutableStateOf(androidx.core.app.NotificationManagerCompat.from(context).areNotificationsEnabled())
    }

    val lifecycleOwner = androidx.lifecycle.compose.LocalLifecycleOwner.current
    DisposableEffect(lifecycleOwner) {
        val observer = androidx.lifecycle.LifecycleEventObserver { _, event ->
            if (event == androidx.lifecycle.Lifecycle.Event.ON_RESUME) {
                areNotificationsEnabled = androidx.core.app.NotificationManagerCompat.from(context).areNotificationsEnabled()
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }

    val pulseAnim = rememberInfiniteTransition(label = "pulse")
    val pulseScale by pulseAnim.animateFloat(
        initialValue = 1f,
        targetValue = if (isSleeping) 1.08f else 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(2000, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "pulseScale"
    )

    val glowAlpha by pulseAnim.animateFloat(
        initialValue = 0.3f,
        targetValue = if (isSleeping) 0.7f else 0.3f,
        animationSpec = infiniteRepeatable(
            animation = tween(2000, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "glowAlpha"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(NavyDeep)
            .verticalScroll(rememberScrollState())
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(24.dp))

        // Header
        Text(
            text = stringResource(R.string.app_name),
            style = MaterialTheme.typography.headlineMedium.copy(
                color = IndigoLight,
                fontWeight = FontWeight.Bold
            )
        )

        Spacer(Modifier.height(8.dp))

        Text(
            text = if (isSleeping) stringResource(R.string.tracking_active)
                   else stringResource(R.string.tracking_idle),
            style = MaterialTheme.typography.bodyMedium,
            color = TextSecondary
        )

        if (!areNotificationsEnabled) {
            Spacer(Modifier.height(16.dp))
            GlassCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        val intent = android.content.Intent(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
                            data = android.net.Uri.fromParts("package", context.packageName, null)
                        }
                        context.startActivity(intent)
                    }
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Warning,
                        contentDescription = null,
                        tint = Color(0xFFFBBF24),
                        modifier = Modifier.size(32.dp)
                    )
                    Spacer(Modifier.width(16.dp))
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = stringResource(R.string.notifications_disabled_title),
                            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                            color = TextPrimary
                        )
                        Spacer(Modifier.height(4.dp))
                        Text(
                            text = stringResource(R.string.notifications_disabled_desc),
                            style = MaterialTheme.typography.bodyMedium,
                            color = TextSecondary
                        )
                    }
                }
            }
        }

        Spacer(Modifier.height(48.dp))

        // Main sleep button with glow ring
        Box(contentAlignment = Alignment.Center) {
            // Outer glow ring
            Box(
                modifier = Modifier
                    .size(200.dp)
                    .scale(pulseScale * 1.1f)
                    .background(
                        brush = Brush.radialGradient(
                            colors = listOf(
                                IndigoAccent.copy(alpha = glowAlpha),
                                Color.Transparent
                            )
                        ),
                        shape = CircleShape
                    )
            )

            // Button
            Button(
                onClick = {
                    if (isSleeping) viewModel.stopSleep(context)
                    else viewModel.startSleep(context)
                },
                modifier = Modifier
                    .size(160.dp)
                    .scale(if (isSleeping) pulseScale else 1f),
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (isSleeping) Color(0xFF1E1B4B) else IndigoAccent
                ),
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 0.dp)
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        imageVector = if (isSleeping) Icons.Default.Stop else Icons.Default.Bedtime,
                        contentDescription = null,
                        tint = TextPrimary,
                        modifier = Modifier.size(40.dp)
                    )
                    Spacer(Modifier.height(8.dp))
                    Text(
                        text = if (isSleeping) stringResource(R.string.stop_sleep)
                               else stringResource(R.string.start_sleep),
                        style = MaterialTheme.typography.labelLarge,
                        color = TextPrimary
                    )
                }
            }
        }

        Spacer(Modifier.height(32.dp))

        // Elapsed time
        if (isSleeping) {
            val hours = elapsedSeconds / 3600
            val minutes = (elapsedSeconds % 3600) / 60
            val seconds = elapsedSeconds % 60
            GlassCard(modifier = Modifier.fillMaxWidth()) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "%02d:%02d:%02d".format(hours, minutes, seconds),
                        style = MaterialTheme.typography.displayMedium.copy(
                            color = IndigoLight,
                            fontWeight = FontWeight.Light,
                            fontSize = 48.sp
                        )
                    )
                    Text(
                        text = stringResource(R.string.time_asleep),
                        style = MaterialTheme.typography.bodyMedium,
                        color = TextSecondary
                    )
                }
            }
        }

        // Show live stage breakdown if active
        activeSession?.let { session ->
            val stages = session.stageDurations()
            if (stages.values.any { it > 0 }) {
                Spacer(Modifier.height(24.dp))
                GlassCard(modifier = Modifier.fillMaxWidth()) {
                    Column {
                        Text(
                            text = stringResource(R.string.live_stages),
                            style = MaterialTheme.typography.titleLarge,
                            color = TextPrimary
                        )
                        Spacer(Modifier.height(16.dp))
                        SleepRingChart(
                            stageDurations = stages,
                            modifier = Modifier
                                .size(160.dp)
                                .align(Alignment.CenterHorizontally)
                        )
                        Spacer(Modifier.height(16.dp))
                        SleepStageLegend(stageDurations = stages)
                    }
                }
            }
        }

        Spacer(Modifier.height(24.dp))
    }
}
