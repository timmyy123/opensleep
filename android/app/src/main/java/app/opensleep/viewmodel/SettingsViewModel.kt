package app.opensleep.viewmodel

import android.app.Application
import android.app.LocaleManager
import android.content.Context
import android.os.Build
import android.os.LocaleList
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import app.opensleep.domain.DownloadStatus
import app.opensleep.domain.ModelDownloadManager
import app.opensleep.domain.ModelVariant
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.Locale

class SettingsViewModel(
    application: Application,
    private val downloadManager: ModelDownloadManager
) : AndroidViewModel(application) {

    val downloadStatus = downloadManager.downloadStatus
    val activeVariant = downloadManager.activeVariant
    val contextWindowSizes = downloadManager.contextWindowSizes
    val useGpu = downloadManager.useGpu

    private val sharedPrefs = application.getSharedPreferences("opensleep_settings", Context.MODE_PRIVATE)

    private val _currentLanguage = MutableStateFlow(getPersistedLanguage())
    val currentLanguage = _currentLanguage.asStateFlow()

    init {
        // Apply the persisted locale on launch
        applyLocale(getPersistedLanguage())
    }

    fun downloadModel(variant: ModelVariant) {
        viewModelScope.launch {
            downloadManager.downloadModel(variant)
        }
    }

    fun pauseDownload(variant: ModelVariant) {
        downloadManager.pauseModelDownload(variant)
    }

    fun cancelDownload(variant: ModelVariant) {
        downloadManager.cancelModelDownload(variant)
    }

    fun deleteModel(variant: ModelVariant) {
        downloadManager.deleteModel(variant)
        if (activeVariant.value == variant) {
            downloadManager.setActiveVariant(null)
        }
    }

    fun setActiveVariant(variant: ModelVariant) {
        downloadManager.setActiveVariant(variant)
    }

    fun setContextWindowSize(variant: ModelVariant, size: Int) {
        downloadManager.setContextWindowSize(variant, size)
    }

    fun setUseGpu(value: Boolean) {
        downloadManager.setUseGpu(value)
    }

    fun setLanguage(languageTag: String) {
        sharedPrefs.edit().putString("language_tag", languageTag).apply()
        _currentLanguage.value = languageTag
        applyLocale(languageTag)
    }

    private fun getPersistedLanguage(): String {
        return sharedPrefs.getString("language_tag", null) ?: Locale.getDefault().language
    }

    private fun applyLocale(languageTag: String) {
        val context = getApplication<Application>().applicationContext
        val locale = Locale.forLanguageTag(languageTag)
        Locale.setDefault(locale)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            val localeManager = context.getSystemService(Context.LOCALE_SERVICE) as? LocaleManager
            localeManager?.applicationLocales = LocaleList.forLanguageTags(languageTag)
        } else {
            val resources = context.resources
            val config = resources.configuration
            config.setLocale(locale)
            resources.updateConfiguration(config, resources.displayMetrics)
        }
    }
}
