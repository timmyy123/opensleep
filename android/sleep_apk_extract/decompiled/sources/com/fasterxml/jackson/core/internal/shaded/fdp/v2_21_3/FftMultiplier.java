package com.fasterxml.jackson.core.internal.shaded.fdp.v2_21_3;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes.dex */
abstract class FftMultiplier {
    public static final double COS_0_25 = Math.cos(0.7853981633974483d);
    public static final double SIN_0_25 = Math.sin(0.7853981633974483d);
    private static volatile ComplexVector[] ROOTS2_CACHE = new ComplexVector[20];
    private static volatile ComplexVector[] ROOTS3_CACHE = new ComplexVector[20];

    public static int bitsPerFftPoint(int i) {
        if (i <= 9728) {
            return 19;
        }
        if (i <= 18432) {
            return 18;
        }
        if (i <= 69632) {
            return 17;
        }
        if (i <= 262144) {
            return 16;
        }
        if (i <= 983040) {
            return 15;
        }
        if (i <= 3670016) {
            return 14;
        }
        if (i <= 13631488) {
            return 13;
        }
        if (i <= 25165824) {
            return 12;
        }
        if (i <= 92274688) {
            return 11;
        }
        if (i <= 335544320) {
            return 10;
        }
        return i <= 1207959552 ? 9 : 8;
    }

    private static ComplexVector calculateRootsOfUnity(int i) {
        if (i == 1) {
            ComplexVector complexVector = new ComplexVector(1);
            complexVector.real(0, 1.0d);
            complexVector.imag(0, 0.0d);
            return complexVector;
        }
        ComplexVector complexVector2 = new ComplexVector(i);
        complexVector2.set(0, 1.0d, 0.0d);
        int i2 = i / 2;
        complexVector2.set(i2, COS_0_25, SIN_0_25);
        double d = 1.5707963267948966d / ((double) i);
        int i3 = 1;
        while (i3 < i2) {
            double d2 = ((double) i3) * d;
            double dCos = Math.cos(d2);
            double dSin = Math.sin(d2);
            complexVector2.set(i3, dCos, dSin);
            int i4 = i3;
            complexVector2.set(i - i4, dSin, dCos);
            i3 = i4 + 1;
        }
        return complexVector2;
    }

    private static void fft(ComplexVector complexVector, ComplexVector[] complexVectorArr) {
        int i = complexVector.length;
        int iNumberOfLeadingZeros = 31 - Integer.numberOfLeadingZeros(i);
        MutableComplex mutableComplex = new MutableComplex();
        MutableComplex mutableComplex2 = new MutableComplex();
        MutableComplex mutableComplex3 = new MutableComplex();
        MutableComplex mutableComplex4 = new MutableComplex();
        MutableComplex mutableComplex5 = new MutableComplex();
        MutableComplex mutableComplex6 = new MutableComplex();
        while (iNumberOfLeadingZeros >= 2) {
            ComplexVector complexVector2 = complexVectorArr[iNumberOfLeadingZeros - 2];
            int i2 = 1 << iNumberOfLeadingZeros;
            for (int i3 = 0; i3 < i; i3 += i2) {
                int i4 = 0;
                while (true) {
                    int i5 = i2 / 4;
                    if (i4 < i5) {
                        mutableComplex5.set(complexVector2, i4);
                        mutableComplex5.squareInto(mutableComplex6);
                        int i6 = i3 + i4;
                        int i7 = i5 + i6;
                        int i8 = (i2 / 2) + i6;
                        int i9 = iNumberOfLeadingZeros;
                        int iM$1 = Fragment$$ExternalSyntheticOutline1.m$1(i2, 3, 4, i6);
                        complexVector.addInto(i6, complexVector, i7, mutableComplex);
                        mutableComplex.add(complexVector, i8);
                        mutableComplex.add(complexVector, iM$1);
                        complexVector.subtractTimesIInto(i6, complexVector, i7, mutableComplex2);
                        mutableComplex2.subtract(complexVector, i8);
                        mutableComplex2.addTimesI(complexVector, iM$1);
                        mutableComplex2.multiplyConjugate(mutableComplex5);
                        complexVector.subtractInto(i6, complexVector, i7, mutableComplex3);
                        mutableComplex3.add(complexVector, i8);
                        mutableComplex3.subtract(complexVector, iM$1);
                        mutableComplex3.multiplyConjugate(mutableComplex6);
                        complexVector.addTimesIInto(i6, complexVector, i7, mutableComplex4);
                        mutableComplex4.subtract(complexVector, i8);
                        mutableComplex4.subtractTimesI(complexVector, iM$1);
                        mutableComplex4.multiply(mutableComplex5);
                        mutableComplex.copyInto(complexVector, i6);
                        mutableComplex2.copyInto(complexVector, i7);
                        mutableComplex3.copyInto(complexVector, i8);
                        mutableComplex4.copyInto(complexVector, iM$1);
                        i4++;
                        iNumberOfLeadingZeros = i9;
                        complexVector2 = complexVector2;
                    }
                }
            }
            iNumberOfLeadingZeros -= 2;
        }
        if (iNumberOfLeadingZeros > 0) {
            for (int i10 = 0; i10 < i; i10 += 2) {
                complexVector.copyInto(i10, mutableComplex);
                int i11 = i10 + 1;
                complexVector.copyInto(i11, mutableComplex2);
                complexVector.add(i10, mutableComplex2);
                mutableComplex.subtractInto(mutableComplex2, complexVector, i11);
            }
        }
    }

