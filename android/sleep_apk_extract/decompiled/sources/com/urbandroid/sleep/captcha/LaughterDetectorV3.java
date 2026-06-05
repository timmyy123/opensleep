package com.urbandroid.sleep.captcha;

import android.content.Context;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.audio.AudioReadBuffer;
import com.urbandroid.sleep.audio.AudioRecorderContext;
import com.urbandroid.sleep.audio.consumer.ChunkedAudioConsumer;
import com.urbandroid.sleep.audio.consumer.SafeChunksBuffer;
import com.urbandroid.sleep.audio.transform.AudioTransformer;
import com.urbandroid.sleep.snoring.SoundClass;
import com.urbandroid.sleep.snoring.classifier.tfv3.AudioClassifier;
import com.urbandroid.sleep.snoring.classifier.tfv3.AudioClassifierExtKt;
import com.urbandroid.sleep.snoring.classifier.tfv3.TFLClassifier_3s_lmf_2L_025s;
import com.urbandroid.sleep.snoring.record.MonoSample;
import com.urbandroid.sleep.snoring.tensorflow.feature.WeirdRuntimeExceptionInAudio;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0014J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000fH\u0014J\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u0013H\u0014J\b\u0010\u0019\u001a\u00020\u0013H\u0014J\b\u0010\u001a\u001a\u00020\u0013H\u0014J\b\u0010\u001b\u001a\u00020\u0013H\u0002J\b\u0010\u001c\u001a\u00020\u0013H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/urbandroid/sleep/captcha/LaughterDetectorV3;", "Lcom/urbandroid/sleep/audio/consumer/ChunkedAudioConsumer;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "sampleRate", "", "chunksCount", "classifier", "Lcom/urbandroid/sleep/snoring/classifier/tfv3/AudioClassifier;", "", "chunks", "Lcom/urbandroid/sleep/audio/consumer/SafeChunksBuffer;", "preprocess", "", "readBuffer", "Lcom/urbandroid/sleep/audio/AudioReadBuffer;", "processChunk", "", "data", "doOpen", "audioRecorderContext", "Lcom/urbandroid/sleep/audio/AudioRecorderContext;", "doClose", "doPause", "doResume", "initClassifier", "destroyClassifier", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
final class LaughterDetectorV3 extends ChunkedAudioConsumer {
    private final SafeChunksBuffer chunks;
    private final int chunksCount;
    private volatile AudioClassifier<Double> classifier;
    private final int sampleRate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LaughterDetectorV3(Context context) {
        super(context, 0);
        context.getClass();
        this.sampleRate = 12000;
        this.chunksCount = 3;
        this.chunks = new SafeChunksBuffer(3);
    }

    private final void destroyClassifier() {
        AudioClassifier<Double> audioClassifier = this.classifier;
        if (audioClassifier != null) {
            audioClassifier.close();
        }
        this.classifier = null;
    }

    private final void initClassifier() {
        if (this.classifier == null) {
            Context context = this.context;
            context.getClass();
            TFLClassifier_3s_lmf_2L_025s tFLClassifier_3s_lmf_2L_025s = new TFLClassifier_3s_lmf_2L_025s(context, "v3_laugh.q.tflite", null, null, 12, null);
            Context context2 = this.context;
            context2.getClass();
            this.classifier = AudioClassifierExtKt.broadcastSoundEvent(tFLClassifier_3s_lmf_2L_025s, context2, SoundClass.LAUGH);
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
        float[] data2 = AudioTransformer.from(this.recorderContext.getSampleRate(), readBuffer).iirFilterFactory(this.recorderContext.getIirFilterFactory()).lowPass5K().copyData().resampleIP(this.sampleRate).toData();
        data2.getClass();
        return data2;
    }

    @Override // com.urbandroid.sleep.audio.consumer.ChunkedAudioConsumer
    public void processChunk(float[] data2) {
        data2.getClass();
        this.chunks.add(data2);
        float[] fArrJoinAllChunks = this.chunks.joinAllChunks();
        if (fArrJoinAllChunks.length != this.sampleRate * this.chunksCount) {
            return;
        }
        try {
            AudioClassifier<Double> audioClassifier = this.classifier;
            if (audioClassifier != null) {
                audioClassifier.classify(new MonoSample(fArrJoinAllChunks, this.sampleRate));
            }
        } catch (WeirdRuntimeExceptionInAudio e) {
            int length = data2.length;
            int i = this.chunksCount;
            int length2 = fArrJoinAllChunks.length;
            int i2 = this.sampleRate;
            StringBuilder sbM = Fragment$$ExternalSyntheticOutline1.m(length, i, "WeirdRuntimeExceptionInAudio LOLCaptcha.LaughterDetectorV3: ", " ", " ");
            sbM.append(length2);
            sbM.append(" ");
            sbM.append(i2);
            Logger.logWarning(sbM.toString(), e);
        }
    }
}
