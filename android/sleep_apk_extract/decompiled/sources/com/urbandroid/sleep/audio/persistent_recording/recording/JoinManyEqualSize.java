package com.urbandroid.sleep.audio.persistent_recording.recording;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.urbandroid.util.ArrayUtil;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.util.Arrays;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public class JoinManyEqualSize extends RecordingBase {
    private final float[] amplitudes;
    private final int partSize;
    private final Recording[] parts;
    private final int sampleRate;
    private final int size;

    public JoinManyEqualSize(Recording... recordingArr) {
        float[] amplitudes = null;
        if (recordingArr.length < 2) {
            Utf8$$ExternalSyntheticBUOutline0.m$3();
            throw null;
        }
        this.partSize = recordingArr[0].size();
        this.sampleRate = recordingArr[0].getSampleRate();
        for (Recording recording : recordingArr) {
            if (recording.size() != this.partSize) {
                Events$$ExternalSyntheticBUOutline0.m(recording.size(), this.partSize, " ");
                throw null;
            }
            if (recording.getSampleRate() != this.sampleRate) {
                Events$$ExternalSyntheticBUOutline0.m(recording.getSampleRate(), this.sampleRate, " ");
                throw null;
            }
        }
        this.size = recordingArr[0].size() * recordingArr.length;
        for (Recording recording2 : recordingArr) {
            amplitudes = amplitudes == null ? recording2.getAmplitudes() : ArrayUtil.join(amplitudes, recording2.getAmplitudes());
        }
        this.amplitudes = amplitudes;
        this.parts = recordingArr;
    }

    @Override // com.urbandroid.sleep.audio.persistent_recording.recording.Recording
    public float get(int i) {
        Recording[] recordingArr = this.parts;
        int i2 = this.partSize;
        return recordingArr[i / i2].get(i % i2);
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
        return this.parts[0].getStartTime();
    }

    @Override // com.urbandroid.sleep.audio.persistent_recording.recording.RecordingBase, com.urbandroid.sleep.audio.persistent_recording.recording.Recording
    public Recording join(Recording recording) {
        return recording.size() == this.partSize ? new JoinManyEqualSize(this.parts, recording) : super.join(recording);
    }

    @Override // com.urbandroid.sleep.audio.persistent_recording.recording.Recording
    public int size() {
        return this.size;
    }

    public String toString() {
        return FileInsert$$ExternalSyntheticOutline0.m(new StringBuilder("JoinManyEqualSize("), Arrays.toString(this.parts), ")");
    }

    public JoinManyEqualSize(Recording[] recordingArr, Recording... recordingArr2) {
        this((Recording[]) ArrayUtil.join(recordingArr, recordingArr2));
    }
}