    private static void fft3(ComplexVector complexVector, ComplexVector complexVector2, ComplexVector complexVector3, int i, double d) {
        double dSqrt = Math.sqrt(3.0d) * ((double) i) * (-0.5d);
        for (int i2 = 0; i2 < complexVector.length; i2++) {
            double dReal = complexVector.real(i2) + complexVector2.real(i2) + complexVector3.real(i2);
            double dImag = complexVector.imag(i2) + complexVector2.imag(i2) + complexVector3.imag(i2);
            double dImag2 = (complexVector3.imag(i2) - complexVector2.imag(i2)) * dSqrt;
            double dReal2 = (complexVector2.real(i2) - complexVector3.real(i2)) * dSqrt;
            double dReal3 = (complexVector2.real(i2) + complexVector3.real(i2)) * 0.5d;
            double dImag3 = (complexVector2.imag(i2) + complexVector3.imag(i2)) * 0.5d;
            double dReal4 = (complexVector.real(i2) - dReal3) + dImag2;
            double dImag4 = (complexVector.imag(i2) + dReal2) - dImag3;
            double dReal5 = (complexVector.real(i2) - dReal3) - dImag2;
            double dImag5 = (complexVector.imag(i2) - dReal2) - dImag3;
            complexVector.real(i2, dReal * d);
            complexVector.imag(i2, dImag * d);
            complexVector2.real(i2, dReal4 * d);
            complexVector2.imag(i2, dImag4 * d);
            complexVector3.real(i2, dReal5 * d);
            complexVector3.imag(i2, dImag5 * d);
        }
    }

    private static void fftMixedRadix(ComplexVector complexVector, ComplexVector[] complexVectorArr, ComplexVector complexVector2) {
        int i = complexVector.length / 3;
        ComplexVector complexVector3 = new ComplexVector(complexVector, 0, i);
        int i2 = i * 2;
        ComplexVector complexVector4 = new ComplexVector(complexVector, i, i2);
        ComplexVector complexVector5 = new ComplexVector(complexVector, i2, complexVector.length);
        fft3(complexVector3, complexVector4, complexVector5, 1, 1.0d);
        MutableComplex mutableComplex = new MutableComplex();
        for (int i3 = 0; i3 < complexVector.length / 4; i3++) {
            mutableComplex.set(complexVector2, i3);
            complexVector4.multiplyConjugate(i3, mutableComplex);
            complexVector5.multiplyConjugate(i3, mutableComplex);
            complexVector5.multiplyConjugate(i3, mutableComplex);
        }
        for (int i4 = complexVector.length / 4; i4 < i; i4++) {
            mutableComplex.set(complexVector2, i4 - (complexVector.length / 4));
            complexVector4.multiplyConjugateTimesI(i4, mutableComplex);
            complexVector5.multiplyConjugateTimesI(i4, mutableComplex);
            complexVector5.multiplyConjugateTimesI(i4, mutableComplex);
        }
        fft(complexVector3, complexVectorArr);
        fft(complexVector4, complexVectorArr);
        fft(complexVector5, complexVectorArr);
    }

