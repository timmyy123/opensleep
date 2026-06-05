package com.fasterxml.jackson.core.internal.shaded.fdp.v2_21_3;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes.dex */
final class JavaBigIntegerFromCharSequence extends AbstractBigIntegerParser {
    private BigInteger parseDecDigits(CharSequence charSequence, int i, int i2, boolean z) {
        int i3 = i2 - i;
        if (AbstractBigIntegerParser.hasManyDigits(i3)) {
            return parseManyDecDigits(charSequence, i, i2, z);
        }
        int i4 = (i3 & 7) + i;
        long jTryToParseUpTo7Digits = FastDoubleSwar.tryToParseUpTo7Digits(charSequence, i, i4);
        boolean z2 = jTryToParseUpTo7Digits >= 0;
        while (i4 < i2) {
            int iTryToParseEightDigits = FastDoubleSwar.tryToParseEightDigits(charSequence, i4);
            z2 &= iTryToParseEightDigits >= 0;
            jTryToParseUpTo7Digits = (jTryToParseUpTo7Digits * 100000000) + ((long) iTryToParseEightDigits);
            i4 += 8;
        }
        if (!z2) {
            throw new NumberFormatException("illegal syntax");
        }
        if (z) {
            jTryToParseUpTo7Digits = -jTryToParseUpTo7Digits;
        }
        return BigInteger.valueOf(jTryToParseUpTo7Digits);
    }

    private BigInteger parseHexDigits(CharSequence charSequence, int i, int i2, boolean z) {
        int i3;
        boolean z2;
        int iSkipZeroes = skipZeroes(charSequence, i, i2);
        int i4 = i2 - iSkipZeroes;
        if (i4 <= 0) {
            return BigInteger.ZERO;
        }
        AbstractBigIntegerParser.checkHexBigIntegerBounds(i4);
        byte[] bArr = new byte[((i4 + 1) >> 1) + 1];
        if ((i4 & 1) != 0) {
            int i5 = iSkipZeroes + 1;
            int iLookupHex = AbstractNumberParser.lookupHex(charSequence.charAt(iSkipZeroes));
            bArr[1] = (byte) iLookupHex;
            i3 = 2;
            z2 = iLookupHex < 0;
            iSkipZeroes = i5;
        } else {
            i3 = 1;
            z2 = false;
        }
        int i6 = ((i2 - iSkipZeroes) & 7) + iSkipZeroes;
        while (iSkipZeroes < i6) {
            char cCharAt = charSequence.charAt(iSkipZeroes);
            char cCharAt2 = charSequence.charAt(iSkipZeroes + 1);
            int iLookupHex2 = AbstractNumberParser.lookupHex(cCharAt);
            int iLookupHex3 = AbstractNumberParser.lookupHex(cCharAt2);
            int i7 = i3 + 1;
            bArr[i3] = (byte) ((iLookupHex2 << 4) | iLookupHex3);
            z2 |= iLookupHex3 < 0 || iLookupHex2 < 0;
            iSkipZeroes += 2;
            i3 = i7;
        }
        while (iSkipZeroes < i2) {
            long jTryToParseEightHexDigits = FastDoubleSwar.tryToParseEightHexDigits(charSequence, iSkipZeroes);
            FastDoubleSwar.writeIntBE(bArr, i3, (int) jTryToParseEightHexDigits);
            z2 |= jTryToParseEightHexDigits < 0;
            iSkipZeroes += 8;
            i3 += 4;
        }
        if (z2) {
            throw new NumberFormatException("illegal syntax");
        }
        BigInteger bigInteger = new BigInteger(bArr);
        return z ? bigInteger.negate() : bigInteger;
    }

    private BigInteger parseManyDecDigits(CharSequence charSequence, int i, int i2, boolean z) {
        int iSkipZeroes = skipZeroes(charSequence, i, i2);
        AbstractBigIntegerParser.checkDecBigIntegerBounds(i2 - iSkipZeroes);
        BigInteger digitsRecursive = ParseDigitsTaskCharSequence.parseDigitsRecursive(charSequence, iSkipZeroes, i2, FastIntegerMath.fillPowersOf10Floor16(iSkipZeroes, i2), 400);
        return z ? digitsRecursive.negate() : digitsRecursive;
    }

    private int skipZeroes(CharSequence charSequence, int i, int i2) {
        while (i < i2 && charSequence.charAt(i) == '0') {
            i++;
        }
        return i;
    }

    public BigInteger parseBigIntegerString(CharSequence charSequence, int i, int i2, int i3) {
        int i4;
        try {
            int iCheckBounds = AbstractNumberParser.checkBounds(charSequence.length(), i, i2);
            char cCharAt = charSequence.charAt(i);
            boolean z = cCharAt == '-';
            if (z || cCharAt == '+') {
                i4 = i + 1;
                if (AbstractNumberParser.charAt(charSequence, i4, iCheckBounds) == 0) {
                    throw new NumberFormatException("illegal syntax");
                }
            } else {
                i4 = i;
            }
            return i3 != 10 ? i3 != 16 ? new BigInteger(charSequence.subSequence(i, i2).toString(), i3) : parseHexDigits(charSequence, i4, iCheckBounds, z) : parseDecDigits(charSequence, i4, iCheckBounds, z);
        } catch (ArithmeticException e) {
            NumberFormatException numberFormatException = new NumberFormatException("value exceeds limits");
            numberFormatException.initCause(e);
            throw numberFormatException;
        }
    }
}
