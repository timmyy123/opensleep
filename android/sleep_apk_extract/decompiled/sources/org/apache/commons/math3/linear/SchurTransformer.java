package org.apache.commons.math3.linear;

import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: loaded from: classes5.dex */
class SchurTransformer {
    private RealMatrix cachedP;
    private RealMatrix cachedPt;
    private RealMatrix cachedT;
    private final double epsilon = Precision.EPSILON;
    private final double[][] matrixP;
    private final double[][] matrixT;

    public static class ShiftInfo {
        double exShift;
        double w;
        double x;
        double y;

        private ShiftInfo() {
        }
    }

    public SchurTransformer(RealMatrix realMatrix) {
        if (!realMatrix.isSquare()) {
            throw new NonSquareMatrixException(realMatrix.getRowDimension(), realMatrix.getColumnDimension());
        }
        HessenbergTransformer hessenbergTransformer = new HessenbergTransformer(realMatrix);
        this.matrixT = hessenbergTransformer.getH().getData();
        this.matrixP = hessenbergTransformer.getP().getData();
        this.cachedT = null;
        this.cachedP = null;
        this.cachedPt = null;
        transform();
    }

    private void computeShift(int i, int i2, int i3, ShiftInfo shiftInfo) {
        double[][] dArr;
        double[][] dArr2 = this.matrixT;
        double[] dArr3 = dArr2[i2];
        double d = dArr3[i2];
        shiftInfo.x = d;
        shiftInfo.w = 0.0d;
        shiftInfo.y = 0.0d;
        if (i < i2) {
            int i4 = i2 - 1;
            double[] dArr4 = dArr2[i4];
            shiftInfo.y = dArr4[i4];
            shiftInfo.w = dArr3[i4] * dArr4[i2];
        }
        if (i3 == 10) {
            shiftInfo.exShift += d;
            int i5 = 0;
            while (true) {
                dArr = this.matrixT;
                if (i5 > i2) {
                    break;
                }
                double[] dArr5 = dArr[i5];
                dArr5[i5] = dArr5[i5] - shiftInfo.x;
                i5++;
            }
            double[] dArr6 = dArr[i2];
            int i6 = i2 - 1;
            double dAbs = FastMath.abs(this.matrixT[i6][i2 - 2]) + FastMath.abs(dArr6[i6]);
            double d2 = 0.75d * dAbs;
            shiftInfo.x = d2;
            shiftInfo.y = d2;
            shiftInfo.w = (-0.4375d) * dAbs * dAbs;
        }
        if (i3 == 30) {
            double d3 = (shiftInfo.y - shiftInfo.x) / 2.0d;
            double d4 = (d3 * d3) + shiftInfo.w;
            if (d4 > 0.0d) {
                double dSqrt = FastMath.sqrt(d4);
                double d5 = shiftInfo.y;
                double d6 = shiftInfo.x;
                if (d5 < d6) {
                    dSqrt = -dSqrt;
                }
                double d7 = d6 - (shiftInfo.w / (((d5 - d6) / 2.0d) + dSqrt));
                for (int i7 = 0; i7 <= i2; i7++) {
                    double[] dArr7 = this.matrixT[i7];
                    dArr7[i7] = dArr7[i7] - d7;
                }
                shiftInfo.exShift += d7;
                shiftInfo.w = 0.964d;
                shiftInfo.y = 0.964d;
                shiftInfo.x = 0.964d;
            }
        }
    }

    private int findSmallSubDiagonalElement(int i, double d) {
        while (i > 0) {
            int i2 = i - 1;
            double dAbs = FastMath.abs(this.matrixT[i][i]) + FastMath.abs(this.matrixT[i2][i2]);
            if (dAbs == 0.0d) {
                dAbs = d;
            }
            if (FastMath.abs(this.matrixT[i][i2]) < this.epsilon * dAbs) {
                break;
            }
            i--;
        }
        return i;
    }

