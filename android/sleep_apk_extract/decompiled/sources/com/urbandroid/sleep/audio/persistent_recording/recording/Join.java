package com.urbandroid.sleep.audio.persistent_recording.recording;

import com.urbandroid.util.ArrayUtil;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public class Join extends RecordingBase {
    private final float[] amplitudes;
    private final Recording r1;
    private final Recording r2;
    private final int size;
    private final int size1;

    public Join(Recording recording, Recording recording2) {
        if (recording.getSampleRate() != recording2.getSampleRate()) {
            Utf8$$ExternalSyntheticBUOutline0.m$3();
            throw null;
        }
        this.r1 = recording;
        this.r2 = recording2;
        int size = recording.size();
        this.size1 = size;
        this.size = recording2.size() + size;
        this.amplitudes = ArrayUtil.join(recording.getAmplitudes(), recording2.getAmplitudes());
    }

    @Override // com.urbandroid.sleep.audio.persistent_recording.recording.Recording
    public float get(int i) {
        int i2 = this.size1;
        return i < i2 ? this.r1.get(i) : this.r2.get(i - i2);
    }

    @Override // com.urbandroid.sleep.audio.persistent_recording.recording.Recording
    public float[] getAmplitudes() {
        return this.amplitudes;
    }

    @Override // com.urbandroid.sleep.audio.persistent_recording.recording.Recording
    public int getSampleRate() {
        return this.r1.getSampleRate();
    }

    @Override // com.urbandroid.sleep.audio.persistent_recording.recording.Recording
    public long getStartTime() {
        return this.r1.getStartTime();
    }

    @Override // com.urbandroid.sleep.audio.persistent_recording.recording.Recording
    public int size() {
        return this.size;
    }

    public String toString() {
        return "Join(" + this.r1 + "," + this.r2 + ")";
    }
}
