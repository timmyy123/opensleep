package com.urbandroid.sleep.audio.consumer;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.snoring.SoundClass;
import com.urbandroid.sleep.snoring.classifier.tfv4.TFLClassifier_10s_lmsd2_5cat;
import com.urbandroid.sleep.snoring.record.MonoSample;
import com.urbandroid.sleep.snoring.tensorflow.feature.WeirdRuntimeExceptionInAudio;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\b\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0014J\u0006\u0010\u0016\u001a\u00020\tJ\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u001a\u001a\u00020\u001bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\t0\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\t0\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\t0\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\t0\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\t0\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/urbandroid/sleep/audio/consumer/Classifier;", "", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "sampleRate", "", "<init>", "(Landroid/content/Context;I)V", "open", "", "tfLiteClassifier", "Lcom/urbandroid/sleep/snoring/classifier/tfv4/TFLClassifier_10s_lmsd2_5cat;", "handleSnore", "Lkotlin/Function1;", "", "handleTalk", "handleLaugh", "handleSick", "handleBaby", "noiseMixin", "", "close", "isOpen", "classify", "", "Lcom/urbandroid/sleep/snoring/SoundClass;", "chunks", "Lcom/urbandroid/sleep/audio/consumer/SafeChunksBuffer;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
final class Classifier {
    private final Context context;
    private Function1<? super Float, Boolean> handleBaby;
    private Function1<? super Float, Boolean> handleLaugh;
    private Function1<? super Float, Boolean> handleSick;
    private Function1<? super Float, Boolean> handleSnore;
    private Function1<? super Float, Boolean> handleTalk;
    private boolean noiseMixin;
    private boolean open;
    private final int sampleRate;
    private TFLClassifier_10s_lmsd2_5cat tfLiteClassifier;

    public Classifier(Context context, int i) {
        context.getClass();
        this.context = context;
        this.sampleRate = i;
        this.handleSnore = TensorflowAudioConsumerV4Kt.nullHandler();
        this.handleTalk = TensorflowAudioConsumerV4Kt.nullHandler();
        this.handleLaugh = TensorflowAudioConsumerV4Kt.nullHandler();
        this.handleSick = TensorflowAudioConsumerV4Kt.nullHandler();
        this.handleBaby = TensorflowAudioConsumerV4Kt.nullHandler();
        open();
    }

    public final Set<SoundClass> classify(SafeChunksBuffer chunks) {
        chunks.getClass();
        TFLClassifier_10s_lmsd2_5cat tFLClassifier_10s_lmsd2_5cat = this.tfLiteClassifier;
        if (tFLClassifier_10s_lmsd2_5cat == null) {
            return SetsKt.emptySet();
        }
        if (chunks.size() < 3) {
            return SetsKt.emptySet();
        }
        float[] fArrJoinAllChunks = chunks.joinAllChunks();
        if (this.noiseMixin) {
            int length = fArrJoinAllChunks.length;
            for (int i = 0; i < length; i++) {
                fArrJoinAllChunks[i] = FileInsert$$ExternalSyntheticOutline0.m((float) Math.random(), 0.5f, 0.01f, fArrJoinAllChunks[i]);
            }
        }
        try {
            float[] fArrClassify = tFLClassifier_10s_lmsd2_5cat.classify(new MonoSample(fArrJoinAllChunks, this.sampleRate));
            if (fArrClassify.length != 5) {
                Logger.logSevere("classify(): unexpected output size: " + fArrClassify.length, null);
                return SetsKt.emptySet();
            }
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            if (this.handleSnore.invoke(Float.valueOf(fArrClassify[0])).booleanValue()) {
                linkedHashSet.add(SoundClass.SNORE);
            }
            if (this.handleTalk.invoke(Float.valueOf(fArrClassify[1])).booleanValue()) {
                linkedHashSet.add(SoundClass.TALK);
            }
            if (this.handleLaugh.invoke(Float.valueOf(fArrClassify[2])).booleanValue()) {
                linkedHashSet.add(SoundClass.LAUGH);
            }
            if (this.handleSick.invoke(Float.valueOf(fArrClassify[3])).booleanValue()) {
                linkedHashSet.add(SoundClass.COUGH);
            }
            if (this.handleBaby.invoke(Float.valueOf(fArrClassify[4])).booleanValue()) {
                linkedHashSet.add(SoundClass.BABY);
            }
            return linkedHashSet;
        } catch (WeirdRuntimeExceptionInAudio e) {
            Logger.logWarning("WeirdRuntimeExceptionInAudio TensorflowAudioConsumerV4: " + fArrJoinAllChunks.length + " " + this.sampleRate, e);
            return SetsKt.emptySet();
        }
    }

