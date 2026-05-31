package app.opensleep.ui.screens

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.opensleep.R
import app.opensleep.data.local.ChatMessage
import app.opensleep.data.local.ChatRole
import app.opensleep.domain.LiteRtState
import app.opensleep.domain.ModelVariant
import app.opensleep.ui.components.GlassCard
import app.opensleep.ui.theme.*
import app.opensleep.viewmodel.AiChatViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

@Composable
fun AiChatScreen(viewModel: AiChatViewModel, onNavigateToSettings: () -> Unit) {
    val messages by viewModel.messages.collectAsState()
    val modelState by viewModel.modelState.collectAsState()
    val isGenerating by viewModel.isGenerating.collectAsState()
    val streamingText by viewModel.streamingText.collectAsState()
    val selectedVariant by viewModel.selectedVariant.collectAsState()
    var inputText by remember { mutableStateOf("") }
    val listState = rememberLazyListState()
    val scope = rememberCoroutineScope()
    val focusManager = LocalFocusManager.current

    // Auto-scroll to bottom
    LaunchedEffect(messages.size, streamingText) {
        if (messages.isNotEmpty() || streamingText.isNotBlank()) {
            listState.animateScrollToItem(
                (messages.size + if (streamingText.isNotBlank()) 1 else 0).coerceAtLeast(1) - 1
            )
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(NavyDeep)
            .pointerInput(Unit) {
                detectTapGestures(onTap = { focusManager.clearFocus() })
            }
    ) {
        // Header
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape)
                    .background(Brush.radialGradient(listOf(PurpleGlow, IndigoAccent))),
                contentAlignment = Alignment.Center
            ) {
                Icon(Icons.Default.AutoAwesome, null, tint = Color.White, modifier = Modifier.size(20.dp))
            }
            Spacer(Modifier.width(12.dp))
            Column {
                Text(
                    stringResource(R.string.ai_chat_title),
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.Bold, color = TextPrimary
                    )
                )
                Text(
                    selectedVariant?.displayName ?: stringResource(R.string.no_model_loaded),
                    style = MaterialTheme.typography.labelSmall,
                    color = if (modelState is LiteRtState.Ready) CyanAccent else TextSecondary
                )
            }
            Spacer(Modifier.weight(1f))
            if (messages.isNotEmpty()) {
                IconButton(onClick = { viewModel.clearChat() }) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Clear Chat",
                        tint = TextTertiary
                    )
                }
            }
        }

        // Removed model picker section

        // Chat messages
        LazyColumn(
            state = listState,
            modifier = Modifier.weight(1f).padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(messages) { msg ->
                ChatBubble(message = msg)
            }
            // Streaming bubble
            if (streamingText.isNotBlank()) {
                item {
                    ChatBubble(
                        isUser = false,
                        text = streamingText,
                        isStreaming = true
                    )
                }
            }
            if (isGenerating && streamingText.isBlank()) {
                item {
                    Row(
                        modifier = Modifier.padding(4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        CircularProgressIndicator(
                            modifier = Modifier.size(16.dp),
                            color = IndigoAccent,
                            strokeWidth = 2.dp
                        )
                        Spacer(Modifier.width(8.dp))
                        Text(
                            text = stringResource(if (modelState is LiteRtState.Loading) R.string.chat_loading else R.string.chat_thinking),
                            style = MaterialTheme.typography.bodyMedium,
                            color = TextSecondary
                        )
                    }
                }
            }
            item { Spacer(Modifier.height(8.dp)) }
        }

        // Input bar
        Box(modifier = Modifier.imePadding()) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    verticalAlignment = Alignment.Bottom
                ) {
                OutlinedTextField(
                    value = inputText,
                    onValueChange = { inputText = it },
                    modifier = Modifier.weight(1f),
                    placeholder = {
                        Text(stringResource(R.string.chat_placeholder), color = TextTertiary)
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = SurfaceVariant,
                        unfocusedContainerColor = SurfaceContainer,
                        focusedBorderColor = IndigoAccent,
                        unfocusedBorderColor = GlassWhiteBorder,
                        focusedTextColor = TextPrimary,
                        unfocusedTextColor = TextPrimary
                    ),
                    shape = RoundedCornerShape(20.dp),
                    maxLines = 4,
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Send),
                    keyboardActions = KeyboardActions(onSend = {
                        viewModel.sendMessage(inputText)
                        inputText = ""
                    })
                )
                Spacer(Modifier.width(8.dp))
                IconButton(
                    onClick = {
                        viewModel.sendMessage(inputText)
                        inputText = ""
                    },
                    enabled = inputText.isNotBlank() && !isGenerating,
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape)
                        .background(if (inputText.isNotBlank()) IndigoAccent else SurfaceVariant)
                ) {
                    Icon(Icons.Default.Send, null, tint = TextPrimary)
                }
            }
        }
    }
}

@Composable
private fun ChatBubble(message: ChatMessage) =
    ChatBubble(isUser = message.role == ChatRole.USER, text = message.content)

sealed class MessageSegment {
    data class Text(val content: String) : MessageSegment()
    data class Table(val headers: List<String>, val rows: List<List<String>>) : MessageSegment()
}

