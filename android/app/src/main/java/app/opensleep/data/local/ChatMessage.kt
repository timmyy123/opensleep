package app.opensleep.data.local

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

enum class ChatRole { USER, ASSISTANT }

@Entity(
    tableName = "chat_messages",
    indices = [Index("sessionId")]
)
data class ChatMessage(
    @PrimaryKey val id: String,
    val sessionId: String, // links to a "chat session", not necessarily a sleep session
    val role: ChatRole,
    val content: String,
    val timestampMs: Long = System.currentTimeMillis()
)
