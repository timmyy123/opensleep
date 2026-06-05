package com.urbandroid.sleep.prefs.backup.preference;

/* JADX INFO: loaded from: classes.dex */
public class PreferencesHolder {
    private final String preferences;
    private final long timestamp;

    public PreferencesHolder(long j, String str) {
        this.timestamp = j;
        this.preferences = str;
    }

    public String getPreferences() {
        return this.preferences;
    }
}
