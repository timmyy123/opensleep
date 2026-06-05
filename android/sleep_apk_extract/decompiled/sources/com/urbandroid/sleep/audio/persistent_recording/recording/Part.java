package com.urbandroid.sleep.audio.persistent_recording.recording;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public class Part extends RecordingBase {
    private final float[] amplitudes;
    private final int endIndexExclusive;
    private final Recording r;
    private final int size;
    private final int startIndex;

    public Part(Recording recording, int i, int i2) {
        this.r = recording;
        if (i > i2 || i < 0 || i2 > recording.size()) {
            Events$$ExternalSyntheticBUOutline0.m$1(i, i2, " ");
            throw null;
        }
        this.startIndex = i;
        this.endIndexExclusive = i2;
        this.size = i2 - i;
        int length = recording.getAmplitudes().length;
        float size = recording.size();
        float f = length;
        this.amplitudes = Arrays.copyOfRange(recording.getAmplitudes(), (int) ((i / size) * f), (int) ((i2 / size) * f));
    }

    @Override // com.urbandroid.sleep.audio.persistent_recording.recording.Recording
    public float get(int i) {
        if (i < 0 || i >= this.size) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
        return this.r.get(i + this.startIndex);
    }

    @Override // com.urbandroid.sleep.audio.persistent_recording.recording.Recording
    public float[] getAmplitudes() {
        return this.amplitudes;
    }

    @Override // com.urbandroid.sleep.audio.persistent_recording.recording.Recording
    public int getSampleRate() {
        return this.r.getSampleRate();
    }

    @Override // com.urbandroid.sleep.audio.persistent_recording.recording.Recording
    public long getStartTime() {
        return this.r.getStartTime() + ((long) ((((double) this.startIndex) * 1000.0d) / ((double) getSampleRate())));
    }

    @Override // com.urbandroid.sleep.audio.persistent_recording.recording.Recording
    public int size() {
        return this.size;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Part(");
        sb.append(this.r);
        sb.append(",");
        sb.append(this.startIndex);
        sb.append(",");
        return FileInsert$$ExternalSyntheticOutline0.m(this.endIndexExclusive, ")", sb);
    }
}
