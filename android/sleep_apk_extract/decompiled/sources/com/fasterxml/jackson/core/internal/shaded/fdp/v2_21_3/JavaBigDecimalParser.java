package com.fasterxml.jackson.core.internal.shaded.fdp.v2_21_3;

import java.math.BigDecimal;

/* JADX INFO: loaded from: classes.dex */
public abstract class JavaBigDecimalParser {
    private static final JavaBigDecimalFromByteArray BYTE_ARRAY_PARSER = new JavaBigDecimalFromByteArray();
    private static final JavaBigDecimalFromCharArray CHAR_ARRAY_PARSER = new JavaBigDecimalFromCharArray();
    private static final JavaBigDecimalFromCharSequence CHAR_SEQUENCE_PARSER = new JavaBigDecimalFromCharSequence();

    public static BigDecimal parseBigDecimal(CharSequence charSequence) {
        return parseBigDecimal(charSequence, 0, charSequence.length());
    }

    public static BigDecimal parseBigDecimal(CharSequence charSequence, int i, int i2) {
        return CHAR_SEQUENCE_PARSER.parseBigDecimalString(charSequence, i, i2);
    }

    public static BigDecimal parseBigDecimal(char[] cArr, int i, int i2) {
        return CHAR_ARRAY_PARSER.parseBigDecimalString(cArr, i, i2);
    }
}
