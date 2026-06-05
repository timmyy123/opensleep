package com.urbandroid.sleep.snoring.tensorflow.feature;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.snoring.record.Function;
import com.urbandroid.sleep.snoring.record.MonoSample;
import com.urbandroid.sleep.snoring.record.Record;
import com.urbandroid.sleep.snoring.tensorflow.mfcc.MelSpectrum;
import com.urbandroid.sleep.snoring.tensorflow.mfcc.MelSpectrumConfig;
import com.urbandroid.util.ScienceUtil;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0015\u0010\u0014R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/urbandroid/sleep/snoring/tensorflow/feature/MelSpectrumFeature;", "", "", "featureName", "", "frameSec", "hopSec", "", "noMelBands", "<init>", "(Ljava/lang/String;FFI)V", "Lcom/urbandroid/sleep/snoring/record/Record;", "r", "apply", "(Lcom/urbandroid/sleep/snoring/record/Record;)Lcom/urbandroid/sleep/snoring/record/Record;", "Ljava/lang/String;", "getFeatureName", "()Ljava/lang/String;", "F", "getFrameSec", "()F", "getHopSec", "I", "getNoMelBands", "()I", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MelSpectrumFeature implements Function {
    private final String featureName;
    private final float frameSec;
    private final float hopSec;
    private final int noMelBands;

    public MelSpectrumFeature(String str, float f, float f2, int i) {
        str.getClass();
        this.featureName = str;
        this.frameSec = f;
        this.hopSec = f2;
        this.noMelBands = i;
    }

    @Override // com.urbandroid.sleep.snoring.record.Function
    public Record apply(Record r) {
        r.getClass();
        MonoSample monoSample = (MonoSample) r.get("SAMPLE");
        int sampleRate = monoSample.getSampleRate();
        float f = sampleRate;
        int iPrevPowerOf2 = ScienceUtil.prevPowerOf2((int) (this.frameSec * f));
        MelSpectrum melSpectrum = new MelSpectrum(new MelSpectrumConfig(iPrevPowerOf2, sampleRate, this.noMelBands, 40.0f, 5000.0f));
        try {
            int i = (int) (f * this.hopSec);
            int size = ((monoSample.size() - iPrevPowerOf2) / i) + 1;
            float[][] fArr = new float[size][];
            for (int i2 = 0; i2 < size; i2++) {
                int i3 = i2 * i;
                MonoSample monoSampleFragment = monoSample.fragment(i3, i3 + iPrevPowerOf2);
                monoSampleFragment.getClass();
                fArr[i2] = melSpectrum.process(monoSampleFragment);
            }
            r.set(this.featureName, fArr);
            r.addFeature(this.featureName, fArr);
            return r;
        } catch (RuntimeException e) {
            String name = e.getClass().getName();
            String message = e.getMessage();
            List<String> featureNames = r.getFeatureNames();
            Set<String> setKeySet = r.getProperties().keySet();
            int size2 = monoSample.size();
            int sampleRate2 = monoSample.getSampleRate();
            float f2 = this.frameSec;
            float f3 = this.hopSec;
            int i4 = this.noMelBands;
            StringBuilder sbM6m = FileInsert$$ExternalSyntheticOutline0.m6m("WeirdRuntimeExceptionInAudio MelSpectrumFeature.apply(): ", name, " >>>", message, "<<< ");
            sbM6m.append(featureNames);
            sbM6m.append(" ");
            sbM6m.append(setKeySet);
            sbM6m.append(" ");
            Fragment$$ExternalSyntheticOutline1.m(sbM6m, size2, " ", sampleRate2, " ");
            sbM6m.append(f2);
            sbM6m.append(" ");
            sbM6m.append(f3);
            sbM6m.append(" ");
            sbM6m.append(i4);
            sbM6m.append(" ");
            sbM6m.append(iPrevPowerOf2);
            Logger.logInfo(sbM6m.toString());
            throw new WeirdRuntimeExceptionInAudio(e);
        }
    }
}
