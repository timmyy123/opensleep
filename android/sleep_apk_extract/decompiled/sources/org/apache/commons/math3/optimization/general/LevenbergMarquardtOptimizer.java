package org.apache.commons.math3.optimization.general;

import java.util.Arrays;
import org.apache.commons.math3.exception.ConvergenceException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.optimization.PointVectorValuePair;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class LevenbergMarquardtOptimizer extends AbstractLeastSquaresOptimizer {
    private double[] beta;
    private final double costRelativeTolerance;
    private double[] diagR;
    private final double initialStepBoundFactor;
    private double[] jacNorm;
    private double[] lmDir;
    private double lmPar;
    private final double orthoTolerance;
    private final double parRelativeTolerance;
    private int[] permutation;
    private final double qrRankingThreshold;
    private int rank;
    private int solvedCols;
    private double[][] weightedJacobian;
    private double[] weightedResidual;

    public LevenbergMarquardtOptimizer() {
        this(100.0d, 1.0E-10d, 1.0E-10d, 1.0E-10d, Precision.SAFE_MIN);
    }

    private void determineLMDirection(double[] dArr, double[] dArr2, double[] dArr3, double[] dArr4) {
        int i;
        int i2;
        double d;
        double dSqrt;
        int i3 = 0;
        while (i3 < this.solvedCols) {
            int i4 = this.permutation[i3];
            int i5 = i3 + 1;
            for (int i6 = i5; i6 < this.solvedCols; i6++) {
                double[][] dArr5 = this.weightedJacobian;
                dArr5[i6][i4] = dArr5[i3][this.permutation[i6]];
            }
            this.lmDir[i3] = this.diagR[i4];
            dArr4[i3] = dArr[i3];
            i3 = i5;
        }
        int i7 = 0;
        while (true) {
            i = this.solvedCols;
            if (i7 >= i) {
                break;
            }
            double d2 = dArr2[this.permutation[i7]];
            if (d2 != 0.0d) {
                Arrays.fill(dArr3, i7 + 1, dArr3.length, 0.0d);
            }
            dArr3[i7] = d2;
            int i8 = i7;
            double d3 = 0.0d;
            while (i8 < this.solvedCols) {
                int i9 = this.permutation[i8];
                if (dArr3[i8] != 0.0d) {
                    double d4 = this.weightedJacobian[i8][i9];
                    if (FastMath.abs(d4) < FastMath.abs(dArr3[i8])) {
                        double d5 = d4 / dArr3[i8];
                        dSqrt = 1.0d / FastMath.sqrt((d5 * d5) + 1.0d);
                        d = d5 * dSqrt;
                    } else {
                        double d6 = dArr3[i8] / d4;
                        double dSqrt2 = 1.0d / FastMath.sqrt((d6 * d6) + 1.0d);
                        double d7 = d6 * dSqrt2;
                        d = dSqrt2;
                        dSqrt = d7;
                    }
                    this.weightedJacobian[i8][i9] = (dArr3[i8] * dSqrt) + (d4 * d);
                    double d8 = dArr4[i8];
                    double d9 = (dSqrt * d3) + (d * d8);
                    i2 = i7;
                    double d10 = -dSqrt;
                    d3 = (d3 * d) + (d8 * d10);
                    dArr4[i8] = d9;
                    for (int i10 = i8 + 1; i10 < this.solvedCols; i10++) {
                        double[] dArr6 = this.weightedJacobian[i10];
                        double d11 = dArr6[i9];
                        double d12 = dArr3[i10];
                        dArr3[i10] = (d12 * d) + (d11 * d10);
                        dArr6[i9] = (dSqrt * d12) + (d * d11);
                    }
                } else {
                    i2 = i7;
                }
                i8++;
                i7 = i2;
            }
            int i11 = i7;
            double[] dArr7 = this.weightedJacobian[i11];
            int i12 = this.permutation[i11];
            dArr3[i11] = dArr7[i12];
            dArr7[i12] = this.lmDir[i11];
            i7 = i11 + 1;
        }
        int i13 = 0;
        while (true) {
            int i14 = this.solvedCols;
            if (i13 >= i14) {
                break;
            }
            if (dArr3[i13] == 0.0d && i == i14) {
                i = i13;
            }
            if (i < i14) {
                dArr4[i13] = 0.0d;
            }
            i13++;
        }
        if (i > 0) {
            for (int i15 = i - 1; i15 >= 0; i15--) {
                int i16 = this.permutation[i15];
                double d13 = 0.0d;
                for (int i17 = i15 + 1; i17 < i; i17++) {
                    d13 += this.weightedJacobian[i17][i16] * dArr4[i17];
                }
                dArr4[i15] = (dArr4[i15] - d13) / dArr3[i15];
            }
        }
        int i18 = 0;
        while (true) {
            double[] dArr8 = this.lmDir;
            if (i18 >= dArr8.length) {
                return;
            }
            dArr8[this.permutation[i18]] = dArr4[i18];
            i18++;
        }
    }

    private void determineLMParameter(double[] dArr, double d, double[] dArr2, double[] dArr3, double[] dArr4, double[] dArr5) {
        int i;
        double d2;
        double dMax;
        double d3;
        int i2;
        double d4;
        double[] dArr6;
        double[] dArr7 = dArr;
        int i3 = 0;
        int length = this.weightedJacobian[0].length;
        int i4 = 0;
        while (true) {
            i = this.rank;
            if (i4 >= i) {
                break;
            }
            this.lmDir[this.permutation[i4]] = dArr7[i4];
            i4++;
        }
        while (i < length) {
            this.lmDir[this.permutation[i]] = 0.0d;
            i++;
        }
        int i5 = this.rank - 1;
        while (i5 >= 0) {
            int i6 = this.permutation[i5];
            double d5 = this.lmDir[i6] / this.diagR[i6];
            int i7 = i3;
            while (true) {
                dArr6 = this.lmDir;
                if (i7 < i5) {
                    int i8 = this.permutation[i7];
                    dArr6[i8] = dArr6[i8] - (this.weightedJacobian[i7][i6] * d5);
                    i7++;
                }
            }
            dArr6[i6] = d5;
            i5--;
            i3 = 0;
        }
        double d6 = 0.0d;
        for (int i9 = 0; i9 < this.solvedCols; i9++) {
            int i10 = this.permutation[i9];
            double d7 = dArr2[i10] * this.lmDir[i10];
            dArr3[i10] = d7;
            d6 += d7 * d7;
        }
        double dSqrt = FastMath.sqrt(d6);
        double d8 = dSqrt - d;
        double d9 = d * 0.1d;
        if (d8 <= d9) {
            this.lmPar = 0.0d;
            return;
        }
        if (this.rank == this.solvedCols) {
            for (int i11 = 0; i11 < this.solvedCols; i11++) {
                int i12 = this.permutation[i11];
                dArr3[i12] = (dArr2[i12] / dSqrt) * dArr3[i12];
            }
            d2 = dSqrt;
            double d10 = 0.0d;
            for (int i13 = 0; i13 < this.solvedCols; i13++) {
                int i14 = this.permutation[i13];
                int i15 = 0;
                double d11 = 0.0d;
                while (i15 < i13) {
                    int i16 = i14;
                    d11 = (this.weightedJacobian[i15][i16] * dArr3[this.permutation[i15]]) + d11;
                    i15++;
                    i14 = i16;
                }
                int i17 = i14;
                double d12 = (dArr3[i17] - d11) / this.diagR[i17];
                dArr3[i17] = d12;
                d10 += d12 * d12;
            }
            dMax = d8 / (d * d10);
        } else {
            d2 = dSqrt;
            dMax = 0.0d;
        }
        double d13 = d8;
        double d14 = 0.0d;
        for (int i18 = 0; i18 < this.solvedCols; i18++) {
            int i19 = this.permutation[i18];
            int i20 = 0;
            double d15 = 0.0d;
            while (i20 <= i18) {
                int i21 = i19;
                d15 = (this.weightedJacobian[i20][i21] * dArr7[i20]) + d15;
                i20++;
                i19 = i21;
            }
            double d16 = d15 / dArr2[i19];
            d14 = (d16 * d16) + d14;
        }
        double dSqrt2 = FastMath.sqrt(d14);
        double dMin = dSqrt2 / d;
        double d17 = 0.0d;
        if (dMin == 0.0d) {
            d3 = 2.2251E-308d;
            dMin = 2.2251E-308d / FastMath.min(d, 0.1d);
        } else {
            d3 = 2.2251E-308d;
        }
        double dMin2 = FastMath.min(dMin, FastMath.max(this.lmPar, dMax));
        this.lmPar = dMin2;
        if (dMin2 == 0.0d) {
            this.lmPar = dSqrt2 / d2;
        }
        int i22 = 10;
        while (i22 >= 0) {
            if (this.lmPar == d17) {
                i2 = i22;
                this.lmPar = FastMath.max(d3, 0.001d * dMin);
            } else {
                i2 = i22;
            }
            double dSqrt3 = FastMath.sqrt(this.lmPar);
            for (int i23 = 0; i23 < this.solvedCols; i23++) {
                int i24 = this.permutation[i23];
                dArr3[i24] = dArr2[i24] * dSqrt3;
            }
            determineLMDirection(dArr7, dArr3, dArr4, dArr5);
            double d18 = 0.0d;
            for (int i25 = 0; i25 < this.solvedCols; i25++) {
                int i26 = this.permutation[i25];
                double d19 = dArr2[i26] * this.lmDir[i26];
                dArr5[i26] = d19;
                d18 = (d19 * d19) + d18;
            }
            double dSqrt4 = FastMath.sqrt(d18);
            double d20 = dSqrt4 - d;
            if (FastMath.abs(d20) <= d9) {
                return;
            }
            if (dMax == 0.0d && d20 <= d13 && d13 < 0.0d) {
                return;
            }
            for (int i27 = 0; i27 < this.solvedCols; i27++) {
                int i28 = this.permutation[i27];
                dArr3[i28] = (dArr5[i28] * dArr2[i28]) / dSqrt4;
            }
            int i29 = 0;
            while (i29 < this.solvedCols) {
                int i30 = this.permutation[i29];
                double d21 = dArr3[i30] / dArr4[i29];
                dArr3[i30] = d21;
                int i31 = i29 + 1;
                while (i31 < this.solvedCols) {
                    int i32 = this.permutation[i31];
                    dArr3[i32] = dArr3[i32] - (this.weightedJacobian[i31][i30] * d21);
                    i31++;
                }
                i29 = i31;
            }
            double d22 = 0.0d;
            for (int i33 = 0; i33 < this.solvedCols; i33++) {
                double d23 = dArr3[this.permutation[i33]];
                d22 = (d23 * d23) + d22;
            }
            double d24 = d20 / (d * d22);
            d17 = 0.0d;
            if (d20 > 0.0d) {
                d4 = d24;
                dMax = FastMath.max(dMax, this.lmPar);
            } else {
                d4 = d24;
                if (d20 < 0.0d) {
                    dMin = FastMath.min(dMin, this.lmPar);
                }
            }
            this.lmPar = FastMath.max(dMax, this.lmPar + d4);
            d13 = d20;
            d3 = 2.2251E-308d;
            i22 = i2 - 1;
            dArr7 = dArr;
        }
    }

    private void qTy(double[] dArr) {
        double[][] dArr2 = this.weightedJacobian;
        int length = dArr2.length;
        int length2 = dArr2[0].length;
        for (int i = 0; i < length2; i++) {
            int i2 = this.permutation[i];
            double d = 0.0d;
            for (int i3 = i; i3 < length; i3++) {
                d += this.weightedJacobian[i3][i2] * dArr[i3];
            }
            double d2 = d * this.beta[i2];
            for (int i4 = i; i4 < length; i4++) {
                dArr[i4] = dArr[i4] - (this.weightedJacobian[i4][i2] * d2);
            }
        }
    }

    private void qrDecomposition(RealMatrix realMatrix) {
        double d;
        double[][] data2 = realMatrix.scalarMultiply(-1.0d).getData();
        this.weightedJacobian = data2;
        int length = data2.length;
        int i = 0;
        int length2 = data2[0].length;
        int i2 = 0;
        while (true) {
            d = 0.0d;
            if (i2 >= length2) {
                break;
            }
            this.permutation[i2] = i2;
            for (int i3 = 0; i3 < length; i3++) {
                double d2 = this.weightedJacobian[i3][i2];
                d += d2 * d2;
            }
            this.jacNorm[i2] = FastMath.sqrt(d);
            i2++;
        }
        while (i < length2) {
            int i4 = -1;
            double d3 = Double.NEGATIVE_INFINITY;
            for (int i5 = i; i5 < length2; i5++) {
                double d4 = d;
                for (int i6 = i; i6 < length; i6++) {
                    double d5 = this.weightedJacobian[i6][this.permutation[i5]];
                    d4 += d5 * d5;
                }
                if (Double.isInfinite(d4) || Double.isNaN(d4)) {
                    throw new ConvergenceException(LocalizedFormats.UNABLE_TO_PERFORM_QR_DECOMPOSITION_ON_JACOBIAN, Integer.valueOf(length), Integer.valueOf(length2));
                }
                if (d4 > d3) {
                    i4 = i5;
                    d3 = d4;
                }
            }
            if (d3 <= this.qrRankingThreshold) {
                this.rank = i;
                return;
            }
            int[] iArr = this.permutation;
            int i7 = iArr[i4];
            iArr[i4] = iArr[i];
            iArr[i] = i7;
            double d6 = this.weightedJacobian[i][i7];
            double dSqrt = FastMath.sqrt(d3);
            if (d6 > d) {
                dSqrt = -dSqrt;
            }
            double d7 = 1.0d / (d3 - (d6 * dSqrt));
            this.beta[i7] = d7;
            this.diagR[i7] = dSqrt;
            double[] dArr = this.weightedJacobian[i];
            dArr[i7] = dArr[i7] - dSqrt;
            int i8 = (length2 - 1) - i;
            while (i8 > 0) {
                double d8 = d;
                for (int i9 = i; i9 < length; i9++) {
                    double[] dArr2 = this.weightedJacobian[i9];
                    d8 += dArr2[i7] * dArr2[this.permutation[i + i8]];
                }
                double d9 = d8 * d7;
                for (int i10 = i; i10 < length; i10++) {
                    double[] dArr3 = this.weightedJacobian[i10];
                    int i11 = this.permutation[i + i8];
                    dArr3[i11] = dArr3[i11] - (dArr3[i7] * d9);
                }
                i8--;
                d = 0.0d;
            }
            i++;
            d = 0.0d;
        }
        this.rank = this.solvedCols;
    }

    /* JADX WARN: Code restructure failed: missing block: B:114:0x02e9, code lost:
    
        setCost(r14);
        r56.point = r18.getPoint();
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x02f2, code lost:
    
        return r18;
     */
    @Override // org.apache.commons.math3.optimization.direct.BaseAbstractMultivariateVectorOptimizer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public PointVectorValuePair doOptimize() {
        double d;
        double d2;
        int i;
        double[] dArr;
        int length = getTarget().length;
        double[] startPoint = getStartPoint();
        int length2 = startPoint.length;
        this.solvedCols = FastMath.min(length, length2);
        this.diagR = new double[length2];
        this.jacNorm = new double[length2];
        this.beta = new double[length2];
        this.permutation = new int[length2];
        this.lmDir = new double[length2];
        double[] dArr2 = new double[length2];
        double[] dArr3 = new double[length2];
        double[] dArr4 = new double[length];
        double[] dArr5 = new double[length];
        double[] dArr6 = new double[length2];
        double[] dArr7 = new double[length2];
        double[] dArr8 = new double[length2];
        RealMatrix weightSquareRoot = getWeightSquareRoot();
        double[] dArrComputeObjectiveValue = computeObjectiveValue(startPoint);
        double[] dArrComputeResiduals = computeResiduals(dArrComputeObjectiveValue);
        PointVectorValuePair pointVectorValuePair = new PointVectorValuePair(startPoint, dArrComputeObjectiveValue);
        double dComputeCost = computeCost(dArrComputeResiduals);
        PointVectorValuePair pointVectorValuePair2 = pointVectorValuePair;
        this.lmPar = 0.0d;
        getConvergenceChecker();
        boolean z = true;
        double[] dArr9 = new double[length];
        double d3 = 0.0d;
        double dSqrt = 0.0d;
        double d4 = dComputeCost;
        double[] dArr10 = dArrComputeResiduals;
        loop0: while (true) {
            qrDecomposition(computeWeightedJacobian(startPoint));
            this.weightedResidual = weightSquareRoot.operate(dArr10);
            int i2 = 0;
            while (i2 < length) {
                int i3 = i2;
                dArr5[i3] = this.weightedResidual[i3];
                i2 = i3 + 1;
            }
            qTy(dArr5);
            double[] dArr11 = dArr5;
            for (int i4 = 0; i4 < this.solvedCols; i4++) {
                int i5 = this.permutation[i4];
                this.weightedJacobian[i4][i5] = this.diagR[i5];
            }
            if (z) {
                double d5 = 0.0d;
                for (int i6 = 0; i6 < length2; i6++) {
                    double d6 = this.jacNorm[i6];
                    if (d6 == 0.0d) {
                        d6 = 1.0d;
                    }
                    double d7 = startPoint[i6] * d6;
                    d5 = (d7 * d7) + d5;
                    dArr2[i6] = d6;
                }
                dSqrt = FastMath.sqrt(d5);
                double d8 = this.initialStepBoundFactor;
                if (dSqrt != 0.0d) {
                    d8 *= dSqrt;
                }
                d3 = d8;
            }
            double[] dArr12 = dArrComputeObjectiveValue;
            double[] dArr13 = dArr2;
            if (d4 != 0.0d) {
                double dMax = 0.0d;
                int i7 = 0;
                while (i7 < this.solvedCols) {
                    int i8 = this.permutation[i7];
                    double d9 = this.jacNorm[i8];
                    if (d9 != 0.0d) {
                        double d10 = 0.0d;
                        int i9 = 0;
                        while (i9 <= i7) {
                            d10 = (this.weightedJacobian[i9][i8] * dArr11[i9]) + d10;
                            i9++;
                            i7 = i7;
                        }
                        i = i7;
                        dArr = dArr6;
                        dMax = FastMath.max(dMax, FastMath.abs(d10) / (d9 * d4));
                    } else {
                        i = i7;
                        dArr = dArr6;
                    }
                    dArr6 = dArr;
                    i7 = i + 1;
                }
                d = dMax;
            } else {
                d = 0.0d;
            }
            double[] dArr14 = dArr6;
            if (d <= this.orthoTolerance) {
                setCost(d4);
                this.point = pointVectorValuePair2.getPoint();
                return pointVectorValuePair2;
            }
            int i10 = 0;
            while (i10 < length2) {
                int i11 = i10;
                dArr13[i11] = FastMath.max(dArr13[i10], this.jacNorm[i11]);
                i10 = i11 + 1;
                dArr14 = dArr14;
            }
            double[] dArr15 = dArr14;
            double[] dArr16 = dArr10;
            double dMin = d3;
            double[] dArr17 = dArr9;
            double d11 = d4;
            double d12 = 0.0d;
            double[] dArr18 = dArr12;
            while (d12 < 1.0E-4d) {
                for (int i12 = 0; i12 < this.solvedCols; i12++) {
                    int i13 = this.permutation[i12];
                    dArr3[i13] = startPoint[i13];
                }
                double[] dArr19 = this.weightedResidual;
                this.weightedResidual = dArr17;
                int i14 = length;
                determineLMParameter(dArr11, dMin, dArr13, dArr15, dArr7, dArr8);
                double d13 = 0.0d;
                for (int i15 = 0; i15 < this.solvedCols; i15++) {
                    int i16 = this.permutation[i15];
                    double[] dArr20 = this.lmDir;
                    double d14 = -dArr20[i16];
                    dArr20[i16] = d14;
                    startPoint[i16] = dArr3[i16] + d14;
                    double d15 = dArr13[i16] * dArr20[i16];
                    d13 = (d15 * d15) + d13;
                }
                double dSqrt2 = FastMath.sqrt(d13);
                if (z) {
                    dMin = FastMath.min(dMin, dSqrt2);
                }
                double[] dArrComputeObjectiveValue2 = computeObjectiveValue(startPoint);
                double[] dArrComputeResiduals2 = computeResiduals(dArrComputeObjectiveValue2);
                PointVectorValuePair pointVectorValuePair3 = new PointVectorValuePair(startPoint, dArrComputeObjectiveValue2);
                double dComputeCost2 = computeCost(dArrComputeResiduals2);
                double d16 = 0.1d;
                double d17 = dComputeCost2 * 0.1d;
                if (d17 < d11) {
                    double d18 = dComputeCost2 / d11;
                    d2 = 1.0d - (d18 * d18);
                } else {
                    d2 = -1.0d;
                }
                int i17 = 0;
                while (i17 < this.solvedCols) {
                    int i18 = this.permutation[i17];
                    double d19 = this.lmDir[i18];
                    dArr15[i17] = 0.0d;
                    int i19 = 0;
                    while (i19 <= i17) {
                        dArr15[i19] = (this.weightedJacobian[i19][i18] * d19) + dArr15[i19];
                        i19++;
                        i17 = i17;
                    }
                    i17++;
                }
                double d20 = 0.0d;
                for (int i20 = 0; i20 < this.solvedCols; i20++) {
                    double d21 = dArr15[i20];
                    d20 = (d21 * d21) + d20;
                }
                double d22 = d11 * d11;
                double d23 = d20 / d22;
                double d24 = this.lmPar;
                double d25 = ((d24 * dSqrt2) * dSqrt2) / d22;
                double d26 = (d25 * 2.0d) + d23;
                double d27 = -(d23 + d25);
                double d28 = d26 == 0.0d ? 0.0d : d2 / d26;
                if (d28 <= 0.25d) {
                    double d29 = d2 < 0.0d ? (d27 * 0.5d) / ((0.5d * d2) + d27) : 0.5d;
                    if (d17 < d11 && d29 >= 0.1d) {
                        d16 = d29;
                    }
                    dMin = FastMath.min(dMin, 10.0d * dSqrt2) * d16;
                    this.lmPar /= d16;
                } else if (d24 == 0.0d || d28 >= 0.75d) {
                    this.lmPar = d24 * 0.5d;
                    dMin = dSqrt2 * 2.0d;
                }
                if (d28 >= 1.0E-4d) {
                    double d30 = 0.0d;
                    for (int i21 = 0; i21 < length2; i21++) {
                        double d31 = dArr13[i21] * startPoint[i21];
                        d30 = (d31 * d31) + d30;
                    }
                    dSqrt = FastMath.sqrt(d30);
                    dArr17 = dArr19;
                    dArr18 = dArrComputeObjectiveValue2;
                    z = false;
                    d11 = dComputeCost2;
                    pointVectorValuePair2 = pointVectorValuePair3;
                } else {
                    for (int i22 = 0; i22 < this.solvedCols; i22++) {
                        int i23 = this.permutation[i22];
                        startPoint[i23] = dArr3[i23];
                    }
                    double[] dArr21 = this.weightedResidual;
                    this.weightedResidual = dArr19;
                    pointVectorValuePair2 = new PointVectorValuePair(startPoint, dArr18);
                    dArr17 = dArr21;
                }
                double dAbs = FastMath.abs(d2);
                double d32 = dMin;
                double d33 = this.costRelativeTolerance;
                if ((dAbs <= d33 && d26 <= d33 && d28 <= 2.0d) || d32 <= this.parRelativeTolerance * dSqrt) {
                    break loop0;
                }
                if (FastMath.abs(d2) <= 2.2204E-16d && d26 <= 2.2204E-16d && d28 <= 2.0d) {
                    throw new ConvergenceException(LocalizedFormats.TOO_SMALL_COST_RELATIVE_TOLERANCE, Double.valueOf(this.costRelativeTolerance));
                }
                if (d32 <= dSqrt * 2.2204E-16d) {
                    throw new ConvergenceException(LocalizedFormats.TOO_SMALL_PARAMETERS_RELATIVE_TOLERANCE, Double.valueOf(this.parRelativeTolerance));
                }
                if (d <= 2.2204E-16d) {
                    throw new ConvergenceException(LocalizedFormats.TOO_SMALL_ORTHOGONALITY_TOLERANCE, Double.valueOf(this.orthoTolerance));
                }
                length = i14;
                dArr16 = dArrComputeResiduals2;
                dMin = d32;
                d12 = d28;
            }
            d3 = dMin;
            dArr9 = dArr17;
            dArrComputeObjectiveValue = dArr18;
            d4 = d11;
            dArr2 = dArr13;
            dArr6 = dArr15;
            dArr10 = dArr16;
            dArr5 = dArr11;
        }
    }

    public LevenbergMarquardtOptimizer(double d, double d2, double d3, double d4, double d5) {
        super(null);
        this.initialStepBoundFactor = d;
        this.costRelativeTolerance = d2;
        this.parRelativeTolerance = d3;
        this.orthoTolerance = d4;
        this.qrRankingThreshold = d5;
    }
}
