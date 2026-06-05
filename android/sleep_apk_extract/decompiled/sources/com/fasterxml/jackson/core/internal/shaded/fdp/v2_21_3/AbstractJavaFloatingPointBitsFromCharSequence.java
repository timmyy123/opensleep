package com.fasterxml.jackson.core.internal.shaded.fdp.v2_21_3;

import com.fasterxml.jackson.core.JsonFactory;

/* JADX INFO: loaded from: classes.dex */
abstract class AbstractJavaFloatingPointBitsFromCharSequence extends AbstractFloatValueParser {
    private long parseDecFloatLiteral(CharSequence charSequence, int i, int i2, int i3, boolean z) {
        int i4;
        int i5;
        int i6;
        boolean z2;
        int i7;
        char c;
        int i8;
        int i9;
        long j;
        boolean z3;
        int i10;
        int i11;
        char cCharAt;
        CharSequence charSequence2 = charSequence;
        int i12 = i;
        int i13 = -1;
        int i14 = i12;
        long j2 = 0;
        boolean z4 = false;
        char cCharAt2 = 0;
        while (true) {
            if (i14 >= i3) {
                break;
            }
            cCharAt2 = charSequence2.charAt(i14);
            char c2 = (char) (cCharAt2 - '0');
            if (c2 >= '\n') {
                if (cCharAt2 != '.') {
                    break;
                }
                z4 |= i13 >= 0;
                i13 = i14 - i12;
            } else {
                j2 = (j2 * 10) + ((long) c2);
            }
            i14++;
        }
        if (i13 < 0) {
            i6 = i14 - i12;
            i5 = i6;
            i4 = 0;
        } else {
            int i15 = (i14 - i12) - 1;
            i4 = i13 - i15;
            i5 = i13;
            i6 = i15;
        }
        boolean z5 = z4 | (i6 == 0 && i14 > i12);
        if ((cCharAt2 | ' ') == 101) {
            i7 = i14 + 1;
            char cCharAt3 = AbstractNumberParser.charAt(charSequence2, i7, i3);
            boolean z6 = cCharAt3 == '-';
            if (z6 || cCharAt3 == '+') {
                i7 = i14 + 2;
                cCharAt3 = AbstractNumberParser.charAt(charSequence2, i7, i3);
            }
            char c3 = (char) (cCharAt3 - '0');
            boolean z7 = (c3 >= '\n') | z5;
            z2 = true;
            int i16 = 0;
            while (true) {
                if (i16 < 1024) {
                    i16 = (i16 * 10) + c3;
                }
                i7++;
                cCharAt = AbstractNumberParser.charAt(charSequence2, i7, i3);
                char c4 = (char) (cCharAt - '0');
                if (c4 >= '\n') {
                    break;
                }
                c3 = c4;
            }
            if (z6) {
                i16 = -i16;
            }
            i4 += i16;
            c = cCharAt;
            i8 = i16;
            z5 = z7;
        } else {
            z2 = true;
            i7 = i14;
            c = cCharAt2;
            i8 = 0;
        }
        if (!z5 && i6 == 0) {
            return parseNaNOrInfinity(charSequence2, i7, i3, z);
        }
        int i17 = i5;
        if ((c | JsonFactory.DEFAULT_QUOTE_CHAR) == 102) {
            i7++;
        }
        int iSkipWhitespace = skipWhitespace(charSequence2, i7, i3);
        if (z5 || iSkipWhitespace < i3) {
            return 9221120237041090561L;
        }
        if (i6 > 19) {
            int i18 = 0;
            long j3 = 0;
            while (true) {
                if (i12 >= i14) {
                    i11 = i18;
                    break;
                }
                char cCharAt4 = (char) (charSequence2.charAt(i12) - '0');
                if (cCharAt4 < '\n') {
                    i11 = i18;
                    if (Long.compare(j3 ^ Long.MIN_VALUE, -8223372036854775808L) >= 0) {
                        break;
                    }
                    j3 = (j3 * 10) + ((long) cCharAt4);
                    i18 = i11 + 1;
                }
                i12++;
                charSequence2 = charSequence;
            }
            boolean z8 = i12 < i14 ? z2 : false;
            i10 = (i17 - i11) + i8;
            i9 = i4;
            z3 = z8;
            j = j3;
        } else {
            i9 = i4;
            j = j2;
            z3 = false;
            i10 = 0;
        }
        return valueOfFloatLiteral(charSequence, i2, i3, z, j, i9, z3, i10);
    }

