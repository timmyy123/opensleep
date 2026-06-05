package com.fasterxml.jackson.core.io.schubfach;

/* JADX INFO: loaded from: classes.dex */
public final class DoubleToDecimal {
    public final int MAX_CHARS = 24;
    private final byte[] bytes = new byte[24];
    private int index;

    private DoubleToDecimal() {
    }

    private void append(int i) {
        byte[] bArr = this.bytes;
        int i2 = this.index + 1;
        this.index = i2;
        bArr[i2] = (byte) i;
    }

    private void append8Digits(int i) {
        int iY = y(i);
        for (int i2 = 0; i2 < 8; i2++) {
            int i3 = iY * 10;
            appendDigit(i3 >>> 28);
            iY = i3 & 268435455;
        }
    }

    private void appendDigit(int i) {
        byte[] bArr = this.bytes;
        int i2 = this.index + 1;
        this.index = i2;
        bArr[i2] = (byte) (i + 48);
    }

    private String charsToString() {
        return new String(this.bytes, 0, 0, this.index + 1);
    }

    private void exponent(int i) {
        append(69);
        if (i < 0) {
            append(45);
            i = -i;
        }
        if (i < 10) {
            appendDigit(i);
            return;
        }
        if (i >= 100) {
            int i2 = (i * 1311) >>> 17;
            appendDigit(i2);
            i -= i2 * 100;
        }
        int i3 = (i * 103) >>> 10;
        appendDigit(i3);
        appendDigit(i - (i3 * 10));
    }

    private void lowDigits(int i) {
        if (i != 0) {
            append8Digits(i);
        }
        removeTrailingZeroes();
    }

    private void removeTrailingZeroes() {
        int i;
        byte b;
        while (true) {
            byte[] bArr = this.bytes;
            i = this.index;
            b = bArr[i];
            if (b != 48) {
                break;
            } else {
                this.index = i - 1;
            }
        }
        if (b == 46) {
            this.index = i + 1;
        }
    }

    private static long rop(long j, long j2, long j3) {
        long jMultiplyHigh = MathUtils.multiplyHigh(j2, j3);
        long j4 = j * j3;
        long jMultiplyHigh2 = MathUtils.multiplyHigh(j, j3);
        long j5 = (j4 >>> 1) + jMultiplyHigh;
        return (jMultiplyHigh2 + (j5 >>> 63)) | (((j5 & Long.MAX_VALUE) + Long.MAX_VALUE) >>> 63);
    }

    private int toChars(long j, int i) {
        int iFlog10pow2 = MathUtils.flog10pow2(64 - Long.numberOfLeadingZeros(j));
        if (j >= MathUtils.pow10(iFlog10pow2)) {
            iFlog10pow2++;
        }
        long jPow10 = j * MathUtils.pow10(17 - iFlog10pow2);
        int i2 = i + iFlog10pow2;
        long jMultiplyHigh = MathUtils.multiplyHigh(jPow10, 193428131138340668L) >>> 20;
        int i3 = (int) (jPow10 - (100000000 * jMultiplyHigh));
        int i4 = (int) ((1441151881 * jMultiplyHigh) >>> 57);
        int i5 = (int) (jMultiplyHigh - ((long) (100000000 * i4)));
        return (i2 <= 0 || i2 > 7) ? (-3 >= i2 || i2 > 0) ? toChars3(i4, i5, i3, i2) : toChars2(i4, i5, i3, i2) : toChars1(i4, i5, i3, i2);
    }

    private int toChars1(int i, int i2, int i3, int i4) {
        appendDigit(i);
        int iY = y(i2);
        int i5 = 1;
        while (i5 < i4) {
            int i6 = iY * 10;
            appendDigit(i6 >>> 28);
            iY = i6 & 268435455;
            i5++;
        }
        append(46);
        while (i5 <= 8) {
            int i7 = iY * 10;
            appendDigit(i7 >>> 28);
            iY = i7 & 268435455;
            i5++;
        }
        lowDigits(i3);
        return 0;
    }

    private int toChars2(int i, int i2, int i3, int i4) {
        appendDigit(0);
        append(46);
        while (i4 < 0) {
            appendDigit(0);
            i4++;
        }
        appendDigit(i);
        append8Digits(i2);
        lowDigits(i3);
        return 0;
    }