    private double getNorm() {
        double dAbs = 0.0d;
        for (int i = 0; i < this.matrixT.length; i++) {
            int iMax = FastMath.max(i - 1, 0);
            while (true) {
                double[][] dArr = this.matrixT;
                if (iMax < dArr.length) {
                    dAbs += FastMath.abs(dArr[i][iMax]);
                    iMax++;
                }
            }
        }
        return dAbs;
    }

    private int initQRStep(int i, int i2, ShiftInfo shiftInfo, double[] dArr) {
        char c = 2;
        int i3 = i2 - 2;
        while (i3 >= i) {
            double[][] dArr2 = this.matrixT;
            double[] dArr3 = dArr2[i3];
            double d = dArr3[i3];
            double d2 = shiftInfo.x - d;
            double d3 = shiftInfo.y - d;
            char c2 = c;
            int i4 = i3;
            double d4 = (d2 * d3) - shiftInfo.w;
            int i5 = i4 + 1;
            double[] dArr4 = dArr2[i5];
            dArr[0] = (d4 / dArr4[i4]) + dArr3[i5];
            dArr[1] = ((dArr4[i5] - d) - d2) - d3;
            dArr[c2] = dArr2[i4 + 2][i5];
            if (i4 == i) {
                return i4;
            }
            int i6 = i4 - 1;
            if ((FastMath.abs(dArr[c2]) + FastMath.abs(dArr[1])) * FastMath.abs(dArr3[i6]) < this.epsilon * (FastMath.abs(this.matrixT[i5][i5]) + FastMath.abs(d) + FastMath.abs(this.matrixT[i6][i6])) * FastMath.abs(dArr[0])) {
                return i4;
            }
            i3 = i4 - 1;
            c = c2;
        }
        return i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x019f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void performDoubleQRStep(int i, int i2, int i3, ShiftInfo shiftInfo, double[] dArr) {
        double dSqrt;
        int i4;
        boolean z;
        char c;
        double d;
        char c2;
        double d2;
        int length = this.matrixT.length;
        boolean z2 = false;
        double d3 = dArr[0];
        boolean z3 = true;
        double d4 = dArr[1];
        char c3 = 2;
        double d5 = dArr[2];
        int i5 = i2;
        while (true) {
            int i6 = i3 - 1;
            if (i5 > i6) {
                break;
            }
            boolean z4 = i5 != i6 ? z3 : z2;
            if (i5 != i2) {
                double[][] dArr2 = this.matrixT;
                int i7 = i5 - 1;
                double d6 = dArr2[i5][i7];
                double d7 = dArr2[i5 + 1][i7];
                double d8 = z4 ? dArr2[i5 + 2][i7] : 0.0d;
                double dAbs = FastMath.abs(d8) + FastMath.abs(d7) + FastMath.abs(d6);
                shiftInfo.x = dAbs;
                if (Precision.equals(dAbs, 0.0d, this.epsilon)) {
                    i4 = length;
                    z = z3;
                    c = c3;
                    d3 = d6;
                    d5 = d8;
                    d4 = d7;
                } else {
                    double d9 = shiftInfo.x;
                    double d10 = d6 / d9;
                    d5 = d8 / d9;
                    d3 = d10;
                    d4 = d7 / d9;
                    boolean z5 = z3;
                    double d11 = d4;
                    dSqrt = FastMath.sqrt((d5 * d5) + (d4 * d4) + (d3 * d3));
                    if (d3 < 0.0d) {
                        dSqrt = -dSqrt;
                    }
                    if (dSqrt == 0.0d) {
                        if (i5 != i2) {
                            z = z5;
                            d = d3;
                            c2 = c3;
                            d2 = d5;
                            this.matrixT[i5][i5 - 1] = (-dSqrt) * shiftInfo.x;
                        } else {
                            z = z5;
                            d = d3;
                            c2 = c3;
                            d2 = d5;
                            if (i != i2) {
                                double[] dArr3 = this.matrixT[i5];
                                int i8 = i5 - 1;
                                dArr3[i8] = -dArr3[i8];
                            }
                        }
                        double d12 = d + dSqrt;
                        shiftInfo.x = d12 / dSqrt;
                        shiftInfo.y = d11 / dSqrt;
                        double d13 = d2 / dSqrt;
                        double d14 = d11 / d12;
                        double d15 = d2 / d12;
                        int i9 = i5;
                        while (i9 < length) {
                            double[][] dArr4 = this.matrixT;
                            double[] dArr5 = dArr4[i5];
                            double d16 = dArr5[i9];
                            double[] dArr6 = dArr4[i5 + 1];
                            double d17 = (dArr6[i9] * d14) + d16;
                            if (z4) {
                                double[] dArr7 = dArr4[i5 + 2];
                                double d18 = dArr7[i9];
                                double d19 = (d15 * d18) + d17;
                                dArr7[i9] = d18 - (d19 * d13);
                                d17 = d19;
                            }
                            dArr5[i9] = dArr5[i9] - (shiftInfo.x * d17);
                            dArr6[i9] = dArr6[i9] - (shiftInfo.y * d17);
                            i9++;
                            d12 = d17;
                            c2 = c2;
                            d14 = d14;
                        }
                        c = c2;
                        double d20 = d14;
                        for (int i10 = 0; i10 <= FastMath.min(i3, i5 + 3); i10++) {
                            double d21 = shiftInfo.x;
                            double[] dArr8 = this.matrixT[i10];
                            int i11 = i5 + 1;
                            d12 = (shiftInfo.y * dArr8[i11]) + (d21 * dArr8[i5]);
                            if (z4) {
                                int i12 = i5 + 2;
                                double d22 = dArr8[i12];
                                double d23 = (d13 * d22) + d12;
                                dArr8[i12] = d22 - (d23 * d15);
                                d12 = d23;
                            }
                            dArr8[i5] = dArr8[i5] - d12;
                            dArr8[i11] = dArr8[i11] - (d12 * d20);
                        }
                        int length2 = this.matrixT.length - 1;
                        int i13 = 0;
                        while (i13 <= length2) {
                            double d24 = shiftInfo.x;
                            double[] dArr9 = this.matrixP[i13];
                            int i14 = length;
                            int i15 = i5 + 1;
                            double d25 = (shiftInfo.y * dArr9[i15]) + (d24 * dArr9[i5]);
                            if (z4) {
                                int i16 = i5 + 2;
                                double d26 = dArr9[i16];
                                double d27 = (d13 * d26) + d25;
                                dArr9[i16] = d26 - (d27 * d15);
                                d25 = d27;
                            }
                            dArr9[i5] = dArr9[i5] - d25;
                            dArr9[i15] = dArr9[i15] - (d25 * d20);
                            i13++;
                            d12 = d25;
                            length = i14;
                        }
                        i4 = length;
                        d3 = d12;
                        d5 = d15;
                        d4 = d20;
                    } else {
                        i4 = length;
                        z = z5;
                        c = c3;
                        d4 = d11;
                    }
                }
            } else {
                boolean z52 = z3;
                double d112 = d4;
                dSqrt = FastMath.sqrt((d5 * d5) + (d4 * d4) + (d3 * d3));
                if (d3 < 0.0d) {
                }
                if (dSqrt == 0.0d) {
                }
            }
            i5++;
            z3 = z;
            c3 = c;
            length = i4;
            z2 = false;
        }
        int i17 = i2 + 2;
        for (int i18 = i17; i18 <= i3; i18++) {
            double[] dArr10 = this.matrixT[i18];
            dArr10[i18 - 2] = 0.0d;
            if (i18 > i17) {
                dArr10[i18 - 3] = 0.0d;
            }
        }
    }

    private void transform() {
        SchurTransformer schurTransformer = this;
        int length = schurTransformer.matrixT.length;
        double norm = schurTransformer.getNorm();
        ShiftInfo shiftInfo = new ShiftInfo();
        int i = length - 1;
        int i2 = i;
        int i3 = 0;
        while (i2 >= 0) {
            int iFindSmallSubDiagonalElement = schurTransformer.findSmallSubDiagonalElement(i2, norm);
            if (iFindSmallSubDiagonalElement == i2) {
                double[] dArr = schurTransformer.matrixT[i2];
                dArr[i2] = dArr[i2] + shiftInfo.exShift;
                i2--;
            } else {
                int i4 = i2 - 1;
                if (iFindSmallSubDiagonalElement == i4) {
                    double[][] dArr2 = schurTransformer.matrixT;
                    double[] dArr3 = dArr2[i4];
                    double d = dArr3[i4];
                    double[] dArr4 = dArr2[i2];
                    double d2 = dArr4[i2];
                    double d3 = (d - d2) / 2.0d;
                    double d4 = (dArr4[i4] * dArr3[i2]) + (d3 * d3);
                    double d5 = shiftInfo.exShift;
                    dArr4[i2] = d2 + d5;
                    dArr3[i4] = dArr3[i4] + d5;
                    if (d4 >= 0.0d) {
                        double dSqrt = FastMath.sqrt(FastMath.abs(d4));
                        double d6 = d3 >= 0.0d ? d3 + dSqrt : d3 - dSqrt;
                        double d7 = schurTransformer.matrixT[i2][i4];
                        double dAbs = FastMath.abs(d6) + FastMath.abs(d7);
                        double d8 = d7 / dAbs;
                        double d9 = d6 / dAbs;
                        double dSqrt2 = FastMath.sqrt((d9 * d9) + (d8 * d8));
                        double d10 = d8 / dSqrt2;
                        double d11 = d9 / dSqrt2;
                        for (int i5 = i4; i5 < length; i5++) {
                            double[][] dArr5 = schurTransformer.matrixT;
                            double[] dArr6 = dArr5[i4];
                            double d12 = dArr6[i5];
                            double[] dArr7 = dArr5[i2];
                            dArr6[i5] = (dArr7[i5] * d10) + (d11 * d12);
                            dArr7[i5] = (dArr7[i5] * d11) - (d12 * d10);
                        }
                        for (int i6 = 0; i6 <= i2; i6++) {
                            double[] dArr8 = schurTransformer.matrixT[i6];
                            double d13 = dArr8[i4];
                            dArr8[i4] = (dArr8[i2] * d10) + (d11 * d13);
                            dArr8[i2] = (dArr8[i2] * d11) - (d13 * d10);
                        }
                        for (int i7 = 0; i7 <= i; i7++) {
                            double[] dArr9 = schurTransformer.matrixP[i7];
                            double d14 = dArr9[i4];
                            dArr9[i4] = (dArr9[i2] * d10) + (d11 * d14);
                            dArr9[i2] = (dArr9[i2] * d11) - (d14 * d10);
                        }
                    }
                    i2 -= 2;
                } else {
                    schurTransformer.computeShift(iFindSmallSubDiagonalElement, i2, i3, shiftInfo);
                    int i8 = i3 + 1;
                    if (i8 > 100) {
                        throw new MaxCountExceededException(LocalizedFormats.CONVERGENCE_FAILED, 100, new Object[0]);
                    }
                    double[] dArr10 = new double[3];
                    schurTransformer.performDoubleQRStep(iFindSmallSubDiagonalElement, schurTransformer.initQRStep(iFindSmallSubDiagonalElement, i2, shiftInfo, dArr10), i2, shiftInfo, dArr10);
                    i3 = i8;
                    schurTransformer = this;
                }
            }
            i3 = 0;
            schurTransformer = this;
        }
    }

    public RealMatrix getP() {
        if (this.cachedP == null) {
            this.cachedP = MatrixUtils.createRealMatrix(this.matrixP);
        }
        return this.cachedP;
    }

    public RealMatrix getT() {
        if (this.cachedT == null) {
            this.cachedT = MatrixUtils.createRealMatrix(this.matrixT);
        }
        return this.cachedT;
    }
}