    public static BigInteger fromFftVector(ComplexVector complexVector, int i, int i2) {
        long j = i2;
        int iMin = (int) Math.min(complexVector.length, (2147483648L / j) + 1);
        int i3 = (int) ((((((long) iMin) * j) + 31) * 8) / 32);
        byte[] bArr = new byte[i3];
        int i4 = 1;
        int i5 = (1 << i2) - 1;
        int i6 = 32 - i2;
        int i7 = (i3 * 8) - i2;
        int i8 = 0;
        int i9 = i3 - 4;
        int iMin2 = Math.min(Math.max(0, i7 >> 3), i9);
        long j2 = 0;
        int i10 = 0;
        int i11 = 0;
        while (i10 <= i4) {
            int i12 = i8;
            while (i12 < iMin) {
                long jRound = Math.round(complexVector.part(i12, i10)) + j2;
                int iMin3 = Math.min(Math.max(i8, i7 >> 3), i9);
                i11 = (i11 >>> ((iMin2 - iMin3) << 3)) | ((int) ((jRound & ((long) i5)) << ((i6 - i7) + (iMin3 << 3))));
                FastDoubleSwar.writeIntBE(bArr, iMin3, i11);
                i7 -= i2;
                i12++;
                iMin2 = iMin3;
                j2 = jRound >> i2;
                i8 = 0;
            }
            i10++;
            i4 = 1;
            i8 = 0;
        }
        return new BigInteger(i, bArr);
    }

    private static ComplexVector[] getRootsOfUnity2(int i) {
        ComplexVector[] complexVectorArr = new ComplexVector[i + 1];
        while (i >= 0) {
            if (i < 20) {
                if (ROOTS2_CACHE[i] == null) {
                    ROOTS2_CACHE[i] = calculateRootsOfUnity(1 << i);
                }
                complexVectorArr[i] = ROOTS2_CACHE[i];
            } else {
                complexVectorArr[i] = calculateRootsOfUnity(1 << i);
            }
            i -= 2;
        }
        return complexVectorArr;
    }

    private static ComplexVector getRootsOfUnity3(int i) {
        if (i >= 20) {
            return calculateRootsOfUnity(3 << i);
        }
        if (ROOTS3_CACHE[i] == null) {
            ROOTS3_CACHE[i] = calculateRootsOfUnity(3 << i);
        }
        return ROOTS3_CACHE[i];
    }

    private static void ifft(ComplexVector complexVector, ComplexVector[] complexVectorArr) {
        int i;
        int i2;
        int i3 = complexVector.length;
        int iNumberOfLeadingZeros = 31 - Integer.numberOfLeadingZeros(i3);
        MutableComplex mutableComplex = new MutableComplex();
        MutableComplex mutableComplex2 = new MutableComplex();
        MutableComplex mutableComplex3 = new MutableComplex();
        MutableComplex mutableComplex4 = new MutableComplex();
        MutableComplex mutableComplex5 = new MutableComplex();
        MutableComplex mutableComplex6 = new MutableComplex();
        MutableComplex mutableComplex7 = new MutableComplex();
        MutableComplex mutableComplex8 = new MutableComplex();
        if (iNumberOfLeadingZeros % 2 != 0) {
            for (int i4 = 0; i4 < i3; i4 += 2) {
                int i5 = i4 + 1;
                complexVector.copyInto(i5, mutableComplex3);
                complexVector.copyInto(i4, mutableComplex);
                complexVector.add(i4, mutableComplex3);
                mutableComplex.subtractInto(mutableComplex3, complexVector, i5);
            }
            i = 2;
        } else {
            i = 1;
        }
        MutableComplex mutableComplex9 = new MutableComplex();
        MutableComplex mutableComplex10 = new MutableComplex();
        while (i <= iNumberOfLeadingZeros) {
            ComplexVector complexVector2 = complexVectorArr[i - 1];
            int i6 = 1 << (i + 1);
            int i7 = i;
            int i8 = 0;
            while (i8 < i3) {
                int i9 = i8;
                int i10 = 0;
                while (true) {
                    i2 = iNumberOfLeadingZeros;
                    int i11 = i6 / 4;
                    if (i10 < i11) {
                        mutableComplex9.set(complexVector2, i10);
                        mutableComplex9.squareInto(mutableComplex10);
                        int i12 = i9 + i10;
                        int i13 = i10;
                        int i14 = i12 + i11;
                        ComplexVector complexVector3 = complexVector2;
                        int i15 = (i6 / 2) + i12;
                        int i16 = i3;
                        int iM$1 = Fragment$$ExternalSyntheticOutline1.m$1(i6, 3, 4, i12);
                        complexVector.copyInto(i12, mutableComplex);
                        complexVector.multiplyInto(i14, mutableComplex9, mutableComplex2);
                        complexVector.multiplyInto(i15, mutableComplex10, mutableComplex3);
                        complexVector.multiplyConjugateInto(iM$1, mutableComplex9, mutableComplex4);
                        mutableComplex.addInto(mutableComplex2, mutableComplex5);
                        mutableComplex5.add(mutableComplex3);
                        mutableComplex5.add(mutableComplex4);
                        mutableComplex.addTimesIInto(mutableComplex2, mutableComplex6);
                        mutableComplex6.subtract(mutableComplex3);
                        mutableComplex6.subtractTimesI(mutableComplex4);
                        mutableComplex.subtractInto(mutableComplex2, mutableComplex7);
                        mutableComplex7.add(mutableComplex3);
                        mutableComplex7.subtract(mutableComplex4);
                        mutableComplex8 = mutableComplex8;
                        mutableComplex.subtractTimesIInto(mutableComplex2, mutableComplex8);
                        mutableComplex8.subtract(mutableComplex3);
                        mutableComplex8.addTimesI(mutableComplex4);
                        mutableComplex5.copyInto(complexVector, i12);
                        mutableComplex6.copyInto(complexVector, i14);
                        mutableComplex7.copyInto(complexVector, i15);
                        mutableComplex8.copyInto(complexVector, iM$1);
                        i10 = i13 + 1;
                        iNumberOfLeadingZeros = i2;
                        i3 = i16;
                        complexVector2 = complexVector3;
                    }
                }
                i8 = i9 + i6;
                iNumberOfLeadingZeros = i2;
            }
            i = i7 + 2;
        }
        int i17 = iNumberOfLeadingZeros;
        for (int i18 = 0; i18 < i3; i18++) {
            complexVector.timesTwoToThe(i18, -i17);
        }
    }