    private long parseHexFloatLiteral(CharSequence charSequence, int i, int i2, int i3, boolean z) {
        char c;
        int i4;
        int iMin;
        char c2;
        int i5;
        int i6;
        int i7;
        long j;
        int i8;
        boolean z2;
        char cCharAt;
        int i9 = -1;
        int i10 = i;
        long j2 = 0;
        char cCharAt2 = 0;
        boolean z3 = false;
        while (true) {
            c = 4;
            if (i10 >= i3) {
                break;
            }
            cCharAt2 = charSequence.charAt(i10);
            int iLookupHex = AbstractNumberParser.lookupHex(cCharAt2);
            if (iLookupHex < 0) {
                if (iLookupHex != -4) {
                    break;
                }
                z3 |= i9 >= 0;
                int i11 = i10;
                while (i11 < i3 - 8) {
                    long jTryToParseEightHexDigits = FastDoubleSwar.tryToParseEightHexDigits(charSequence, i11 + 1);
                    if (jTryToParseEightHexDigits < 0) {
                        break;
                    }
                    j2 = (j2 << 32) + jTryToParseEightHexDigits;
                    i11 += 8;
                }
                int i12 = i10;
                i10 = i11;
                i9 = i12;
            } else {
                j2 = (j2 << 4) | ((long) iLookupHex);
            }
            i10++;
        }
        if (i9 < 0) {
            i4 = i10 - i;
            i9 = i10;
            iMin = 0;
        } else {
            i4 = (i10 - i) - 1;
            iMin = Math.min((i9 - i10) + 1, 1024) * 4;
        }
        boolean z4 = (cCharAt2 | ' ') == 112;
        if (z4) {
            i5 = i10 + 1;
            char cCharAt3 = AbstractNumberParser.charAt(charSequence, i5, i3);
            boolean z5 = cCharAt3 == '-';
            if (z5 || cCharAt3 == '+') {
                i5 = i10 + 2;
                cCharAt3 = AbstractNumberParser.charAt(charSequence, i5, i3);
            }
            char c3 = (char) (cCharAt3 - '0');
            boolean z6 = z3 | (c3 >= '\n');
            int i13 = 0;
            while (true) {
                if (i13 < 1024) {
                    i13 = (i13 * 10) + c3;
                }
                i5++;
                cCharAt = AbstractNumberParser.charAt(charSequence, i5, i3);
                c2 = c;
                char c4 = (char) (cCharAt - '0');
                if (c4 >= '\n') {
                    break;
                }
                c3 = c4;
                c = c2;
            }
            if (z5) {
                i13 = -i13;
            }
            iMin += i13;
            cCharAt2 = cCharAt;
            i6 = i13;
            z3 = z6;
        } else {
            c2 = 4;
            i5 = i10;
            i6 = 0;
        }
        if ((cCharAt2 | JsonFactory.DEFAULT_QUOTE_CHAR) == 102) {
            i5++;
        }
        int iSkipWhitespace = skipWhitespace(charSequence, i5, i3);
        if (z3 || iSkipWhitespace < i3 || i4 == 0 || !z4) {
            return 9221120237041090561L;
        }
        if (i4 > 16) {
            int i14 = i;
            int i15 = 0;
            long j3 = 0;
            while (i14 < i10) {
                int iLookupHex2 = AbstractNumberParser.lookupHex(charSequence.charAt(i14));
                if (iLookupHex2 < 0) {
                    i15++;
                } else {
                    if (Long.compare(j3 ^ Long.MIN_VALUE, -8223372036854775808L) >= 0) {
                        break;
                    }
                    j3 = (j3 << c2) | ((long) iLookupHex2);
                }
                i14++;
            }
            boolean z7 = i14 < i10;
            int i16 = i15;
            iSkipWhitespace = i14;
            i8 = i16;
            i7 = i6;
            z2 = z7;
            j = j3;
        } else {
            i7 = i6;
            j = j2;
            i8 = 0;
            z2 = false;
        }
        return valueOfHexLiteral(charSequence, i2, i3, z, j, iMin, z2, (((i9 - iSkipWhitespace) + i8) * 4) + i7);
    }

    private long parseNaNOrInfinity(CharSequence charSequence, int i, int i2, boolean z) {
        if (i >= i2) {
            return 9221120237041090561L;
        }
        if (charSequence.charAt(i) == 'N') {
            int i3 = i + 2;
            if (i3 < i2 && charSequence.charAt(i + 1) == 'a' && charSequence.charAt(i3) == 'N' && skipWhitespace(charSequence, i + 3, i2) == i2) {
                return nan();
            }
            return 9221120237041090561L;
        }
        int i4 = i + 7;
        if (i4 < i2 && charSequence.charAt(i) == 'I' && charSequence.charAt(i + 1) == 'n' && charSequence.charAt(i + 2) == 'f' && charSequence.charAt(i + 3) == 'i' && charSequence.charAt(i + 4) == 'n' && charSequence.charAt(i + 5) == 'i' && charSequence.charAt(i + 6) == 't' && charSequence.charAt(i4) == 'y' && skipWhitespace(charSequence, i + 8, i2) == i2) {
            return z ? negativeInfinity() : positiveInfinity();
        }
        return 9221120237041090561L;
    }

    private static int skipWhitespace(CharSequence charSequence, int i, int i2) {
        while (i < i2 && charSequence.charAt(i) <= ' ') {
            i++;
        }
        return i;
    }

    public abstract long nan();

    public abstract long negativeInfinity();

    public final long parseFloatingPointLiteral(CharSequence charSequence, int i, int i2) {
        int iCheckBounds = AbstractNumberParser.checkBounds(charSequence.length(), i, i2);
        int iSkipWhitespace = skipWhitespace(charSequence, i, iCheckBounds);
        if (iSkipWhitespace == iCheckBounds) {
            return 9221120237041090561L;
        }
        char cCharAt = charSequence.charAt(iSkipWhitespace);
        boolean z = cCharAt == '-';
        if ((z || cCharAt == '+') && (cCharAt = AbstractNumberParser.charAt(charSequence, (iSkipWhitespace = iSkipWhitespace + 1), iCheckBounds)) == 0) {
            return 9221120237041090561L;
        }
        int i3 = iSkipWhitespace;
        return (cCharAt == '0' && (AbstractNumberParser.charAt(charSequence, i3 + 1, iCheckBounds) | ' ') == 120) ? parseHexFloatLiteral(charSequence, i3 + 2, i, iCheckBounds, z) : parseDecFloatLiteral(charSequence, i3, i, iCheckBounds, z);
    }

    public abstract long positiveInfinity();

    public abstract long valueOfFloatLiteral(CharSequence charSequence, int i, int i2, boolean z, long j, int i3, boolean z2, int i4);

    public abstract long valueOfHexLiteral(CharSequence charSequence, int i, int i2, boolean z, long j, int i3, boolean z2, int i4);
}
