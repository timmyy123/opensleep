package com.fasterxml.jackson.core.internal.shaded.fdp.v2_21_3;

import com.fasterxml.jackson.core.JsonFactory;

/* JADX INFO: loaded from: classes.dex */
abstract class AbstractJavaFloatingPointBitsFromCharArray extends AbstractFloatValueParser {
    private long parseDecFloatLiteral(char[] cArr, int i, int i2, int i3, boolean z) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        long j;
        boolean z2;
        int i10;
        int i11;
        char[] cArr2 = cArr;
        int i12 = i;
        int iMin = Math.min(i3 - 4, 1073741824);
        int i13 = -1;
        int i14 = i12;
        long j2 = 0;
        boolean z3 = false;
        char cCharAt = 0;
        while (true) {
            if (i14 >= i3) {
                break;
            }
            cCharAt = cArr2[i14];
            char c = (char) (cCharAt - '0');
            if (c >= '\n') {
                if (cCharAt != '.') {
                    break;
                }
                z3 |= i13 >= 0;
                int i15 = i14 - i12;
                while (i14 < iMin) {
                    int iTryToParseFourDigits = FastDoubleSwar.tryToParseFourDigits(cArr2, i14 + 1);
                    if (iTryToParseFourDigits < 0) {
                        break;
                    }
                    j2 = (j2 * 10000) + ((long) iTryToParseFourDigits);
                    i14 += 4;
                }
                i13 = i15;
            } else {
                j2 = (j2 * 10) + ((long) c);
            }
            i14++;
        }
        if (i13 < 0) {
            i5 = i14 - i12;
            i6 = i5;
            i4 = 0;
        } else {
            int i16 = (i14 - i12) - 1;
            i4 = i13 - i16;
            int i17 = i13;
            i5 = i16;
            i6 = i17;
        }
        boolean z4 = (i5 == 0 && i14 > i12) | z3;
        if ((cCharAt | ' ') == 101) {
            int i18 = i14 + 1;
            char cCharAt2 = AbstractNumberParser.charAt(cArr2, i18, i3);
            boolean z5 = cCharAt2 == '-';
            if (z5 || cCharAt2 == '+') {
                i18 = i14 + 2;
                cCharAt2 = AbstractNumberParser.charAt(cArr2, i18, i3);
            }
            char c2 = (char) (cCharAt2 - '0');
            boolean z6 = z4 | (c2 >= '\n');
            int i19 = 0;
            do {
                if (i19 < 1024) {
                    i19 = (i19 * 10) + c2;
                }
                i18++;
                cCharAt = AbstractNumberParser.charAt(cArr2, i18, i3);
                c2 = (char) (cCharAt - '0');
            } while (c2 < '\n');
            if (z5) {
                i19 = -i19;
            }
            i8 = i18;
            i7 = i4 + i19;
            i9 = i19;
            z4 = z6;
        } else {
            i7 = i4;
            i8 = i14;
            i9 = 0;
        }
        if (!z4 && i5 == 0) {
            return parseNaNOrInfinity(cArr2, i8, i3, z);
        }
        int i20 = i9;
        if ((cCharAt | JsonFactory.DEFAULT_QUOTE_CHAR) == 102) {
            i8++;
        }
        int iSkipWhitespace = skipWhitespace(cArr2, i8, i3);
        if (z4 || iSkipWhitespace < i3) {
            return 9221120237041090561L;
        }
        if (i5 > 19) {
            int i21 = 0;
            long j3 = 0;
            while (true) {
                if (i12 >= i14) {
                    i11 = i6;
                    break;
                }
                char c3 = (char) (cArr2[i12] - '0');
                if (c3 < '\n') {
                    i11 = i6;
                    if (Long.compare(j3 ^ Long.MIN_VALUE, -8223372036854775808L) >= 0) {
                        break;
                    }
                    j3 = (j3 * 10) + ((long) c3);
                    i21++;
                } else {
                    i11 = i6;
                }
                i12++;
                cArr2 = cArr;
                i6 = i11;
            }
            i10 = (i11 - i21) + i20;
            z2 = i12 < i14;
            j = j3;
        } else {
            j = j2;
            z2 = false;
            i10 = 0;
        }
        return valueOfFloatLiteral(cArr, i2, i3, z, j, i7, z2, i10);
    }

    private long parseHexFloatLiteral(char[] cArr, int i, int i2, int i3, boolean z) {
        int i4;
        int iMin;
        char c;
        boolean z2;
        int i5;
        int i6;
        long j;
        boolean z3;
        int i7;
        int i8 = -1;
        int i9 = i;
        long j2 = 0;
        char cCharAt = 0;
        boolean z4 = false;
        while (i9 < i3) {
            cCharAt = cArr[i9];
            int iLookupHex = AbstractNumberParser.lookupHex(cCharAt);
            if (iLookupHex < 0) {
                if (iLookupHex != -4) {
                    break;
                }
                z4 |= i8 >= 0;
                int i10 = i9;
                while (i10 < i3 - 8) {
                    long jTryToParseEightHexDigits = tryToParseEightHexDigits(cArr, i10 + 1);
                    if (jTryToParseEightHexDigits < 0) {
                        break;
                    }
                    j2 = (j2 << 32) + jTryToParseEightHexDigits;
                    i10 += 8;
                }
                int i11 = i9;
                i9 = i10;
                i8 = i11;
            } else {
                j2 = (j2 << 4) | ((long) iLookupHex);
            }
            i9++;
        }
        int i12 = 1024;
        if (i8 < 0) {
            i4 = i9 - i;
            i8 = i9;
            iMin = 0;
        } else {
            i4 = (i9 - i) - 1;
            iMin = Math.min((i8 - i9) + 1, 1024) * 4;
        }
        boolean z5 = (cCharAt | ' ') == 112;
        if (z5) {
            i5 = i9 + 1;
            char cCharAt2 = AbstractNumberParser.charAt(cArr, i5, i3);
            c = 4;
            boolean z6 = cCharAt2 == '-';
            z2 = true;
            if (z6 || cCharAt2 == '+') {
                i5 = i9 + 2;
                cCharAt2 = AbstractNumberParser.charAt(cArr, i5, i3);
            }
            char c2 = (char) (cCharAt2 - '0');
            boolean z7 = z4 | (c2 >= '\n');
            int i13 = 0;
            while (true) {
                if (i13 < i12) {
                    i13 = (i13 * 10) + c2;
                }
                i5++;
                cCharAt = AbstractNumberParser.charAt(cArr, i5, i3);
                char c3 = (char) (cCharAt - '0');
                if (c3 >= '\n') {
                    break;
                }
                c2 = c3;
                i12 = 1024;
            }
            if (z6) {
                i13 = -i13;
            }
            iMin += i13;
            i6 = i13;
            z4 = z7;
        } else {
            c = 4;
            z2 = true;
            i5 = i9;
            i6 = 0;
        }
        if ((cCharAt | JsonFactory.DEFAULT_QUOTE_CHAR) == 102) {
            i5++;
        }
        int iSkipWhitespace = skipWhitespace(cArr, i5, i3);
        if (z4 || iSkipWhitespace < i3 || i4 == 0 || !z5) {
            return 9221120237041090561L;
        }
        if (i4 > 16) {
            int i14 = i;
            int i15 = 0;
            j = 0;
            while (i14 < i9) {
                int iLookupHex2 = AbstractNumberParser.lookupHex(cArr[i14]);
                if (iLookupHex2 < 0) {
                    i15++;
                } else {
                    if (Long.compare(j ^ Long.MIN_VALUE, -8223372036854775808L) >= 0) {
                        break;
                    }
                    j = (j << c) | ((long) iLookupHex2);
                }
                i14++;
            }
            z3 = i14 < i9 ? z2 : false;
            i7 = i15;
            iSkipWhitespace = i14;
        } else {
            j = j2;
            z3 = false;
            i7 = 0;
        }
        return valueOfHexLiteral(cArr, i2, i3, z, j, iMin, z3, (((i8 - iSkipWhitespace) + i7) * 4) + i6);
    }

    private long parseNaNOrInfinity(char[] cArr, int i, int i2, boolean z) {
        if (i >= i2) {
            return 9221120237041090561L;
        }
        char c = cArr[i];
        if (c == 'N') {
            int i3 = i + 2;
            if (i3 < i2 && cArr[i + 1] == 'a' && cArr[i3] == 'N' && skipWhitespace(cArr, i + 3, i2) == i2) {
                return nan();
            }
            return 9221120237041090561L;
        }
        int i4 = i + 7;
        if (i4 < i2 && c == 'I' && cArr[i + 1] == 'n' && cArr[i + 2] == 'f' && cArr[i + 3] == 'i' && cArr[i + 4] == 'n' && cArr[i + 5] == 'i' && cArr[i + 6] == 't' && cArr[i4] == 'y' && skipWhitespace(cArr, i + 8, i2) == i2) {
            return z ? negativeInfinity() : positiveInfinity();
        }
        return 9221120237041090561L;
    }

    private static int skipWhitespace(char[] cArr, int i, int i2) {
        while (i < i2 && cArr[i] <= ' ') {
            i++;
        }
        return i;
    }

    private long tryToParseEightHexDigits(char[] cArr, int i) {
        return FastDoubleSwar.tryToParseEightHexDigits(cArr, i);
    }

    public abstract long nan();

    public abstract long negativeInfinity();

    public long parseFloatingPointLiteral(char[] cArr, int i, int i2) {
        int iCheckBounds = AbstractNumberParser.checkBounds(cArr.length, i, i2);
        int iSkipWhitespace = skipWhitespace(cArr, i, iCheckBounds);
        if (iSkipWhitespace == iCheckBounds) {
            return 9221120237041090561L;
        }
        char cCharAt = cArr[iSkipWhitespace];
        boolean z = cCharAt == '-';
        if ((z || cCharAt == '+') && (cCharAt = AbstractNumberParser.charAt(cArr, (iSkipWhitespace = iSkipWhitespace + 1), iCheckBounds)) == 0) {
            return 9221120237041090561L;
        }
        int i3 = iSkipWhitespace;
        return (cCharAt == '0' && (AbstractNumberParser.charAt(cArr, i3 + 1, iCheckBounds) | ' ') == 120) ? parseHexFloatLiteral(cArr, i3 + 2, i, iCheckBounds, z) : parseDecFloatLiteral(cArr, i3, i, iCheckBounds, z);
    }

    public abstract long positiveInfinity();

    public abstract long valueOfFloatLiteral(char[] cArr, int i, int i2, boolean z, long j, int i3, boolean z2, int i4);

    public abstract long valueOfHexLiteral(char[] cArr, int i, int i2, boolean z, long j, int i3, boolean z2, int i4);
}
