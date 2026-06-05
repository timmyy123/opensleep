package com.urbandroid.sleep.audio.consumer;

import android.content.Context;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;
import com.urbandroid.sleep.audio.AudioReadBuffer;
import com.urbandroid.sleep.audio.AudioRecorder;
import com.urbandroid.sleep.audio.AudioRecorderContext;

/* JADX INFO: loaded from: classes4.dex */
public abstract class BaseAudioConsumer implements AudioRecorder.Consumer {
    protected final Context context;
    protected AudioRecorderContext recorderContext;
    protected AudioRecorder.Consumer.State state = AudioRecorder.Consumer.State.CLOSED;

    public BaseAudioConsumer(Context context) {
        this.context = context;
        GlobalInitializator.initializeIfRequired(context);
    }

    @Override // com.urbandroid.sleep.audio.AudioRecorder.Consumer
    public final synchronized void close() {
        AudioRecorder.Consumer.State state = this.state;
        AudioRecorder.Consumer.State state2 = AudioRecorder.Consumer.State.CLOSED;
        if (state == state2) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        doClose();
        this.state = state2;
        Logger.logInfo("AudioRecorder: " + getClass().getSimpleName() + " closed " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
    }

    public void doClose() {
    }

    public void doOpen(AudioRecorderContext audioRecorderContext) {
    }

    public void doPause() {
    }

    public abstract void doProcess(AudioReadBuffer audioReadBuffer);

    public void doResume() {
    }

    @Override // com.urbandroid.sleep.audio.AudioRecorder.Consumer
    public synchronized AudioRecorder.Consumer.State getState() {
        return this.state;
    }

    @Override // com.urbandroid.sleep.audio.AudioRecorder.Consumer
    public final synchronized void open(AudioRecorderContext audioRecorderContext) {
        if (this.state != AudioRecorder.Consumer.State.CLOSED) {
            return;
        }
        Logger.logInfo("AudioRecorder: " + getClass().getSimpleName() + " open with " + audioRecorderContext.getBaseSampleRate() + " sample rate");
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.recorderContext = audioRecorderContext;
        doOpen(audioRecorderContext);
        this.state = AudioRecorder.Consumer.State.OPEN;
        Logger.logInfo("AudioRecorder: " + getClass().getSimpleName() + " open " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
    }

    @Override // com.urbandroid.sleep.audio.AudioRecorder.Consumer
    public final synchronized void pause() {
        AudioRecorder.Consumer.State state = this.state;
        AudioRecorder.Consumer.State state2 = AudioRecorder.Consumer.State.PAUSED;
        if (state != state2 && state != AudioRecorder.Consumer.State.CLOSED) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            doPause();
            this.state = state2;
            Logger.logInfo("AudioRecorder: " + getClass().getSimpleName() + " pause " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
        }
    }

    @Override // com.urbandroid.sleep.audio.AudioRecorder.Consumer
    public final synchronized void process(AudioReadBuffer audioReadBuffer) {
        if (this.state == AudioRecorder.Consumer.State.OPEN) {
            doProcess(audioReadBuffer);
        }
    }

    @Override // com.urbandroid.sleep.audio.AudioRecorder.Consumer
    public final synchronized void resume() {
        AudioRecorder.Consumer.State state = this.state;
        AudioRecorder.Consumer.State state2 = AudioRecorder.Consumer.State.OPEN;
        if (state != state2 && state != AudioRecorder.Consumer.State.CLOSED) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            doResume();
            this.state = state2;
            Logger.logInfo("AudioRecorder: " + getClass().getSimpleName() + " resume " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
        }
    }
}
