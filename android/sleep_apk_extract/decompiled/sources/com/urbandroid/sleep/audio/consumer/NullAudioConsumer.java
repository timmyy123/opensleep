package com.urbandroid.sleep.audio.consumer;

import android.content.Context;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.audio.AudioReadBuffer;

/* JADX INFO: loaded from: classes4.dex */
public class NullAudioConsumer extends BaseAudioConsumer {
    public NullAudioConsumer(Context context) {
        super(context);
    }

    @Override // com.urbandroid.sleep.audio.consumer.BaseAudioConsumer
    public void doProcess(AudioReadBuffer audioReadBuffer) {
        Logger.logDebug("AudioRecorder: NullAudioConsumer received data for processing: " + audioReadBuffer.length());
    }
}
