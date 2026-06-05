package com.urbandroid.sleep.nearby.pairtracking;

import com.urbandroid.util.ScienceUtil;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B1\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\r\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\r\u001a\u00020\u0013¢\u0006\u0004\b\r\u0010\u0014J\u0015\u0010\r\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0019¨\u0006\u001b"}, d2 = {"Lcom/urbandroid/sleep/nearby/pairtracking/PairRecord;", "", "Lcom/urbandroid/sleep/nearby/pairtracking/AscSortedAppendableArray;", "", "times", "Lcom/urbandroid/sleep/nearby/pairtracking/AppendableArray;", "", "localValues", "remoteValues", "<init>", "(Lcom/urbandroid/sleep/nearby/pairtracking/AscSortedAppendableArray;Lcom/urbandroid/sleep/nearby/pairtracking/AppendableArray;Lcom/urbandroid/sleep/nearby/pairtracking/AppendableArray;)V", "localActivity", "remoteActivity", "getPairAdjustedActivity", "(FF)F", "", "factor", "aggregate", "(I)Lcom/urbandroid/sleep/nearby/pairtracking/PairRecord;", "", "()[F", "localTime", "(J)F", "Lcom/urbandroid/sleep/nearby/pairtracking/LFSeries;", "local", "Lcom/urbandroid/sleep/nearby/pairtracking/LFSeries;", "remote", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class PairRecord {
    private final LFSeries local;
    private final LFSeries remote;

    public PairRecord(AscSortedAppendableArray<Long> ascSortedAppendableArray, AppendableArray<Float> appendableArray, AppendableArray<Float> appendableArray2) {
        ascSortedAppendableArray.getClass();
        appendableArray.getClass();
        appendableArray2.getClass();
        this.local = new LFSeries(0.0f, 0, ascSortedAppendableArray, appendableArray, 3, null);
        this.remote = new LFSeries(0.0f, 0, ascSortedAppendableArray, appendableArray2, 3, null);
    }

    public final PairRecord aggregate(int factor) {
        long[] jArrDecimate = ScienceUtil.decimate(this.local.keysAsLongArray(), factor);
        jArrDecimate.getClass();
        LongAscSortedAppendableArray longAscSortedAppendableArray = new LongAscSortedAppendableArray(jArrDecimate, 0, 2, null);
        float[] fArrDecimate = ScienceUtil.decimate(ScienceUtil.movingMax(this.local.valuesAsFloatArray(), factor), factor);
        fArrDecimate.getClass();
        FloatAppendableArray floatAppendableArray = new FloatAppendableArray(fArrDecimate, 0, 2, null);
        float[] fArrDecimate2 = ScienceUtil.decimate(ScienceUtil.movingMax(this.remote.valuesAsFloatArray(), factor), factor);
        fArrDecimate2.getClass();
        return new PairRecord(longAscSortedAppendableArray, floatAppendableArray, new FloatAppendableArray(fArrDecimate2, 0, 2, null));
    }

    public final float getPairAdjustedActivity(long localTime) {
        return getPairAdjustedActivity(this.local.getLGE(Long.valueOf(localTime)).floatValue(), this.remote.getLGE(Long.valueOf(localTime)).floatValue());
    }

    public final float[] getPairAdjustedActivity() {
        float[] fArrValuesAsFloatArray = this.local.valuesAsFloatArray();
        float[] fArrValuesAsFloatArray2 = this.remote.valuesAsFloatArray();
        float[] fArr = new float[fArrValuesAsFloatArray.length];
        int length = fArrValuesAsFloatArray.length;
        for (int i = 0; i < length; i++) {
            fArr[i] = getPairAdjustedActivity(fArrValuesAsFloatArray[i], fArrValuesAsFloatArray2[i]);
        }
        return fArr;
    }

    private final float getPairAdjustedActivity(float localActivity, float remoteActivity) {
        float f = localActivity - 2.0f;
        if (f >= 0.0f) {
            float f2 = remoteActivity - 2.0f;
            if (f2 >= 0.0f) {
                return Math.min(Math.max(0.0f, (f * 2.0f) - f2), f) + 2.0f;
            }
        }
        return localActivity;
    }
}
