package org.apache.commons.math3.optimization;

import org.apache.commons.math3.linear.DiagonalMatrix;
import org.apache.commons.math3.linear.RealMatrix;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class Weight implements OptimizationData {
    private final RealMatrix weightMatrix;

    public Weight(double[] dArr) {
        this.weightMatrix = new DiagonalMatrix(dArr);
    }

    public RealMatrix getWeight() {
        return this.weightMatrix.copy();
    }
}
