package com.urbandroid.common.util;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import android.text.format.DateFormat;
import android.text.format.DateUtils;
import android.util.Pair;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.facebook.appevents.AppEventsConstants;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.domain.interval.Interval;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import j$.util.DesugarTimeZone;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes4.dex */
public abstract class DateUtil {
    private static SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
    private static SimpleDateFormat format2 = new SimpleDateFormat("yyyyMMdd_H.mm");
    private static SimpleDateFormat formatShortTimeDate = new SimpleDateFormat("dd.MM.H:mm");
    private static SimpleDateFormat hours24hFormat = new SimpleDateFormat("H:mm");
    private static SimpleDateFormat hours12hFormat = new SimpleDateFormat("h:mm");
    private static SimpleDateFormat hours12hFormatAmPm = new SimpleDateFormat("h:mm aa");
    private static Map<String, TimeZone> timeZones = new HashMap();

    private static void assignShortName(String[] strArr, int i, int i2) {
        strArr[i] = DateUtils.getDayOfWeekString(i, i2);
    }

    public static long dateDifference(Date date, Date date2) {
        long time = date2.getTime() - date.getTime();
        return time < 0 ? time * (-1) : time;
    }

    public static int dateDifferenceDays(Date date, Date date2) {
        return Math.round(dateDifference(date, date2) / 8.64E7f);
    }

    public static String formatDay(long j) {
        return DateFormat.format("E", new Date(j)).toString();
    }

    public static String formatDuration(int i) {
        StringBuilder sb = new StringBuilder();
        if (i < 0) {
            sb.append("-");
        }
        int iAbs = Math.abs(i);
        int i2 = iAbs % 60;
        sb.append(iAbs / 60);
        sb.append(":");
        return zzba$$ExternalSyntheticOutline0.m(i2, i2 > 9 ? "" : AppEventsConstants.EVENT_PARAM_VALUE_NO, sb);
    }

    public static String formatHoursMinutes(Context context, long j) {
        StringBuilder sb = new StringBuilder();
        long j2 = j / 60;
        long j3 = j % 60;
        if (j2 == 1) {
            sb.append(context.getString(R.string.hour));
            if (j3 > 0) {
                sb.append(" ");
            }
        } else if (j2 > 1) {
            sb.append(context.getString(R.string.hours, String.valueOf(j2)));
            if (j3 > 0) {
                sb.append(" ");
            }
        }
        if (j3 == 1) {
            sb.append(context.getString(R.string.minute));
        } else if (j3 > 1) {
            sb.append(context.getString(R.string.minutes, String.valueOf(j3)));
        }
        return sb.toString();
    }

    public static String formatHoursMinutesSeconds(int i) {
        return String.format("%2d:%02d:%02d", Integer.valueOf(i / 3600), Integer.valueOf((i / 60) % 60), Integer.valueOf(i % 60));
    }

    public static String formatHoursPositive(Long l) {
        return String.valueOf(Math.abs(l.intValue()) / 60);
    }

    public static String formatHoursPositiveRound(Long l) {
        return String.valueOf(Math.round(Math.abs(l.intValue()) / 60.0f));
    }

    public static String formatMinutes(Integer num) {
        return num == null ? "" : formatMinutesPositive(Integer.valueOf(Math.abs(num.intValue())));
    }

    public static String formatMinutesAndSecondsFromMs(Context context, long j) {
        StringBuilder sb = new StringBuilder();
        long j2 = j / 1000;
        long j3 = j2 / 60;
        long j4 = j2 % 60;
        if (j3 == 1) {
            sb.append(context.getString(R.string.minute));
            sb.append(" ");
        } else if (j3 > 1) {
            sb.append(context.getString(R.string.minutes, String.valueOf(j3)));
            sb.append(" ");
        } else if (j2 == 0) {
            sb.append("0 ");
            sb.append(context.getString(R.string.bed_time_min));
        }
        if (j4 > 0) {
            sb.append(j4);
            sb.append(" ");
            sb.append(context.getString(R.string.seconds));
        }
        return sb.toString();
    }

    public static String formatMinutesAndSecondsFromMsShort(Context context, long j) {
        StringBuilder sb = new StringBuilder();
        long j2 = j / 1000;
        long j3 = j2 / 60;
        if (j2 % 60 > 45) {
            j3++;
        }
        if (j3 > 0) {
            sb.append(j3);
            sb.append(" ");
            sb.append(context.getString(R.string.bed_time_min));
            sb.append(" ");
        } else if (j2 >= 0) {
            sb.append(j2);
            sb.append(" ");
            sb.append(context.getString(R.string.seconds));
            sb.append(" ");
        }
        return sb.toString();
    }

