package com.urbandroid.sleep.audio.writer;

import com.urbandroid.sleep.audio.AudioRecorderContext;
import com.urbandroid.sleep.mic.IRecordingWriter;

/* JADX INFO: loaded from: classes4.dex */
public interface AudioWriterCreator {
    IRecordingWriter createWriter(AudioRecorderContext audioRecorderContext);
}
