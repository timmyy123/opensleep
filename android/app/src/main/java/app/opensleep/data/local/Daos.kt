package app.opensleep.data.local

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface SleepSessionDao {

    @Query("SELECT * FROM sleep_sessions ORDER BY startTimeMs DESC")
    fun getAllSessions(): Flow<List<SleepSession>>

    @Query("SELECT * FROM sleep_sessions WHERE endTimeMs IS NULL LIMIT 1")
    fun getActiveSession(): Flow<SleepSession?>

    @Query("SELECT * FROM sleep_sessions WHERE endTimeMs IS NULL LIMIT 1")
    suspend fun getActiveSessionOneShot(): SleepSession?

    @Query("SELECT * FROM sleep_sessions WHERE id = :id")
    suspend fun getSessionById(id: String): SleepSession?

    @Query("SELECT * FROM sleep_sessions ORDER BY startTimeMs DESC LIMIT :limit")
    suspend fun getRecentSessions(limit: Int = 7): List<SleepSession>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(session: SleepSession)

    @Update
    suspend fun update(session: SleepSession)

    @Query("DELETE FROM sleep_sessions WHERE id = :id")
    suspend fun deleteById(id: String)
}

@Dao
interface ChatDao {

    @Query("SELECT * FROM chat_messages WHERE sessionId = :sessionId ORDER BY timestampMs ASC")
    fun getMessagesForSession(sessionId: String): Flow<List<ChatMessage>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(message: ChatMessage)

    @Query("DELETE FROM chat_messages WHERE sessionId = :sessionId")
    suspend fun clearSession(sessionId: String)
}
