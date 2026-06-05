package com.urbandroid.sleep.nearby.pairtracking;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0003\u001a-\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/urbandroid/sleep/nearby/pairtracking/Series;", "", "", "src", "step", "", "normalizeTimeSteps", "(Lcom/urbandroid/sleep/nearby/pairtracking/Series;J)[J", "Sleep_prodRelease"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class RawPairDataKt {
    public static final long[] normalizeTimeSteps(Series<Long, Float> series, long j) {
        series.getClass();
        Object objKeysAsPrimitiveArray = series.keysAsPrimitiveArray();
        objKeysAsPrimitiveArray.getClass();
        long[] jArr = (long[]) objKeysAsPrimitiveArray;
        long j2 = j / 2;
        for (int length = jArr.length - 2; -1 < length; length--) {
            int i = length + 1;
            if (jArr[i] - jArr[length] < j2) {
                if (series.value(length).floatValue() < 0.0f || series.value(i).floatValue() >= 0.0f) {
                    jArr[length] = jArr[i] - j;
                } else {
                    int length2 = jArr.length;
                    while (i < length2) {
                        long j3 = jArr[i];
                        long j4 = jArr[i - 1];
                        if (j3 > j4) {
                            break;
                        }
                        jArr[i] = j4 + 1;
                        i++;
                    }
                }
            }
        }
        return jArr;
    }

    public static /* synthetic */ long[] normalizeTimeSteps$default(Series series, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 10000;
        }
        return normalizeTimeSteps(series, j);
    }
}