    public final void close() {
        if (this.open) {
            TFLClassifier_10s_lmsd2_5cat tFLClassifier_10s_lmsd2_5cat = this.tfLiteClassifier;
            if (tFLClassifier_10s_lmsd2_5cat != null) {
                tFLClassifier_10s_lmsd2_5cat.close();
            }
            this.tfLiteClassifier = null;
            this.handleSnore = TensorflowAudioConsumerV4Kt.nullHandler();
            this.handleTalk = TensorflowAudioConsumerV4Kt.nullHandler();
            this.handleLaugh = TensorflowAudioConsumerV4Kt.nullHandler();
            this.handleSick = TensorflowAudioConsumerV4Kt.nullHandler();
            this.handleBaby = TensorflowAudioConsumerV4Kt.nullHandler();
            this.open = false;
        }
    }

    /* JADX INFO: renamed from: isOpen, reason: from getter */
    public final boolean getOpen() {
        return this.open;
    }

    public final void open() {
        if (this.open) {
            return;
        }
        Settings settings = SharedApplicationContext.getSettings();
        if (settings.isAnySoundRecognitionEnabled()) {
            this.tfLiteClassifier = new TFLClassifier_10s_lmsd2_5cat(this.context, "v4_model.q.tflite");
            int soundRecognitionSensitivitySnoring = settings.getSoundRecognitionSensitivitySnoring();
            if (soundRecognitionSensitivitySnoring > 0) {
                this.handleSnore = TensorflowAudioConsumerV4Kt.commonHandler(this.context, SoundClass.SNORE, TensorflowAudioConsumerV4Kt.thresholdValue(soundRecognitionSensitivitySnoring, 0.9f, 0.5f, 0.3f));
            }
            int soundRecognitionSensitivityTalk = settings.getSoundRecognitionSensitivityTalk();
            if (soundRecognitionSensitivityTalk > 0) {
                this.handleTalk = TensorflowAudioConsumerV4Kt.commonHandler(this.context, SoundClass.TALK, TensorflowAudioConsumerV4Kt.thresholdValue(soundRecognitionSensitivityTalk, 0.9f, 0.5f, 0.3f));
            }
            int soundRecognitionSensitivityLaughter = settings.getSoundRecognitionSensitivityLaughter();
            if (soundRecognitionSensitivityLaughter > 0) {
                this.handleLaugh = TensorflowAudioConsumerV4Kt.commonHandler(this.context, SoundClass.LAUGH, TensorflowAudioConsumerV4Kt.thresholdValue(soundRecognitionSensitivityLaughter, 0.9f, 0.5f, 0.3f));
            }
            int soundRecognitionSensitivitySick = settings.getSoundRecognitionSensitivitySick();
            if (soundRecognitionSensitivitySick > 0) {
                this.handleSick = TensorflowAudioConsumerV4Kt.commonHandler(this.context, SoundClass.COUGH, TensorflowAudioConsumerV4Kt.thresholdValue(soundRecognitionSensitivitySick, 0.8f, 0.4f, 0.2f));
            }
            int soundRecognitionSensitivityBabyCry = settings.getSoundRecognitionSensitivityBabyCry();
            if (soundRecognitionSensitivityBabyCry > 0) {
                this.handleBaby = TensorflowAudioConsumerV4Kt.commonHandler(this.context, SoundClass.BABY, TensorflowAudioConsumerV4Kt.thresholdValue(soundRecognitionSensitivityBabyCry, 0.8f, 0.4f, 0.2f));
            }
            boolean zIsSoundRecognitionNoiseMixin = SharedApplicationContext.getSettings().isSoundRecognitionNoiseMixin();
            this.noiseMixin = zIsSoundRecognitionNoiseMixin;
            StringBuilder sbM = Fragment$$ExternalSyntheticOutline1.m(soundRecognitionSensitivitySnoring, soundRecognitionSensitivityTalk, "open(): sensitivity: snore=", " talk=", " sick=");
            Fragment$$ExternalSyntheticOutline1.m(sbM, soundRecognitionSensitivitySick, " laugh=", soundRecognitionSensitivityLaughter, " baby=");
            sbM.append(soundRecognitionSensitivityBabyCry);
            sbM.append(" noiseMixin=");
            sbM.append(zIsSoundRecognitionNoiseMixin);
            Logger.logInfo(sbM.toString(), null);
        } else {
            Logger.logInfo("open(): all disabled", null);
        }
        this.open = true;
    }
}