    public static String formatMinutesInHumanLanguage(Context context, Integer num, boolean z) {
        String str;
        if (num.intValue() == 0) {
            return "0 " + context.getString(R.string.bed_time_min);
        }
        boolean z2 = num.intValue() < 0;
        int iAbs = Math.abs(num.intValue());
        int i = iAbs / 60;
        int i2 = iAbs % 60;
        String str2 = "";
        String string = i > 1 ? context.getString(R.string.hours, FileInsert$$ExternalSyntheticOutline0.m(i, "")) : i == 1 ? context.getString(R.string.hour) : "";
        if (i2 != 0) {
            str = i2 + " " + context.getString(R.string.bed_time_min);
        } else {
            str = "";
        }
        StringBuilder sb = new StringBuilder();
        if (z2) {
            str2 = "-";
        } else if (z) {
            str2 = MqttTopic.SINGLE_LEVEL_WILDCARD;
        }
        sb.append(str2);
        sb.append((string + " " + str).trim());
        return sb.toString();
    }

    public static String formatMinutesInHumanLanguageHtml(Context context, Integer num) {
        String strM;
        String string;
        int iIntValue = num.intValue() / 60;
        int iIntValue2 = num.intValue() % 60;
        String str = "";
        if (iIntValue > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(iIntValue);
            sb.append("<small><small><small><small>");
            if (iIntValue2 != 0) {
                string = context.getString(R.string.h);
            } else {
                string = context.getString(R.string.h) + context.getString(R.string.leave_empty_time_after);
            }
            strM = FileInsert$$ExternalSyntheticOutline0.m(sb, string, "</small></small></small></small> ");
        } else {
            strM = "";
        }
        if (iIntValue == 0 || iIntValue2 != 0) {
            str = iIntValue2 + "<small><small><small><small>" + context.getString(R.string.bed_time_min) + context.getString(R.string.leave_empty_time_after) + "</small></small></small></small>";
        }
        return (strM + " " + str).trim();
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

    public static String formatShortTimeDate(Date date) {
        return formatShortTimeDate.format(date);
    }

    public static String formatTime(Context context, long j) {
        return DateFormat.format(new Settings(context).is24HourFormat() ? "k:mm" : "h:mm aa", new Date(j)).toString();
    }

    public static String formatTimeDay(Context context, long j) {
        return DateFormat.format(new Settings(context).is24HourFormat() ? "E k:mm" : "E h:mm aa", new Date(j)).toString();
    }

    public static String formatTimeNeverAmPm(Context context, long j) {
        return DateFormat.format(new Settings(context).is24HourFormat() ? "k:mm" : "h:mm", new Date(j)).toString();
    }

    public static String formatTimeNoAmPm(Context context, long j) {
        Settings settings = new Settings(context);
        if (settings.isShowAmPm()) {
            return formatTime(context, j);
        }
        return DateFormat.format(settings.is24HourFormat() ? "k:mm" : "h:mm", new Date(j)).toString();
    }

    public static String formatTimeShort(Context context, long j) {
        return DateFormat.format(new Settings(context).is24HourFormat() ? "k:mm" : "h:mm", new Date(j)).toString();
    }

    public static String formatTimeShortHumanTts(Context context, long j) {
        return DateFormat.format(new Settings(context).is24HourFormat() ? "k mm" : "h mm", new Date(j)).toString().replaceAll("00", "");
    }

    public static String formatTimeShortSec(long j) {
        return DateFormat.format("HH:mm:ss", new Date(j)).toString();
    }

    public static int getAgeFromBirthYear(Date date) {
        return (int) ((new Date().getTime() - date.getTime()) / 31449600000L);
    }

    public static ArrayList<Calendar> getCalendarDatesForThisWeekStartingWithSystemFirstDayOfWeek() {
        Calendar calendar = Calendar.getInstance();
        ArrayList<Calendar> arrayList = new ArrayList<>();
        calendar.set(7, SharedApplicationContext.getSettings().getFirstDayOfWeek());
        arrayList.add((Calendar) calendar.clone());
        for (int i = 0; i < 6; i++) {
            calendar.add(5, 1);
            arrayList.add((Calendar) calendar.clone());
        }
        return arrayList;
    }

    public static ArrayList<Integer> getCalendarWeekdaysStartingWithSystemFirstDayOfWeek() {
        int firstDayOfWeek = SharedApplicationContext.getSettings().getFirstDayOfWeek();
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        Collections.rotate(arrayList, -(firstDayOfWeek - 1));
        return arrayList;
    }

    public static ArrayList<Pair<String, Integer>> getCalendarWeekdaysWithShorterNamesStartingWithSystemFirstDayOfWeek() {
        ArrayList<Integer> calendarWeekdaysStartingWithSystemFirstDayOfWeek = getCalendarWeekdaysStartingWithSystemFirstDayOfWeek();
        String[] shorterWeekdayNames = getShorterWeekdayNames();
        ArrayList<Pair<String, Integer>> arrayList = new ArrayList<>();
        for (int i = 0; i < calendarWeekdaysStartingWithSystemFirstDayOfWeek.size(); i++) {
            arrayList.add(new Pair<>(shorterWeekdayNames[i], calendarWeekdaysStartingWithSystemFirstDayOfWeek.get(i)));
        }
        return arrayList;
    }

    public static Date getCutOffDate(Date date, int i) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        if (calendar.get(11) < i) {
            calendar.add(6, -1);
        }
        calendar.set(11, i);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTime();
    }

