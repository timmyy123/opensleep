package com.urbandroid.sleep.prefs.backup.preference;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.SharedPreferences;
import com.urbandroid.sleep.service.SettingKeys;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class XmlPreferencesBuilder implements SettingKeys {
    public static final List<String> ignoredKeys = Arrays.asList("key_last_app_started", "key_last_recording_delete", "key_ana_events", "key_time_diff_internal");
    private final StringBuilder sb = new StringBuilder();
    private long timestamp;
    private boolean wasInitialized;

    private void init() {
        reset();
        this.sb.append("<?xml version='1.0' encoding='utf-8' standalone='yes' ?>\n");
        this.sb.append("<map>\n");
        this.wasInitialized = true;
    }

    public void addAllPrefs(SharedPreferences sharedPreferences) {
        if (!this.wasInitialized) {
            init();
        }
        Map<String, ?> all = sharedPreferences.getAll();
        for (String str : all.keySet()) {
            Object obj = all.get(str);
            if (obj != null) {
                String name = obj.getClass().getName();
                if (!ignoredKeys.contains(str)) {
                    if (Long.class.getName().equals(name)) {
                        long j = Long.parseLong(obj.toString());
                        this.sb.append("\t<long name=\"" + str + "\" value=\"" + j + "\" />\n");
                        if ("key_last_setting_modification".equals(str)) {
                            this.timestamp = j;
                        }
                    } else if (Integer.class.getName().equals(name)) {
                        this.sb.append("\t<int name=\"" + str + "\" value=\"" + Integer.parseInt(obj.toString()) + "\" />\n");
                    } else if (String.class.getName().equals(name)) {
                        this.sb.append(FileInsert$$ExternalSyntheticOutline0.m("\t<string name=\"", str, "\"><![CDATA[", obj.toString(), "]]></string>\n"));
                    } else if (Boolean.class.getName().equals(name)) {
                        this.sb.append("\t<boolean name=\"" + str + "\" value=\"" + Boolean.parseBoolean(obj.toString()) + "\" />\n");
                    } else if (Float.class.getName().equals(name)) {
                        this.sb.append("\t<float name=\"" + str + "\" value=\"" + Float.parseFloat(obj.toString()) + "\" />\n");
                    }
                }
            }
        }
    }

    public PreferencesHolder build() {
        if (!this.wasInitialized) {
            init();
        }
        this.sb.append("</map>\n");
        this.wasInitialized = false;
        return new PreferencesHolder(this.timestamp, this.sb.toString());
    }

    public void reset() {
        this.timestamp = 0L;
        this.wasInitialized = false;
        StringBuilder sb = this.sb;
        sb.delete(0, sb.length());
    }
}