    private int toChars3(int i, int i2, int i3, int i4) {
        appendDigit(i);
        append(46);
        append8Digits(i2);
        lowDigits(i3);
        exponent(i4 - 1);
        return 0;
    }

    private int toDecimal(int i, long j, int i2) {
        long j2;
        int iFlog10threeQuartersPow2;
        char c;
        long j3;
        int i3 = ((int) j) & 1;
        long j4 = j << 2;
        long j5 = j4 + 2;
        if ((j != 4503599627370496L) || (i == -1074)) {
            j2 = j4 - 2;
            iFlog10threeQuartersPow2 = MathUtils.flog10pow2(i);
        } else {
            j2 = j4 - 1;
            iFlog10threeQuartersPow2 = MathUtils.flog10threeQuartersPow2(i);
        }
        int iFlog2pow10 = i + MathUtils.flog2pow10(-iFlog10threeQuartersPow2) + 2;
        long jG1 = MathUtils.g1(iFlog10threeQuartersPow2);
        long jG0 = MathUtils.g0(iFlog10threeQuartersPow2);
        long jRop = rop(jG1, jG0, j4 << iFlog2pow10);
        long jRop2 = rop(jG1, jG0, j2 << iFlog2pow10);
        long jRop3 = rop(jG1, jG0, j5 << iFlog2pow10);
        long j6 = jRop >> 2;
        if (j6 >= 100) {
            j3 = 1;
            long jMultiplyHigh = MathUtils.multiplyHigh(j6, 1844674407370955168L) * 10;
            long j7 = jMultiplyHigh + 10;
            c = 1;
            int i4 = iFlog10threeQuartersPow2;
            long j8 = i3;
            boolean z = jRop2 + j8 <= (jMultiplyHigh << 2);
            if (z != ((j7 << 2) + j8 <= jRop3)) {
                if (!z) {
                    jMultiplyHigh = j7;
                }
                return toChars(jMultiplyHigh, i4);
            }
            iFlog10threeQuartersPow2 = i4;
        } else {
            c = 1;
            j3 = 1;
        }
        long j9 = j6 + j3;
        long j10 = i3;
        char c2 = jRop2 + j10 <= (j6 << 2) ? c : (char) 0;
        if (c2 != ((j9 << 2) + j10 <= jRop3 ? c : (char) 0)) {
            if (c2 == 0) {
                j6 = j9;
            }
            return toChars(j6, iFlog10threeQuartersPow2 + i2);
        }
        long j11 = jRop - ((j6 + j9) << c);
        if (j11 >= 0 && (j11 != 0 || (j6 & j3) != 0)) {
            j6 = j9;
        }
        return toChars(j6, iFlog10threeQuartersPow2 + i2);
    }

    private String toDecimalString(double d) {
        int decimal = toDecimal(d);
        return decimal != 0 ? decimal != 1 ? decimal != 2 ? decimal != 3 ? decimal != 4 ? "NaN" : "-Infinity" : "Infinity" : "-0.0" : "0.0" : charsToString();
    }

    public static String toString(double d) {
        return new DoubleToDecimal().toDecimalString(d);
    }

    private int y(int i) {
        return ((int) (MathUtils.multiplyHigh(((long) (i + 1)) << 28, 193428131138340668L) >>> 20)) - 1;
    }

    private int toDecimal(double d) {
        long jDoubleToRawLongBits = Double.doubleToRawLongBits(d);
        long j = 4503599627370495L & jDoubleToRawLongBits;
        int i = ((int) (jDoubleToRawLongBits >>> 52)) & 2047;
        if (i >= 2047) {
            if (j != 0) {
                return 5;
            }
            return jDoubleToRawLongBits > 0 ? 3 : 4;
        }
        this.index = -1;
        if (jDoubleToRawLongBits < 0) {
            append(45);
        }
        if (i == 0) {
            if (j == 0) {
                return jDoubleToRawLongBits == 0 ? 1 : 2;
            }
            if (j < 3) {
                return toDecimal(-1074, j * 10, -1);
            }
            return toDecimal(-1074, j, 0);
        }
        int i2 = 1075 - i;
        long j2 = j | 4503599627370496L;
        if ((i2 < 53) & (i2 > 0)) {
            long j3 = j2 >> i2;
            if ((j3 << i2) == j2) {
                return toChars(j3, 0);
            }
        }
        return toDecimal(-i2, j2, 0);
    }
}
