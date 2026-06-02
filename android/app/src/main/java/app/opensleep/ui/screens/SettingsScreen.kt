package app.opensleep.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.opensleep.R
import app.opensleep.domain.DownloadStatus
import app.opensleep.domain.ModelVariant
import app.opensleep.ui.components.GlassCard
import app.opensleep.ui.theme.*
import app.opensleep.viewmodel.SettingsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(viewModel: SettingsViewModel) {
    val downloadStatus by viewModel.downloadStatus.collectAsState()
    val activeVariant by viewModel.activeVariant.collectAsState()
    val currentLanguage by viewModel.currentLanguage.collectAsState()

    val languages = listOf(
        "en" to "English",
        "pt" to "Português",
        "es" to "Español",
        "de" to "Deutsch",
        "fr" to "Français",
        "it" to "Italiano"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(NavyDeep)
            .verticalScroll(rememberScrollState())
            .padding(24.dp)
    ) {
        Spacer(Modifier.height(24.dp))

        // Title
        Text(
            text = stringResource(R.string.menu_settings),
            style = MaterialTheme.typography.headlineMedium.copy(
                color = IndigoLight,
                fontWeight = FontWeight.Bold
            )
        )

        Spacer(Modifier.height(24.dp))

        // Language Section
        Text(
            text = stringResource(R.string.section_language),
            style = MaterialTheme.typography.titleMedium,
            color = IndigoLight,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        var expanded by remember { mutableStateOf(false) }
        val currentLangName = languages.find { (tag, _) -> currentLanguage == tag || (currentLanguage.startsWith(tag) && tag != "en") }?.second ?: "English"

        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = it },
            modifier = Modifier.fillMaxWidth()
        ) {
            OutlinedTextField(
                value = currentLangName,
                onValueChange = {},
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                colors = ExposedDropdownMenuDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = IndigoLight.copy(alpha = 0.5f),
                    focusedBorderColor = IndigoLight,
                    unfocusedTextColor = TextPrimary,
                    focusedTextColor = TextPrimary,
                    unfocusedTrailingIconColor = IndigoLight,
                    focusedTrailingIconColor = IndigoLight
                ),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.fillMaxWidth().menuAnchor()
            )
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier.background(NavyDeep)
            ) {
                languages.forEach { (tag, name) ->
                    DropdownMenuItem(
                        text = { Text(name, color = TextPrimary) },
                        onClick = {
                            viewModel.setLanguage(tag)
                            expanded = false
                        },
                        contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                    )
                }
            }
        }

        Spacer(Modifier.height(32.dp))

        // AI Settings Section
        Text(
            text = stringResource(R.string.section_ai_settings),
            style = MaterialTheme.typography.titleMedium,
            color = IndigoLight,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        val useGpu by viewModel.useGpu.collectAsState()

        GlassCard(modifier = Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp, horizontal = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = stringResource(R.string.setting_use_gpu),
                        style = MaterialTheme.typography.bodyLarge,
                        color = TextPrimary
                    )
                    Spacer(Modifier.height(4.dp))
                    Text(
                        text = stringResource(R.string.setting_use_gpu_desc),
                        style = MaterialTheme.typography.bodySmall,
                        color = TextSecondary
                    )
                }
                Switch(
                    checked = useGpu,
                    onCheckedChange = { viewModel.setUseGpu(it) },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = Color.White,
                        checkedTrackColor = IndigoAccent,
                        uncheckedThumbColor = TextSecondary,
                        uncheckedTrackColor = SurfaceVariant
                    )
                )
            }
        }

        Spacer(Modifier.height(32.dp))

        // Downloads Section
        Text(
            text = stringResource(R.string.section_models),
            style = MaterialTheme.typography.titleMedium,
            color = IndigoLight,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        val contextWindowSizes by viewModel.contextWindowSizes.collectAsState()

        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            ModelVariant.entries.forEach { variant ->
                val status = downloadStatus[variant] ?: DownloadStatus(DownloadStatus.State.IDLE)
                val contextSize = contextWindowSizes[variant] ?: 4096
                ModelDownloadCard(
                    variant = variant,
                    status = status,
                    contextWindowSize = contextSize,
                    isActive = activeVariant == variant,
                    onSelect = { viewModel.setActiveVariant(variant) },
                    onDownload = { viewModel.downloadModel(variant) },
                    onPause = { viewModel.pauseDownload(variant) },
                    onCancel = { viewModel.cancelDownload(variant) },
                    onDelete = { viewModel.deleteModel(variant) },
                    onContextWindowSizeChange = { viewModel.setContextWindowSize(variant, it) }
                )
            }
        }

        Spacer(Modifier.height(48.dp))

        // About & Privacy Section
        Text(
            text = stringResource(R.string.section_about),
            style = MaterialTheme.typography.titleMedium,
            color = IndigoLight,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        var showPrivacyDialog by remember { mutableStateOf(false) }
        val context = androidx.compose.ui.platform.LocalContext.current

        GlassCard(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.fillMaxWidth().padding(4.dp)) {
                // Privacy Dialog Trigger
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { showPrivacyDialog = true }
                        .padding(vertical = 12.dp, horizontal = 4.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.Info, contentDescription = null, tint = IndigoLight)
                        Spacer(Modifier.width(12.dp))
                        Text(
                            text = stringResource(R.string.privacy_tos),
                            style = MaterialTheme.typography.bodyLarge,
                            color = TextPrimary
                        )
                    }
                    Icon(Icons.Default.KeyboardArrowRight, contentDescription = null, tint = TextTertiary)
                }

                Divider(color = IndigoLight.copy(alpha = 0.2f), modifier = Modifier.padding(vertical = 4.dp))

                // GitHub Link
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            val intent = android.content.Intent(android.content.Intent.ACTION_VIEW, android.net.Uri.parse("https://github.com/timmyy123/opensleep"))
                            context.startActivity(intent)
                        }
                        .padding(vertical = 12.dp, horizontal = 4.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.Star, contentDescription = null, tint = IndigoLight)
                        Spacer(Modifier.width(12.dp))
                        Text(
                            text = stringResource(R.string.github_repo),
                            style = MaterialTheme.typography.bodyLarge,
                            color = TextPrimary
                        )
                    }
                    Icon(Icons.Default.KeyboardArrowRight, contentDescription = null, tint = TextTertiary)
                }
            }
        }

        if (showPrivacyDialog) {
            AlertDialog(
                onDismissRequest = { showPrivacyDialog = false },
                title = { Text(stringResource(R.string.privacy_title), fontWeight = FontWeight.Bold) },
                text = {
                    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                        Text(
                            text = stringResource(R.string.privacy_body),
                            style = MaterialTheme.typography.bodyMedium.copy(lineHeight = 22.sp),
                            color = TextPrimary
                        )
                    }
                },
                confirmButton = {
                    TextButton(onClick = { showPrivacyDialog = false }) {
                        Text(stringResource(R.string.cancel))
                    }
                }
            )
        }

        Spacer(Modifier.height(48.dp))
    }
}



