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

    suspend fun updateStages(sessionId: String, newStages: List<SleepStage>) {
        val session = dao.getSessionById(sessionId) ?: return
        if (newStages.isEmpty()) return
        
        val existingStages = session.stages()
        val mergedStages = if (existingStages.isEmpty()) {
            newStages
        } else {
            val firstNewStart = newStages.first().startMs
            // Keep existing stages that end before or at the start of new stages
            val keepStages = existingStages.filter { it.endMs <= firstNewStart }.toMutableList()
            
            if (keepStages.isEmpty()) {
                newStages
            } else {
                val lastKeep = keepStages.last()
                val firstNew = newStages.first()
                if (lastKeep.type == firstNew.type && lastKeep.endMs >= firstNew.startMs) {
                    // Merge adjacent stages of same type at boundary
                    keepStages[keepStages.lastIndex] = lastKeep.copy(endMs = firstNew.endMs)
                    keepStages.addAll(newStages.drop(1))
                } else {
                    keepStages.addAll(newStages)
                }
                keepStages
            }
        }
        dao.update(session.copy(stagesJson = mergedStages.encodeToString()))
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