    public static Interval getCutOffInterval(Date date, int i) {
        Date cutOffDate = getCutOffDate(date, i);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(cutOffDate);
        calendar.add(5, 1);
        return new Interval(cutOffDate.getTime(), calendar.getTime().getTime());
    }

    public static int getDatestampNumber(Date date) {
        try {
            return Integer.parseInt(format.format(date));
        } catch (NumberFormatException e) {
            Utf8$$ExternalSyntheticBUOutline0.m((Throwable) e);
            return 0;
        }
    }

    public static String getDatetimestamp(Date date) {
        return format2.format(date);
    }

    public static String getDayHumanReadable(Context context, Date date) {
        Date date2 = new Date();
        Logger.logInfo("Date: " + date2 + " " + date + " " + com.urbandroid.sleep.addon.stats.util.DateUtil.isSameDate(date2, date));
        if (com.urbandroid.sleep.addon.stats.util.DateUtil.isSameDate(date2, date)) {
            return context.getString(R.string.today);
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date2);
        calendar.add(5, 1);
        return com.urbandroid.sleep.addon.stats.util.DateUtil.isSameDate(calendar.getTime(), date) ? context.getString(R.string.tomorrow) : getShortDateInstanceWithoutYears(context, TimeZone.getDefault()).format(date);
    }

    public static String[] getFormattedWeekdays(String str) {
        ArrayList<Calendar> calendarDatesForThisWeekStartingWithSystemFirstDayOfWeek = getCalendarDatesForThisWeekStartingWithSystemFirstDayOfWeek();
        String[] strArr = new String[7];
        android.icu.text.SimpleDateFormat simpleDateFormat = new android.icu.text.SimpleDateFormat(str);
        for (int i = 0; i < calendarDatesForThisWeekStartingWithSystemFirstDayOfWeek.size(); i++) {
            strArr[i] = simpleDateFormat.format(calendarDatesForThisWeekStartingWithSystemFirstDayOfWeek.get(i).getTime());
        }
        return strArr;
    }

