package com.urbandroid.sleep.audio.persistent_recording.recording;

import com.urbandroid.util.ArrayUtil;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public class NearlyHomogenousBuffer extends RecordingBase {
    private final float[] amplitudes;
    private final Recording head;
    private final int headSize;
    private final int size;
    private final Recording tail;

    private NearlyHomogenousBuffer(Recording recording, Recording recording2) {
        this.head = recording;
        this.tail = recording2;
        int size = recording.size();
        this.headSize = size;
        this.size = recording2.size() + size;
        this.amplitudes = ArrayUtil.join(recording.getAmplitudes(), recording2.getAmplitudes());
    }

    @Override // com.urbandroid.sleep.audio.persistent_recording.recording.Recording
    public float get(int i) {
        int i2 = this.headSize;
        return i < i2 ? this.head.get(i) : this.tail.get(i - i2);
    }

    @Override // com.urbandroid.sleep.audio.persistent_recording.recording.Recording
    public float[] getAmplitudes() {
        return this.amplitudes;
    }

    @Override // com.urbandroid.sleep.audio.persistent_recording.recording.Recording
    public int getSampleRate() {
        return this.head.getSampleRate();
    }

    @Override // com.urbandroid.sleep.audio.persistent_recording.recording.Recording
    public long getStartTime() {
        return this.head.getStartTime();
    }

    @Override // com.urbandroid.sleep.audio.persistent_recording.recording.RecordingBase, com.urbandroid.sleep.audio.persistent_recording.recording.Recording
    public Recording join(Recording recording) {
        if (getSampleRate() != recording.getSampleRate()) {
            Utf8$$ExternalSyntheticBUOutline0.m$3();
            return null;
        }
        Recording recording2 = this.tail;
        boolean z = recording2 instanceof NullRecording;
        Recording recording3 = this.head;
        return z ? new NearlyHomogenousBuffer(recording3, recording) : new NearlyHomogenousBuffer(recording3, recording2.join(recording));
    }

    @Override // com.urbandroid.sleep.audio.persistent_recording.recording.Recording
    public int size() {
        return this.size;
    }

    public String toString() {
        return "NearlyHomogenousBuffer(" + this.head + "," + this.tail + ")";
    }

    public NearlyHomogenousBuffer(Recording recording) {
        this(recording, new NullRecording());
    }
}