fun parseMessageContent(content: String): List<MessageSegment> {
    val lines = content.split("\n")
    val segments = mutableListOf<MessageSegment>()
    val currentTextLines = mutableListOf<String>()
    val currentTableLines = mutableListOf<String>()
    var isInsideTable = false

    fun flushText() {
        if (currentTextLines.isNotEmpty()) {
            segments.add(MessageSegment.Text(currentTextLines.joinToString("\n")))
            currentTextLines.clear()
        }
    }

    fun flushTable() {
        if (currentTableLines.isNotEmpty()) {
            var headers = listOf<String>()
            val rows = mutableListOf<List<String>>()

            for (line in currentTableLines) {
                val rawParts = line.split("|").map { it.trim() }
                val parts = if (rawParts.first().isEmpty() && rawParts.last().isEmpty() && rawParts.size > 2) {
                    rawParts.subList(1, rawParts.size - 1)
                } else {
                    rawParts.filter { it.isNotEmpty() }
                }
                if (parts.isEmpty()) continue
                if (line.contains("---")) continue

                if (headers.isEmpty()) {
                    headers = parts
                } else {
                    rows.add(parts)
                }
            }

            if (headers.isNotEmpty()) {
                segments.add(MessageSegment.Table(headers, rows))
            } else {
                segments.add(MessageSegment.Text(currentTableLines.joinToString("\n")))
            }
            currentTableLines.clear()
        }
    }

    for (line in lines) {
        val trimmed = line.trim()
        val isTableLine = trimmed.startsWith("|") && trimmed.contains("|")

        if (isTableLine) {
            if (!isInsideTable) {
                flushText()
                isInsideTable = true
            }
            currentTableLines.add(line)
        } else {
            if (isInsideTable) {
                flushTable()
                isInsideTable = false
            }
            currentTextLines.add(line)
        }
    }

    flushText()
    flushTable()

    return segments
}

fun parseMarkdownToAnnotatedString(text: String): androidx.compose.ui.text.AnnotatedString {
    return buildAnnotatedString {
        var i = 0
        while (i < text.length) {
            if (i + 1 < text.length && text[i] == '*' && text[i + 1] == '*') {
                val end = text.indexOf("**", i + 2)
                if (end != -1) {
                    withStyle(SpanStyle(fontWeight = FontWeight.Bold)) {
                        append(text.substring(i + 2, end))
                    }
                    i = end + 2
                } else {
                    append(text[i].toString())
                    i++
                }
            } else if (text[i] == '*') {
                val end = text.indexOf('*', i + 1)
                if (end != -1 && text[end - 1] != '*') {
                    withStyle(SpanStyle(fontStyle = FontStyle.Italic)) {
                        append(text.substring(i + 1, end))
                    }
                    i = end + 1
                } else {
                    append(text[i].toString())
                    i++
                }
            } else {
                append(text[i].toString())
                i++
            }
        }
    }
}

@Composable
private fun TableSegment(headers: List<String>, rows: List<List<String>>) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = RoundedCornerShape(8.dp),
        border = androidx.compose.foundation.BorderStroke(1.dp, GlassWhiteBorder),
        colors = CardDefaults.cardColors(containerColor = SurfaceVariant.copy(alpha = 0.5f))
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            // Header Row
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(IndigoAccent.copy(alpha = 0.15f))
                    .padding(vertical = 6.dp, horizontal = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                headers.forEach { header ->
                    Text(
                        text = header,
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontWeight = FontWeight.Bold,
                            color = IndigoLight
                        ),
                        modifier = Modifier.weight(1f)
                    )
                }
            }
            HorizontalDivider(color = GlassWhiteBorder)
            
            // Rows
            rows.forEachIndexed { rowIndex, row ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp, horizontal = 4.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    row.forEach { cell ->
                        Text(
                            text = cell,
                            style = MaterialTheme.typography.bodySmall.copy(
                                color = TextPrimary
                            ),
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
                if (rowIndex < rows.size - 1) {
                    HorizontalDivider(color = GlassWhiteBorder.copy(alpha = 0.5f))
                }
            }
        }
    }
}

@Composable
private fun ChatBubble(isUser: Boolean, text: String, isStreaming: Boolean = false) {
    if (isUser) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Box(
                modifier = Modifier
                    .widthIn(max = 300.dp)
                    .clip(
                        RoundedCornerShape(
                            topStart = 20.dp, topEnd = 20.dp,
                            bottomStart = 20.dp,
                            bottomEnd = 4.dp
                        )
                    )
                    .background(IndigoAccent.copy(alpha = 0.85f))
                    .padding(horizontal = 16.dp, vertical = 10.dp)
            ) {
                Text(
                    text = parseMarkdownToAnnotatedString(text),
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = TextPrimary,
                        fontSize = 15.sp
                    )
                )
            }
        }
    } else {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 4.dp)
        ) {
            val content = if (isStreaming) "$text▌" else text
            val segments = remember(content) { parseMessageContent(content) }
            
            segments.forEach { segment ->
                when (segment) {
                    is MessageSegment.Text -> {
                        Text(
                            text = parseMarkdownToAnnotatedString(segment.content),
                            style = MaterialTheme.typography.bodyLarge.copy(
                                color = TextPrimary,
                                fontSize = 15.sp,
                                lineHeight = 22.sp
                            )
                        )
                    }
                    is MessageSegment.Table -> {
                        TableSegment(headers = segment.headers, rows = segment.rows)
                    }
                }
            }
        }
    }
}


