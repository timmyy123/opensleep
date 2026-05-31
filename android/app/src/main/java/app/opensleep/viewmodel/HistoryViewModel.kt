package app.opensleep.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.opensleep.data.local.SleepSession
import app.opensleep.data.repository.SleepRepository
import app.opensleep.domain.HealthSyncManager
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class HistoryViewModel(
    private val repository: SleepRepository,
    private val healthSync: HealthSyncManager
) : ViewModel() {

    init {
        syncFromHealth()
    }

    val sessions: StateFlow<List<SleepSession>> = repository.getAllSessions()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    fun syncFromHealth() {
        viewModelScope.launch {
            if (healthSync.isAvailable() && healthSync.hasPermissions()) {
                val imported = healthSync.syncSleepDataFromHealthConnect(repository)
                if (imported > 0) {
                    println("Successfully imported $imported sleep sessions from Health Connect.")
                }
            }
        }
    }

    fun deleteSession(id: String) {
        viewModelScope.launch {
            repository.getSessionById(id)?.let { session ->
                healthSync.markSessionAsDeleted(session.startTimeMs)
                healthSync.deleteSleepSession(session)
            }
            repository.deleteSession(id)
        }
    }
}
