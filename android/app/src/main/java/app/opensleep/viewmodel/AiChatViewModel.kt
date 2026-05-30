package app.opensleep.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.opensleep.data.local.ChatMessage
import app.opensleep.data.local.ChatRole
import app.opensleep.data.local.SleepSession
import app.opensleep.data.repository.ChatRepository
import app.opensleep.data.repository.SleepRepository
import app.opensleep.domain.LiteRtManager
import app.opensleep.domain.LiteRtState
import app.opensleep.domain.ModelDownloadManager
import app.opensleep.domain.ModelVariant
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

class AiChatViewModel(
    private val chatRepository: ChatRepository,
    private val sleepRepository: SleepRepository,
    private val liteRtManager: LiteRtManager,
    private val downloadManager: ModelDownloadManager
) : ViewModel() {

    private val chatSessionId = SimpleDateFormat("yyyy-MM-dd", Locale.US).format(Date())

    val messages: StateFlow<List<ChatMessage>> = chatRepository.getMessages(chatSessionId)
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    private val _modelState = MutableStateFlow<LiteRtState>(LiteRtState.Unloaded)
    val modelState: StateFlow<LiteRtState> = _modelState.asStateFlow()

    private val _isGenerating = MutableStateFlow(false)
    val isGenerating: StateFlow<Boolean> = _isGenerating.asStateFlow()

    private val _streamingText = MutableStateFlow("")
    val streamingText: StateFlow<String> = _streamingText.asStateFlow()

    val selectedVariant: StateFlow<ModelVariant?> = downloadManager.activeVariant

    fun isModelDownloaded(variant: ModelVariant) = downloadManager.isModelDownloaded(variant)

    fun downloadModel(variant: ModelVariant) = downloadManager.downloadModel(variant)

    fun sendMessage(text: String) {
        if (text.isBlank() || _isGenerating.value) return
        val variant = selectedVariant.value ?: ModelVariant.entries.firstOrNull { downloadManager.isModelDownloaded(it) } ?: return

        viewModelScope.launch {
            // Save user message immediately so it shows up in UI
            chatRepository.addMessage(chatSessionId, ChatRole.USER, text)

            _isGenerating.value = true
            _streamingText.value = ""

            if (!liteRtManager.isLoaded()) {
                _modelState.value = LiteRtState.Loading
                val modelPath = downloadManager.getModelPath(variant)
                val contextWindowSize = downloadManager.contextWindowSizes.value[variant] ?: 4096
                _modelState.value = liteRtManager.loadModel(modelPath, contextWindowSize)
                if (_modelState.value is LiteRtState.Error) {
                    _isGenerating.value = false
                    return@launch
                }
            }

            // Build system prompt with sleep context
            val systemPrompt = buildSystemPrompt()

            // Build conversation history for context
            val history = messages.value.takeLast(20).map { msg ->
                Pair(if (msg.role == ChatRole.USER) "user" else "assistant", msg.content)
            }

            val sb = StringBuilder()
            liteRtManager.sendMessage(history, text, systemPrompt)
                .catch { e -> _streamingText.value = "[Error: ${e.message}]" }
                .collect { chunk ->
                    sb.append(chunk)
                    _streamingText.value = sb.toString()
                }

            // Save full assistant response
            val fullResponse = _streamingText.value
            if (fullResponse.isNotBlank()) {
                chatRepository.addMessage(chatSessionId, ChatRole.ASSISTANT, fullResponse)
            }
            _streamingText.value = ""
            _isGenerating.value = false
        }
    }

    private suspend fun buildSystemPrompt(): String {
        val recentSessions = sleepRepository.getRecentSessions()
        val sleepContext = if (recentSessions.isEmpty()) {
            "The user has no recorded sleep data yet."
        } else {
            val sb = StringBuilder("User's recent sleep data:\n")
            recentSessions.take(3).forEach { session ->
                if (session.endTimeMs != null) {
                    val hours = TimeUnit.MILLISECONDS.toHours(session.durationMs())
                    val minutes = TimeUnit.MILLISECONDS.toMinutes(session.durationMs()) % 60
                    val stages = session.stageDurations()
                    val fmt = SimpleDateFormat("EEE, MMM d", Locale.US)
                    sb.append(
                        "- ${fmt.format(Date(session.startTimeMs))}: " +
                        "${hours}h ${minutes}m total sleep | " +
                        "Deep: ${TimeUnit.MILLISECONDS.toMinutes(stages[app.opensleep.data.local.SleepStageType.DEEP] ?: 0)}m | " +
                        "REM: ${TimeUnit.MILLISECONDS.toMinutes(stages[app.opensleep.data.local.SleepStageType.REM] ?: 0)}m | " +
                        "Light: ${TimeUnit.MILLISECONDS.toMinutes(stages[app.opensleep.data.local.SleepStageType.LIGHT] ?: 0)}m | " +
                        "Awake: ${TimeUnit.MILLISECONDS.toMinutes(stages[app.opensleep.data.local.SleepStageType.AWAKE] ?: 0)}m\n"
                    )
                }
            }
            sb.toString()
        }

        return """You are a knowledgeable, empathetic sleep coach assistant built into the OpenSleep app. 
You help users understand and improve their sleep based on their actual tracked data.
Keep responses concise and practical. Do not recommend seeing a doctor unless truly necessary.
Today's date: ${SimpleDateFormat("EEEE, MMMM d, yyyy", Locale.US).format(Date())}

$sleepContext"""
    }
}
