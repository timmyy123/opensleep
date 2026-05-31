package app.opensleep.data.repository

import app.opensleep.data.local.SleepSession
import app.opensleep.data.local.SleepSessionDao
import app.opensleep.data.local.SleepStage
import app.opensleep.data.local.encodeToString
import kotlinx.coroutines.flow.Flow
import java.util.UUID

class SleepRepository(private val dao: SleepSessionDao) {

    fun getAllSessions(): Flow<List<SleepSession>> = dao.getAllSessions()

    fun getActiveSession(): Flow<SleepSession?> = dao.getActiveSession()

    suspend fun getActiveSessionOneShot(): SleepSession? = dao.getActiveSessionOneShot()

    suspend fun startSession(): SleepSession {
        val session = SleepSession(
            id = UUID.randomUUID().toString(),
            startTimeMs = System.currentTimeMillis(),
            endTimeMs = null
        )
        dao.insert(session)
        return session
    }

    suspend fun endSession(sessionId: String, stages: List<SleepStage>) {
        val session = dao.getSessionById(sessionId) ?: return
        dao.update(
            session.copy(
                endTimeMs = System.currentTimeMillis(),
                stagesJson = stages.encodeToString()
            )
        )
    }

    suspend fun updateStages(sessionId: String, stages: List<SleepStage>) {
        val session = dao.getSessionById(sessionId) ?: return
        dao.update(session.copy(stagesJson = stages.encodeToString()))
    }

    suspend fun markSynced(sessionId: String) {
        val session = dao.getSessionById(sessionId) ?: return
        dao.update(session.copy(syncedToHealthConnect = true))
    }

    suspend fun getSessionById(id: String): SleepSession? = dao.getSessionById(id)

    suspend fun getRecentSessions(): List<SleepSession> = dao.getRecentSessions()

    suspend fun deleteSession(id: String) = dao.deleteById(id)
}
