package com.urbandroid.sleep.audio.consumer;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.facebook.appevents.internal.ActivityLifecycleTracker$$ExternalSyntheticLambda1;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.logging.filter.Filters;
import com.urbandroid.common.logging.filter.FrequencyGuards;
import com.urbandroid.common.logging.filter.Matchers;
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
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0014J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001cH\u0014J\u0010\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020$H\u0014J\b\u0010%\u001a\u00020 H\u0014J\b\u0010&\u001a\u00020 H\u0014J\b\u0010'\u001a\u00020 H\u0014R\u0014\u0010\b\u001a\u00020\tX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/urbandroid/sleep/audio/consumer/TensorflowAudioConsumerV4;", "Lcom/urbandroid/sleep/audio/consumer/ChunkedAudioConsumer;", "Lcom/urbandroid/sleep/audio/consumer/SoundDetectionAudioConsumer;", "Lcom/urbandroid/common/FeatureLogger;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "tag", "", "getTag", "()Ljava/lang/String;", "sampleRate", "", "handler", "Landroid/os/Handler;", "broadcast", "Landroidx/localbroadcastmanager/content/LocalBroadcastManager;", "classifier", "Lcom/urbandroid/sleep/audio/consumer/Classifier;", "chunks", "Lcom/urbandroid/sleep/audio/consumer/SafeChunksBuffer;", "count", "Ljava/util/concurrent/atomic/AtomicInteger;", "lastAntisnoringTriggered", "", "lastSoundEvent", "preprocess", "", "readBuffer", "Lcom/urbandroid/sleep/audio/AudioReadBuffer;", "processChunk", "", "data", "doOpen", "audioRecorderContext", "Lcom/urbandroid/sleep/audio/AudioRecorderContext;", "doClose", "doPause", "doResume", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class TensorflowAudioConsumerV4 extends ChunkedAudioConsumer implements SoundDetectionAudioConsumer, FeatureLogger {
    private final LocalBroadcastManager broadcast;
    private final SafeChunksBuffer chunks;
    private final Classifier classifier;
    private final AtomicInteger count;
    private final Handler handler;
    private long lastAntisnoringTriggered;
    private long lastSoundEvent;
    private final int sampleRate;
    private final String tag;

    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SoundClass.values().length];
            try {
                iArr[SoundClass.SNORE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SoundClass.TALK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SoundClass.COUGH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SoundClass.LAUGH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[SoundClass.BABY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[SoundClass.OTHER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TensorflowAudioConsumerV4(Context context) {
        super(context, 0);
        context.getClass();
        this.tag = "TensorflowAudioConsumerV4";
        this.sampleRate = 24000;
        this.handler = new Handler();
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(context);
        localBroadcastManager.getClass();
        this.broadcast = localBroadcastManager;
        this.classifier = new Classifier(context, 24000);
        this.chunks = new SafeChunksBuffer(10);
        this.count = new AtomicInteger(0);
        Logger.addFilter(Filters.filter$default(Matchers.startsWith(getTag() + ":"), FrequencyGuards.maxCountPerInterval(60, 20), 0, 4, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void processChunk$lambda$0(SleepRecord sleepRecord, SoundClass soundClass, double d, long j) {
        if (sleepRecord.isFinished()) {
            return;
        }
        switch (WhenMappings.$EnumSwitchMapping$0[soundClass.ordinal()]) {
            case 1:
                sleepRecord.addSnore((int) Math.round(d));
                sleepRecord.addEventLabel(EventLabel.SNORING, j);
                break;
            case 2:
                sleepRecord.addEventLabel(EventLabel.TALK, j);
                break;
            case 3:
                sleepRecord.addEventLabel(EventLabel.SICK, j);
                break;
            case 4:
                sleepRecord.addEventLabel(EventLabel.LAUGH, j);
                break;
            case 5:
                sleepRecord.addEventLabel(EventLabel.BABY, j);
                break;
            case 6:
                break;
            default:
                Home$$ExternalSyntheticBUOutline0.m();
                break;
        }
    }

    @Override // com.urbandroid.sleep.audio.consumer.BaseAudioConsumer
    public void doClose() {
        super.doClose();
        this.chunks.clear();
        this.classifier.close();
    }

    @Override // com.urbandroid.sleep.audio.consumer.BaseAudioConsumer
    public void doOpen(AudioRecorderContext audioRecorderContext) {
        audioRecorderContext.getClass();
        super.doOpen(audioRecorderContext);
        this.chunkSize = this.sampleRate;
        this.classifier.open();
        this.count.set(0);
    }

    @Override // com.urbandroid.sleep.audio.consumer.BaseAudioConsumer
    public void doPause() {
        super.doPause();
        this.chunks.clear();
        this.classifier.close();
    }

    @Override // com.urbandroid.sleep.audio.consumer.BaseAudioConsumer
    public void doResume() {
        super.doResume();
        this.classifier.open();
        this.count.set(0);
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
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
        data2.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.chunks.add(data2);
        if (this.count.getAndIncrement() % 3 == 0 && this.classifier.getOpen()) {
            Set<SoundClass> setClassify = this.classifier.classify(this.chunks);
            SoundClass soundClass = SoundClass.TALK;
            if (!setClassify.contains(soundClass)) {
                soundClass = SoundClass.SNORE;
                if (!setClassify.contains(soundClass)) {
                    soundClass = SoundClass.COUGH;
                    if (!setClassify.contains(soundClass)) {
                        soundClass = SoundClass.LAUGH;
                        if (!setClassify.contains(soundClass)) {
                            soundClass = SoundClass.BABY;
                            if (!setClassify.contains(soundClass)) {
                                soundClass = SoundClass.OTHER;
                            }
                        }
                    }
                }
            }
            SoundClass soundClass2 = soundClass;
            SoundEvent soundEventNewAggregatedEvent = SoundEvent.newAggregatedEvent(soundClass2, 1.0d);
            this.broadcast.sendBroadcast(soundEventNewAggregatedEvent.toIntent());
            if (soundClass2 == SoundClass.OTHER || (jCurrentTimeMillis - this.lastSoundEvent) / 1000 < 30.0d) {
                return;
            }
            String str = Logger.defaultTag;
            Logger.logDebug(str, getTag() + ": " + ("processChunk(): generating sound event. " + soundClass2), null);
            this.lastSoundEvent = jCurrentTimeMillis;
            SleepRecord record = CurrentSleepRecord.getInstance().getRecord();
            if (record != null) {
                this.handler.post(new ActivityLifecycleTracker$$ExternalSyntheticLambda1(record, soundClass2, System.currentTimeMillis() - Math.round(30000.0d), 2));
            }
            if (soundClass2 == SoundClass.SNORE && (jCurrentTimeMillis - this.lastAntisnoringTriggered) / 1000 >= 60) {
                Logger.logDebug(Logger.defaultTag, getTag() + ": processChunk(): antisnoring called", null);
                Context context = this.context;
                context.getClass();
                ContextExtKt.sendExplicitBroadcast$default(context, new Intent(SnoringReceiver.ANTISNORING_ACTION), null, 2, null);
                this.lastAntisnoringTriggered = jCurrentTimeMillis;
            }
            Context context2 = this.context;
            context2.getClass();
            Intent publicIntent = soundEventNewAggregatedEvent.toPublicIntent();
            publicIntent.getClass();
            ContextExtKt.sendExplicitBroadcast$default(context2, publicIntent, null, 2, null);
        }
    }
}
