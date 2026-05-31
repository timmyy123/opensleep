package app.opensleep.domain

import android.content.Context
import androidx.health.connect.client.HealthConnectClient
import androidx.health.connect.client.permission.HealthPermission
import androidx.health.connect.client.records.SleepSessionRecord
import androidx.health.connect.client.records.metadata.Metadata
import androidx.health.connect.client.request.ReadRecordsRequest
import androidx.health.connect.client.time.TimeRangeFilter
import app.opensleep.data.local.SleepSession
import app.opensleep.data.local.SleepStageType
import app.opensleep.data.local.SleepStage
import app.opensleep.data.local.encodeToString
import app.opensleep.data.repository.SleepRepository
import java.time.Instant
import java.time.ZoneId

class HealthSyncManager(private val context: Context) {

    companion object {
        val PERMISSIONS = setOf(
            HealthPermission.getWritePermission(SleepSessionRecord::class),
            HealthPermission.getReadPermission(SleepSessionRecord::class)
        )
    }

    private val client: HealthConnectClient? by lazy {
        runCatching { HealthConnectClient.getOrCreate(context) }.getOrNull()
    }

    fun isAvailable(): Boolean =
        HealthConnectClient.getSdkStatus(context) == HealthConnectClient.SDK_AVAILABLE

    suspend fun hasPermissions(): Boolean {
        val c = client ?: return false
        return c.permissionController.getGrantedPermissions().containsAll(PERMISSIONS)
    }

    suspend fun writeSleepSession(session: SleepSession): Boolean {
        val c = client ?: return false
        if (!hasPermissions()) return false
        if (session.endTimeMs == null) return false

        val stages = session.stages()
        val zone = ZoneId.systemDefault()
        val startInstant = Instant.ofEpochMilli(session.startTimeMs)
        val endInstant = Instant.ofEpochMilli(session.endTimeMs)
        val startZdt = startInstant.atZone(zone)
        val endZdt = endInstant.atZone(zone)

        val sleepRecord = SleepSessionRecord(
            startTime = startInstant,
            startZoneOffset = startZdt.offset,
            endTime = endInstant,
            endZoneOffset = endZdt.offset,
            metadata = Metadata.manualEntry(),
            stages = stages.map { stage ->
                SleepSessionRecord.Stage(
                    startTime = Instant.ofEpochMilli(stage.startMs),
                    endTime = Instant.ofEpochMilli(stage.endMs),
                    stage = stage.type.toHealthConnectStage()
                )
            }
        )

        return runCatching {
            c.insertRecords(listOf(sleepRecord))
            true
        }.getOrDefault(false)
    }

    suspend fun deleteSleepSession(session: SleepSession): Boolean {
        val c = client ?: return false
        if (!hasPermissions()) return false
        val endTimeMs = session.endTimeMs ?: return false

        val startInstant = Instant.ofEpochMilli(session.startTimeMs)
        val endInstant = Instant.ofEpochMilli(endTimeMs)

        return runCatching {
            val response = c.readRecords(
                ReadRecordsRequest(
                    recordType = SleepSessionRecord::class,
                    timeRangeFilter = TimeRangeFilter.between(startInstant, endInstant)
                )
            )
            val recordIds = response.records.map { it.metadata.id }
            if (recordIds.isNotEmpty()) {
                c.deleteRecords(
                    recordType = SleepSessionRecord::class,
                    recordIdsList = recordIds,
                    clientRecordIdsList = emptyList()
                )
            }
            true
        }.getOrDefault(false)
    }

    private fun SleepStageType.toHealthConnectStage(): Int = when (this) {
        SleepStageType.AWAKE -> SleepSessionRecord.STAGE_TYPE_AWAKE
        SleepStageType.LIGHT -> SleepSessionRecord.STAGE_TYPE_LIGHT
        SleepStageType.DEEP -> SleepSessionRecord.STAGE_TYPE_DEEP
        SleepStageType.REM -> SleepSessionRecord.STAGE_TYPE_REM
    }

    private val prefs = context.getSharedPreferences("opensleep_sync_prefs", Context.MODE_PRIVATE)

    fun markSessionAsDeleted(startTimeMs: Long) {
        val deletedTimes = getDeletedSessionStartTimes().toMutableSet()
        deletedTimes.add(startTimeMs.toString())
        
        // Keep only the most recent 100 deleted sessions
        val sortedList = deletedTimes.mapNotNull { it.toLongOrNull() }.sortedDescending()
        val keptList = sortedList.take(100)
        
        prefs.edit().putStringSet("deleted_sessions", keptList.map { it.toString() }.toSet()).apply()
    }

    fun isSessionDeleted(startTimeMs: Long): Boolean {
        val deletedTimes = getDeletedSessionStartTimes().mapNotNull { it.toLongOrNull() }
        return deletedTimes.any { java.lang.Math.abs(it - startTimeMs) <= 3600 * 1000 }
    }

    private fun getDeletedSessionStartTimes(): Set<String> {
        return prefs.getStringSet("deleted_sessions", emptySet()) ?: emptySet()
    }

    suspend fun syncSleepDataFromHealthConnect(repository: SleepRepository): Int {
        val c = client ?: return 0
        if (!hasPermissions()) return 0
        
        val endTime = Instant.now()
        val startTime = endTime.minus(java.time.Duration.ofDays(730))
        
        return runCatching {
            val response = c.readRecords(
                ReadRecordsRequest(
                    recordType = SleepSessionRecord::class,
                    timeRangeFilter = TimeRangeFilter.between(startTime, endTime)
                )
            )
            
            var importCount = 0
            for (record in response.records) {
                val recordStartMs = record.startTime.toEpochMilli()
                val recordEndMs = record.endTime.toEpochMilli()
                
                val existing = repository.getSessionInTimeRange(recordStartMs - 3600 * 1000, recordStartMs + 3600 * 1000)
                val isDeleted = isSessionDeleted(recordStartMs)
                if (existing == null && !isDeleted) {
                    val stages = record.stages.map { stageRecord ->
                        val stageType = when (stageRecord.stage) {
                            SleepSessionRecord.STAGE_TYPE_AWAKE -> SleepStageType.AWAKE
                            SleepSessionRecord.STAGE_TYPE_DEEP -> SleepStageType.DEEP
                            SleepSessionRecord.STAGE_TYPE_REM -> SleepStageType.REM
                            else -> SleepStageType.LIGHT
                        }
                        SleepStage(
                            type = stageType,
                            startMs = stageRecord.startTime.toEpochMilli(),
                            endMs = stageRecord.endTime.toEpochMilli()
                        )
                    }
                    
                    val id = java.util.UUID.randomUUID().toString()
                    val newSession = SleepSession(
                        id = id,
                        startTimeMs = recordStartMs,
                        endTimeMs = recordEndMs,
                        stagesJson = stages.encodeToString(),
                        syncedToHealthConnect = true
                    )
                    
                    repository.insertSession(newSession)
                    importCount++
                }
            }
            importCount
        }.getOrDefault(0)
    }
}
