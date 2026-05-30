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

    private fun SleepStageType.toHealthConnectStage(): Int = when (this) {
        SleepStageType.AWAKE -> SleepSessionRecord.STAGE_TYPE_AWAKE
        SleepStageType.LIGHT -> SleepSessionRecord.STAGE_TYPE_LIGHT
        SleepStageType.DEEP -> SleepSessionRecord.STAGE_TYPE_DEEP
        SleepStageType.REM -> SleepSessionRecord.STAGE_TYPE_REM
    }
}
