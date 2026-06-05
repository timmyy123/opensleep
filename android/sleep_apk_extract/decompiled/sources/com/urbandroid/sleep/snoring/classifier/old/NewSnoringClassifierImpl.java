package com.urbandroid.sleep.snoring.classifier.old;

import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.snoring.feature.CompoundFftOnIntervals;
import com.urbandroid.sleep.snoring.feature.FftFeature;
import com.urbandroid.sleep.snoring.feature.IntervalsOUCrossFreq;
import com.urbandroid.sleep.snoring.feature.IntervalsOverUnder;
import com.urbandroid.sleep.snoring.feature.TotalWeightedEnergy;
import com.urbandroid.sleep.snoring.feature.TwoFftsDiff;
import com.urbandroid.sleep.snoring.record.CompoundOperation;
import com.urbandroid.sleep.snoring.record.ComputeFft;
import com.urbandroid.sleep.snoring.record.DownsampleAndMovingMax;
import com.urbandroid.sleep.snoring.record.Function;
import com.urbandroid.sleep.snoring.record.MonoSample;
import com.urbandroid.sleep.snoring.record.Record;
import com.urbandroid.util.ScienceUtil;

/* JADX INFO: loaded from: classes5.dex */
public class NewSnoringClassifierImpl implements SnoringClassifier {
    private int doClassify(Record record) {
        IntervalsOverUnder intervalsOverUnder = (IntervalsOverUnder) record.get("INTERVALS");
        double overFrequency = intervalsOverUnder.getOverFrequency();
        double underFrequency = intervalsOverUnder.getUnderFrequency();
        int i = (overFrequency < 0.1d || overFrequency > 0.4d) ? 0 : 1;
        if (underFrequency >= 0.2d && underFrequency <= 0.35d) {
            i++;
        }
        Record recordApply = FftFeature.energyMaxRel("FFT_LF", 0.2d, 0.5d).apply(record);
        if (((Double) recordApply.getLastFeature()).doubleValue() >= 0.03d) {
            i++;
        }
        Record recordApply2 = FftFeature.energyMaxFreq("FFT_LF", 0.1d, 2.0d).apply(recordApply);
        double dDoubleValue = ((Double) recordApply2.getLastFeature()).doubleValue();
        if (dDoubleValue >= 0.2d && dDoubleValue <= 0.35d) {
            i++;
        }
        Record recordApply3 = new TotalWeightedEnergy().apply(recordApply2);
        double dDoubleValue2 = ((Double) recordApply3.getLastFeature()).doubleValue();
        if (dDoubleValue2 >= 8.0d) {
            i++;
        }
        Record recordApply4 = new TwoFftsDiff("FFT_OVR", "FFT_UDR", 100.0d, 300.0d).apply(recordApply3);
        double dDoubleValue3 = ((Double) recordApply4.getLastFeature()).doubleValue();
        if (dDoubleValue3 >= 0.0d) {
            i++;
        }
        if (((Double) new TwoFftsDiff("FFT_OVR", "FFT_UDR", 1000.0d, 4000.0d).apply(recordApply4).getLastFeature()).doubleValue() <= -0.1d) {
            i++;
        }
        int i2 = i > 4 ? 1 : 0;
        if (i2 == 1) {
            Logger.logDebug("Snoring detected: " + overFrequency + " " + underFrequency + " " + dDoubleValue + " " + dDoubleValue2 + " " + dDoubleValue3);
        }
        return i2;
    }

    private Record preprocess(Record record) {
        return new CompoundOperation(new ComputeFft("FFT"), new DownsampleAndMovingMax("SAMPLE_LF", 32, 0.2d), new ComputeFft("SAMPLE_LF", "FFT_LF"), new Function() { // from class: com.urbandroid.sleep.snoring.classifier.old.NewSnoringClassifierImpl.1
            @Override // com.urbandroid.sleep.snoring.record.Function
            public Record apply(Record record2) {
                MonoSample monoSample = (MonoSample) record2.get("SAMPLE");
                IntervalsOverUnder intervalsOverUnderApply = new IntervalsOUCrossFreq(3.0d, 2.0d, 0.1d, 0.5d, 3.0d, 8).apply(monoSample);
                record2.set("INTERVALS", intervalsOverUnderApply);
                record2.set("FFT_OVR", CompoundFftOnIntervals.over(monoSample, intervalsOverUnderApply));
                record2.set("FFT_UDR", CompoundFftOnIntervals.under(monoSample, intervalsOverUnderApply));
                return record2;
            }
        }).apply(record);
    }

    @Override // com.urbandroid.sleep.snoring.classifier.old.SnoringClassifier
    public boolean isSnoring(float[] fArr, int i) {
        System.currentTimeMillis();
        if (i < 8000 || i > 12000) {
            Logger.logWarning("NewSnoringClassifierImpl: The sample should have been downsampled to 8-12 kHz. sampleRate=" + i);
        }
        int length = fArr.length;
        if (length != ScienceUtil.prevPowerOf2(length)) {
            Logger.logWarning("NewSnoringClassifierImpl: The size of the sample should be a power of 2. dataSize=" + length);
        }
        MonoSample monoSample = new MonoSample(fArr, i);
        double durationSeconds = monoSample.getDurationSeconds();
        if (durationSeconds < 15.0d || durationSeconds > 30.0d) {
            Logger.logWarning("NewSnoringClassifierImpl: The duration of the sample should be between 15 and 30 seconds. duration=" + durationSeconds);
        }
        Record record = new Record();
        record.set("SAMPLE", monoSample);
        Record recordPreprocess = preprocess(record);
        System.currentTimeMillis();
        int iDoClassify = doClassify(recordPreprocess);
        System.currentTimeMillis();
        return iDoClassify == 1;
    }
}
