package com.urbandroid.sleep.audio.consumer;

import android.content.Context;
import com.urbandroid.sleep.audio.AudioReadBuffer;
import com.urbandroid.sleep.audio.persistent_recording.recording.Data;
import com.urbandroid.sleep.audio.persistent_recording.recording.NearlyHomogenousBuffer;
import com.urbandroid.sleep.audio.persistent_recording.recording.NullRecording;
import com.urbandroid.sleep.audio.persistent_recording.recording.Recording;
import com.urbandroid.util.ArrayUtil;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ChunkedAudioConsumer extends BaseAudioConsumer {
    protected int chunkSize;
    private Recording remainder;

    public ChunkedAudioConsumer(Context context, int i) {
        super(context);
        setChunkSize(i);
        this.remainder = new NullRecording();
    }

    @Override // com.urbandroid.sleep.audio.consumer.BaseAudioConsumer
    public void doProcess(AudioReadBuffer audioReadBuffer) {
        float[] fArrPreprocess = preprocess(audioReadBuffer);
        if (fArrPreprocess.length == 0) {
            return;
        }
        Recording recordingJoin = this.remainder.join(new Data(audioReadBuffer.getReadTimestamp(), ArrayUtil.toFloatArray(audioReadBuffer.getMaxAmplitudes()), this.recorderContext.getSampleRate(), fArrPreprocess));
        this.remainder = recordingJoin;
        int size = recordingJoin.size();
        int i = this.chunkSize;
        if (size < i) {
            return;
        }
        List<Recording> listSplit = this.remainder.split(i);
        int size2 = listSplit.size();
        for (Recording recording : listSplit) {
            if (recording.size() == this.chunkSize) {
                processChunk(recording.toArray());
            }
        }
        Recording recording2 = listSplit.get(size2 - 1);
        if (recording2.size() == this.chunkSize) {
            this.remainder = new NullRecording();
        } else {
            this.remainder = new NearlyHomogenousBuffer(recording2.eval());
        }
    }

    public float[] preprocess(AudioReadBuffer audioReadBuffer) {
        return audioReadBuffer.toFloat();
    }

    public abstract void processChunk(float[] fArr);

    public void setChunkSize(int i) {
        this.chunkSize = i;
    }
}
