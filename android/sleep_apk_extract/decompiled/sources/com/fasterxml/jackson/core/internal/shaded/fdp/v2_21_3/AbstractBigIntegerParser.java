package com.fasterxml.jackson.core.internal.shaded.fdp.v2_21_3;

/* JADX INFO: loaded from: classes.dex */
abstract class AbstractBigIntegerParser extends AbstractNumberParser {
    public static void checkDecBigIntegerBounds(int i) {
        if (i > 646456993) {
            throw new NumberFormatException("value exceeds limits");
        }
    }

    public static void checkHexBigIntegerBounds(int i) {
        if (i > 536870912) {
            throw new NumberFormatException("value exceeds limits");
        }
    }

    public static boolean hasManyDigits(int i) {
        return i > 18;
    }
}
