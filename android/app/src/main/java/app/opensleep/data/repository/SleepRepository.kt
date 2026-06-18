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

    private fun mergeStages(existingStages: List<SleepStage>, newStages: List<SleepStage>): List<SleepStage> {
        if (newStages.isEmpty()) return existingStages
        if (existingStages.isEmpty()) return newStages
        
        val firstNewStart = newStages.first().startMs
        val keepStages = existingStages.filter { it.endMs <= firstNewStart }.toMutableList()
        
        return if (keepStages.isEmpty()) {
            newStages
        } else {
            val lastKeep = keepStages.last()
            val firstNew = newStages.first()
            if (lastKeep.type == firstNew.type && lastKeep.endMs >= firstNew.startMs) {
                keepStages[keepStages.lastIndex] = lastKeep.copy(endMs = firstNew.endMs)
                keepStages.addAll(newStages.drop(1))
            } else {
                keepStages.addAll(newStages)
            }
            keepStages
        }
    }

    suspend fun endSession(sessionId: String, stages: List<SleepStage>) {
        val session = dao.getSessionById(sessionId) ?: return
        val merged = mergeStages(session.stages(), stages)
        dao.update(
            session.copy(
                endTimeMs = System.currentTimeMillis(),
                stagesJson = merged.encodeToString()
            )
        )
    }

    suspend fun updateStages(sessionId: String, newStages: List<SleepStage>) {
        val session = dao.getSessionById(sessionId) ?: return
        if (newStages.isEmpty()) return
        val merged = mergeStages(session.stages(), newStages)
        dao.update(session.copy(stagesJson = merged.encodeToString()))
    }

    suspend fun markSynced(sessionId: String) {
        val session = dao.getSessionById(sessionId) ?: return
        dao.update(session.copy(syncedToHealthConnect = true))
    }

    suspend fun getSessionById(id: String): SleepSession? = dao.getSessionById(id)

    suspend fun getRecentSessions(): List<SleepSession> = dao.getRecentSessions()

    suspend fun getSessionInTimeRange(fromTime: Long, toTime: Long): SleepSession? =
        dao.getSessionInTimeRange(fromTime, toTime)

    suspend fun insertSession(session: SleepSession) = dao.insert(session)

    suspend fun deleteSession(id: String) = dao.deleteById(id)
}
