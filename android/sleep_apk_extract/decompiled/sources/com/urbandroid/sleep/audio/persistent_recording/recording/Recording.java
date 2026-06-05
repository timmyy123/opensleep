package com.urbandroid.sleep.audio.persistent_recording.recording;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface Recording {
    Recording eval();

    float get(int i);

    float[] getAmplitudes();

    int getSampleRate();

    long getStartTime();

    Recording join(Recording recording);

    int size();

    List<Recording> split(int i);

    float[] toArray();
}
