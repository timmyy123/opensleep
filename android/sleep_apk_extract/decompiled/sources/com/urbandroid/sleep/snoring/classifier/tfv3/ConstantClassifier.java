package com.urbandroid.sleep.snoring.classifier.tfv3;

import com.urbandroid.sleep.snoring.record.MonoSample;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B#\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000b\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\rH\u0016¢\u0006\u0002\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0005H\u0016J\b\u0010\u0010\u001a\u00020\u0007H\u0016R\u0010\u0010\u0003\u001a\u00028\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/urbandroid/sleep/snoring/classifier/tfv3/ConstantClassifier;", "T", "Lcom/urbandroid/sleep/snoring/classifier/tfv3/AudioClassifier;", "returnValue", "inputSampleRate", "", "inputLengthSeconds", "", "<init>", "(Ljava/lang/Object;ID)V", "Ljava/lang/Object;", "classify", "sample", "Lcom/urbandroid/sleep/snoring/record/MonoSample;", "(Lcom/urbandroid/sleep/snoring/record/MonoSample;)Ljava/lang/Object;", "getInputSampleRate", "getInputLengthSeconds", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ConstantClassifier<T> implements AudioClassifier<T> {
    private final double inputLengthSeconds;
    private final int inputSampleRate;
    private final T returnValue;

    public /* synthetic */ ConstantClassifier(Object obj, int i, double d, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, (i2 & 2) != 0 ? 12000 : i, (i2 & 4) != 0 ? 1.0d : d);
    }

    @Override // com.urbandroid.sleep.snoring.classifier.tfv3.AudioClassifier
    public T classify(MonoSample sample) {
        sample.getClass();
        return this.returnValue;
    }

    @Override // com.urbandroid.sleep.snoring.classifier.tfv3.AudioClassifier
    public /* bridge */ void close() {
        super.close();
    }

    @Override // com.urbandroid.sleep.snoring.classifier.tfv3.AudioClassifier
    public double getInputLengthSeconds() {
        return this.inputLengthSeconds;
    }

    @Override // com.urbandroid.sleep.snoring.classifier.tfv3.AudioClassifier
    public int getInputSampleRate() {
        return this.inputSampleRate;
    }

    public ConstantClassifier(T t, int i, double d) {
        this.returnValue = t;
        this.inputSampleRate = i;
        this.inputLengthSeconds = d;
    }
}
