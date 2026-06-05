package org.apache.commons.math3.util;

import java.io.Serializable;

/* JADX INFO: loaded from: classes5.dex */
public class MedianOf3PivotingStrategy implements PivotingStrategyInterface, Serializable {
    private static final long serialVersionUID = 20140713;

    /* JADX WARN: Removed duplicated region for block: B:15:0x0029 A[RETURN] */
    @Override // org.apache.commons.math3.util.PivotingStrategyInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int pivotIndex(double[] dArr, int i, int i2) {
        MathArrays.verifyValues(dArr, i, i2 - i);
        int i3 = i2 - 1;
        int i4 = ((i3 - i) / 2) + i;
        double d = dArr[i];
        double d2 = dArr[i4];
        double d3 = dArr[i3];
        if (d < d2) {
            if (d2 >= d3) {
                return d < d3 ? i3 : i;
            }
            return i4;
        }
        if (d >= d3) {
            if (d2 >= d3) {
                return i4;
            }
        }
    }
}
