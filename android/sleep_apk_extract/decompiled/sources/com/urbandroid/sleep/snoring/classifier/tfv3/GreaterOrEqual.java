package com.urbandroid.sleep.snoring.classifier.tfv3;

import com.urbandroid.sleep.snoring.record.MonoSample;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000bJ\t\u0010\f\u001a\u00020\rH\u0096\u0001J\t\u0010\u000e\u001a\u00020\u0004H\u0096\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u0096\u0001R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/urbandroid/sleep/snoring/classifier/tfv3/GreaterOrEqual;", "Lcom/urbandroid/sleep/snoring/classifier/tfv3/AudioClassifier;", "", "delegate", "", "threshold", "<init>", "(Lcom/urbandroid/sleep/snoring/classifier/tfv3/AudioClassifier;D)V", "classify", "sample", "Lcom/urbandroid/sleep/snoring/record/MonoSample;", "(Lcom/urbandroid/sleep/snoring/record/MonoSample;)Ljava/lang/Boolean;", "close", "", "getInputLengthSeconds", "getInputSampleRate", "", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
final class GreaterOrEqual implements AudioClassifier<Boolean> {
    private final /* synthetic */ AudioClassifier<Boolean> $$delegate_0;
    private final AudioClassifier<Double> delegate;
    private final double threshold;

    /* JADX WARN: Multi-variable type inference failed */
    public GreaterOrEqual(AudioClassifier<Double> audioClassifier, double d) {
        audioClassifier.getClass();
        this.$$delegate_0 = audioClassifier;
        this.delegate = audioClassifier;
        this.threshold = d;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.urbandroid.sleep.snoring.classifier.tfv3.AudioClassifier
    public Boolean classify(MonoSample sample) {
        sample.getClass();
        return Boolean.valueOf(this.delegate.classify(sample).doubleValue() >= this.threshold);
    }

    @Override // com.urbandroid.sleep.snoring.classifier.tfv3.AudioClassifier
    public void close() {
        this.$$delegate_0.close();
    }

    @Override // com.urbandroid.sleep.snoring.classifier.tfv3.AudioClassifier
    public double getInputLengthSeconds() {
        return this.$$delegate_0.getInputLengthSeconds();
    }

    @Override // com.urbandroid.sleep.snoring.classifier.tfv3.AudioClassifier
    public int getInputSampleRate() {
        return this.$$delegate_0.getInputSampleRate();
    }
}
