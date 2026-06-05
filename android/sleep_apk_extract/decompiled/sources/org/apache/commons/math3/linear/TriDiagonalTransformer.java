package org.apache.commons.math3.linear;

import java.lang.reflect.Array;
import java.util.Arrays;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes5.dex */
class TriDiagonalTransformer {
    private RealMatrix cachedQ;
    private RealMatrix cachedQt;
    private RealMatrix cachedT;
    private final double[][] householderVectors;
    private final double[] main;
    private final double[] secondary;

    public TriDiagonalTransformer(RealMatrix realMatrix) {
        if (!realMatrix.isSquare()) {
            throw new NonSquareMatrixException(realMatrix.getRowDimension(), realMatrix.getColumnDimension());
        }
        int rowDimension = realMatrix.getRowDimension();
        this.householderVectors = realMatrix.getData();
        this.main = new double[rowDimension];
        this.secondary = new double[rowDimension - 1];
        this.cachedQ = null;
        this.cachedQt = null;
        this.cachedT = null;
        transform();
    }

    private void transform() {
        int length = this.householderVectors.length;
        double[] dArr = new double[length];
        int i = 0;
        while (true) {
            int i2 = length - 1;
            if (i >= i2) {
                this.main[i2] = this.householderVectors[i2][i2];
                return;
            }
            double[] dArr2 = this.householderVectors[i];
            this.main[i] = dArr2[i];
            int i3 = i + 1;
            double d = 0.0d;
            for (int i4 = i3; i4 < length; i4++) {
                double d2 = dArr2[i4];
                d += d2 * d2;
            }
            double dSqrt = dArr2[i3] > 0.0d ? -FastMath.sqrt(d) : FastMath.sqrt(d);
            this.secondary[i] = dSqrt;
            if (dSqrt != 0.0d) {
                double d3 = dArr2[i3] - dSqrt;
                dArr2[i3] = d3;
                double d4 = (-1.0d) / (dSqrt * d3);
                Arrays.fill(dArr, i3, length, 0.0d);
                int i5 = i3;
                while (i5 < length) {
                    double[] dArr3 = this.householderVectors[i5];
                    double d5 = dArr2[i5];
                    double d6 = dArr3[i5] * d5;
                    int i6 = i5 + 1;
                    for (int i7 = i6; i7 < length; i7++) {
                        double d7 = dArr3[i7];
                        d6 = (dArr2[i7] * d7) + d6;
                        dArr[i7] = (d7 * d5) + dArr[i7];
                    }
                    dArr[i5] = (dArr[i5] + d6) * d4;
                    i5 = i6;
                }
                double d8 = 0.0d;
                for (int i8 = i3; i8 < length; i8++) {
                    d8 += dArr[i8] * dArr2[i8];
                }
                double d9 = (d4 / 2.0d) * d8;
                for (int i9 = i3; i9 < length; i9++) {
                    dArr[i9] = dArr[i9] - (dArr2[i9] * d9);
                }
                for (int i10 = i3; i10 < length; i10++) {
                    double[] dArr4 = this.householderVectors[i10];
                    for (int i11 = i10; i11 < length; i11++) {
                        dArr4[i11] = dArr4[i11] - ((dArr[i10] * dArr2[i11]) + (dArr2[i10] * dArr[i11]));
                    }
                }
            }
            i = i3;
        }
    }

    public double[] getMainDiagonalRef() {
        return this.main;
    }

    public RealMatrix getQ() {
        if (this.cachedQ == null) {
            this.cachedQ = getQT().transpose();
        }
        return this.cachedQ;
    }

    public RealMatrix getQT() {
        if (this.cachedQt == null) {
            int length = this.householderVectors.length;
            double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, length, length);
            for (int i = length - 1; i >= 1; i--) {
                int i2 = i - 1;
                double[] dArr2 = this.householderVectors[i2];
                double[] dArr3 = dArr[i];
                dArr3[i] = 1.0d;
                double d = dArr2[i];
                if (d != 0.0d) {
                    double d2 = this.secondary[i2];
                    double d3 = 1.0d / (d2 * d);
                    double d4 = 1.0d / d2;
                    dArr3[i] = (d * d4) + 1.0d;
                    int i3 = i + 1;
                    for (int i4 = i3; i4 < length; i4++) {
                        dArr[i][i4] = dArr2[i4] * d4;
                    }
                    for (int i5 = i3; i5 < length; i5++) {
                        double d5 = 0.0d;
                        for (int i6 = i3; i6 < length; i6++) {
                            d5 += dArr[i5][i6] * dArr2[i6];
                        }
                        double d6 = d5 * d3;
                        dArr[i5][i] = dArr2[i] * d6;
                        for (int i7 = i3; i7 < length; i7++) {
                            double[] dArr4 = dArr[i5];
                            dArr4[i7] = (dArr2[i7] * d6) + dArr4[i7];
                        }
                    }
                }
            }
            dArr[0][0] = 1.0d;
            this.cachedQt = MatrixUtils.createRealMatrix(dArr);
        }
        return this.cachedQt;
    }

    public double[] getSecondaryDiagonalRef() {
        return this.secondary;
    }
}
