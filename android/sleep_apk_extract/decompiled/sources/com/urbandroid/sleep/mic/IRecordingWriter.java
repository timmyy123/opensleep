package com.urbandroid.sleep.mic;

import androidx.documentfile.provider.DocumentFile;
import com.urbandroid.sleep.audio.AudioReadBuffer;
import com.urbandroid.sleep.audio.persistent_recording.recording.Recording;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes4.dex */
public interface IRecordingWriter extends IRecordingStateObserver {

    /* JADX INFO: loaded from: classes.dex */
    public interface FailureListener {
        void fail(String str);
    }

    /* JADX INFO: loaded from: classes.dex */
    public interface Listener {
        void recordingStored(Recording recording);
    }

    long flushPendingBuffers(LinkedList<Recording> linkedList, boolean z);

    @Deprecated
    long flushPendingBuffers(LinkedList<AudioReadBuffer> linkedList, boolean z, List<Float> list);

    String getNewRecordingFileName(long j);

    void interrupt();

    Future<DocumentFile> safStartWritingToFile(String str, FailureListener failureListener);

    void setListener(Listener listener);

    void startWritingToFile(String str);

    void stopWritingToFile(Runnable runnable);

    @Deprecated
    void writeBuffer(AudioReadBuffer audioReadBuffer, List<Float> list);

    void writeBuffer(Recording recording);
}
