package com.urbandroid.common.util;

import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes4.dex */
public abstract class DecimalUtil {
    public static String formatAlways2Decimal(float f) {
        return new DecimalFormat("0.00").format(f);
    }
}
