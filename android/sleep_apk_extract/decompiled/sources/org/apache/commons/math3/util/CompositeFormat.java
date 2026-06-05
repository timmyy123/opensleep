package org.apache.commons.math3.util;

import java.text.FieldPosition;
import java.text.NumberFormat;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public abstract class CompositeFormat {
    public static StringBuffer formatDouble(double d, NumberFormat numberFormat, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        if (!Double.isNaN(d) && !Double.isInfinite(d)) {
            numberFormat.format(d, stringBuffer, fieldPosition);
            return stringBuffer;
        }
        stringBuffer.append('(');
        stringBuffer.append(d);
        stringBuffer.append(')');
        return stringBuffer;
    }

    public static NumberFormat getDefaultNumberFormat(Locale locale) {
        NumberFormat numberFormat = NumberFormat.getInstance(locale);
        numberFormat.setMaximumFractionDigits(10);
        return numberFormat;
    }

    public static NumberFormat getDefaultNumberFormat() {
        return getDefaultNumberFormat(Locale.getDefault());
    }
}
