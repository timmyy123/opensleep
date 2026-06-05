package com.fasterxml.jackson.core.internal.shaded.fdp.v2_21_3;

import java.math.BigInteger;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
abstract class ParseDigitsTaskCharArray {
    public static BigInteger parseDigitsIterative(char[] cArr, int i, int i2) {
        int i3 = i2 - i;
        BigSignificand bigSignificand = new BigSignificand(FastIntegerMath.estimateNumBits(i3));
        int i4 = (i3 & 7) + i;
        int iTryToParseUpTo7Digits = FastDoubleSwar.tryToParseUpTo7Digits(cArr, i, i4);
        boolean z = iTryToParseUpTo7Digits >= 0;
        bigSignificand.add(iTryToParseUpTo7Digits);
        while (i4 < i2) {
            int iTryToParseEightDigits = FastDoubleSwar.tryToParseEightDigits(cArr, i4);
            z &= iTryToParseEightDigits >= 0;
            bigSignificand.fma(100000000, iTryToParseEightDigits);
            i4 += 8;
        }
        if (z) {
            return bigSignificand.toBigInteger();
        }
        throw new NumberFormatException("illegal syntax");
    }

    public static BigInteger parseDigitsRecursive(char[] cArr, int i, int i2, Map<Integer, BigInteger> map, int i3) {
        if (i2 - i <= i3) {
            return parseDigitsIterative(cArr, i, i2);
        }
        int iSplitFloor16 = FastIntegerMath.splitFloor16(i, i2);
        return parseDigitsRecursive(cArr, iSplitFloor16, i2, map, i3).add(FftMultiplier.multiply(parseDigitsRecursive(cArr, i, iSplitFloor16, map, i3), map.get(Integer.valueOf(i2 - iSplitFloor16))));
    }
}
