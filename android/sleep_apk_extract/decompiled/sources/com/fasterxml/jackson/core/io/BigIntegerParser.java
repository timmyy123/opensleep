package com.fasterxml.jackson.core.io;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.fasterxml.jackson.core.internal.shaded.fdp.v2_21_3.JavaBigIntegerParser;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes.dex */
public abstract class BigIntegerParser {
    public static BigInteger parseWithFastParser(String str) {
        try {
            return JavaBigIntegerParser.parseBigInteger(str);
        } catch (NumberFormatException e) {
            if (str.length() > 1000) {
                str = str.substring(0, 1000).concat(" [truncated]");
            }
            StringBuilder sbM5m = FileInsert$$ExternalSyntheticOutline0.m5m("Value \"", str, "\" can not be represented as `java.math.BigInteger`, reason: ");
            sbM5m.append(e.getMessage());
            throw new NumberFormatException(sbM5m.toString());
        }
    }
}