    private static void ifftMixedRadix(ComplexVector complexVector, ComplexVector[] complexVectorArr, ComplexVector complexVector2) {
        int i = complexVector.length / 3;
        ComplexVector complexVector3 = new ComplexVector(complexVector, 0, i);
        int i2 = i * 2;
        ComplexVector complexVector4 = new ComplexVector(complexVector, i, i2);
        ComplexVector complexVector5 = new ComplexVector(complexVector, i2, complexVector.length);
        ifft(complexVector3, complexVectorArr);
        ifft(complexVector4, complexVectorArr);
        ifft(complexVector5, complexVectorArr);
        MutableComplex mutableComplex = new MutableComplex();
        for (int i3 = 0; i3 < complexVector.length / 4; i3++) {
            mutableComplex.set(complexVector2, i3);
            complexVector4.multiply(i3, mutableComplex);
            complexVector5.multiply(i3, mutableComplex);
            complexVector5.multiply(i3, mutableComplex);
        }
        for (int i4 = complexVector.length / 4; i4 < i; i4++) {
            mutableComplex.set(complexVector2, i4 - (complexVector.length / 4));
            complexVector4.multiplyByIAnd(i4, mutableComplex);
            complexVector5.multiplyByIAnd(i4, mutableComplex);
            complexVector5.multiplyByIAnd(i4, mutableComplex);
        }
        fft3(complexVector3, complexVector4, complexVector5, -1, 0.3333333333333333d);
    }

    public static BigInteger multiply(BigInteger bigInteger, BigInteger bigInteger2) {
        if (bigInteger2.signum() == 0 || bigInteger.signum() == 0) {
            return BigInteger.ZERO;
        }
        if (bigInteger2 == bigInteger) {
            return square(bigInteger2);
        }
        int iBitLength = bigInteger.bitLength();
        int iBitLength2 = bigInteger2.bitLength();
        if (((long) iBitLength) + ((long) iBitLength2) <= 2147483648L) {
            return (iBitLength <= 1920 || iBitLength2 <= 1920 || (iBitLength <= 33220 && iBitLength2 <= 33220)) ? bigInteger.multiply(bigInteger2) : multiplyFft(bigInteger, bigInteger2);
        }
        throw new ArithmeticException("BigInteger would overflow supported range");
    }

