package com.urbandroid.util;

import com.facebook.appevents.AppEventsConstants;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes4.dex */
public abstract class DecimalFormatUtil {
    public static DecimalFormat getLong() {
        return new DecimalFormat("0.000");
    }

    public static DecimalFormat getShort() {
        return new DecimalFormat("0.0");
    }

    public static DecimalFormat getZeroDigit() {
        return new DecimalFormat(AppEventsConstants.EVENT_PARAM_VALUE_NO);
    }
}
