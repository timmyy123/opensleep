package com.urbandroid.sleep.snoring.classifier.tfv3;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.urbandroid.sleep.snoring.feature.FftFeature;
import com.urbandroid.sleep.snoring.record.ComputeFft;
import com.urbandroid.sleep.snoring.record.DownsampleAndMovingMax;
import com.urbandroid.sleep.snoring.record.MonoSample;
import com.urbandroid.sleep.snoring.record.Record;
import kotlin.Metadata;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\u0002H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/urbandroid/sleep/snoring/classifier/tfv3/BreathFrequencyClassifier;", "Lcom/urbandroid/sleep/snoring/classifier/tfv3/AudioClassifier;", "", "sampleRate", "", "historySize", "<init>", "(ID)V", "classify", "sample", "Lcom/urbandroid/sleep/snoring/record/MonoSample;", "(Lcom/urbandroid/sleep/snoring/record/MonoSample;)Ljava/lang/Double;", "getInputSampleRate", "getInputLengthSeconds", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class BreathFrequencyClassifier implements AudioClassifier<Double> {
    private final double historySize;
    private final int sampleRate;

    public BreathFrequencyClassifier(int i, double d) {
        this.sampleRate = i;
        this.historySize = d;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.urbandroid.sleep.snoring.classifier.tfv3.AudioClassifier
    public Double classify(MonoSample sample) {
        sample.getClass();
        if (sample.getSampleRate() != getSampleRate()) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m(sample.getSampleRate(), "Illegal sample rate: "));
            return null;
        }
        if (sample.getDurationSeconds() != getHistorySize()) {
            throw new IllegalArgumentException("Illegal sample length: " + sample.getDurationSeconds());
        }
        Record record = new Record();
        record.set("SAMPLE", sample);
        Record recordApply = new DownsampleAndMovingMax("SAMPLE_LF", 32, 0.2d).apply(record);
        recordApply.getClass();
        Record recordApply2 = new ComputeFft("SAMPLE_LF", "FFT_LF").apply(recordApply);
        recordApply2.getClass();
        Record recordApply3 = FftFeature.energyMaxRel("FFT_LF", 0.2d, 0.5d).apply(recordApply2);
        recordApply3.getClass();
        Double d = (Double) recordApply3.getLastFeature();
        d.getClass();
        return d;
    }

    @Override // com.urbandroid.sleep.snoring.classifier.tfv3.AudioClassifier
    public /* bridge */ void close() {
        super.close();
    }

    @Override // com.urbandroid.sleep.snoring.classifier.tfv3.AudioClassifier
    /* JADX INFO: renamed from: getInputLengthSeconds, reason: from getter */
    public double getHistorySize() {
        return this.historySize;
    }

    @Override // com.urbandroid.sleep.snoring.classifier.tfv3.AudioClassifier
    /* JADX INFO: renamed from: getInputSampleRate, reason: from getter */
    public int getSampleRate() {
        return this.sampleRate;
    }
}
