package com.urbandroid.sleep.snoring.classifier.tfv3;

import com.urbandroid.sleep.snoring.record.MonoSample;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016¢\u0006\u0002\u0010\rJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\t\u0010\u0010\u001a\u00020\u0002H\u0096\u0001J\t\u0010\u0011\u001a\u00020\u0005H\u0096\u0001R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/urbandroid/sleep/snoring/classifier/tfv3/RollingMean;", "Lcom/urbandroid/sleep/snoring/classifier/tfv3/AudioClassifier;", "", "delegate", "historySize", "", "<init>", "(Lcom/urbandroid/sleep/snoring/classifier/tfv3/AudioClassifier;I)V", "history", "", "classify", "sample", "Lcom/urbandroid/sleep/snoring/record/MonoSample;", "(Lcom/urbandroid/sleep/snoring/record/MonoSample;)Ljava/lang/Double;", "close", "", "getInputLengthSeconds", "getInputSampleRate", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
final class RollingMean implements AudioClassifier<Double> {
    private final AudioClassifier<Double> delegate;
    private final List<Double> history;
    private final int historySize;

    public RollingMean(AudioClassifier<Double> audioClassifier, int i) {
        audioClassifier.getClass();
        this.delegate = audioClassifier;
        this.historySize = i;
        this.history = new ArrayList();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.urbandroid.sleep.snoring.classifier.tfv3.AudioClassifier
    public Double classify(MonoSample sample) {
        sample.getClass();
        this.history.add(Double.valueOf(this.delegate.classify(sample).doubleValue()));
        while (true) {
            int size = this.history.size();
            int i = this.historySize;
            List<Double> list = this.history;
            if (size <= i) {
                return Double.valueOf(CollectionsKt.sumOfDouble(list) / ((double) this.history.size()));
            }
            list.remove(0);
        }
    }

    @Override // com.urbandroid.sleep.snoring.classifier.tfv3.AudioClassifier
    public void close() {
        this.history.clear();
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