    public static BigInteger multiplyFft(BigInteger bigInteger, BigInteger bigInteger2) {
        int iSignum = bigInteger2.signum() * bigInteger.signum();
        if (bigInteger.signum() < 0) {
            bigInteger = bigInteger.negate();
        }
        byte[] byteArray = bigInteger.toByteArray();
        if (bigInteger2.signum() < 0) {
            bigInteger2 = bigInteger2.negate();
        }
        byte[] byteArray2 = bigInteger2.toByteArray();
        int iMax = Math.max(byteArray.length, byteArray2.length) * 8;
        int iBitsPerFftPoint = bitsPerFftPoint(iMax);
        int i = ((iMax + iBitsPerFftPoint) - 1) / iBitsPerFftPoint;
        int i2 = i + 1;
        int iNumberOfLeadingZeros = Integer.numberOfLeadingZeros(i);
        int i3 = 32 - iNumberOfLeadingZeros;
        int i4 = 1 << i3;
        int i5 = (i4 * 3) / 4;
        if (i2 >= i5 || i3 <= 3) {
            ComplexVector[] rootsOfUnity2 = getRootsOfUnity2(i3);
            ComplexVector fftVector = toFftVector(byteArray, i4, iBitsPerFftPoint);
            fftVector.applyWeights(rootsOfUnity2[i3]);
            fft(fftVector, rootsOfUnity2);
            ComplexVector fftVector2 = toFftVector(byteArray2, i4, iBitsPerFftPoint);
            fftVector2.applyWeights(rootsOfUnity2[i3]);
            fft(fftVector2, rootsOfUnity2);
            fftVector.multiplyPointwise(fftVector2);
            ifft(fftVector, rootsOfUnity2);
            fftVector.applyInverseWeights(rootsOfUnity2[i3]);
            return fromFftVector(fftVector, iSignum, iBitsPerFftPoint);
        }
        int i6 = 30 - iNumberOfLeadingZeros;
        ComplexVector[] rootsOfUnity22 = getRootsOfUnity2(i6);
        ComplexVector rootsOfUnity3 = getRootsOfUnity3(i6);
        ComplexVector rootsOfUnity32 = getRootsOfUnity3(28 - iNumberOfLeadingZeros);
        ComplexVector fftVector3 = toFftVector(byteArray, i5, iBitsPerFftPoint);
        fftVector3.applyWeights(rootsOfUnity3);
        fftMixedRadix(fftVector3, rootsOfUnity22, rootsOfUnity32);
        ComplexVector fftVector4 = toFftVector(byteArray2, i5, iBitsPerFftPoint);
        fftVector4.applyWeights(rootsOfUnity3);
        fftMixedRadix(fftVector4, rootsOfUnity22, rootsOfUnity32);
        fftVector3.multiplyPointwise(fftVector4);
        ifftMixedRadix(fftVector3, rootsOfUnity22, rootsOfUnity32);
        fftVector3.applyInverseWeights(rootsOfUnity3);
        return fromFftVector(fftVector3, iSignum, iBitsPerFftPoint);
    }

    public static BigInteger square(BigInteger bigInteger) {
        return bigInteger.signum() == 0 ? BigInteger.ZERO : bigInteger.bitLength() < 33220 ? bigInteger.multiply(bigInteger) : squareFft(bigInteger);
    }

    public static BigInteger squareFft(BigInteger bigInteger) {
        byte[] byteArray = bigInteger.toByteArray();
        int length = byteArray.length * 8;
        int iBitsPerFftPoint = bitsPerFftPoint(length);
        int i = ((length + iBitsPerFftPoint) - 1) / iBitsPerFftPoint;
        int i2 = i + 1;
        int iNumberOfLeadingZeros = Integer.numberOfLeadingZeros(i);
        int i3 = 32 - iNumberOfLeadingZeros;
        int i4 = 1 << i3;
        int i5 = (i4 * 3) / 4;
        if (i2 >= i5) {
            ComplexVector fftVector = toFftVector(byteArray, i4, iBitsPerFftPoint);
            ComplexVector[] rootsOfUnity2 = getRootsOfUnity2(i3);
            fftVector.applyWeights(rootsOfUnity2[i3]);
            fft(fftVector, rootsOfUnity2);
            fftVector.squarePointwise();
            ifft(fftVector, rootsOfUnity2);
            fftVector.applyInverseWeights(rootsOfUnity2[i3]);
            return fromFftVector(fftVector, 1, iBitsPerFftPoint);
        }
        ComplexVector fftVector2 = toFftVector(byteArray, i5, iBitsPerFftPoint);
        int i6 = 30 - iNumberOfLeadingZeros;
        ComplexVector[] rootsOfUnity22 = getRootsOfUnity2(i6);
        ComplexVector rootsOfUnity3 = getRootsOfUnity3(i6);
        ComplexVector rootsOfUnity32 = getRootsOfUnity3(28 - iNumberOfLeadingZeros);
        fftVector2.applyWeights(rootsOfUnity3);
        fftMixedRadix(fftVector2, rootsOfUnity22, rootsOfUnity32);
        fftVector2.squarePointwise();
        ifftMixedRadix(fftVector2, rootsOfUnity22, rootsOfUnity32);
        fftVector2.applyInverseWeights(rootsOfUnity3);
        return fromFftVector(fftVector2, 1, iBitsPerFftPoint);
    }

