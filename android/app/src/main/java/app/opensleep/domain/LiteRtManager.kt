package app.opensleep.domain

import android.content.Context
import com.google.ai.edge.litertlm.Backend
import com.google.ai.edge.litertlm.Contents
import com.google.ai.edge.litertlm.ConversationConfig
import com.google.ai.edge.litertlm.Engine
import com.google.ai.edge.litertlm.EngineConfig
import com.google.ai.edge.litertlm.ExperimentalApi
import com.google.ai.edge.litertlm.ExperimentalFlags
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext

sealed class LiteRtState {
    object Unloaded : LiteRtState()
    object Loading : LiteRtState()
    object Ready : LiteRtState()
    data class Error(val message: String) : LiteRtState()
}

class LiteRtManager(private val context: Context) {

    private var engine: Engine? = null
    private var currentModelPath: String? = null

    @OptIn(ExperimentalApi::class)
    suspend fun loadModel(modelPath: String, contextWindowSize: Int): LiteRtState = withContext(Dispatchers.IO) {
        if (currentModelPath == modelPath && engine != null) return@withContext LiteRtState.Ready

        runCatching { engine?.close() }
        engine = null

        try {
            ExperimentalFlags.enableSpeculativeDecoding = true
            val config = EngineConfig(
                modelPath = modelPath,
                backend = Backend.GPU(),
                cacheDir = context.cacheDir.absolutePath,
                maxNumTokens = contextWindowSize
            )
            val e = Engine(config)
            e.initialize()
            engine = e
            currentModelPath = modelPath
            LiteRtState.Ready
        } catch (t: Throwable) {
            LiteRtState.Error(t.message ?: "Unknown error loading model")
        }
    }

    fun sendMessage(
        conversationHistory: List<Pair<String, String>>, // (role, content)
        newMessage: String,
        systemPrompt: String
    ): Flow<String> = flow {
        val e = engine ?: error("Engine not loaded")

        val config = ConversationConfig(
            systemInstruction = Contents.of(systemPrompt)
        )

        e.createConversation(config).use { conversation ->
            // Replay history
            for ((role, content) in conversationHistory) {
                if (role == "user") {
                    // Feed history silently — LiteRT-LM maintains context via initialMessages
                }
            }

            conversation.sendMessageAsync(newMessage)
                .catch { t -> emit("[Error: ${t.message}]") }
                .collect { message ->
                    emit(message.toString())
                }
        }
    }.flowOn(Dispatchers.IO)

    fun isLoaded(): Boolean = engine != null

    fun unload() {
        engine?.close()
        engine = null
        currentModelPath = null
    }
}
