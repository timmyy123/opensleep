package com.fasterxml.jackson.core.internal.shaded.fdp.v2_21_3;

/* JADX INFO: loaded from: classes.dex */
abstract class AbstractBigDecimalParser extends AbstractNumberParser {
    public static void checkParsedBigDecimalBounds(boolean z, int i, int i2, int i3, long j) {
        if (z || i < i2) {
            throw new NumberFormatException("illegal syntax");
        }
        if (j <= -2147483648L || j > 2147483647L || i3 > 646456993) {
            throw new NumberFormatException("value exceeds limits");
        }
    }

    public static boolean hasManyDigits(int i) {
        return i >= 32;
    }
}
