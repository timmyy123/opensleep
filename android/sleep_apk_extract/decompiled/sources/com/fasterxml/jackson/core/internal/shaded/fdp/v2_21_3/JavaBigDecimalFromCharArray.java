package com.fasterxml.jackson.core.internal.shaded.fdp.v2_21_3;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.NavigableMap;

/* JADX INFO: loaded from: classes.dex */
final class JavaBigDecimalFromCharArray extends AbstractBigDecimalParser {
    public BigDecimal parseBigDecimalString(char[] cArr, int i, int i2) {
        boolean z;
        int i3;
        long j;
        int i4;
        int i5;
        long j2;
        int iTryToParseFourDigits;
        int i6 = i;
        try {
            int iCheckBounds = AbstractNumberParser.checkBounds(cArr.length, i6, i2);
            if (AbstractBigDecimalParser.hasManyDigits(i2)) {
                return parseBigDecimalStringWithManyDigits(cArr, i, i2);
            }
            char cCharAt = AbstractNumberParser.charAt(cArr, i6, iCheckBounds);
            boolean z2 = cCharAt == '-';
            if (z2 || cCharAt == '+') {
                i6++;
                cCharAt = AbstractNumberParser.charAt(cArr, i6, iCheckBounds);
                if (cCharAt == 0) {
                    throw new NumberFormatException("illegal syntax");
                }
            }
            char c = cCharAt;
            int i7 = i6;
            char c2 = c;
            int i8 = -1;
            int i9 = i7;
            long j3 = 0;
            boolean z3 = false;
            while (true) {
                if (i9 >= iCheckBounds) {
                    z = true;
                    break;
                }
                c2 = cArr[i9];
                z = true;
                char c3 = (char) (c2 - '0');
                if (c3 >= '\n') {
                    if (c2 != '.') {
                        break;
                    }
                    z3 |= i8 >= 0;
                    int i10 = i9;
                    while (i10 < iCheckBounds - 4 && (iTryToParseFourDigits = FastDoubleSwar.tryToParseFourDigits(cArr, i10 + 1)) >= 0) {
                        j3 = (j3 * 10000) + ((long) iTryToParseFourDigits);
                        i10 += 4;
                    }
                    i8 = i9;
                    i9 = i10;
                } else {
                    j3 = (j3 * 10) + ((long) c3);
                }
                i9++;
            }
            if (i8 < 0) {
                i3 = i9 - i7;
                i4 = i9;
                j = 0;
            } else {
                i3 = (i9 - i7) - 1;
                j = (i8 - i9) + 1;
                i4 = i8;
            }
            if ((c2 | ' ') == 101) {
                int i11 = i9 + 1;
                char cCharAt2 = AbstractNumberParser.charAt(cArr, i11, iCheckBounds);
                boolean z4 = cCharAt2 == '-' ? z : false;
                if (z4 || cCharAt2 == '+') {
                    i11 = i9 + 2;
                    cCharAt2 = AbstractNumberParser.charAt(cArr, i11, iCheckBounds);
                }
                char c4 = (char) (cCharAt2 - '0');
                z3 |= c4 >= '\n' ? z : false;
                long j4 = 0;
                while (true) {
                    if (j4 < 2147483647L) {
                        j4 = (j4 * 10) + ((long) c4);
                    }
                    j2 = j4;
                    i11++;
                    char cCharAt3 = (char) (AbstractNumberParser.charAt(cArr, i11, iCheckBounds) - '0');
                    if (cCharAt3 >= '\n') {
                        break;
                    }
                    j4 = j2;
                    c4 = cCharAt3;
                }
                if (z4) {
                    j2 = -j2;
                }
                j += j2;
                i5 = i11;
            } else {
                i5 = i9;
                i9 = iCheckBounds;
            }
            long j5 = j;
            if (i3 != 0) {
                z = false;
            }
            AbstractBigDecimalParser.checkParsedBigDecimalBounds(z3 | z, i5, iCheckBounds, i3, j5);
            if (i3 >= 19) {
                return valueOfBigDecimalString(cArr, i7, i4, i4 + 1, i9, z2, (int) j5);
            }
            if (z2) {
                j3 = -j3;
            }
            return new BigDecimal(j3).scaleByPowerOfTen((int) j5);
        } catch (ArithmeticException e) {
            NumberFormatException numberFormatException = new NumberFormatException("value exceeds limits");
            numberFormatException.initCause(e);
            throw numberFormatException;
        }
    }

