package org.apache.commons.math3.ml.clustering;

import java.io.Serializable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public class DoublePoint implements Clusterable, Serializable {
    private static final long serialVersionUID = 3946024775784901369L;
    private final double[] point;

    public DoublePoint(double[] dArr) {
        this.point = dArr;
    }

    public boolean equals(Object obj) {
        if (obj instanceof DoublePoint) {
            return Arrays.equals(this.point, ((DoublePoint) obj).point);
        }
        return false;
    }

    @Override // org.apache.commons.math3.ml.clustering.Clusterable
    public double[] getPoint() {
        return this.point;
    }

    public int hashCode() {
        return Arrays.hashCode(this.point);
    }

    public String toString() {
        return Arrays.toString(this.point);
    }
}
