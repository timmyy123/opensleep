package com.urbandroid.sleep.audio.persistent_recording.recording;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class NullRecording implements Recording {
    @Override // com.urbandroid.sleep.audio.persistent_recording.recording.Recording
    public Recording eval() {
        return this;
    }

    @Override // com.urbandroid.sleep.audio.persistent_recording.recording.Recording
    public float get(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // com.urbandroid.sleep.audio.persistent_recording.recording.Recording
    public float[] getAmplitudes() {
        return new float[0];
    }

    @Override // com.urbandroid.sleep.audio.persistent_recording.recording.Recording
    public int getSampleRate() {
        throw new UnsupportedOperationException();
    }

    @Override // com.urbandroid.sleep.audio.persistent_recording.recording.Recording
    public long getStartTime() {
        throw new UnsupportedOperationException();
    }

    @Override // com.urbandroid.sleep.audio.persistent_recording.recording.Recording
    public Recording join(Recording recording) {
        return recording;
    }

    @Override // com.urbandroid.sleep.audio.persistent_recording.recording.Recording
    public int size() {
        return 0;
    }

    @Override // com.urbandroid.sleep.audio.persistent_recording.recording.Recording
    public List<Recording> split(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // com.urbandroid.sleep.audio.persistent_recording.recording.Recording
    public float[] toArray() {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return "NullRecording()";
    }
}