    public BigDecimal parseBigDecimalStringWithManyDigits(char[] cArr, int i, int i2) {
        int i3;
        int i4;
        boolean z;
        int i5;
        long j;
        int i6;
        boolean z2;
        long j2;
        int i7;
        boolean z3;
        int i8;
        int i9 = i;
        int i10 = i9 + i2;
        char cCharAt = AbstractNumberParser.charAt(cArr, i9, i10);
        boolean z4 = cCharAt == '-';
        if ((z4 || cCharAt == '+') && (cCharAt = AbstractNumberParser.charAt(cArr, (i9 = i9 + 1), i10)) == 0) {
            throw new NumberFormatException("illegal syntax");
        }
        int iMin = Math.min(i10 - 8, 1073741824);
        int i11 = i9;
        while (i11 < iMin && FastDoubleSwar.isEightZeroes(cArr, i11)) {
            i11 += 8;
        }
        while (i11 < i10 && cArr[i11] == '0') {
            i11++;
        }
        int i12 = i11;
        while (i12 < iMin && FastDoubleSwar.isEightDigits(cArr, i12)) {
            i12 += 8;
        }
        while (i12 < i10) {
            cCharAt = cArr[i12];
            if (!FastDoubleSwar.isDigit(cCharAt)) {
                break;
            }
            i12++;
        }
        if (cCharAt == '.') {
            int i13 = i12 + 1;
            while (i13 < iMin && FastDoubleSwar.isEightZeroes(cArr, i13)) {
                i13 += 8;
            }
            while (i13 < i10 && cArr[i13] == '0') {
                i13++;
            }
            int i14 = i13;
            while (i14 < iMin && FastDoubleSwar.isEightDigits(cArr, i14)) {
                i14 += 8;
            }
            while (i14 < i10) {
                cCharAt = cArr[i14];
                if (!FastDoubleSwar.isDigit(cCharAt)) {
                    break;
                }
                i14++;
            }
            i4 = i13;
            i3 = i12;
            i12 = i14;
        } else {
            i3 = -1;
            i4 = -1;
        }
        long j3 = 0;
        if (i3 < 0) {
            z = true;
            i6 = i12 - i11;
            i4 = i12;
            i3 = i4;
            i5 = i3;
            j = 0;
        } else {
            z = true;
            i5 = i12;
            j = (i3 - i12) + 1;
            i6 = i11 == i3 ? i12 - i4 : (i12 - i11) - 1;
        }
        if ((cCharAt | ' ') == 101) {
            int i15 = i5 + 1;
            char cCharAt2 = AbstractNumberParser.charAt(cArr, i15, i10);
            boolean z5 = cCharAt2 == '-' ? z : false;
            if (z5 || cCharAt2 == '+') {
                i15 = i5 + 2;
                cCharAt2 = AbstractNumberParser.charAt(cArr, i15, i10);
            }
            char cCharAt3 = (char) (cCharAt2 - '0');
            z3 = cCharAt3 >= '\n' ? z : false;
            while (true) {
                if (j3 < 2147483647L) {
                    z2 = z4;
                    j3 = (j3 * 10) + ((long) cCharAt3);
                } else {
                    z2 = z4;
                }
                i15++;
                cCharAt3 = (char) (AbstractNumberParser.charAt(cArr, i15, i10) - '0');
                if (cCharAt3 >= '\n') {
                    break;
                }
                z4 = z2;
            }
            if (z5) {
                j3 = -j3;
            }
            i7 = i15;
            j2 = j + j3;
            i8 = i5;
        } else {
            z2 = z4;
            j2 = j;
            i7 = i5;
            z3 = false;
            i8 = i10;
        }
        AbstractBigDecimalParser.checkParsedBigDecimalBounds(z3 | ((i9 == i3 && i3 == i8) ? z : false), i7, i10, i6, j2);
        return valueOfBigDecimalString(cArr, i11, i3, i4, i8, z2, (int) j2);
    }

    public BigDecimal valueOfBigDecimalString(char[] cArr, int i, int i2, int i3, int i4, boolean z, int i5) {
        BigInteger bigIntegerNegate;
        BigInteger digitsIterative;
        int i6 = (i4 - i2) - 1;
        int i7 = i4 - i3;
        int i8 = i2 - i;
        NavigableMap<Integer, BigInteger> navigableMapCreatePowersOfTenFloor16Map = null;
        if (i8 <= 0) {
            bigIntegerNegate = BigInteger.ZERO;
        } else if (i8 > 400) {
            navigableMapCreatePowersOfTenFloor16Map = FastIntegerMath.createPowersOfTenFloor16Map();
            FastIntegerMath.fillPowersOfNFloor16Recursive(navigableMapCreatePowersOfTenFloor16Map, i, i2);
            bigIntegerNegate = ParseDigitsTaskCharArray.parseDigitsRecursive(cArr, i, i2, navigableMapCreatePowersOfTenFloor16Map, 400);
        } else {
            bigIntegerNegate = ParseDigitsTaskCharArray.parseDigitsIterative(cArr, i, i2);
        }
        if (i6 > 0) {
            if (i7 > 400) {
                if (navigableMapCreatePowersOfTenFloor16Map == null) {
                    navigableMapCreatePowersOfTenFloor16Map = FastIntegerMath.createPowersOfTenFloor16Map();
                }
                FastIntegerMath.fillPowersOfNFloor16Recursive(navigableMapCreatePowersOfTenFloor16Map, i3, i4);
                digitsIterative = ParseDigitsTaskCharArray.parseDigitsRecursive(cArr, i3, i4, navigableMapCreatePowersOfTenFloor16Map, 400);
            } else {
                digitsIterative = ParseDigitsTaskCharArray.parseDigitsIterative(cArr, i3, i4);
            }
            bigIntegerNegate = bigIntegerNegate.signum() == 0 ? digitsIterative : FftMultiplier.multiply(bigIntegerNegate, FastIntegerMath.computePowerOfTen(navigableMapCreatePowersOfTenFloor16Map, i6)).add(digitsIterative);
        }
        if (z) {
            bigIntegerNegate = bigIntegerNegate.negate();
        }
        return new BigDecimal(bigIntegerNegate, -i5);
    }
}
