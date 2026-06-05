package com.urbandroid.sleep.audio.consumer;

import android.content.Context;
import android.os.Handler;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.audio.AudioReadBuffer;
import com.urbandroid.sleep.audio.AudioRecorderContext;
import com.urbandroid.sleep.audio.event.SoundEvent;
import com.urbandroid.sleep.audio.transform.AudioTransformer;
import com.urbandroid.sleep.domain.CurrentSleepRecord;
import com.urbandroid.sleep.domain.EventLabel;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.mic.SnoringReceiver;
import com.urbandroid.sleep.snoring.SoundClass;
import com.urbandroid.sleep.snoring.classifier.old.NewSnoringClassifierImpl;
import com.urbandroid.sleep.snoring.classifier.old.RequireTwoSubsequentPositives;
import com.urbandroid.sleep.snoring.classifier.old.SnoringClassifier;

/* JADX INFO: loaded from: classes4.dex */
public class SnoringDetectionAudioConsumer extends ChunkedAudioConsumer implements SoundDetectionAudioConsumer {
    private int bufferSizeInSeconds;
    private int decimateFactor;
    private Handler h;
    private long lastAntisnoring;
    private final SnoringClassifier snoringClassifier;

    public SnoringDetectionAudioConsumer(Context context) {
        super(context, 0);
        this.bufferSizeInSeconds = 20;
        this.lastAntisnoring = 0L;
        this.h = new Handler();
        this.snoringClassifier = new RequireTwoSubsequentPositives(new NewSnoringClassifierImpl());
    }

    public static SnoringDetectionAudioConsumer from(Context context) {
        return new SnoringDetectionAudioConsumer(context);
    }

    public SnoringDetectionAudioConsumer bufferSizeInSeconds(int i) {
        this.bufferSizeInSeconds = i;
        return this;
    }

    public SnoringDetectionAudioConsumer decimateFactor(int i) {
        this.decimateFactor = i;
        return this;
    }

    @Override // com.urbandroid.sleep.audio.consumer.BaseAudioConsumer
    public void doOpen(AudioRecorderContext audioRecorderContext) {
        int floatBufferSize = audioRecorderContext.getFloatBufferSize();
        int sampleRate = audioRecorderContext.getSampleRate();
        while (true) {
            float f = floatBufferSize / sampleRate;
            if (f > this.bufferSizeInSeconds) {
                this.chunkSize = floatBufferSize / this.decimateFactor;
                Logger.logDebug("Snoring: Calculated chunkSize: " + this.chunkSize + " seconds: " + f);
                return;
            }
            floatBufferSize *= 2;
        }
    }

    @Override // com.urbandroid.sleep.audio.consumer.ChunkedAudioConsumer
    public float[] preprocess(AudioReadBuffer audioReadBuffer) {
        AudioTransformer audioTransformerFrom = AudioTransformer.from(this.recorderContext.getSampleRate(), audioReadBuffer);
        if (this.recorderContext.hasFeature(AudioRecorderContext.Feature.ULTRASOUND_PLAYER)) {
            audioTransformerFrom = audioTransformerFrom.iirFilterFactory(this.recorderContext.getIirFilterFactory()).lowPass14K();
        }
        return audioTransformerFrom.copyData().decimate(this.decimateFactor).toData();
    }

    @Override // com.urbandroid.sleep.audio.consumer.ChunkedAudioConsumer
    public void processChunk(float[] fArr) {
        int baseSampleRate = this.recorderContext.getBaseSampleRate() / this.decimateFactor;
        boolean zIsSnoring = this.snoringClassifier.isSnoring(fArr, baseSampleRate);
        SoundEvent soundEventNewAggregatedEvent = zIsSnoring ? SoundEvent.newAggregatedEvent(SoundClass.SNORE, 1.0d) : SoundEvent.newAggregatedEvent(SoundClass.OTHER, 1.0d);
        ContextExtKt.sendExplicitBroadcast(this.context, soundEventNewAggregatedEvent.toIntent());
        LocalBroadcastManager.getInstance(this.context).sendBroadcast(soundEventNewAggregatedEvent.toIntent());
        if (zIsSnoring) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if ((jCurrentTimeMillis - this.lastAntisnoring) / 1000 >= 60) {
                Logger.logDebug("SnoringDetectionAudioConsumer: antisnoring called");
                zza$$ExternalSyntheticOutline0.m(this.context, SnoringReceiver.ANTISNORING_ACTION);
                this.lastAntisnoring = jCurrentTimeMillis;
            }
            Logger.logDebug("SnoringDetectionAudioConsumer: addSnore " + zIsSnoring);
            final SleepRecord record = CurrentSleepRecord.getInstance().getRecord();
            if (record != null) {
                final double length = ((double) fArr.length) / ((double) baseSampleRate);
                final long jCurrentTimeMillis2 = System.currentTimeMillis() - Math.round(1000.0d * length);
                this.h.post(new Runnable() { // from class: com.urbandroid.sleep.audio.consumer.SnoringDetectionAudioConsumer.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (record.isFinished()) {
                            return;
                        }
                        record.addSnore((int) Math.round(length));
                        record.addEventLabel(EventLabel.SNORING, jCurrentTimeMillis2);
                    }
                });
            }
        }
    }
}
