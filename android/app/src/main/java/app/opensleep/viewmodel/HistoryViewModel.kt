package app.opensleep.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.opensleep.data.local.SleepSession
import app.opensleep.data.repository.SleepRepository
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class HistoryViewModel(private val repository: SleepRepository) : ViewModel() {

    val sessions: StateFlow<List<SleepSession>> = repository.getAllSessions()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    fun deleteSession(id: String) {
        viewModelScope.launch { repository.deleteSession(id) }
    }
}
