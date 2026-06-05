package com.urbandroid.util;

import android.content.Context;
import com.urbandroid.sleep.service.Settings;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/* JADX INFO: loaded from: classes4.dex */
public abstract class TimeFormatUtil {
    public static DateFormat getTimeFormatWithoutAmPm(Context context) {
        return new SimpleDateFormat(new Settings(context).is24HourFormat() ? "H:mm" : "h:mm");
    }
}
