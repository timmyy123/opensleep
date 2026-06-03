package app.opensleep.viewmodel

import android.content.Context
import android.content.Intent
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.opensleep.data.local.SleepSession
import app.opensleep.data.repository.SleepRepository
import app.opensleep.domain.HealthSyncManager
import app.opensleep.service.SleepTrackerService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


class HomeViewModel(
    private val repository: SleepRepository,
    private val healthSync: HealthSyncManager
) : ViewModel() {

    private val _activeSession = MutableStateFlow<SleepSession?>(null)
    val activeSession: StateFlow<SleepSession?> = _activeSession.asStateFlow()

    private val _isSleeping = MutableStateFlow(false)
    val isSleeping: StateFlow<Boolean> = _isSleeping.asStateFlow()

    // True while service is finalizing the session after stop is requested.
    // Locks the button so the user can't spam-tap or restart mid-finalization.
    private val _isStopping = MutableStateFlow(false)
    val isStopping: StateFlow<Boolean> = _isStopping.asStateFlow()

    private val _elapsedSeconds = MutableStateFlow(0L)
    val elapsedSeconds: StateFlow<Long> = _elapsedSeconds.asStateFlow()

    private val _isHealthConnectAvailable = MutableStateFlow(false)
    val isHealthConnectAvailable: StateFlow<Boolean> = _isHealthConnectAvailable.asStateFlow()

    private val _hasHealthPermissions = MutableStateFlow(false)
    val hasHealthPermissions: StateFlow<Boolean> = _hasHealthPermissions.asStateFlow()

    init {
        refreshHealthPermissions()

        viewModelScope.launch {
            repository.getActiveSession().collectLatest { session ->
                if (session != null && !SleepTrackerService.isRunning) {
                    android.util.Log.d("HomeViewModel", "Orphaned active session found (Service is not running). Auto-closing session: ${session.id}")
                    repository.endSession(session.id, session.stages())
                    return@collectLatest
                }

                _activeSession.value = session
                _isSleeping.value = session != null
                if (session != null) {
                    _elapsedSeconds.value = (System.currentTimeMillis() - session.startTimeMs) / 1000
                }

                // Once the session disappears the service has fully stopped — clear the stopping flag.
                if (session == null) {
                    _isStopping.value = false
                }
            }
        }

        // Tick elapsed time
        viewModelScope.launch {
            while (true) {
                kotlinx.coroutines.delay(1000)
                val session = _activeSession.value
                if (session != null) {
                    _elapsedSeconds.value = (System.currentTimeMillis() - session.startTimeMs) / 1000
                }
            }
        }
    }

    fun refreshHealthPermissions() {
        viewModelScope.launch {
            val available = healthSync.isAvailable()
            _isHealthConnectAvailable.value = available
            _hasHealthPermissions.value = available && healthSync.hasPermissions()
        }
    }

    fun startSleep(context: Context) {
        viewModelScope.launch {
            val session = repository.startSession()
            val intent = Intent(context, SleepTrackerService::class.java).apply {
                action = SleepTrackerService.ACTION_START
                putExtra(SleepTrackerService.EXTRA_SESSION_ID, session.id)
            }
            context.startForegroundService(intent)
        }
    }

    fun stopSleep(context: Context) {
        if (_isStopping.value) return  // Guard against double-tap during finalization
        _isStopping.value = true
        val intent = Intent(context, SleepTrackerService::class.java).apply {
            action = SleepTrackerService.ACTION_STOP
        }
        context.startService(intent)
    }
}
