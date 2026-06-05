package org.apache.commons.math3.linear;

import org.apache.commons.math3.complex.Complex;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.MathUnsupportedOperationException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: loaded from: classes5.dex */
public class EigenDecomposition {
    private RealMatrix cachedV;
    private RealMatrix cachedVt;
    private ArrayRealVector[] eigenvectors;
    private double[] imagEigenvalues;
    private final boolean isSymmetric;
    private double[] main;
    private byte maxIter = 30;
    private double[] realEigenvalues;
    private double[] secondary;
    private TriDiagonalTransformer transformer;

    public EigenDecomposition(RealMatrix realMatrix) {
        boolean zIsSymmetric = MatrixUtils.isSymmetric(realMatrix, ((double) (realMatrix.getColumnDimension() * realMatrix.getRowDimension() * 10)) * Precision.EPSILON);
        this.isSymmetric = zIsSymmetric;
        if (!zIsSymmetric) {
            findEigenVectorsFromSchur(transformToSchur(realMatrix));
        } else {
            transformToTridiagonal(realMatrix);
            findEigenVectors(this.transformer.getQ().getData());
        }
    }

    private Complex cdiv(double d, double d2, double d3, double d4) {
        return new Complex(d, d2).divide(new Complex(d3, d4));
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x01b4, code lost:
    
        r5 = r5 + 1;
        r7 = r20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void findEigenVectors(double[][] dArr) {
        int i;
        double[] dArr2;
        double d;
        double d2;
        double d3;
        double d4;
        double d5;
        double[][] dArr3 = (double[][]) dArr.clone();
        int length = this.main.length;
        this.realEigenvalues = new double[length];
        this.imagEigenvalues = new double[length];
        double[] dArr4 = new double[length];
        int i2 = 0;
        while (true) {
            i = length - 1;
            dArr2 = this.realEigenvalues;
            if (i2 >= i) {
                break;
            }
            dArr2[i2] = this.main[i2];
            dArr4[i2] = this.secondary[i2];
            i2++;
        }
        dArr2[i] = this.main[i];
        double d6 = 0.0d;
        dArr4[i] = 0.0d;
        double dAbs = 0.0d;
        for (int i3 = 0; i3 < length; i3++) {
            if (FastMath.abs(this.realEigenvalues[i3]) > dAbs) {
                dAbs = FastMath.abs(this.realEigenvalues[i3]);
            }
            if (FastMath.abs(dArr4[i3]) > dAbs) {
                dAbs = FastMath.abs(dArr4[i3]);
            }
        }
        if (dAbs != 0.0d) {
            for (int i4 = 0; i4 < length; i4++) {
                double dAbs2 = FastMath.abs(this.realEigenvalues[i4]);
                double d7 = Precision.EPSILON;
                if (dAbs2 <= d7 * dAbs) {
                    this.realEigenvalues[i4] = 0.0d;
                }
                if (FastMath.abs(dArr4[i4]) <= d7 * dAbs) {
                    dArr4[i4] = 0.0d;
                }
            }
        }
        int i5 = 0;
        while (i5 < length) {
            int i6 = 0;
            while (true) {
                int i7 = i5;
                while (i7 < i) {
                    int i8 = i7 + 1;
                    double dAbs3 = FastMath.abs(this.realEigenvalues[i8]) + FastMath.abs(this.realEigenvalues[i7]);
                    if (FastMath.abs(dArr4[i7]) + dAbs3 == dAbs3) {
                        break;
                    } else {
                        i7 = i8;
                    }
                }
                if (i7 != i5) {
                    byte b = this.maxIter;
                    if (i6 == b) {
                        throw new MaxCountExceededException(LocalizedFormats.CONVERGENCE_FAILED, Byte.valueOf(b), new Object[0]);
                    }
                    i6++;
                    double[] dArr5 = this.realEigenvalues;
                    double d8 = (dArr5[i5 + 1] - dArr5[i5]) / (dArr4[i5] * 2.0d);
                    double dSqrt = FastMath.sqrt((d8 * d8) + 1.0d);
                    d = d6;
                    double[] dArr6 = this.realEigenvalues;
                    if (d8 < d6) {
                        d2 = dArr6[i7] - dArr6[i5];
                        d3 = dArr4[i5];
                        d4 = d8 - dSqrt;
                    } else {
                        d2 = dArr6[i7] - dArr6[i5];
                        d3 = dArr4[i5];
                        d4 = d8 + dSqrt;
                    }
                    double d9 = (d3 / d4) + d2;
                    int i9 = i7 - 1;
                    double d10 = 1.0d;
                    double d11 = 1.0d;
                    double d12 = d;
                    while (true) {
                        if (i9 < i5) {
                            break;
                        }
                        double d13 = dArr4[i9];
                        double d14 = d10 * d13;
                        double d15 = d11 * d13;
                        if (FastMath.abs(d14) >= FastMath.abs(d9)) {
                            double d16 = d9 / d14;
                            double dSqrt2 = FastMath.sqrt((d16 * d16) + 1.0d);
                            dArr4[i9 + 1] = d14 * dSqrt2;
                            d10 = 1.0d / dSqrt2;
                            d5 = d16 * d10;
                            dSqrt = dSqrt2;
                        } else {
                            double d17 = d14 / d9;
                            dSqrt = FastMath.sqrt((d17 * d17) + 1.0d);
                            dArr4[i9 + 1] = d9 * dSqrt;
                            d5 = 1.0d / dSqrt;
                            d10 = d17 * d5;
                        }
                        int i10 = i9 + 1;
                        double d18 = dArr4[i10];
                        double[] dArr7 = this.realEigenvalues;
                        if (d18 == d) {
                            dArr7[i10] = dArr7[i10] - d12;
                            dArr4[i7] = d;
                            break;
                        }
                        double d19 = dArr7[i10] - d12;
                        dSqrt = (d5 * 2.0d * d15) + ((dArr7[i9] - d19) * d10);
                        d12 = d10 * dSqrt;
                        dArr7[i10] = d19 + d12;
                        d9 = (d5 * dSqrt) - d15;
                        for (int i11 = 0; i11 < length; i11++) {
                            double[] dArr8 = dArr3[i11];
                            double d20 = dArr8[i10];
                            dArr8[i10] = (d5 * d20) + (dArr8[i9] * d10);
                            dArr8[i9] = (dArr8[i9] * d5) - (d20 * d10);
                        }
                        i9--;
                        d11 = d5;
                    }
                    if (dSqrt != d || i9 < i5) {
                        double[] dArr9 = this.realEigenvalues;
                        dArr9[i5] = dArr9[i5] - d12;
                        dArr4[i5] = d9;
                        dArr4[i7] = d;
                    }
                } else {
                    d = d6;
                }
                if (i7 == i5) {
                    break;
                } else {
                    d6 = d;
                }
            }
        }
        double d21 = d6;
        int i12 = 0;
        while (i12 < length) {
            double d22 = this.realEigenvalues[i12];
            int i13 = i12 + 1;
            int i14 = i12;
            for (int i15 = i13; i15 < length; i15++) {
                double d23 = this.realEigenvalues[i15];
                if (d23 > d22) {
                    i14 = i15;
                    d22 = d23;
                }
            }
            if (i14 != i12) {
                double[] dArr10 = this.realEigenvalues;
                dArr10[i14] = dArr10[i12];
                dArr10[i12] = d22;
                for (int i16 = 0; i16 < length; i16++) {
                    double[] dArr11 = dArr3[i16];
                    double d24 = dArr11[i12];
                    dArr11[i12] = dArr11[i14];
                    dArr11[i14] = d24;
                }
            }
            i12 = i13;
        }
        double dAbs4 = d21;
        for (int i17 = 0; i17 < length; i17++) {
            if (FastMath.abs(this.realEigenvalues[i17]) > dAbs4) {
                dAbs4 = FastMath.abs(this.realEigenvalues[i17]);
            }
        }
        if (dAbs4 != d21) {
            for (int i18 = 0; i18 < length; i18++) {
                if (FastMath.abs(this.realEigenvalues[i18]) < Precision.EPSILON * dAbs4) {
                    this.realEigenvalues[i18] = d21;
                }
            }
        }
        this.eigenvectors = new ArrayRealVector[length];
        double[] dArr12 = new double[length];
        for (int i19 = 0; i19 < length; i19++) {
            for (int i20 = 0; i20 < length; i20++) {
                dArr12[i20] = dArr3[i20][i19];
            }
            this.eigenvectors[i19] = new ArrayRealVector(dArr12);
        }
    }

    private void findEigenVectorsFromSchur(SchurTransformer schurTransformer) {
        double[][] dArr;
        int i;
        int i2;
        int i3;
        double[][] dArr2;
        int i4;
        double d;
        int i5;
        double[][] dArr3;
        int i6;
        int i7;
        double d2;
        int i8;
        int i9;
        double d3;
        double d4;
        double[][] dArr4;
        double[][] dArr5;
        EigenDecomposition eigenDecomposition = this;
        double[][] data2 = schurTransformer.getT().getData();
        double[][] data3 = schurTransformer.getP().getData();
        int length = data2.length;
        double d5 = 0.0d;
        double dAbs = 0.0d;
        for (int i10 = 0; i10 < length; i10++) {
            for (int iMax = FastMath.max(i10 - 1, 0); iMax < length; iMax++) {
                dAbs += FastMath.abs(data2[i10][iMax]);
            }
        }
        double d6 = dAbs;
        if (Precision.equals(dAbs, 0.0d, 1.0E-12d)) {
            throw new MathArithmeticException(LocalizedFormats.ZERO_NORM, new Object[0]);
        }
        int i11 = length - 1;
        int i12 = i11;
        double d7 = 0.0d;
        double d8 = 0.0d;
        double d9 = 0.0d;
        while (i12 >= 0) {
            double d10 = eigenDecomposition.realEigenvalues[i12];
            double d11 = eigenDecomposition.imagEigenvalues[i12];
            if (Precision.equals(d11, d5)) {
                data2[i12][i12] = 1.0d;
                int i13 = i12 - 1;
                int i14 = i12;
                double d12 = d7;
                while (i13 >= 0) {
                    double d13 = data2[i13][i13] - d10;
                    double d14 = d5;
                    for (int i15 = i14; i15 <= i12; i15++) {
                        d14 = (data2[i13][i15] * data2[i15][i12]) + d14;
                    }
                    if (Precision.compareTo(eigenDecomposition.imagEigenvalues[i13], 0.0d, 1.0E-12d) < 0) {
                        d12 = d14;
                        dArr4 = data2;
                        dArr5 = data3;
                        d8 = d13;
                    } else {
                        dArr4 = data2;
                        dArr5 = data3;
                        if (!Precision.equals(eigenDecomposition.imagEigenvalues[i13], d5)) {
                            double[] dArr6 = dArr4[i13];
                            int i16 = i13 + 1;
                            double d15 = dArr6[i16];
                            double d16 = dArr4[i16][i13];
                            double d17 = eigenDecomposition.realEigenvalues[i13];
                            double d18 = eigenDecomposition.imagEigenvalues[i13];
                            double d19 = ((d15 * d12) - (d8 * d14)) / ((d18 * d18) + ((d17 - d10) * (d17 - d10)));
                            dArr6[i12] = d19;
                            if (FastMath.abs(d15) > FastMath.abs(d8)) {
                                dArr4[i16][i12] = ((-d14) - (d13 * d19)) / d15;
                            } else {
                                dArr4[i16][i12] = ((-d12) - (d16 * d19)) / d8;
                            }
                        } else if (d13 != d5) {
                            dArr4[i13][i12] = (-d14) / d13;
                        } else {
                            dArr4[i13][i12] = (-d14) / (Precision.EPSILON * d6);
                        }
                        double dAbs2 = FastMath.abs(dArr4[i13][i12]);
                        if (Precision.EPSILON * dAbs2 * dAbs2 > 1.0d) {
                            for (int i17 = i13; i17 <= i12; i17++) {
                                double[] dArr7 = dArr4[i17];
                                dArr7[i12] = dArr7[i12] / dAbs2;
                            }
                        }
                        i14 = i13;
                    }
                    i13--;
                    d9 = d14;
                    data2 = dArr4;
                    data3 = dArr5;
                }
                dArr = data3;
                i = i11;
                i2 = i12;
                d7 = d12;
                dArr2 = data2;
                i3 = length;
            } else {
                double[][] dArr8 = data2;
                dArr = data3;
                if (d11 < d5) {
                    int i18 = i12 - 1;
                    if (FastMath.abs(dArr8[i12][i18]) > FastMath.abs(dArr8[i18][i12])) {
                        double[] dArr9 = dArr8[i18];
                        double[] dArr10 = dArr8[i12];
                        dArr9[i18] = d11 / dArr10[i18];
                        dArr9[i12] = (-(dArr10[i12] - d10)) / dArr10[i18];
                        i4 = i11;
                        d = d5;
                        i2 = i12;
                    } else {
                        double[] dArr11 = dArr8[i18];
                        i4 = i11;
                        double d20 = d5;
                        i2 = i12;
                        d = d20;
                        Complex complexCdiv = eigenDecomposition.cdiv(0.0d, -dArr11[i12], dArr11[i18] - d10, d11);
                        dArr8[i18][i18] = complexCdiv.getReal();
                        dArr8[i18][i2] = complexCdiv.getImaginary();
                    }
                    double[] dArr12 = dArr8[i2];
                    dArr12[i18] = d;
                    dArr12[i2] = 1.0d;
                    int i19 = i2 - 2;
                    int i20 = i18;
                    while (i19 >= 0) {
                        double d21 = d;
                        double d22 = d21;
                        for (int i21 = i20; i21 <= i2; i21++) {
                            double d23 = dArr8[i19][i21];
                            double[] dArr13 = dArr8[i21];
                            d21 = (dArr13[i18] * d23) + d21;
                            d22 = (d23 * dArr13[i2]) + d22;
                        }
                        double d24 = dArr8[i19][i19] - d10;
                        if (Precision.compareTo(eigenDecomposition.imagEigenvalues[i19], 0.0d, 1.0E-12d) < 0) {
                            d9 = d21;
                            d7 = d22;
                            i8 = length;
                            i5 = i19;
                            dArr3 = dArr8;
                            d8 = d24;
                            i6 = i18;
                            i7 = i4;
                        } else {
                            double d25 = d11;
                            if (Precision.equals(eigenDecomposition.imagEigenvalues[i19], d)) {
                                eigenDecomposition = this;
                                i5 = i19;
                                dArr3 = dArr8;
                                d3 = d7;
                                d11 = d25;
                                i6 = i18;
                                i7 = i4;
                                d2 = d9;
                                Complex complexCdiv2 = eigenDecomposition.cdiv(-d21, -d22, d24, d11);
                                dArr3[i5][i6] = complexCdiv2.getReal();
                                dArr3[i5][i2] = complexCdiv2.getImaginary();
                                i8 = length;
                                i9 = i2;
                                d4 = d8;
                            } else {
                                i5 = i19;
                                dArr3 = dArr8;
                                double d26 = d7;
                                i6 = i18;
                                i7 = i4;
                                d2 = d9;
                                int i22 = i5 + 1;
                                double d27 = dArr3[i5][i22];
                                double d28 = dArr3[i22][i5];
                                double d29 = this.realEigenvalues[i5];
                                double d30 = this.imagEigenvalues[i5];
                                double dAbs3 = ((d30 * d30) + ((d29 - d10) * (d29 - d10))) - (d25 * d25);
                                double d31 = (d29 - d10) * 2.0d * d25;
                                i8 = length;
                                i9 = i2;
                                if (Precision.equals(dAbs3, 0.0d) && Precision.equals(d31, 0.0d)) {
                                    dAbs3 = Precision.EPSILON * d6 * (FastMath.abs(d8) + FastMath.abs(d28) + FastMath.abs(d27) + FastMath.abs(d25) + FastMath.abs(d24));
                                }
                                double d32 = ((d27 * d26) - (d8 * d22)) - (d25 * d21);
                                double d33 = d21;
                                double d34 = d22;
                                Complex complexCdiv3 = cdiv((d25 * d22) + ((d27 * d2) - (d8 * d21)), d32, dAbs3, d31);
                                dArr3[i5][i6] = complexCdiv3.getReal();
                                dArr3[i5][i9] = complexCdiv3.getImaginary();
                                if (FastMath.abs(d27) > FastMath.abs(d25) + FastMath.abs(d8)) {
                                    double[] dArr14 = dArr3[i22];
                                    double[] dArr15 = dArr3[i5];
                                    dArr14[i6] = ((d25 * dArr15[i9]) + ((-d33) - (dArr15[i6] * d24))) / d27;
                                    dArr14[i9] = (((-d34) - (dArr15[i9] * d24)) - (d25 * dArr15[i6])) / d27;
                                    eigenDecomposition = this;
                                    d4 = d8;
                                    d3 = d26;
                                    d11 = d25;
                                } else {
                                    double[] dArr16 = dArr3[i5];
                                    d3 = d26;
                                    d4 = d8;
                                    d11 = d25;
                                    eigenDecomposition = this;
                                    Complex complexCdiv4 = eigenDecomposition.cdiv((-d2) - (dArr16[i6] * d28), (-d3) - (d28 * dArr16[i9]), d4, d11);
                                    dArr3[i22][i6] = complexCdiv4.getReal();
                                    dArr3[i22][i9] = complexCdiv4.getImaginary();
                                }
                            }
                            double dMax = FastMath.max(FastMath.abs(dArr3[i5][i6]), FastMath.abs(dArr3[i5][i9]));
                            if (Precision.EPSILON * dMax * dMax > 1.0d) {
                                i2 = i9;
                                for (int i23 = i5; i23 <= i2; i23++) {
                                    double[] dArr17 = dArr3[i23];
                                    dArr17[i6] = dArr17[i6] / dMax;
                                    dArr17[i2] = dArr17[i2] / dMax;
                                }
                            } else {
                                i2 = i9;
                            }
                            d8 = d4;
                            d9 = d2;
                            d7 = d3;
                            i20 = i5;
                        }
                        i19 = i5 - 1;
                        i18 = i6;
                        i4 = i7;
                        dArr8 = dArr3;
                        length = i8;
                        d = 0.0d;
                    }
                    i = i4;
                    i3 = length;
                    dArr2 = dArr8;
                } else {
                    i = i11;
                    i2 = i12;
                    i3 = length;
                    dArr2 = dArr8;
                }
            }
            i12 = i2 - 1;
            data3 = dArr;
            i11 = i;
            data2 = dArr2;
            length = i3;
            d5 = 0.0d;
        }
        int i24 = i11;
        double[][] dArr18 = data2;
        double[][] dArr19 = data3;
        int i25 = length;
        while (i11 >= 0) {
            int i26 = i24;
            for (int i27 = 0; i27 <= i26; i27++) {
                double d35 = 0.0d;
                for (int i28 = 0; i28 <= FastMath.min(i11, i26); i28++) {
                    d35 += dArr19[i27][i28] * dArr18[i28][i11];
                }
                dArr19[i27][i11] = d35;
            }
            i11--;
            i24 = i26;
        }
        eigenDecomposition.eigenvectors = new ArrayRealVector[i25];
        double[] dArr20 = new double[i25];
        for (int i29 = 0; i29 < i25; i29++) {
            for (int i30 = 0; i30 < i25; i30++) {
                dArr20[i30] = dArr19[i30][i29];
            }
            eigenDecomposition.eigenvectors[i29] = new ArrayRealVector(dArr20);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private SchurTransformer transformToSchur(RealMatrix realMatrix) {
        SchurTransformer schurTransformer = new SchurTransformer(realMatrix);
        double[][] data2 = schurTransformer.getT().getData();
        this.realEigenvalues = new double[data2.length];
        this.imagEigenvalues = new double[data2.length];
        int i = 0;
        while (true) {
            if (i >= this.realEigenvalues.length) {
                return schurTransformer;
            }
            if (i != r4.length - 1) {
                int i2 = i + 1;
                if (Precision.equals(data2[i2][i], 0.0d, 1.0E-12d)) {
                    this.realEigenvalues[i] = data2[i][i];
                } else {
                    double[] dArr = data2[i2];
                    double d = dArr[i2];
                    double[] dArr2 = data2[i];
                    double d2 = (dArr2[i] - d) * 0.5d;
                    double dSqrt = FastMath.sqrt(FastMath.abs((dArr[i] * dArr2[i2]) + (d2 * d2)));
                    double[] dArr3 = this.realEigenvalues;
                    double d3 = d + d2;
                    dArr3[i] = d3;
                    double[] dArr4 = this.imagEigenvalues;
                    dArr4[i] = dSqrt;
                    dArr3[i2] = d3;
                    dArr4[i2] = -dSqrt;
                    i = i2;
                }
            }
            i++;
        }
    }

    private void transformToTridiagonal(RealMatrix realMatrix) {
        TriDiagonalTransformer triDiagonalTransformer = new TriDiagonalTransformer(realMatrix);
        this.transformer = triDiagonalTransformer;
        this.main = triDiagonalTransformer.getMainDiagonalRef();
        this.secondary = this.transformer.getSecondaryDiagonalRef();
    }

    public RealMatrix getSquareRoot() {
        if (!this.isSymmetric) {
            throw new MathUnsupportedOperationException();
        }
        double[] dArr = new double[this.realEigenvalues.length];
        int i = 0;
        while (true) {
            double[] dArr2 = this.realEigenvalues;
            if (i >= dArr2.length) {
                RealMatrix realMatrixCreateRealDiagonalMatrix = MatrixUtils.createRealDiagonalMatrix(dArr);
                RealMatrix v = getV();
                return v.multiply(realMatrixCreateRealDiagonalMatrix).multiply(getVT());
            }
            double d = dArr2[i];
            if (d <= 0.0d) {
                throw new MathUnsupportedOperationException();
            }
            dArr[i] = FastMath.sqrt(d);
            i++;
        }
    }

    public RealMatrix getV() {
        if (this.cachedV == null) {
            int length = this.eigenvectors.length;
            this.cachedV = MatrixUtils.createRealMatrix(length, length);
            for (int i = 0; i < length; i++) {
                this.cachedV.setColumnVector(i, this.eigenvectors[i]);
            }
        }
        return this.cachedV;
    }

    public RealMatrix getVT() {
        if (this.cachedVt == null) {
            int length = this.eigenvectors.length;
            this.cachedVt = MatrixUtils.createRealMatrix(length, length);
            for (int i = 0; i < length; i++) {
                this.cachedVt.setRowVector(i, this.eigenvectors[i]);
            }
        }
        return this.cachedVt;
    }
}