    public static ComplexVector toFftVector(byte[] bArr, int i, int i2) {
        ComplexVector complexVector = new ComplexVector(i);
        if (bArr.length < 4) {
            byte[] bArr2 = new byte[4];
            System.arraycopy(bArr, 0, bArr2, 4 - bArr.length, bArr.length);
            bArr = bArr2;
        }
        int i3 = 1 << i2;
        int i4 = i3 / 2;
        int i5 = i3 - 1;
        int i6 = 32 - i2;
        int length = (bArr.length * 8) - i2;
        int intBE = 0;
        int i7 = 0;
        while (length > (-i2)) {
            int iMin = Math.min(Math.max(0, length >> 3), bArr.length - 4);
            intBE = (i4 - (((FastDoubleSwar.readIntBE(bArr, iMin) >>> ((i6 - length) + (iMin << 3))) & i5) + intBE)) >>> 31;
            complexVector.real(i7, r9 - ((-intBE) & i3));
            i7++;
            length -= i2;
        }
        if (intBE > 0) {
            complexVector.real(i7, intBE);
        }
        return complexVector;
    }

    public static final class ComplexVector {
        private final double[] a;
        private final int length;
        private final int offset;

        public ComplexVector(int i) {
            this.a = new double[i << 1];
            this.length = i;
            this.offset = 0;
        }

        private int imagIdx(int i) {
            return (i << 1) + this.offset + 1;
        }

        private int realIdx(int i) {
            return (i << 1) + this.offset;
        }

        public void add(int i, MutableComplex mutableComplex) {
            double[] dArr = this.a;
            int iRealIdx = realIdx(i);
            dArr[iRealIdx] = dArr[iRealIdx] + mutableComplex.real;
            double[] dArr2 = this.a;
            int iImagIdx = imagIdx(i);
            dArr2[iImagIdx] = dArr2[iImagIdx] + mutableComplex.imag;
        }

        public void addInto(int i, ComplexVector complexVector, int i2, MutableComplex mutableComplex) {
            mutableComplex.real = this.a[realIdx(i)] + complexVector.real(i2);
            mutableComplex.imag = this.a[imagIdx(i)] + complexVector.imag(i2);
        }

        public void addTimesIInto(int i, ComplexVector complexVector, int i2, MutableComplex mutableComplex) {
            mutableComplex.real = this.a[realIdx(i)] - complexVector.imag(i2);
            mutableComplex.imag = this.a[imagIdx(i)] + complexVector.real(i2);
        }

        public void applyInverseWeights(ComplexVector complexVector) {
            int i = complexVector.offset;
            double[] dArr = complexVector.a;
            int i2 = this.offset;
            int i3 = (this.length + i2) << 1;
            while (i2 < i3) {
                double[] dArr2 = this.a;
                double d = dArr2[i2];
                int i4 = i2 + 1;
                double d2 = dArr2[i4];
                int i5 = i + 1;
                dArr2[i2] = FastDoubleSwar.fma(d, dArr[i], dArr[i5] * d2);
                this.a[i4] = FastDoubleSwar.fma(-d, dArr[i5], d2 * dArr[i]);
                i += 2;
                i2 += 2;
            }
        }

        public void applyWeights(ComplexVector complexVector) {
            int i = complexVector.offset;
            double[] dArr = complexVector.a;
            int i2 = this.offset;
            int i3 = (this.length + i2) << 1;
            while (i2 < i3) {
                double[] dArr2 = this.a;
                double d = dArr2[i2];
                dArr2[i2] = dArr[i] * d;
                dArr2[i2 + 1] = d * dArr[i + 1];
                i += 2;
                i2 += 2;
            }
        }

        public void copyInto(int i, MutableComplex mutableComplex) {
            mutableComplex.real = this.a[realIdx(i)];
            mutableComplex.imag = this.a[imagIdx(i)];
        }

        public double imag(int i) {
            return this.a[(i << 1) + this.offset + 1];
        }

        public void multiply(int i, MutableComplex mutableComplex) {
            int iRealIdx = realIdx(i);
            int iImagIdx = imagIdx(i);
            double[] dArr = this.a;
            double d = dArr[iRealIdx];
            double d2 = dArr[iImagIdx];
            dArr[iRealIdx] = FastDoubleSwar.fma(d, mutableComplex.real, (-d2) * mutableComplex.imag);
            this.a[iImagIdx] = FastDoubleSwar.fma(d, mutableComplex.imag, d2 * mutableComplex.real);
        }

