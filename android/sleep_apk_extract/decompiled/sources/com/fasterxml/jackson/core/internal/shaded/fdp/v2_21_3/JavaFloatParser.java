package com.fasterxml.jackson.core.internal.shaded.fdp.v2_21_3;

/* JADX INFO: loaded from: classes.dex */
public abstract class JavaFloatParser {
    private static final JavaFloatBitsFromByteArray BYTE_ARRAY_PARSER = new JavaFloatBitsFromByteArray();
    private static final JavaFloatBitsFromCharArray CHAR_ARRAY_PARSER = new JavaFloatBitsFromCharArray();
    private static final JavaFloatBitsFromCharSequence CHAR_SEQUENCE_PARSER = new JavaFloatBitsFromCharSequence();

    public static float parseFloat(CharSequence charSequence, int i, int i2) {
        long floatingPointLiteral = CHAR_SEQUENCE_PARSER.parseFloatingPointLiteral(charSequence, i, i2);
        if (floatingPointLiteral != 9221120237041090561L) {
            return Float.intBitsToFloat((int) floatingPointLiteral);
        }
        throw new NumberFormatException("illegal syntax");
    }

    public static float parseFloat(CharSequence charSequence) {
        return parseFloat(charSequence, 0, charSequence.length());
    }

    public static float parseFloat(char[] cArr, int i, int i2) {
        long floatingPointLiteral = CHAR_ARRAY_PARSER.parseFloatingPointLiteral(cArr, i, i2);
        if (floatingPointLiteral != 9221120237041090561L) {
            return Float.intBitsToFloat((int) floatingPointLiteral);
        }
        throw new NumberFormatException("illegal syntax");
    }
}
