package com.urbandroid.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes5.dex */
public abstract class DateUtils {
    public static String toReadableDate(Date date) {
        if (date == null) {
            return null;
        }
        return new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date);
    }

    public static String toReadableDate(long j) {
        return toReadableDate(new Date(j));
    }
}