        public void multiplyByIAnd(int i, MutableComplex mutableComplex) {
            int iRealIdx = realIdx(i);
            int iImagIdx = imagIdx(i);
            double[] dArr = this.a;
            double d = dArr[iRealIdx];
            double d2 = -dArr[iImagIdx];
            dArr[iRealIdx] = FastDoubleSwar.fma(-d, mutableComplex.imag, mutableComplex.real * d2);
            this.a[iImagIdx] = FastDoubleSwar.fma(d, mutableComplex.real, mutableComplex.imag * d2);
        }

        public void multiplyConjugate(int i, MutableComplex mutableComplex) {
            int iRealIdx = realIdx(i);
            int iImagIdx = imagIdx(i);
            double[] dArr = this.a;
            double d = dArr[iRealIdx];
            double d2 = dArr[iImagIdx];
            dArr[iRealIdx] = FastDoubleSwar.fma(d, mutableComplex.real, mutableComplex.imag * d2);
            this.a[iImagIdx] = FastDoubleSwar.fma(-d, mutableComplex.imag, d2 * mutableComplex.real);
        }

        public void multiplyConjugateInto(int i, MutableComplex mutableComplex, MutableComplex mutableComplex2) {
            double d = this.a[realIdx(i)];
            double d2 = this.a[imagIdx(i)];
            mutableComplex2.real = FastDoubleSwar.fma(d, mutableComplex.real, d2 * mutableComplex.imag);
            mutableComplex2.imag = FastDoubleSwar.fma(-d, mutableComplex.imag, d2 * mutableComplex.real);
        }

        public void multiplyConjugateTimesI(int i, MutableComplex mutableComplex) {
            int iRealIdx = realIdx(i);
            int iImagIdx = imagIdx(i);
            double[] dArr = this.a;
            double d = dArr[iRealIdx];
            double d2 = dArr[iImagIdx];
            double d3 = -d;
            dArr[iRealIdx] = FastDoubleSwar.fma(d3, mutableComplex.imag, d2 * mutableComplex.real);
            this.a[iImagIdx] = FastDoubleSwar.fma(d3, mutableComplex.real, (-d2) * mutableComplex.imag);
        }

        public void multiplyInto(int i, MutableComplex mutableComplex, MutableComplex mutableComplex2) {
            double d = this.a[realIdx(i)];
            double d2 = this.a[imagIdx(i)];
            mutableComplex2.real = FastDoubleSwar.fma(d, mutableComplex.real, mutableComplex.imag * (-d2));
            mutableComplex2.imag = FastDoubleSwar.fma(d, mutableComplex.imag, d2 * mutableComplex.real);
        }

        public void multiplyPointwise(ComplexVector complexVector) {
            int i = complexVector.offset;
            double[] dArr = complexVector.a;
            int i2 = this.offset;
            int i3 = (this.length + i2) << 1;
            while (i2 < i3) {
                double[] dArr2 = this.a;
                double d = dArr2[i2];
                int i4 = i2 + 1;
                double d2 = dArr2[i4];
                double d3 = dArr[i];
                double d4 = dArr[i + 1];
                dArr2[i2] = FastDoubleSwar.fma(d, d3, (-d2) * d4);
                this.a[i4] = FastDoubleSwar.fma(d, d4, d2 * d3);
                i += 2;
                i2 += 2;
            }
        }

        public double part(int i, int i2) {
            return this.a[(i << 1) + i2];
        }

        public double real(int i) {
            return this.a[(i << 1) + this.offset];
        }

        public void set(int i, double d, double d2) {
            int iRealIdx = realIdx(i);
            double[] dArr = this.a;
            dArr[iRealIdx] = d;
            dArr[iRealIdx + 1] = d2;
        }

        public void squarePointwise() {
            int i = this.offset;
            int i2 = (this.length + i) << 1;
            while (i < i2) {
                double[] dArr = this.a;
                double d = dArr[i];
                int i3 = i + 1;
                double d2 = dArr[i3];
                dArr[i] = FastDoubleSwar.fma(d, d, (-d2) * d2);
                this.a[i3] = d * 2.0d * d2;
                i += 2;
            }
        }

        public void subtractInto(int i, ComplexVector complexVector, int i2, MutableComplex mutableComplex) {
            mutableComplex.real = this.a[realIdx(i)] - complexVector.real(i2);
            mutableComplex.imag = this.a[imagIdx(i)] - complexVector.imag(i2);
        }

        public void subtractTimesIInto(int i, ComplexVector complexVector, int i2, MutableComplex mutableComplex) {
            mutableComplex.real = this.a[realIdx(i)] + complexVector.imag(i2);
            mutableComplex.imag = this.a[imagIdx(i)] - complexVector.real(i2);
        }

