package com.urbandroid.sleep.snoring.classifier.tfv3;

import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.snoring.record.MonoSample;
import com.urbandroid.util.Experiments;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\u0016¢\u0006\u0002\u0010\u0014J\b\u0010\u0015\u001a\u00020\u0004H\u0016J\b\u0010\u0016\u001a\u00020\u0006H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/urbandroid/sleep/snoring/classifier/tfv3/EnsembleSnoreClassifier;", "Lcom/urbandroid/sleep/snoring/classifier/tfv3/AudioClassifier;", "", "shortPeriodClassifier", "", "thresholdSetting", "", "<init>", "(Lcom/urbandroid/sleep/snoring/classifier/tfv3/AudioClassifier;I)V", "historySize", "buffer", "Lcom/urbandroid/sleep/snoring/classifier/tfv3/AudioBuffer;", "shortPeriodClassifierMean", "longPeriodClassifier", "Lcom/urbandroid/sleep/snoring/classifier/tfv3/BreathFrequencyClassifier;", "meanSnoreThreshold", "breathFreqThreshold", "classify", "sample", "Lcom/urbandroid/sleep/snoring/record/MonoSample;", "(Lcom/urbandroid/sleep/snoring/record/MonoSample;)Ljava/lang/Boolean;", "getInputLengthSeconds", "getInputSampleRate", "close", "", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class EnsembleSnoreClassifier implements AudioClassifier<Boolean> {
    private final double breathFreqThreshold;
    private final AudioBuffer buffer;
    private final double historySize;
    private final BreathFrequencyClassifier longPeriodClassifier;
    private final double meanSnoreThreshold;
    private final AudioClassifier<Double> shortPeriodClassifier;
    private final AudioClassifier<Double> shortPeriodClassifierMean;
    private final int thresholdSetting;

    public EnsembleSnoreClassifier(AudioClassifier<Double> audioClassifier, int i) {
        audioClassifier.getClass();
        this.shortPeriodClassifier = audioClassifier;
        this.thresholdSetting = i;
        this.historySize = 30.0d;
        this.buffer = new AudioBuffer(audioClassifier.getSampleRate(), 30.0d);
        this.shortPeriodClassifierMean = AudioClassifierExtKt.mean(audioClassifier, (int) 30.0d);
        this.longPeriodClassifier = new BreathFrequencyClassifier(audioClassifier.getSampleRate(), 30.0d);
        double d = Double.POSITIVE_INFINITY;
        this.meanSnoreThreshold = i != 1 ? i != 2 ? i != 3 ? Double.POSITIVE_INFINITY : 0.05d : 0.1d : 0.2d;
        if (i == 1) {
            d = 0.035d;
        } else if (i == 2) {
            d = 0.025d;
        } else if (i == 3) {
            d = 0.015d;
        }
        this.breathFreqThreshold = d;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.urbandroid.sleep.snoring.classifier.tfv3.AudioClassifier
    public Boolean classify(MonoSample sample) {
        sample.getClass();
        AudioBuffer audioBuffer = this.buffer;
        float[] sample2 = sample.getSample();
        sample2.getClass();
        audioBuffer.add(sample2);
        double historySize = this.shortPeriodClassifier.getHistorySize();
        if (this.buffer.getLengthSeconds() < historySize) {
            return Boolean.FALSE;
        }
        double dDoubleValue = this.shortPeriodClassifierMean.classify(this.buffer.getLatest(historySize)).doubleValue();
        double historySize2 = this.longPeriodClassifier.getHistorySize();
        if (this.buffer.getLengthSeconds() < historySize2) {
            return Boolean.FALSE;
        }
        double dDoubleValue2 = this.longPeriodClassifier.classify(this.buffer.getLatest(historySize2)).doubleValue();
        if (Experiments.getInstance().isDetailedSoundRecognitionLoggingExperiment()) {
            Logger.logDebug("EnsembleSnoreClassifier: " + dDoubleValue + " " + dDoubleValue2);
        }
        return Boolean.valueOf(dDoubleValue >= this.meanSnoreThreshold && dDoubleValue2 > this.breathFreqThreshold);
    }

    @Override // com.urbandroid.sleep.snoring.classifier.tfv3.AudioClassifier
    public void close() {
        this.shortPeriodClassifier.close();
        this.shortPeriodClassifierMean.close();
        this.longPeriodClassifier.close();
    }

    @Override // com.urbandroid.sleep.snoring.classifier.tfv3.AudioClassifier
    /* JADX INFO: renamed from: getInputLengthSeconds */
    public double getHistorySize() {
        return 1.0d;
    }

    @Override // com.urbandroid.sleep.snoring.classifier.tfv3.AudioClassifier
    /* JADX INFO: renamed from: getInputSampleRate */
    public int getSampleRate() {
        return this.shortPeriodClassifier.getSampleRate();
    }
}
