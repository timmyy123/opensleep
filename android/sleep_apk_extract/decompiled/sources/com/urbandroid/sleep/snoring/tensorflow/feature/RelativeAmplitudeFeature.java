package com.urbandroid.sleep.snoring.tensorflow.feature;

import com.urbandroid.sleep.snoring.record.Function;
import com.urbandroid.sleep.snoring.record.MonoSample;
import com.urbandroid.sleep.snoring.record.Record;
import com.urbandroid.util.ScienceUtil;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0016R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0017R\u0014\u0010\u0006\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/urbandroid/sleep/snoring/tensorflow/feature/RelativeAmplitudeFeature;", "", "", "featureName", "", "frameSec", "hopSec", "<init>", "(Ljava/lang/String;FF)V", "Lcom/urbandroid/sleep/snoring/record/MonoSample;", "sample", "amplitude", "(Lcom/urbandroid/sleep/snoring/record/MonoSample;)F", "Lcom/urbandroid/sleep/snoring/record/Record;", "r", "apply", "(Lcom/urbandroid/sleep/snoring/record/Record;)Lcom/urbandroid/sleep/snoring/record/Record;", "", "a", "", "normalize", "([F)V", "Ljava/lang/String;", "F", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class RelativeAmplitudeFeature implements Function {
    private final String featureName;
    private final float frameSec;
    private final float hopSec;

    public RelativeAmplitudeFeature(String str, float f, float f2) {
        str.getClass();
        this.featureName = str;
        this.frameSec = f;
        this.hopSec = f2;
    }

    private final float amplitude(MonoSample sample) {
        float[] sample2 = sample.getSample();
        sample2.getClass();
        float f = 0.0f;
        for (float f2 : sample2) {
            f += f2 * f2;
        }
        return (float) Math.log(Math.max(1.0E-6f, f));
    }

    @Override // com.urbandroid.sleep.snoring.record.Function
    public Record apply(Record r) {
        r.getClass();
        Object obj = r.get("SAMPLE");
        obj.getClass();
        MonoSample monoSample = (MonoSample) obj;
        int iPrevPowerOf2 = ScienceUtil.prevPowerOf2((int) (monoSample.getSampleRate() * this.frameSec));
        int sampleRate = (int) (monoSample.getSampleRate() * this.hopSec);
        int size = ((monoSample.size() - iPrevPowerOf2) / sampleRate) + 1;
        float[] fArr = new float[size];
        for (int i = 0; i < size; i++) {
            int i2 = i * sampleRate;
            MonoSample monoSampleFragment = monoSample.fragment(i2, i2 + iPrevPowerOf2);
            monoSampleFragment.getClass();
            fArr[i] = amplitude(monoSampleFragment);
        }
        normalize(fArr);
        r.set(this.featureName, fArr);
        r.addFeature(this.featureName, fArr);
        return r;
    }

    public final void normalize(float[] a) {
        a.getClass();
        float fPercentile = ScienceUtil.percentile(a, 1.0f);
        float fPercentile2 = ScienceUtil.percentile(a, 99.0f);
        float fMax = Math.max(fPercentile2 - fPercentile, 1.0E-6f);
        int length = a.length;
        for (int i = 0; i < length; i++) {
            a[i] = (Math.min(fPercentile2, Math.max(fPercentile, a[i])) - fPercentile) / fMax;
        }
    }
}
