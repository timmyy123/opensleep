package com.urbandroid.sleep.snoring.classifier.tfv3;

import android.content.Context;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.urbandroid.sleep.audio.event.SoundEvent;
import com.urbandroid.sleep.snoring.SoundClass;
import com.urbandroid.sleep.snoring.record.MonoSample;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0002\u0010\u000fJ\t\u0010\u0010\u001a\u00020\u0011H\u0096\u0001J\t\u0010\u0012\u001a\u00020\u0002H\u0096\u0001J\t\u0010\u0013\u001a\u00020\u0014H\u0096\u0001R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/urbandroid/sleep/snoring/classifier/tfv3/BroadcastSoundEvent;", "Lcom/urbandroid/sleep/snoring/classifier/tfv3/AudioClassifier;", "", "delegate", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "soundClass", "Lcom/urbandroid/sleep/snoring/SoundClass;", "<init>", "(Lcom/urbandroid/sleep/snoring/classifier/tfv3/AudioClassifier;Landroid/content/Context;Lcom/urbandroid/sleep/snoring/SoundClass;)V", "broadcast", "Landroidx/localbroadcastmanager/content/LocalBroadcastManager;", "classify", "sample", "Lcom/urbandroid/sleep/snoring/record/MonoSample;", "(Lcom/urbandroid/sleep/snoring/record/MonoSample;)Ljava/lang/Double;", "close", "", "getInputLengthSeconds", "getInputSampleRate", "", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
final class BroadcastSoundEvent implements AudioClassifier<Double> {
    private final LocalBroadcastManager broadcast;
    private final Context context;
    private final AudioClassifier<Double> delegate;
    private final SoundClass soundClass;

    public BroadcastSoundEvent(AudioClassifier<Double> audioClassifier, Context context, SoundClass soundClass) {
        audioClassifier.getClass();
        context.getClass();
        soundClass.getClass();
        this.delegate = audioClassifier;
        this.context = context;
        this.soundClass = soundClass;
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(context);
        localBroadcastManager.getClass();
        this.broadcast = localBroadcastManager;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.urbandroid.sleep.snoring.classifier.tfv3.AudioClassifier
    public Double classify(MonoSample sample) {
        sample.getClass();
        double dDoubleValue = this.delegate.classify(sample).doubleValue();
        this.broadcast.sendBroadcast(SoundEvent.newRawEvent(this.soundClass, dDoubleValue).toIntent());
        return Double.valueOf(dDoubleValue);
    }

    @Override // com.urbandroid.sleep.snoring.classifier.tfv3.AudioClassifier
    public void close() {
        this.delegate.close();
    }

    @Override // com.urbandroid.sleep.snoring.classifier.tfv3.AudioClassifier
    public double getInputLengthSeconds() {
        return this.delegate.getInputLengthSeconds();
    }

    @Override // com.urbandroid.sleep.snoring.classifier.tfv3.AudioClassifier
    public int getInputSampleRate() {
        return this.delegate.getInputSampleRate();
    }
}
