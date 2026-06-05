package com.urbandroid.sleep.snoring.classifier.tfv3;

import android.content.Context;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.urbandroid.sleep.snoring.SoundClass;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u001e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001*\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0002\u001a&\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f¨\u0006\r"}, d2 = {"mean", "Lcom/urbandroid/sleep/snoring/classifier/tfv3/AudioClassifier;", "", "windowSize", "", "isAbove", "", "threshold", "broadcastSoundEvent", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "soundClass", "Lcom/urbandroid/sleep/snoring/SoundClass;", "Sleep_prodRelease"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class AudioClassifierExtKt {
    public static final AudioClassifier<Double> broadcastSoundEvent(AudioClassifier<Double> audioClassifier, Context context, SoundClass soundClass) {
        audioClassifier.getClass();
        context.getClass();
        soundClass.getClass();
        return new BroadcastSoundEvent(audioClassifier, context, soundClass);
    }

    public static final AudioClassifier<Boolean> isAbove(AudioClassifier<Double> audioClassifier, double d) {
        audioClassifier.getClass();
        return new GreaterOrEqual(audioClassifier, d);
    }

    public static final AudioClassifier<Double> mean(AudioClassifier<Double> audioClassifier, int i) {
        audioClassifier.getClass();
        return new RollingMean(audioClassifier, i);
    }
}
