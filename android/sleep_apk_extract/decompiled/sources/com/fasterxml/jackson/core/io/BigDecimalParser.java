package com.fasterxml.jackson.core.io;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.fasterxml.jackson.core.internal.shaded.fdp.v2_21_3.JavaBigDecimalParser;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes.dex */
public abstract class BigDecimalParser {
    private static String _generateExceptionMessage(String str, String str2) {
        return Fragment$$ExternalSyntheticOutline1.m("Value ", str, " can not be deserialized as `java.math.BigDecimal`, reason:  ", str2);
    }

    private static String _getValueDesc(char[] cArr, int i, int i2) {
        return i2 <= 1000 ? FileInsert$$ExternalSyntheticOutline0.m("\"", new String(cArr, i, i2), "\"") : String.format("\"%s\" (truncated to %d chars (from %d))", new String(cArr, i, 1000), 1000, Integer.valueOf(i2));
    }

    private static NumberFormatException _parseFailure(Exception exc, String str) {
        String message = exc.getMessage();
        if (message == null) {
            message = "Not a valid number representation";
        }
        return new NumberFormatException(_generateExceptionMessage(_getValueDesc(str), message));
    }

    public static BigDecimal parse(String str) {
        try {
            return str.length() < 500 ? new BigDecimal(str) : JavaBigDecimalParser.parseBigDecimal(str);
        } catch (ArithmeticException e) {
            e = e;
            throw _parseFailure(e, str);
        } catch (NumberFormatException e2) {
            e = e2;
            throw _parseFailure(e, str);
        }
    }

    public static BigDecimal parseWithFastParser(String str) {
        try {
            return JavaBigDecimalParser.parseBigDecimal(str);
        } catch (ArithmeticException | NumberFormatException e) {
            throw _parseFailure(e, str);
        }
    }

    public static BigDecimal parseWithFastParser(char[] cArr, int i, int i2) {
        try {
            return JavaBigDecimalParser.parseBigDecimal(cArr, i, i2);
        } catch (ArithmeticException | NumberFormatException e) {
            throw _parseFailure(e, cArr, i, i2);
        }
    }

    private static NumberFormatException _parseFailure(Exception exc, char[] cArr, int i, int i2) {
        String message = exc.getMessage();
        if (message == null) {
            message = "Not a valid number representation";
        }
        return new NumberFormatException(_generateExceptionMessage(_getValueDesc(cArr, i, i2), message));
    }

    public static BigDecimal parse(char[] cArr, int i, int i2) {
        try {
            if (i2 < 500) {
                return new BigDecimal(cArr, i, i2);
            }
            return JavaBigDecimalParser.parseBigDecimal(cArr, i, i2);
        } catch (ArithmeticException e) {
            e = e;
            throw _parseFailure(e, cArr, i, i2);
        } catch (NumberFormatException e2) {
            e = e2;
            throw _parseFailure(e, cArr, i, i2);
        }
    }

    public static BigDecimal parse(char[] cArr) {
        return parse(cArr, 0, cArr.length);
    }

    private static String _getValueDesc(String str) {
        int length = str.length();
        if (length <= 1000) {
            return FileInsert$$ExternalSyntheticOutline0.m("\"", str, "\"");
        }
        return String.format("\"%s\" (truncated to %d chars (from %d))", str.substring(0, 1000), 1000, Integer.valueOf(length));
    }
}