@Composable
fun ModelDownloadCard(
    variant: ModelVariant,
    status: DownloadStatus,
    contextWindowSize: Int,
    isActive: Boolean,
    onSelect: () -> Unit,
    onDownload: () -> Unit,
    onPause: () -> Unit,
    onCancel: () -> Unit,
    onDelete: () -> Unit,
    onContextWindowSizeChange: (Int) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    
    GlassCard(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(enabled = status.state == DownloadStatus.State.DONE) { expanded = !expanded }
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = variant.displayName,
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                        color = TextPrimary
                    )
                    Text(
                        text = "Size: %.1f GB".format(variant.sizeGB),
                        style = MaterialTheme.typography.bodyMedium,
                        color = TextSecondary
                    )
                }

                Spacer(Modifier.width(8.dp))

                // Actions based on state
                when (status.state) {
                    DownloadStatus.State.IDLE -> {
                        Button(
                            onClick = onDownload,
                            colors = ButtonDefaults.buttonColors(containerColor = IndigoAccent)
                        ) {
                            Text(stringResource(R.string.download_model), color = TextPrimary)
                        }
                    }
                    DownloadStatus.State.DOWNLOADING -> {
                        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            IconButton(onClick = onPause) {
                                Icon(Icons.Default.Pause, contentDescription = "Pause", tint = IndigoLight)
                            }
                            IconButton(onClick = onCancel) {
                                Icon(Icons.Default.Close, contentDescription = "Cancel", tint = Color.Red)
                            }
                        }
                    }
                    DownloadStatus.State.PAUSED -> {
                        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            IconButton(onClick = onDownload) {
                                Icon(Icons.Default.PlayArrow, contentDescription = "Resume", tint = IndigoLight)
                            }
                            IconButton(onClick = onCancel) {
                                Icon(Icons.Default.Close, contentDescription = "Cancel", tint = Color.Red)
                            }
                        }
                    }
                    DownloadStatus.State.DONE -> {
                        Row(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalAlignment = Alignment.CenterVertically) {
                            if (isActive) {
                                Text(stringResource(R.string.active_model), color = IndigoLight, style = MaterialTheme.typography.labelLarge)
                            } else {
                                Button(
                                    onClick = onSelect,
                                    colors = ButtonDefaults.buttonColors(containerColor = IndigoAccent)
                                ) {
                                    Text("Select", color = TextPrimary)
                                }
                            }
                            IconButton(onClick = onDelete) {
                                Icon(Icons.Default.Delete, contentDescription = "Delete", tint = Color.Red)
                            }
                            Icon(
                                imageVector = if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                                contentDescription = null,
                                tint = IndigoLight
                            )
                        }
                    }
                    DownloadStatus.State.FAILED -> {
                        Button(
                            onClick = onDownload,
                            colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
                        ) {
                            Text("Retry", color = TextPrimary)
                        }
                    }
                }
            }

            // Realtime metrics progress details
            if (status.state == DownloadStatus.State.DOWNLOADING || status.state == DownloadStatus.State.PAUSED) {
                Spacer(Modifier.height(12.dp))
                LinearProgressIndicator(
                    progress = { status.progress },
                    modifier = Modifier.fillMaxWidth(),
                    color = IndigoLight,
                    trackColor = Color.Gray.copy(alpha = 0.2f),
                    strokeCap = androidx.compose.ui.graphics.StrokeCap.Round
                )
                Spacer(Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "${formatSize(status.downloadedBytes)} / ${formatSize(status.totalBytes)}",
                        style = MaterialTheme.typography.bodySmall,
                        color = TextSecondary
                    )
                    Text(
                        text = if (status.state == DownloadStatus.State.DOWNLOADING) {
                            formatSpeed(status.speedBytesPerSec)
                        } else {
                            "Paused"
                        },
                        style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Bold),
                        color = if (status.state == DownloadStatus.State.DOWNLOADING) IndigoLight else TextSecondary
                    )
                }
            } else if (status.state == DownloadStatus.State.DONE) {
                Spacer(Modifier.height(8.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.CheckCircle,
                        contentDescription = null,
                        tint = IndigoLight,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(Modifier.width(4.dp))
                    Text(
                        text = stringResource(R.string.ready_to_use),
                        style = MaterialTheme.typography.bodySmall,
                        color = IndigoLight
                    )
                }
                
                if (expanded) {
                    Spacer(Modifier.height(16.dp))
                    Divider(color = IndigoLight.copy(alpha = 0.2f))
                    Spacer(Modifier.height(16.dp))
                    
                    Text(
                        text = stringResource(R.string.setting_context_size),
                        style = MaterialTheme.typography.titleSmall,
                        color = IndigoLight
                    )
                    Spacer(Modifier.height(8.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "$contextWindowSize tokens",
                            style = MaterialTheme.typography.bodyMedium,
                            color = TextPrimary
                        )
                    }
                    Slider(
                        value = contextWindowSize.toFloat(),
                        onValueChange = { onContextWindowSizeChange(it.toInt()) },
                        valueRange = 2048f..8192f,
                        steps = ((8192 - 2048) / 1024) - 1,
                        colors = SliderDefaults.colors(
                            thumbColor = IndigoLight,
                            activeTrackColor = IndigoAccent,
                            inactiveTrackColor = SurfaceVariant
                        )
                    )
                }
            }
        }
    }
}

private fun formatSpeed(bytesPerSec: Double): String {
    return when {
        bytesPerSec >= 1024 * 1024 -> "%.1f MB/s".format(bytesPerSec / (1024 * 1024))
        bytesPerSec >= 1024 -> "%.1f KB/s".format(bytesPerSec / 1024)
        else -> "%.0f B/s".format(bytesPerSec)
    }
}

private fun formatSize(bytes: Long): String {
    val kb = bytes / 1024.0
    val mb = kb / 1024.0
    val gb = mb / 1024.0
    return when {
        gb >= 0.1 -> "%.2f GB".format(gb)
        mb >= 0.1 -> "%.1f MB".format(mb)
        else -> "%.1f KB".format(kb)
    }
}
