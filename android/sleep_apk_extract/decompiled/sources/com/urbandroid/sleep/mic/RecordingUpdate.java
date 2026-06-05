package com.urbandroid.sleep.mic;

import android.content.Intent;
import com.google.gson.Gson$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public class RecordingUpdate {
    public static final String ACTION_RECORDING_UPDATE = "action_sleep_recording_update";
    public static final String EXTRA_RECORDING_UPDATE_LEVEL = "extra_sleep_recording_update_level";
    public static final String EXTRA_RECORDING_UPDATE_MAX = "extra_sleep_recording_update_max";
    public static final String EXTRA_RECORDING_UPDATE_RECORDING = "extra_sleep_recording_update_recording";
    public static final String EXTRA_RECORDING_UPDATE_THRESHOLD = "extra_sleep_recording_update_threshold";
    private final int level;
    private final int max;
    private final boolean recording;
    private final int threshold;

    public RecordingUpdate(Intent intent) {
        if (!intent.getAction().equals(ACTION_RECORDING_UPDATE) || !intent.hasExtra(EXTRA_RECORDING_UPDATE_RECORDING) || !intent.hasExtra(EXTRA_RECORDING_UPDATE_MAX) || !intent.hasExtra(EXTRA_RECORDING_UPDATE_THRESHOLD) || !intent.hasExtra(EXTRA_RECORDING_UPDATE_LEVEL)) {
            Gson$$ExternalSyntheticBUOutline0.m("Cannot construct Recording update from intent ", intent);
            throw null;
        }
        this.recording = intent.getBooleanExtra(EXTRA_RECORDING_UPDATE_RECORDING, false);
        this.level = intent.getIntExtra(EXTRA_RECORDING_UPDATE_LEVEL, 0);
        this.max = intent.getIntExtra(EXTRA_RECORDING_UPDATE_MAX, 0);
        this.threshold = intent.getIntExtra(EXTRA_RECORDING_UPDATE_THRESHOLD, 0);
    }

    public int getLevel() {
        return this.level;
    }

    public int getMax() {
        return this.max;
    }

    public int getThreshold() {
        return this.threshold;
    }

    public boolean isRecording() {
        return this.recording;
    }

    public Intent toIntent() {
        Intent intent = new Intent(ACTION_RECORDING_UPDATE);
        intent.putExtra(EXTRA_RECORDING_UPDATE_LEVEL, getLevel());
        intent.putExtra(EXTRA_RECORDING_UPDATE_RECORDING, isRecording());
        intent.putExtra(EXTRA_RECORDING_UPDATE_THRESHOLD, getThreshold());
        intent.putExtra(EXTRA_RECORDING_UPDATE_MAX, getMax());
        return intent;
    }

    public RecordingUpdate(boolean z, int i, int i2, int i3) {
        this.recording = z;
        this.level = i;
        this.max = i2;
        this.threshold = i3;
    }
}
