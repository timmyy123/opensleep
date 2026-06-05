package com.urbandroid.sleep.captcha;

import android.content.Context;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.audio.AudioReadBuffer;
import com.urbandroid.sleep.audio.AudioRecorderContext;
import com.urbandroid.sleep.audio.consumer.ChunkedAudioConsumer;
import com.urbandroid.sleep.audio.consumer.SafeChunksBuffer;
import com.urbandroid.sleep.audio.event.SoundEvent;
import com.urbandroid.sleep.audio.transform.AudioTransformer;
import com.urbandroid.sleep.snoring.SoundClass;
import com.urbandroid.sleep.snoring.classifier.tfv4.TFLClassifier_10s_lmsd2_5cat;
import com.urbandroid.sleep.snoring.record.MonoSample;
import com.urbandroid.sleep.snoring.tensorflow.feature.WeirdRuntimeExceptionInAudio;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0014J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0011H\u0014J\u0010\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0019H\u0014J\b\u0010\u001a\u001a\u00020\u0015H\u0014J\b\u0010\u001b\u001a\u00020\u0015H\u0014J\b\u0010\u001c\u001a\u00020\u0015H\u0014J\b\u0010\u001d\u001a\u00020\u0015H\u0002J\b\u0010\u001e\u001a\u00020\u0015H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/urbandroid/sleep/captcha/LaughterDetectorV4;", "Lcom/urbandroid/sleep/audio/consumer/ChunkedAudioConsumer;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "sampleRate", "", "classifier", "Lcom/urbandroid/sleep/snoring/classifier/tfv4/TFLClassifier_10s_lmsd2_5cat;", "chunks", "Lcom/urbandroid/sleep/audio/consumer/SafeChunksBuffer;", "count", "Ljava/util/concurrent/atomic/AtomicInteger;", "broadcast", "Landroidx/localbroadcastmanager/content/LocalBroadcastManager;", "preprocess", "", "readBuffer", "Lcom/urbandroid/sleep/audio/AudioReadBuffer;", "processChunk", "", "data", "doOpen", "audioRecorderContext", "Lcom/urbandroid/sleep/audio/AudioRecorderContext;", "doClose", "doPause", "doResume", "initClassifier", "destroyClassifier", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
final class LaughterDetectorV4 extends ChunkedAudioConsumer {
    private final LocalBroadcastManager broadcast;
    private final SafeChunksBuffer chunks;
    private TFLClassifier_10s_lmsd2_5cat classifier;
    private final AtomicInteger count;
    private final int sampleRate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LaughterDetectorV4(Context context) {
        super(context, 0);
        context.getClass();
        this.sampleRate = 24000;
        this.chunks = new SafeChunksBuffer(4);
        this.count = new AtomicInteger(0);
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(context);
        localBroadcastManager.getClass();
        this.broadcast = localBroadcastManager;
    }

    private final void destroyClassifier() {
        TFLClassifier_10s_lmsd2_5cat tFLClassifier_10s_lmsd2_5cat = this.classifier;
        if (tFLClassifier_10s_lmsd2_5cat != null) {
            tFLClassifier_10s_lmsd2_5cat.close();
        }
        this.classifier = null;
    }

    private final void initClassifier() {
        if (this.classifier == null) {
            Context context = this.context;
            context.getClass();
            this.classifier = new TFLClassifier_10s_lmsd2_5cat(context, "v4_model.q.tflite");
            this.count.set(0);
        }
    }

    @Override // com.urbandroid.sleep.audio.consumer.BaseAudioConsumer
    public void doClose() {
        super.doClose();
        this.chunks.clear();
        destroyClassifier();
    }

    @Override // com.urbandroid.sleep.audio.consumer.BaseAudioConsumer
    public void doOpen(AudioRecorderContext audioRecorderContext) {
        audioRecorderContext.getClass();
        super.doOpen(audioRecorderContext);
        this.chunkSize = this.sampleRate;
        initClassifier();
    }

    @Override // com.urbandroid.sleep.audio.consumer.BaseAudioConsumer
    public void doPause() {
        super.doPause();
        this.chunks.clear();
        destroyClassifier();
    }

    @Override // com.urbandroid.sleep.audio.consumer.BaseAudioConsumer
    public void doResume() {
        super.doResume();
        initClassifier();
    }

    @Override // com.urbandroid.sleep.audio.consumer.ChunkedAudioConsumer
    public float[] preprocess(AudioReadBuffer readBuffer) {
        readBuffer.getClass();
        float[] data2 = AudioTransformer.from(this.recorderContext.getSampleRate(), readBuffer).iirFilterFactory(this.recorderContext.getIirFilterFactory()).lowPass6K().copyData().resampleIP(this.sampleRate).toData();
        data2.getClass();
        return data2;
    }

    @Override // com.urbandroid.sleep.audio.consumer.ChunkedAudioConsumer
    public void processChunk(float[] data2) {
        TFLClassifier_10s_lmsd2_5cat tFLClassifier_10s_lmsd2_5cat;
        data2.getClass();
        this.chunks.add(data2);
        if (this.count.getAndIncrement() % 2 == 0 && (tFLClassifier_10s_lmsd2_5cat = this.classifier) != null && this.chunks.size() >= 3) {
            float[] fArrJoinAllChunks = this.chunks.joinAllChunks();
            try {
                double d = tFLClassifier_10s_lmsd2_5cat.classify(new MonoSample(fArrJoinAllChunks, this.sampleRate))[2];
                SoundClass soundClass = SoundClass.LAUGH;
                if (d < 0.1d) {
                    d = 0.0d;
                }
                this.broadcast.sendBroadcast(SoundEvent.newRawEvent(soundClass, d).toIntent());
            } catch (WeirdRuntimeExceptionInAudio e) {
                Logger.logWarning("WeirdRuntimeExceptionInAudio LOLCaptcha.LaughterDetectorV4: " + fArrJoinAllChunks.length + " " + this.sampleRate, e);
                Unit unit = Unit.INSTANCE;
            }
        }
    }
}
