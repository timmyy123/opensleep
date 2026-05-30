package app.opensleep.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
enum class SleepStageType {
    AWAKE, LIGHT, DEEP, REM
}

@Serializable
data class SleepStage(
    val type: SleepStageType,
    val startMs: Long,
    val endMs: Long
)

@Entity(tableName = "sleep_sessions")
data class SleepSession(
    @PrimaryKey val id: String,
    val startTimeMs: Long,
    val endTimeMs: Long?,
    val stagesJson: String = "[]", // JSON array of SleepStage
    val syncedToHealthConnect: Boolean = false
) {
    fun stages(): List<SleepStage> = Json.decodeFromString(stagesJson)
    fun durationMs(): Long = (endTimeMs ?: System.currentTimeMillis()) - startTimeMs

    fun stageDurations(): Map<SleepStageType, Long> {
        val stages = stages()
        return SleepStageType.entries.associateWith { type ->
            stages.filter { it.type == type }.sumOf { it.endMs - it.startMs }
        }
    }
}

fun List<SleepStage>.encodeToString(): String = Json.encodeToString(this)
