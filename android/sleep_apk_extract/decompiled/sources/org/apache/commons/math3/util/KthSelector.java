package org.apache.commons.math3.util;

import java.io.Serializable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public class KthSelector implements Serializable {
    private static final long serialVersionUID = 20140713;
    private final PivotingStrategyInterface pivotingStrategy;

    public KthSelector(PivotingStrategyInterface pivotingStrategyInterface) {
        MathUtils.checkNotNull(pivotingStrategyInterface);
        this.pivotingStrategy = pivotingStrategyInterface;
    }

    private int partition(double[] dArr, int i, int i2, int i3) {
        double d = dArr[i3];
        dArr[i3] = dArr[i];
        int i4 = i + 1;
        int i5 = i2 - 1;
        while (i4 < i5) {
            while (i4 < i5 && dArr[i5] > d) {
                i5--;
            }
            while (i4 < i5 && dArr[i4] < d) {
                i4++;
            }
            if (i4 < i5) {
                double d2 = dArr[i4];
                dArr[i4] = dArr[i5];
                dArr[i5] = d2;
                i5--;
                i4++;
            }
        }
        if (i4 >= i2 || dArr[i4] > d) {
            i4--;
        }
        dArr[i] = dArr[i4];
        dArr[i4] = d;
        return i4;
    }

    public double select(double[] dArr, int[] iArr, int i) {
        int iPartition;
        int length = dArr.length;
        int i2 = 0;
        boolean z = iArr != null;
        int iMin = 0;
        while (length - i2 > 15) {
            if (!z || iMin >= iArr.length || (iPartition = iArr[iMin]) < 0) {
                iPartition = partition(dArr, i2, length, this.pivotingStrategy.pivotIndex(dArr, i2, length));
                if (z && iMin < iArr.length) {
                    iArr[iMin] = iPartition;
                }
            }
            if (i == iPartition) {
                return dArr[i];
            }
            if (i < iPartition) {
                iMin = FastMath.min((iMin * 2) + 1, z ? iArr.length : iPartition);
                length = iPartition;
            } else {
                int i3 = iPartition + 1;
                iMin = FastMath.min((iMin * 2) + 2, z ? iArr.length : length);
                i2 = i3;
            }
        }
        Arrays.sort(dArr, i2, length);
        return dArr[i];
    }
}
