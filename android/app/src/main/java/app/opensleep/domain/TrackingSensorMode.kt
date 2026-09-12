package app.opensleep.domain

enum class TrackingSensorMode(val key: String) {
    SONAR("sonar"),
    ACCELEROMETER("accelerometer");

    companion object {
        fun fromKey(key: String?): TrackingSensorMode {
            return entries.firstOrNull { it.key.equals(key, ignoreCase = true) } ?: SONAR
        }
    }
}
