package com.urbandroid.sleep.audio.persistent_recording.recording;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import java.util.Arrays;
import java.util.List;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public abstract class RecordingBase implements Recording {
    @Override // com.urbandroid.sleep.audio.persistent_recording.recording.Recording
    public Recording eval() {
        return new Data(getStartTime(), getAmplitudes(), getSampleRate(), toArray());
    }

    @Override // com.urbandroid.sleep.audio.persistent_recording.recording.Recording
    public Recording join(Recording recording) {
        return size() == recording.size() ? new JoinManyEqualSize(this, recording) : size() == 0 ? recording : recording.size() == 0 ? this : new Join(this, recording);
    }

    public Recording part(int i, int i2) {
        return new Part(this, i, i2);
    }

    @Override // com.urbandroid.sleep.audio.persistent_recording.recording.Recording
    public List<Recording> split(int i) {
        if (i <= 0) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m(i, ""));
            return null;
        }
        if (size() == 0 || size() == i) {
            return Arrays.asList(this);
        }
        int size = size() / i;
        if (size() % i > 0) {
            size++;
        }
        Recording[] recordingArr = new Recording[size];
        int i2 = 0;
        while (i2 < size) {
            int i3 = i2 + 1;
            recordingArr[i2] = part(i2 * i, Math.min(i3 * i, size()));
            i2 = i3;
        }
        return Arrays.asList(recordingArr);
    }

    @Override // com.urbandroid.sleep.audio.persistent_recording.recording.Recording
    public float[] toArray() {
        int size = size();
        float[] fArr = new float[size];
        for (int i = 0; i < size; i++) {
            fArr[i] = get(i);
        }
        return fArr;
    }
}