    public static java.text.DateFormat getHoursFormat(Context context, TimeZone timeZone) {
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat) DateFormat.getDateFormat(context);
        if (timeZone != null) {
            simpleDateFormat.setTimeZone(timeZone);
        }
        if (new Settings(context).is24HourFormat()) {
            simpleDateFormat.applyPattern("H:mm");
            return simpleDateFormat;
        }
        simpleDateFormat.applyPattern(new Settings(context).isShowAmPm() ? "h:mm aa" : "h:mm");
        return simpleDateFormat;
    }

    public static String[] getLongWeekdayNames() {
        String[] weekdays = new DateFormatSymbols().getWeekdays();
        return !weekdays[1].trim().matches("\\d") ? weekdays : getWeekdayNamesAlternative(10);
    }

    public static java.text.DateFormat getShortDateInstanceWithoutYears(Context context, TimeZone timeZone) {
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat) DateFormat.getDateFormat(context);
        if (timeZone != null) {
            simpleDateFormat.setTimeZone(timeZone);
        }
        if (simpleDateFormat.toPattern().toLowerCase().startsWith("yyyy-")) {
            simpleDateFormat.applyPattern(simpleDateFormat.toPattern().substring(5));
            return simpleDateFormat;
        }
        simpleDateFormat.applyPattern(simpleDateFormat.toPattern().replaceAll("[\\s/]*y+[\\s/]*", ""));
        if (simpleDateFormat.toPattern().startsWith("-") && simpleDateFormat.toPattern().length() > 1) {
            simpleDateFormat.applyPattern(simpleDateFormat.toPattern().substring(1));
        }
        return simpleDateFormat;
    }

    public static java.text.DateFormat getShortDateInstanceWithoutYearsWithTime(Context context, TimeZone timeZone) {
        String pattern = ((SimpleDateFormat) getShortDateInstanceWithoutYears(context, timeZone)).toPattern();
        return new SimpleDateFormat(new Settings(context).is24HourFormat() ? FileInsert$$ExternalSyntheticOutline0.m$1(pattern, " H:mm") : FileInsert$$ExternalSyntheticOutline0.m$1(pattern, " h:mm aa"));
    }

    public static java.text.DateFormat getShortDateLongWeekInstanceWithoutYears(Context context) {
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat) DateFormat.getDateFormat(context);
        simpleDateFormat.applyPattern("EEE " + simpleDateFormat.toPattern().replaceAll("[\\s/]*y+[\\s/]*", ""));
        return simpleDateFormat;
    }

    public static java.text.DateFormat getShortDateLongerWeekInstanceWithoutYears(Context context) {
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat) DateFormat.getDateFormat(context);
        simpleDateFormat.applyPattern("EEE " + simpleDateFormat.toPattern().replaceAll("[\\s/]*y+[\\s/]*", ""));
        return simpleDateFormat;
    }

    public static java.text.DateFormat getShortDateWeekInstanceWithoutYears(Context context) {
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat) DateFormat.getDateFormat(context);
        simpleDateFormat.applyPattern("E " + simpleDateFormat.toPattern().replaceAll("[\\s/]*y+[\\s/]*", ""));
        return simpleDateFormat;
    }

    public static java.text.DateFormat getShortDateWeekOnlyInstanceWithoutYears(Context context, TimeZone timeZone) {
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat) DateFormat.getDateFormat(context);
        if (timeZone != null) {
            simpleDateFormat.setTimeZone(timeZone);
        }
        simpleDateFormat.applyPattern("EEEE");
        return simpleDateFormat;
    }

    public static java.text.DateFormat getShortDateWeekShortOnlyInstanceWithoutYears(Context context, TimeZone timeZone) {
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat) DateFormat.getDateFormat(context);
        if (timeZone != null) {
            simpleDateFormat.setTimeZone(timeZone);
        }
        simpleDateFormat.applyPattern("EEE");
        return simpleDateFormat;
    }

    public static String[] getShortWeekdayNames(int i) {
        String[] shortWeekdays = new DateFormatSymbols().getShortWeekdays();
        if (shortWeekdays[1].trim().matches("\\d")) {
            shortWeekdays = getWeekdayNamesAlternative(20);
            for (int i2 = 0; i2 < shortWeekdays.length; i2++) {
                String str = shortWeekdays[i2];
                shortWeekdays[i2] = str.substring(0, Math.min(str.length(), i));
            }
        }
        return shortWeekdays;
    }

    public static String[] getShorterWeekdayNames() {
        return getFormattedWeekdays("EEEEEE");
    }

    public static synchronized TimeZone getTimeZone(String str) {
        TimeZone timeZone;
        timeZone = timeZones.get(str);
        if (timeZone == null) {
            timeZone = DesugarTimeZone.getTimeZone(str);
            timeZones.put(str, timeZone);
        }
        return timeZone;
    }

    private static String[] getWeekdayNamesAlternative(int i) {
        String[] strArr = new String[8];
        for (int i2 : getWeekdays()) {
            assignShortName(strArr, i2, i);
        }
        return strArr;
    }

    private static int[] getWeekdays() {
        return new int[]{1, 2, 3, 4, 5, 6, 7};
    }

    public static void resetCalendarTimeDayEnd(Calendar calendar) {
        calendar.set(12, 23);
        calendar.set(11, 59);
        calendar.set(13, 59);
        calendar.set(14, 999);
    }

    public static void resetCalendarTimeDayStart(Calendar calendar) {
        calendar.set(12, 0);
        calendar.set(11, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
    }

    public static java.text.DateFormat getHoursFormat(Context context) {
        if (new Settings(context).is24HourFormat()) {
            return hours24hFormat;
        }
        return new Settings(context).isShowAmPm() ? hours12hFormatAmPm : hours12hFormat;
    }

    public static String formatMinutesPositive(Long l) {
        return formatMinutesPositive(Integer.valueOf(l.intValue()));
    }

    public static String[] getShortWeekdayNames() {
        return getShortWeekdayNames(3);
    }

    public static String formatMinutesInHumanLanguage(Context context, Integer num) {
        return formatMinutesInHumanLanguage(context, num, false);
    }
}
