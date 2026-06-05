package com.urbandroid.sleep.addon.stats.util;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.text.format.DateUtils;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.facebook.appevents.AppEventsConstants;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import org.achartengine.chart.TimeChart;

/* JADX INFO: loaded from: classes4.dex */
public abstract class DateUtil {
    public static final Date SINCE_DATE = new Date(1233442800000L);
    private static SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
    private static SimpleDateFormat format2 = new SimpleDateFormat("yyyyMMdd_H.mm");

    private static void assignShortName(String[] strArr, int i, int i2) {
        if (DateUtils.getDayOfWeekString(i, i2) == null) {
            strArr[i] = FileInsert$$ExternalSyntheticOutline0.m(i, "");
        } else {
            strArr[i] = DateUtils.getDayOfWeekString(i, i2);
        }
    }

    public static long dateDifferenceMin(Date date, Date date2) {
        return Math.abs(date2.getTime() - date.getTime()) / 60000;
    }

    public static String formatMinutes(Integer num) {
        return num == null ? "" : formatMinutesPositive(Integer.valueOf(Math.abs(num.intValue())));
    }

    public static String formatMinutesPositive(Integer num) {
        if (num == null || num.intValue() < 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int iIntValue = num.intValue() % 60;
        sb.append(num.intValue() / 60);
        sb.append(":");
        return zzba$$ExternalSyntheticOutline0.m(iIntValue, iIntValue <= 9 ? AppEventsConstants.EVENT_PARAM_VALUE_NO : "", sb);
    }

    public static Date getDateSince(long j) {
        return new Date(SINCE_DATE.getTime() + (j * TimeChart.DAY) + 1);
    }

    public static long getDayEnd(long j, TimeZone timeZone) {
        Calendar calendar = Calendar.getInstance(timeZone);
        calendar.setTimeInMillis(j);
        calendar.set(11, 23);
        calendar.set(12, 59);
        calendar.set(13, 59);
        calendar.set(14, 59);
        return calendar.getTimeInMillis();
    }

    public static long getDaysSince(Date date) {
        return (date.getTime() - SINCE_DATE.getTime()) / TimeChart.DAY;
    }

    public static long getMidDay(long j, TimeZone timeZone) {
        Calendar calendar = Calendar.getInstance(timeZone);
        calendar.setTimeInMillis(j);
        calendar.set(11, 12);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    public static String[] getShortWeekdayNames() {
        String[] shortWeekdays = new DateFormatSymbols().getShortWeekdays();
        return !shortWeekdays[1].trim().matches("\\d") ? shortWeekdays : getWeekdayNamesAlternative(20);
    }

    private static String[] getWeekdayNamesAlternative(int i) {
        String[] strArr = new String[8];
        assignShortName(strArr, 1, i);
        assignShortName(strArr, 2, i);
        assignShortName(strArr, 3, i);
        assignShortName(strArr, 4, i);
        assignShortName(strArr, 5, i);
        assignShortName(strArr, 6, i);
        assignShortName(strArr, 7, i);
        return strArr;
    }

    public static boolean isSameDate(Date date, TimeZone timeZone, Date date2, TimeZone timeZone2, int i) {
        boolean zIsSameDate = isSameDate(date, timeZone, date2, timeZone2);
        if (i == 0) {
            return zIsSameDate;
        }
        if (date.after(date2)) {
            date2 = date;
            date = date2;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);
        if (!zIsSameDate || ((calendar.get(11) <= i || calendar2.get(11) <= i) && (calendar.get(11) > i || calendar2.get(11) > i))) {
            return !zIsSameDate && dateDifferenceMin(date, date2) <= 1440 && calendar.get(11) > i && calendar2.get(11) <= i;
        }
        return true;
    }

    public static boolean isSameDate(Date date, Date date2) {
        if (date == null || date2 == null) {
            return false;
        }
        return format.format(date).equals(format.format(date2));
    }

    public static boolean isSameDate(Date date, TimeZone timeZone, Date date2, TimeZone timeZone2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        if (timeZone != null) {
            calendar.setTimeZone(timeZone);
        }
        int i = calendar.get(1);
        int i2 = calendar.get(2);
        int i3 = calendar.get(5);
        calendar.setTime(date2);
        if (timeZone2 != null) {
            calendar.setTimeZone(timeZone2);
        }
        return i == calendar.get(1) && i2 == calendar.get(2) && i3 == calendar.get(5);
    }
}
