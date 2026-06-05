package com.fasterxml.jackson.core.internal.shaded.fdp.v2_21_3;

/* JADX INFO: loaded from: classes.dex */
public abstract class JavaDoubleParser {
    private static final JavaDoubleBitsFromByteArray BYTE_ARRAY_PARSER = new JavaDoubleBitsFromByteArray();
    private static final JavaDoubleBitsFromCharArray CHAR_ARRAY_PARSER = new JavaDoubleBitsFromCharArray();
    private static final JavaDoubleBitsFromCharSequence CHAR_SEQUENCE_PARSER = new JavaDoubleBitsFromCharSequence();

    public static double parseDouble(CharSequence charSequence, int i, int i2) {
        long floatingPointLiteral = CHAR_SEQUENCE_PARSER.parseFloatingPointLiteral(charSequence, i, i2);
        if (floatingPointLiteral != 9221120237041090561L) {
            return Double.longBitsToDouble(floatingPointLiteral);
        }
        throw new NumberFormatException("illegal syntax");
    }

    public static double parseDouble(CharSequence charSequence) {
        return parseDouble(charSequence, 0, charSequence.length());
    }

    public static double parseDouble(char[] cArr, int i, int i2) {
        long floatingPointLiteral = CHAR_ARRAY_PARSER.parseFloatingPointLiteral(cArr, i, i2);
        if (floatingPointLiteral != 9221120237041090561L) {
            return Double.longBitsToDouble(floatingPointLiteral);
        }
        throw new NumberFormatException("illegal syntax");
    }
}
