package org.apache.commons.math3.linear;

import java.text.FieldPosition;
import java.text.NumberFormat;
import java.util.Locale;
import org.apache.commons.math3.util.CompositeFormat;

/* JADX INFO: loaded from: classes5.dex */
public class RealMatrixFormat {
    private final String columnSeparator;
    private final NumberFormat format;
    private final String prefix;
    private final String rowPrefix;
    private final String rowSeparator;
    private final String rowSuffix;
    private final String suffix;

    public RealMatrixFormat(String str, String str2, String str3, String str4, String str5, String str6, NumberFormat numberFormat) {
        this.prefix = str;
        this.suffix = str2;
        this.rowPrefix = str3;
        this.rowSuffix = str4;
        this.rowSeparator = str5;
        this.columnSeparator = str6;
        this.format = numberFormat;
        numberFormat.setGroupingUsed(false);
    }

    public static RealMatrixFormat getInstance(Locale locale) {
        return new RealMatrixFormat(CompositeFormat.getDefaultNumberFormat(locale));
    }

    public StringBuffer format(RealMatrix realMatrix, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        fieldPosition.setBeginIndex(0);
        fieldPosition.setEndIndex(0);
        stringBuffer.append(this.prefix);
        int rowDimension = realMatrix.getRowDimension();
        for (int i = 0; i < rowDimension; i++) {
            stringBuffer.append(this.rowPrefix);
            for (int i2 = 0; i2 < realMatrix.getColumnDimension(); i2++) {
                if (i2 > 0) {
                    stringBuffer.append(this.columnSeparator);
                }
                CompositeFormat.formatDouble(realMatrix.getEntry(i, i2), this.format, stringBuffer, fieldPosition);
            }
            stringBuffer.append(this.rowSuffix);
            if (i < rowDimension - 1) {
                stringBuffer.append(this.rowSeparator);
            }
        }
        stringBuffer.append(this.suffix);
        return stringBuffer;
    }

    public NumberFormat getFormat() {
        return this.format;
    }

    public static RealMatrixFormat getInstance() {
        return getInstance(Locale.getDefault());
    }

    public RealMatrixFormat(String str, String str2, String str3, String str4, String str5, String str6) {
        this(str, str2, str3, str4, str5, str6, CompositeFormat.getDefaultNumberFormat());
    }

    public RealMatrixFormat(NumberFormat numberFormat) {
        this("{", "}", "{", "}", ",", ",", numberFormat);
    }

    public String format(RealMatrix realMatrix) {
        return format(realMatrix, new StringBuffer(), new FieldPosition(0)).toString();
    }
}
