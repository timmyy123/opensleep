package com.urbandroid.sleep.audio.consumer;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.facebook.appevents.internal.ActivityLifecycleTracker$$ExternalSyntheticLambda1;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
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
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.snoring.SoundClass;
import com.urbandroid.sleep.snoring.classifier.tfv3.AudioClassifier;
import com.urbandroid.sleep.snoring.classifier.tfv3.AudioClassifierExtKt;
import com.urbandroid.sleep.snoring.classifier.tfv3.ConstantClassifier;
import com.urbandroid.sleep.snoring.classifier.tfv3.EnsembleSnoreClassifier;
import com.urbandroid.sleep.snoring.classifier.tfv3.TFLClassifier_3s_lmf_2L_025s;
import com.urbandroid.sleep.snoring.record.MonoSample;
import com.urbandroid.sleep.snoring.tensorflow.feature.WeirdRuntimeExceptionInAudio;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001!B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0014J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0015H\u0014J\u0010\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001dH\u0014J\b\u0010\u001e\u001a\u00020\u0019H\u0014J\b\u0010\u001f\u001a\u00020\u0019H\u0014J\b\u0010 \u001a\u00020\u0019H\u0014R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/urbandroid/sleep/audio/consumer/TensorflowAudioConsumerV3;", "Lcom/urbandroid/sleep/audio/consumer/ChunkedAudioConsumer;", "Lcom/urbandroid/sleep/audio/consumer/SoundDetectionAudioConsumer;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "sampleRate", "", "handler", "Landroid/os/Handler;", "broadcast", "Landroidx/localbroadcastmanager/content/LocalBroadcastManager;", "classifiers", "Lcom/urbandroid/sleep/audio/consumer/TensorflowAudioConsumerV3$Classifiers;", "chunks", "Lcom/urbandroid/sleep/audio/consumer/SafeChunksBuffer;", "lastAntisnoringTriggereg", "", "lastSoundEvent", "preprocess", "", "readBuffer", "Lcom/urbandroid/sleep/audio/AudioReadBuffer;", "processChunk", "", "data", "doOpen", "audioRecorderContext", "Lcom/urbandroid/sleep/audio/AudioRecorderContext;", "doClose", "doPause", "doResume", "Classifiers", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class TensorflowAudioConsumerV3 extends ChunkedAudioConsumer implements SoundDetectionAudioConsumer {
    private final LocalBroadcastManager broadcast;
    private final SafeChunksBuffer chunks;
    private final Classifiers classifiers;
    private final Handler handler;
    private volatile long lastAntisnoringTriggereg;
    private volatile long lastSoundEvent;
    private final int sampleRate;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\b\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0012\u001a\u00020\tJ\u000e\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0015J \u0010\u001a\u001a\u00020\t2\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/urbandroid/sleep/audio/consumer/TensorflowAudioConsumerV3$Classifiers;", "", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "sampleRate", "", "<init>", "(Landroid/content/Context;I)V", "open", "", "snore", "Lcom/urbandroid/sleep/snoring/classifier/tfv3/AudioClassifier;", "talk", "sick", "laugh", "baby", "", "close", "isOpen", "isSnore", "chunks", "Lcom/urbandroid/sleep/audio/consumer/SafeChunksBuffer;", "isTalk", "isSick", "isLaugh", "isBaby", "classify", "classifier", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Classifiers {
        private AudioClassifier<Boolean> baby;
        private final Context context;
        private AudioClassifier<Boolean> laugh;
        private boolean open;
        private final int sampleRate;
        private AudioClassifier<Boolean> sick;
        private AudioClassifier<Boolean> snore;
        private AudioClassifier<Boolean> talk;

        public Classifiers(Context context, int i) {
            context.getClass();
            this.context = context;
            this.sampleRate = i;
            open();
        }

        private final boolean classify(AudioClassifier<Boolean> classifier, SafeChunksBuffer chunks) {
            if (classifier == null) {
                return false;
            }
            int historySize = (int) classifier.getInputLengthSeconds();
            float[] fArrJoinChunks = chunks.joinChunks(historySize);
            int length = fArrJoinChunks.length;
            int i = this.sampleRate;
            if (length != i * historySize) {
                return false;
            }
            try {
                return classifier.classify(new MonoSample(fArrJoinChunks, i)).booleanValue();
            } catch (WeirdRuntimeExceptionInAudio e) {
                int length2 = fArrJoinChunks.length;
                int i2 = this.sampleRate;
                StringBuilder sbM = Fragment$$ExternalSyntheticOutline1.m(historySize, length2, "WeirdRuntimeExceptionInAudio TensorflowAudioConsumerV3.Classifiers.classify(): ", " ", " ");
                sbM.append(i2);
                Logger.logWarning(sbM.toString(), e);
                return false;
            }
        }

        public final void close() {
            if (this.open) {
                AudioClassifier<Boolean> audioClassifier = this.snore;
                if (audioClassifier != null) {
                    audioClassifier.close();
                }
                this.snore = null;
                AudioClassifier<Boolean> audioClassifier2 = this.talk;
                if (audioClassifier2 != null) {
                    audioClassifier2.close();
                }
                this.talk = null;
                AudioClassifier<Boolean> audioClassifier3 = this.sick;
                if (audioClassifier3 != null) {
                    audioClassifier3.close();
                }
                this.sick = null;
                AudioClassifier<Boolean> audioClassifier4 = this.laugh;
                if (audioClassifier4 != null) {
                    audioClassifier4.close();
                }
                this.laugh = null;
                AudioClassifier<Boolean> audioClassifier5 = this.baby;
                if (audioClassifier5 != null) {
                    audioClassifier5.close();
                }
                this.baby = null;
                this.open = false;
            }
        }

        public final boolean isBaby(SafeChunksBuffer chunks) {
            chunks.getClass();
            return classify(this.baby, chunks);
        }

        public final boolean isLaugh(SafeChunksBuffer chunks) {
            chunks.getClass();
            return classify(this.laugh, chunks);
        }

        /* JADX INFO: renamed from: isOpen, reason: from getter */
        public final boolean getOpen() {
            return this.open;
        }

        public final boolean isSick(SafeChunksBuffer chunks) {
            chunks.getClass();
            return classify(this.sick, chunks);
        }

        public final boolean isSnore(SafeChunksBuffer chunks) {
            chunks.getClass();
            return classify(this.snore, chunks);
        }

        public final boolean isTalk(SafeChunksBuffer chunks) {
            chunks.getClass();
            return classify(this.talk, chunks);
        }

        public final void open() {
            AudioClassifier<Boolean> constantClassifier;
            AudioClassifier<Boolean> constantClassifier2;
            AudioClassifier<Boolean> constantClassifier3;
            AudioClassifier<Boolean> constantClassifier4;
            if (this.open) {
                return;
            }
            Settings settings = SharedApplicationContext.getSettings();
            int soundRecognitionSensitivitySnoring = settings.getSoundRecognitionSensitivitySnoring();
            this.snore = soundRecognitionSensitivitySnoring > 0 ? new EnsembleSnoreClassifier(AudioClassifierExtKt.broadcastSoundEvent(new TFLClassifier_3s_lmf_2L_025s(this.context, "v3_snore.q.tflite", null, null, 12, null), this.context, SoundClass.SNORE), soundRecognitionSensitivitySnoring) : new ConstantClassifier(Boolean.FALSE, 0, 0.0d, 6, null);
            int soundRecognitionSensitivityTalk = settings.getSoundRecognitionSensitivityTalk();
            double d = Double.POSITIVE_INFINITY;
            if (soundRecognitionSensitivityTalk > 0) {
                constantClassifier = AudioClassifierExtKt.isAbove(AudioClassifierExtKt.mean(AudioClassifierExtKt.broadcastSoundEvent(new TFLClassifier_3s_lmf_2L_025s(this.context, "v3_talk.q.tflite", null, null, 12, null), this.context, SoundClass.TALK), 30), soundRecognitionSensitivityTalk != 1 ? soundRecognitionSensitivityTalk != 2 ? soundRecognitionSensitivityTalk != 3 ? Double.POSITIVE_INFINITY : 0.05d : 0.1d : 0.2d);
            } else {
                constantClassifier = new ConstantClassifier(Boolean.FALSE, 0, 0.0d, 6, null);
            }
            this.talk = constantClassifier;
            int soundRecognitionSensitivitySick = settings.getSoundRecognitionSensitivitySick();
            if (soundRecognitionSensitivitySick > 0) {
                constantClassifier2 = AudioClassifierExtKt.isAbove(AudioClassifierExtKt.mean(AudioClassifierExtKt.broadcastSoundEvent(new TFLClassifier_3s_lmf_2L_025s(this.context, "v3_sick.q.tflite", null, null, 12, null), this.context, SoundClass.COUGH), 30), soundRecognitionSensitivitySick != 1 ? soundRecognitionSensitivitySick != 2 ? soundRecognitionSensitivitySick != 3 ? Double.POSITIVE_INFINITY : 0.04d : 0.08d : 0.16d);
            } else {
                constantClassifier2 = new ConstantClassifier(Boolean.FALSE, 0, 0.0d, 6, null);
            }
            this.sick = constantClassifier2;
            int soundRecognitionSensitivityLaughter = settings.getSoundRecognitionSensitivityLaughter();
            if (soundRecognitionSensitivityLaughter > 0) {
                constantClassifier3 = AudioClassifierExtKt.isAbove(AudioClassifierExtKt.mean(AudioClassifierExtKt.broadcastSoundEvent(new TFLClassifier_3s_lmf_2L_025s(this.context, "v3_laugh.q.tflite", null, null, 12, null), this.context, SoundClass.LAUGH), 30), soundRecognitionSensitivityLaughter != 1 ? soundRecognitionSensitivityLaughter != 2 ? soundRecognitionSensitivityLaughter != 3 ? Double.POSITIVE_INFINITY : 0.05d : 0.1d : 0.2d);
            } else {
                constantClassifier3 = new ConstantClassifier(Boolean.FALSE, 0, 0.0d, 6, null);
            }
            this.laugh = constantClassifier3;
            int soundRecognitionSensitivityBabyCry = settings.getSoundRecognitionSensitivityBabyCry();
            if (soundRecognitionSensitivityBabyCry > 0) {
                AudioClassifier<Double> audioClassifierMean = AudioClassifierExtKt.mean(AudioClassifierExtKt.broadcastSoundEvent(new TFLClassifier_3s_lmf_2L_025s(this.context, "v3_baby.q.tflite", null, null, 12, null), this.context, SoundClass.BABY), 30);
                if (soundRecognitionSensitivityBabyCry == 1) {
                    d = 0.2d;
                } else if (soundRecognitionSensitivityBabyCry == 2) {
                    d = 0.1d;
                } else if (soundRecognitionSensitivityBabyCry == 3) {
                    d = 0.05d;
                }
                constantClassifier4 = AudioClassifierExtKt.isAbove(audioClassifierMean, d);
            } else {
                constantClassifier4 = new ConstantClassifier(Boolean.FALSE, 0, 0.0d, 6, null);
            }
            this.baby = constantClassifier4;
            StringBuilder sbM = Fragment$$ExternalSyntheticOutline1.m(soundRecognitionSensitivitySnoring, soundRecognitionSensitivityTalk, "TensorflowAudioConsumerV3: sensitivity: snore=", " talk=", " sick=");
            Fragment$$ExternalSyntheticOutline1.m(sbM, soundRecognitionSensitivitySick, " laugh=", soundRecognitionSensitivityLaughter, " baby=");
            zza$$ExternalSyntheticOutline0.m(sbM, soundRecognitionSensitivityBabyCry);
            this.open = true;
        }
    }

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
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TensorflowAudioConsumerV3(Context context) {
        super(context, 0);
        context.getClass();
        this.sampleRate = 12000;
        this.handler = new Handler();
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(context);
        localBroadcastManager.getClass();
        this.broadcast = localBroadcastManager;
        this.classifiers = new Classifiers(context, 12000);
        this.chunks = new SafeChunksBuffer(60);
        Logger.addFilter(Filters.filter$default(Matchers.startsWith("TensorflowAudioConsumerV3:"), FrequencyGuards.maxCountPerInterval(60, 20), 0, 4, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void processChunk$lambda$0(SleepRecord sleepRecord, SoundClass soundClass, double d, long j) {
        if (sleepRecord.isFinished()) {
            return;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[soundClass.ordinal()];
        if (i == 1) {
            sleepRecord.addSnore((int) Math.round(d));
            sleepRecord.addEventLabel(EventLabel.SNORING, j);
            return;
        }
        if (i == 2) {
            sleepRecord.addEventLabel(EventLabel.TALK, j);
            return;
        }
        if (i == 3) {
            sleepRecord.addEventLabel(EventLabel.SICK, j);
            return;
        }
        if (i == 4) {
            sleepRecord.addEventLabel(EventLabel.LAUGH, j);
        } else {
            if (i == 5) {
                sleepRecord.addEventLabel(EventLabel.BABY, j);
                return;
            }
            Logger.logDebug("SoundClass - " + soundClass, null);
        }
    }

    @Override // com.urbandroid.sleep.audio.consumer.BaseAudioConsumer
    public void doClose() {
        super.doClose();
        this.chunks.clear();
        this.classifiers.close();
    }

    @Override // com.urbandroid.sleep.audio.consumer.BaseAudioConsumer
    public void doOpen(AudioRecorderContext audioRecorderContext) {
        audioRecorderContext.getClass();
        super.doOpen(audioRecorderContext);
        this.chunkSize = this.sampleRate;
        this.classifiers.open();
    }

    @Override // com.urbandroid.sleep.audio.consumer.BaseAudioConsumer
    public void doPause() {
        super.doPause();
        this.chunks.clear();
        this.classifiers.close();
    }

    @Override // com.urbandroid.sleep.audio.consumer.BaseAudioConsumer
    public void doResume() {
        super.doResume();
        this.classifiers.open();
    }

    @Override // com.urbandroid.sleep.audio.consumer.ChunkedAudioConsumer
    public float[] preprocess(AudioReadBuffer readBuffer) {
        readBuffer.getClass();
        float[] data2 = AudioTransformer.from(this.recorderContext.getSampleRate(), readBuffer).iirFilterFactory(this.recorderContext.getIirFilterFactory()).lowPass5K().copyData().resampleIP(this.sampleRate).toData();
        data2.getClass();
        return data2;
    }

    @Override // com.urbandroid.sleep.audio.consumer.ChunkedAudioConsumer
    public void processChunk(float[] data2) {
        data2.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.chunks.add(data2);
        if (this.classifiers.getOpen()) {
            SoundClass soundClass = this.classifiers.isTalk(this.chunks) ? SoundClass.TALK : this.classifiers.isSnore(this.chunks) ? SoundClass.SNORE : this.classifiers.isSick(this.chunks) ? SoundClass.COUGH : this.classifiers.isLaugh(this.chunks) ? SoundClass.LAUGH : this.classifiers.isBaby(this.chunks) ? SoundClass.BABY : SoundClass.OTHER;
            SoundEvent soundEventNewAggregatedEvent = SoundEvent.newAggregatedEvent(soundClass, 1.0d);
            this.broadcast.sendBroadcast(soundEventNewAggregatedEvent.toIntent());
            if (soundClass == SoundClass.OTHER || (jCurrentTimeMillis - this.lastSoundEvent) / 1000 < 30.0d) {
                return;
            }
            Logger.logDebug("TensorflowAudioConsumerV3: generating sound event. " + soundClass);
            this.lastSoundEvent = jCurrentTimeMillis;
            SleepRecord record = CurrentSleepRecord.getInstance().getRecord();
            if (record != null) {
                this.handler.post(new ActivityLifecycleTracker$$ExternalSyntheticLambda1(record, soundClass, System.currentTimeMillis() - Math.round(30000.0d), 1));
            }
            if (soundClass == SoundClass.SNORE && (jCurrentTimeMillis - this.lastAntisnoringTriggereg) / 1000 >= 60) {
                Logger.logDebug("TensorflowAudioConsumerV3: antisnoring called");
                Context context = this.context;
                context.getClass();
                ContextExtKt.sendExplicitBroadcast$default(context, new Intent(SnoringReceiver.ANTISNORING_ACTION), null, 2, null);
                this.lastAntisnoringTriggereg = jCurrentTimeMillis;
            }
            Context context2 = this.context;
            context2.getClass();
            Intent publicIntent = soundEventNewAggregatedEvent.toPublicIntent();
            publicIntent.getClass();
            ContextExtKt.sendExplicitBroadcast$default(context2, publicIntent, null, 2, null);
        }
    }
}
