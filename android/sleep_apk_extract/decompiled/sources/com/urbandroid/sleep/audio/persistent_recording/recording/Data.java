package com.urbandroid.sleep.audio.persistent_recording.recording;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import java.util.Arrays;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public class Data extends RecordingBase {
    private final float[] amplitudes;

    /* JADX INFO: renamed from: data, reason: collision with root package name */
    private final float[] f62data;
    private final int sampleRate;
    private final long start;

    public Data(long j, float[] fArr, int i, float... fArr2) {
        this.f62data = fArr2;
        this.start = j;
        this.amplitudes = fArr;
        if (i > 0) {
            this.sampleRate = i;
        } else {
            Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m(i, ""));
            throw null;
        }
    }

    @Override // com.urbandroid.sleep.audio.persistent_recording.recording.RecordingBase, com.urbandroid.sleep.audio.persistent_recording.recording.Recording
    public Recording eval() {
        return this;
    }

    @Override // com.urbandroid.sleep.audio.persistent_recording.recording.Recording
    public float get(int i) {
        return this.f62data[i];
    }

    @Override // com.urbandroid.sleep.audio.persistent_recording.recording.Recording
    public float[] getAmplitudes() {
        return this.amplitudes;
    }

    @Override // com.urbandroid.sleep.audio.persistent_recording.recording.Recording
    public int getSampleRate() {
        return this.sampleRate;
    }

    @Override // com.urbandroid.sleep.audio.persistent_recording.recording.Recording
    public long getStartTime() {
        return this.start;
    }

    @Override // com.urbandroid.sleep.audio.persistent_recording.recording.Recording
    public int size() {
        return this.f62data.length;
    }

    @Override // com.urbandroid.sleep.audio.persistent_recording.recording.RecordingBase, com.urbandroid.sleep.audio.persistent_recording.recording.Recording
    public float[] toArray() {
        float[] fArr = this.f62data;
        return Arrays.copyOf(fArr, fArr.length);
    }

    public String toString() {
        return "Data(" + size() + ")";
    }
}
