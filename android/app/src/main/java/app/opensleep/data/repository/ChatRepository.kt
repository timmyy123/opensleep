package app.opensleep.data.repository

import app.opensleep.data.local.ChatDao
import app.opensleep.data.local.ChatMessage
import app.opensleep.data.local.ChatRole
import kotlinx.coroutines.flow.Flow
import java.util.UUID

class ChatRepository(private val dao: ChatDao) {

    fun getMessages(sessionId: String): Flow<List<ChatMessage>> =
        dao.getMessagesForSession(sessionId)

    suspend fun addMessage(sessionId: String, role: ChatRole, content: String): ChatMessage {
        val msg = ChatMessage(
            id = UUID.randomUUID().toString(),
            sessionId = sessionId,
            role = role,
            content = content
        )
        dao.insert(msg)
        return msg
    }

    suspend fun clearSession(sessionId: String) = dao.clearSession(sessionId)
}