        public void timesTwoToThe(int i, int i2) {
            int iRealIdx = realIdx(i);
            int iImagIdx = imagIdx(i);
            double[] dArr = this.a;
            double d = dArr[iRealIdx];
            double d2 = dArr[iImagIdx];
            long j = i2;
            dArr[iRealIdx] = FastDoubleMath.fastScalb(d, j);
            this.a[iImagIdx] = FastDoubleMath.fastScalb(d2, j);
        }

        public void real(int i, double d) {
            this.a[(i << 1) + this.offset] = d;
        }

        public void imag(int i, double d) {
            this.a[(i << 1) + this.offset + 1] = d;
        }

        public ComplexVector(ComplexVector complexVector, int i, int i2) {
            this.length = i2 - i;
            this.a = complexVector.a;
            this.offset = i << 1;
        }
    }

    public static final class MutableComplex {
        double imag;
        double real;

        public void add(ComplexVector complexVector, int i) {
            this.real += complexVector.real(i);
            this.imag += complexVector.imag(i);
        }

        public void addInto(MutableComplex mutableComplex, MutableComplex mutableComplex2) {
            mutableComplex2.real = this.real + mutableComplex.real;
            mutableComplex2.imag = this.imag + mutableComplex.imag;
        }

        public void addTimesI(ComplexVector complexVector, int i) {
            this.real -= complexVector.imag(i);
            this.imag += complexVector.real(i);
        }

        public void addTimesIInto(MutableComplex mutableComplex, MutableComplex mutableComplex2) {
            mutableComplex2.real = this.real - mutableComplex.imag;
            mutableComplex2.imag = this.imag + mutableComplex.real;
        }

        public void copyInto(ComplexVector complexVector, int i) {
            complexVector.real(i, this.real);
            complexVector.imag(i, this.imag);
        }

        public void multiply(MutableComplex mutableComplex) {
            double d = this.real;
            this.real = FastDoubleSwar.fma(d, mutableComplex.real, (-this.imag) * mutableComplex.imag);
            this.imag = FastDoubleSwar.fma(d, mutableComplex.imag, this.imag * mutableComplex.real);
        }

        public void multiplyConjugate(MutableComplex mutableComplex) {
            double d = this.real;
            this.real = FastDoubleSwar.fma(d, mutableComplex.real, this.imag * mutableComplex.imag);
            this.imag = FastDoubleSwar.fma(-d, mutableComplex.imag, this.imag * mutableComplex.real);
        }

        public void set(ComplexVector complexVector, int i) {
            this.real = complexVector.real(i);
            this.imag = complexVector.imag(i);
        }

        public void squareInto(MutableComplex mutableComplex) {
            double d = this.real;
            double d2 = this.imag;
            mutableComplex.real = FastDoubleSwar.fma(d, d, (-d2) * d2);
            mutableComplex.imag = this.real * 2.0d * this.imag;
        }

        public void subtract(ComplexVector complexVector, int i) {
            this.real -= complexVector.real(i);
            this.imag -= complexVector.imag(i);
        }

        public void subtractInto(MutableComplex mutableComplex, ComplexVector complexVector, int i) {
            complexVector.real(i, this.real - mutableComplex.real);
            complexVector.imag(i, this.imag - mutableComplex.imag);
        }

        public void subtractTimesI(ComplexVector complexVector, int i) {
            this.real += complexVector.imag(i);
            this.imag -= complexVector.real(i);
        }

        public void subtractTimesIInto(MutableComplex mutableComplex, MutableComplex mutableComplex2) {
            mutableComplex2.real = this.real + mutableComplex.imag;
            mutableComplex2.imag = this.imag - mutableComplex.real;
        }

        public void subtractInto(MutableComplex mutableComplex, MutableComplex mutableComplex2) {
            mutableComplex2.real = this.real - mutableComplex.real;
            mutableComplex2.imag = this.imag - mutableComplex.imag;
        }

        public void add(MutableComplex mutableComplex) {
            this.real += mutableComplex.real;
            this.imag += mutableComplex.imag;
        }

        public void addTimesI(MutableComplex mutableComplex) {
            this.real -= mutableComplex.imag;
            this.imag += mutableComplex.real;
        }

        public void subtract(MutableComplex mutableComplex) {
            this.real -= mutableComplex.real;
            this.imag -= mutableComplex.imag;
        }

        public void subtractTimesI(MutableComplex mutableComplex) {
            this.real += mutableComplex.imag;
            this.imag -= mutableComplex.real;
        }
    }
}
