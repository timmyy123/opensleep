package org.apache.commons.math3.linear;

import java.lang.reflect.Array;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: loaded from: classes5.dex */
class HessenbergTransformer {
    private RealMatrix cachedH;
    private RealMatrix cachedP;
    private RealMatrix cachedPt;
    private final double[][] householderVectors;
    private final double[] ort;

    public HessenbergTransformer(RealMatrix realMatrix) {
        if (!realMatrix.isSquare()) {
            throw new NonSquareMatrixException(realMatrix.getRowDimension(), realMatrix.getColumnDimension());
        }
        int rowDimension = realMatrix.getRowDimension();
        this.householderVectors = realMatrix.getData();
        this.ort = new double[rowDimension];
        this.cachedP = null;
        this.cachedPt = null;
        this.cachedH = null;
        transform();
    }

    private void transform() {
        double[] dArr;
        int length = this.householderVectors.length;
        int i = length - 1;
        for (int i2 = 1; i2 <= length - 2; i2++) {
            double d = 0.0d;
            double dAbs = 0.0d;
            for (int i3 = i2; i3 <= i; i3++) {
                dAbs += FastMath.abs(this.householderVectors[i3][i2 - 1]);
            }
            if (!Precision.equals(dAbs, 0.0d)) {
                int i4 = i;
                double d2 = 0.0d;
                while (true) {
                    dArr = this.ort;
                    if (i4 < i2) {
                        break;
                    }
                    double d3 = this.householderVectors[i4][i2 - 1] / dAbs;
                    dArr[i4] = d3;
                    d2 += d3 * d3;
                    i4--;
                }
                double d4 = dArr[i2];
                double dSqrt = FastMath.sqrt(d2);
                if (d4 > 0.0d) {
                    dSqrt = -dSqrt;
                }
                double[] dArr2 = this.ort;
                double d5 = dArr2[i2];
                double d6 = d2 - (d5 * dSqrt);
                dArr2[i2] = d5 - dSqrt;
                int i5 = i2;
                while (i5 < length) {
                    double d7 = d;
                    for (int i6 = i; i6 >= i2; i6--) {
                        d7 = (this.ort[i6] * this.householderVectors[i6][i5]) + d7;
                    }
                    double d8 = d7 / d6;
                    for (int i7 = i2; i7 <= i; i7++) {
                        double[] dArr3 = this.householderVectors[i7];
                        dArr3[i5] = dArr3[i5] - (this.ort[i7] * d8);
                    }
                    i5++;
                    d = 0.0d;
                }
                for (int i8 = 0; i8 <= i; i8++) {
                    double d9 = 0.0d;
                    for (int i9 = i; i9 >= i2; i9--) {
                        d9 = (this.ort[i9] * this.householderVectors[i8][i9]) + d9;
                    }
                    double d10 = d9 / d6;
                    for (int i10 = i2; i10 <= i; i10++) {
                        double[] dArr4 = this.householderVectors[i8];
                        dArr4[i10] = dArr4[i10] - (this.ort[i10] * d10);
                    }
                }
                double[] dArr5 = this.ort;
                dArr5[i2] = dArr5[i2] * dAbs;
                this.householderVectors[i2][i2 - 1] = dAbs * dSqrt;
            }
        }
    }

    public RealMatrix getH() {
        if (this.cachedH == null) {
            int length = this.householderVectors.length;
            double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, length, length);
            for (int i = 0; i < length; i++) {
                if (i > 0) {
                    int i2 = i - 1;
                    dArr[i][i2] = this.householderVectors[i][i2];
                }
                for (int i3 = i; i3 < length; i3++) {
                    dArr[i][i3] = this.householderVectors[i][i3];
                }
            }
            this.cachedH = MatrixUtils.createRealMatrix(dArr);
        }
        return this.cachedH;
    }

    public RealMatrix getP() {
        double[] dArr;
        if (this.cachedP == null) {
            int length = this.householderVectors.length;
            int i = length - 1;
            double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, length, length);
            int i2 = 0;
            while (i2 < length) {
                int i3 = 0;
                while (i3 < length) {
                    dArr2[i2][i3] = i2 == i3 ? 1.0d : 0.0d;
                    i3++;
                }
                i2++;
            }
            for (int i4 = length - 2; i4 >= 1; i4--) {
                int i5 = i4 - 1;
                if (this.householderVectors[i4][i5] != 0.0d) {
                    for (int i6 = i4 + 1; i6 <= i; i6++) {
                        this.ort[i6] = this.householderVectors[i6][i5];
                    }
                    for (int i7 = i4; i7 <= i; i7++) {
                        int i8 = i4;
                        double d = 0.0d;
                        while (true) {
                            dArr = this.ort;
                            if (i8 > i) {
                                break;
                            }
                            d += dArr[i8] * dArr2[i8][i7];
                            i8++;
                        }
                        double d2 = (d / dArr[i4]) / this.householderVectors[i4][i5];
                        for (int i9 = i4; i9 <= i; i9++) {
                            double[] dArr3 = dArr2[i9];
                            dArr3[i7] = (this.ort[i9] * d2) + dArr3[i7];
                        }
                    }
                }
            }
            this.cachedP = MatrixUtils.createRealMatrix(dArr2);
        }
        return this.cachedP;
    }
}
