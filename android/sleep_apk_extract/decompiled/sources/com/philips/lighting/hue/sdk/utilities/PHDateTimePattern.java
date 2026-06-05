package com.philips.lighting.hue.sdk.utilities;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes4.dex */
public class PHDateTimePattern {
    private Date date = null;
    private Integer timeIntervalStart = null;
    private Integer timeIntervalEnd = null;
    private Integer timer = null;
    private Integer recurringTimerInterval = null;
    private Integer randomTime = null;
    private Integer recurringDays = Integer.valueOf(RecurringDay.RecurringNone.value);
    private TimeZone timeZone = null;

    public enum RecurringDay {
        RecurringNone(0),
        RecurringMonday(64),
        RecurringTuesday(32),
        RecurringWednesday(16),
        RecurringThursday(8),
        RecurringFriday(4),
        RecurringSaturday(2),
        RecurringSunday(1),
        RecurringWeekdays(124),
        RecurringWeekend(3),
        RecurringAlldays(127);

        private int value;

        RecurringDay(int i) {
            this.value = i;
        }

        public static RecurringDay fromValue(int i) {
            RecurringDay recurringDay = RecurringMonday;
            if (i == recurringDay.getValue()) {
                return recurringDay;
            }
            RecurringDay recurringDay2 = RecurringTuesday;
            if (i == recurringDay2.getValue()) {
                return recurringDay2;
            }
            RecurringDay recurringDay3 = RecurringWednesday;
            if (i == recurringDay3.getValue()) {
                return recurringDay3;
            }
            RecurringDay recurringDay4 = RecurringThursday;
            if (i == recurringDay4.getValue()) {
                return recurringDay4;
            }
            RecurringDay recurringDay5 = RecurringFriday;
            if (i == recurringDay5.getValue()) {
                return recurringDay5;
            }
            RecurringDay recurringDay6 = RecurringSaturday;
            if (i == recurringDay6.getValue()) {
                return recurringDay6;
            }
            RecurringDay recurringDay7 = RecurringSunday;
            if (i == recurringDay7.getValue()) {
                return recurringDay7;
            }
            RecurringDay recurringDay8 = RecurringWeekdays;
            if (i == recurringDay8.getValue()) {
                return recurringDay8;
            }
            RecurringDay recurringDay9 = RecurringWeekend;
            if (i == recurringDay9.getValue()) {
                return recurringDay9;
            }
            RecurringDay recurringDay10 = RecurringAlldays;
            return i == recurringDay10.getValue() ? recurringDay10 : RecurringNone;
        }

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static RecurringDay[] valuesCustom() {
            RecurringDay[] recurringDayArrValuesCustom = values();
            int length = recurringDayArrValuesCustom.length;
            RecurringDay[] recurringDayArr = new RecurringDay[length];
            System.arraycopy(recurringDayArrValuesCustom, 0, recurringDayArr, 0, length);
            return recurringDayArr;
        }

        public int getValue() {
            return this.value;
        }
    }

    public static PHDateTimePattern patternWithAbsoluteTime(String str, String str2, TimeZone timeZone) {
        Date date;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", new Locale("nl_NL"));
        simpleDateFormat.setTimeZone(timeZone);
        try {
            date = simpleDateFormat.parse(str.substring(0, 19));
        } catch (ParseException e) {
            e.printStackTrace();
            date = null;
        }
        if (date == null) {
            return null;
        }
        PHDateTimePattern pHDateTimePattern = new PHDateTimePattern();
        pHDateTimePattern.timeZone = timeZone;
        pHDateTimePattern.date = date;
        int iRandomTimeWithTimeString = randomTimeWithTimeString(str2);
        Integer numValueOf = Integer.valueOf(iRandomTimeWithTimeString);
        if (iRandomTimeWithTimeString > 0) {
            pHDateTimePattern.randomTime = numValueOf;
        } else if (iRandomTimeWithTimeString == -1) {
            pHDateTimePattern.randomTime = null;
        }
        return pHDateTimePattern;
    }

    public static PHDateTimePattern patternWithRecurringTime(String str, String str2, TimeZone timeZone) {
        Date date;
        Matcher matcher = Pattern.compile("^W([0-9]{1,3})/(T([0-9]{2}:[0-9]{2}:[0-9]{2}))?", 2).matcher(str);
        matcher.find();
        String strGroup = matcher.group(3);
        String strSubstring = (strGroup == null || strGroup.length() <= 0) ? "00:00:00" : str.substring(str.indexOf(47) + 2, str.length());
        matcher.reset();
        if (!matcher.find()) {
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss", new Locale("nl_NL"));
        simpleDateFormat.setTimeZone(timeZone);
        try {
            date = simpleDateFormat.parse(strSubstring);
        } catch (ParseException e) {
            e.printStackTrace();
            date = null;
        }
        if (date == null) {
            return null;
        }
        PHDateTimePattern pHDateTimePattern = new PHDateTimePattern();
        pHDateTimePattern.setTimeZone(timeZone);
        pHDateTimePattern.setDate(date);
        try {
            pHDateTimePattern.setRecurringDays(Integer.valueOf(Integer.parseInt(str.substring(1, str.indexOf(47)))));
            int iRandomTimeWithTimeString = randomTimeWithTimeString(str2);
            if (iRandomTimeWithTimeString > 0) {
                pHDateTimePattern.setRandomTime(Integer.valueOf(iRandomTimeWithTimeString));
            } else if (iRandomTimeWithTimeString == -1) {
                return null;
            }
            return pHDateTimePattern;
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static PHDateTimePattern patternWithRecurringTimeInterval(String str, String str2, TimeZone timeZone) {
        Integer numValueOf;
        Matcher matcher = Pattern.compile("^W([0-9]{1,3})/(T[0-9]{2}:[0-9]{2}:[0-9]{2}-T[0-9]{2}:[0-9]{2}:[0-9]{2})", 2).matcher(str);
        PHDateTimePattern pHDateTimePatternPatternWithTimeInterval = null;
        if (matcher.find()) {
            String strGroup = matcher.group();
            try {
                numValueOf = Integer.valueOf(Integer.parseInt(strGroup.substring(1, strGroup.indexOf(MqttTopic.TOPIC_LEVEL_SEPARATOR))));
            } catch (NumberFormatException e) {
                e.printStackTrace();
                numValueOf = null;
            }
            if (numValueOf != null && (pHDateTimePatternPatternWithTimeInterval = patternWithTimeInterval(strGroup.substring(strGroup.indexOf(47) + 1, strGroup.length()), str2, timeZone)) != null) {
                pHDateTimePatternPatternWithTimeInterval.recurringDays = numValueOf;
            }
        }
        return pHDateTimePatternPatternWithTimeInterval;
    }

    public static PHDateTimePattern patternWithRecurringTimerString(String str, String str2, TimeZone timeZone) {
        Matcher matcher = Pattern.compile("^R([0-9]{0,2})/(PT[0-9]{2}:[0-9]{2}:[0-9]{2})", 2).matcher(str);
        if (!matcher.find()) {
            return null;
        }
        String strGroup = matcher.group();
        String strSubstring = strGroup.substring(1, strGroup.indexOf(47));
        int i = strSubstring.isEmpty() ? -1 : Integer.parseInt(strSubstring);
        if ((i <= 0 || i > 99) && i != -1) {
            return null;
        }
        PHDateTimePattern pHDateTimePatternPatternWithTimerString = patternWithTimerString(strGroup.substring(strGroup.indexOf(47) + 1, strGroup.length()), str2, timeZone);
        if (pHDateTimePatternPatternWithTimerString != null) {
            pHDateTimePatternPatternWithTimerString.recurringTimerInterval = Integer.valueOf(i);
        }
        return pHDateTimePatternPatternWithTimerString;
    }

    public static PHDateTimePattern patternWithTimeInterval(String str, String str2, TimeZone timeZone) {
        String strSubstring = str.substring(1, str.indexOf(45));
        String strSubstring2 = str.substring(str.indexOf(45) + 2, str.length());
        int iTimeWithTruncatedTimeString = timeWithTruncatedTimeString(strSubstring);
        Integer numValueOf = Integer.valueOf(iTimeWithTruncatedTimeString);
        int iTimeWithTruncatedTimeString2 = timeWithTruncatedTimeString(strSubstring2);
        Integer numValueOf2 = Integer.valueOf(iTimeWithTruncatedTimeString2);
        if (iTimeWithTruncatedTimeString <= 0 || iTimeWithTruncatedTimeString2 <= 0) {
            return null;
        }
        PHDateTimePattern pHDateTimePattern = new PHDateTimePattern();
        pHDateTimePattern.timeZone = timeZone;
        pHDateTimePattern.timeIntervalStart = numValueOf;
        pHDateTimePattern.timeIntervalEnd = numValueOf2;
        return pHDateTimePattern;
    }

    public static PHDateTimePattern patternWithTimeString(String str, TimeZone timeZone) {
        if (str != null && str.length() != 0) {
            Matcher matcher = Pattern.compile("^[0-9]{4}-[0-9]{2}-[0-9]{2}T[0-9]{2}:[0-9]{2}:[0-9]{2}(A[0-9]{2}:[0-9]{2}:[0-9]{2})?$", 2).matcher(str);
            Matcher matcher2 = Pattern.compile("^W[0-9]{1,3}/(T[0-9]{2}:[0-9]{2}:[0-9]{2})?(A[0-9]{2}:[0-9]{2}:[0-9]{2})?$", 2).matcher(str);
            Matcher matcher3 = Pattern.compile("^T[0-9]{1,2}:[0-9]{2}:[0-9]{2}-T[0-9]{2}:[0-9]{2}:[0-9]{2}", 2).matcher(str);
            Matcher matcher4 = Pattern.compile("^W[0-9]{1,3}/T[0-9]{2}:[0-9]{2}:[0-9]{2}-T[0-9]{2}:[0-9]{2}:[0-9]{2}", 2).matcher(str);
            Matcher matcher5 = Pattern.compile("^PT[0-9]{1,2}:[0-9]{2}:[0-9]{2}(A[0-9]{2}:[0-9]{2}:[0-9]{2})?$", 2).matcher(str);
            Matcher matcher6 = Pattern.compile("^R[0-9]{0,2}/PT[0-9]{2}:[0-9]{2}:[0-9]{2}(A[0-9]{2}:[0-9]{2}:[0-9]{2})?$", 2).matcher(str);
            if (matcher.find()) {
                return patternWithAbsoluteTime(matcher.group(), str, timeZone);
            }
            if (matcher2.find()) {
                return patternWithRecurringTime(matcher2.group(), str, timeZone);
            }
            if (matcher3.find()) {
                return patternWithTimeInterval(matcher3.group(), str, timeZone);
            }
            if (matcher4.find()) {
                return patternWithRecurringTimeInterval(matcher4.group(), str, timeZone);
            }
            if (matcher5.find()) {
                return patternWithTimerString(matcher5.group(), str, timeZone);
            }
            if (matcher6.find()) {
                return patternWithRecurringTimerString(matcher6.group(), str, timeZone);
            }
        }
        return null;
    }

    public static PHDateTimePattern patternWithTimerString(String str, String str2, TimeZone timeZone) {
        int iTimeWithTruncatedTimeString = timeWithTruncatedTimeString(str.substring(2, 10));
        if (iTimeWithTruncatedTimeString <= 0) {
            return null;
        }
        PHDateTimePattern pHDateTimePattern = new PHDateTimePattern();
        pHDateTimePattern.timeZone = timeZone;
        pHDateTimePattern.timer = Integer.valueOf(iTimeWithTruncatedTimeString);
        int iRandomTimeWithTimeString = randomTimeWithTimeString(str2);
        if (iRandomTimeWithTimeString > 0) {
            pHDateTimePattern.randomTime = Integer.valueOf(iRandomTimeWithTimeString);
            return pHDateTimePattern;
        }
        if (iRandomTimeWithTimeString == -1) {
            return null;
        }
        return pHDateTimePattern;
    }

    public static int randomTimeWithTimeString(String str) {
        Matcher matcher = Pattern.compile("A[0-9]{2}:[0-9]{2}:[0-9]{2}", 2).matcher(str);
        if (!matcher.find()) {
            return 0;
        }
        String strGroup = matcher.group();
        int iTimeWithTruncatedTimeString = timeWithTruncatedTimeString(strGroup.substring(1, strGroup.length()));
        if (iTimeWithTruncatedTimeString == 0) {
            return -1;
        }
        return iTimeWithTruncatedTimeString;
    }

    public static int timeWithTruncatedTimeString(String str) {
        String[] strArrSplit = str.split(":");
        if (strArrSplit.length != 3) {
            return 0;
        }
        if (strArrSplit[0].startsWith("PT")) {
            strArrSplit[0] = strArrSplit[0].substring(2);
        }
        try {
            int i = Integer.parseInt(strArrSplit[0]);
            int i2 = Integer.parseInt(strArrSplit[1]);
            int i3 = Integer.parseInt(strArrSplit[2]);
            if (i <= 24 && i2 <= 60 && i3 <= 60) {
                int i4 = (i2 * 60) + (i * 3600) + i3;
                if (i4 > 0 && i4 <= 86400) {
                    return i4;
                }
            }
            return 0;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public String absoluteTimeAsString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", new Locale("nl_NL"));
        TimeZone timeZone = this.timeZone;
        if (timeZone != null) {
            simpleDateFormat.setTimeZone(timeZone);
        }
        String str = simpleDateFormat.format(this.date);
        Integer num = this.randomTime;
        if (num == null || num.intValue() <= 0) {
            return str;
        }
        String strRandomTimeAsStringWithTime = randomTimeAsStringWithTime(this.randomTime);
        if (strRandomTimeAsStringWithTime != null) {
            return str.concat(strRandomTimeAsStringWithTime);
        }
        return null;
    }

    public Date getDate() {
        return this.date;
    }

    public Integer getRandomTime() {
        return this.randomTime;
    }

    public Integer getRecurringDays() {
        return this.recurringDays;
    }

    public Integer getRecurringTimerInterval() {
        return this.recurringTimerInterval;
    }

    public Integer getTimeIntervalEnd() {
        return this.timeIntervalEnd;
    }

    public Integer getTimeIntervalStart() {
        return this.timeIntervalStart;
    }

    public TimeZone getTimeZone() {
        return this.timeZone;
    }

    public Integer getTimer() {
        return this.timer;
    }

    public String patternAsString() {
        Integer num;
        if (this.date != null) {
            Integer num2 = this.recurringDays;
            return (num2 == null || num2.intValue() == RecurringDay.RecurringNone.value) ? absoluteTimeAsString() : recurringTimeAsString();
        }
        Integer num3 = this.timeIntervalStart;
        if (num3 != null && num3.intValue() > 0 && (num = this.timeIntervalEnd) != null && num.intValue() > 0) {
            Integer num4 = this.recurringDays;
            return (num4 == null || num4.intValue() == RecurringDay.RecurringNone.value) ? timeIntervalAsString() : recurringTimeIntervalAsString();
        }
        Integer num5 = this.timer;
        if (num5 == null || num5.intValue() <= 0) {
            return null;
        }
        Integer num6 = this.recurringTimerInterval;
        return (num6 == null || num6.intValue() <= 0) ? timerAsString() : recurringTimerAsString();
    }

    public String randomTimeAsStringWithTime(Integer num) {
        if (num.intValue() <= 0 || num.intValue() > 86400) {
            return null;
        }
        return String.format(new Locale("nl_NL"), "A%02d:%02d:%02d", Integer.valueOf((int) Math.floor(num.intValue() / 3600)), Integer.valueOf((int) Math.floor((num.intValue() % 3600) / 60)), Integer.valueOf((num.intValue() % 3600) % 60));
    }

    public String recurringTimeAsString() {
        if (this.recurringDays == null) {
            return null;
        }
        String str = String.format(new Locale("nl_NL"), "W%03d/", this.recurringDays);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("'T'HH:mm:ss", new Locale("nl_NL"));
        TimeZone timeZone = this.timeZone;
        if (timeZone != null) {
            simpleDateFormat.setTimeZone(timeZone);
        }
        String str2 = simpleDateFormat.format(this.date);
        if (str2 == null) {
            return null;
        }
        String strConcat = str.concat(str2);
        Integer num = this.randomTime;
        if (num == null || num.intValue() <= 0) {
            return strConcat;
        }
        String strRandomTimeAsStringWithTime = randomTimeAsStringWithTime(this.randomTime);
        if (strRandomTimeAsStringWithTime != null) {
            return strConcat.concat(strRandomTimeAsStringWithTime);
        }
        return null;
    }

    public String recurringTimeIntervalAsString() {
        return String.format(new Locale("nl_NL"), "W%03d/", this.recurringDays).concat(timeIntervalAsString());
    }

    public String recurringTimerAsString() {
        String str;
        if ((this.recurringTimerInterval.intValue() >= 1 && this.recurringTimerInterval.intValue() <= 99) || this.recurringTimerInterval.intValue() == -1) {
            if (this.recurringTimerInterval.intValue() == -1) {
                str = "R/";
            } else {
                Locale locale = new Locale("nl_NL");
                Integer num = this.recurringTimerInterval;
                num.intValue();
                str = String.format(locale, "R%02d/", num);
            }
            String strTimerAsString = timerAsString();
            if (strTimerAsString != null) {
                return str.concat(strTimerAsString);
            }
        }
        return null;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setRandomTime(Integer num) {
        this.randomTime = num;
    }

    public void setRecurringDays(Integer num) {
        this.recurringDays = num;
    }

    public void setRecurringTimerInterval(Integer num) {
        this.recurringTimerInterval = num;
    }

    public void setTimeIntervalEnd(Integer num) {
        this.timeIntervalEnd = num;
    }

    public void setTimeIntervalStart(Integer num) {
        this.timeIntervalStart = num;
    }

    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }

    public void setTimer(Integer num) {
        this.timer = num;
    }

    public String timeIntervalAsString() {
        String strTruncatedTimeAsStringWithTime = truncatedTimeAsStringWithTime(this.timeIntervalStart);
        String strTruncatedTimeAsStringWithTime2 = truncatedTimeAsStringWithTime(this.timeIntervalEnd);
        if (strTruncatedTimeAsStringWithTime == null || strTruncatedTimeAsStringWithTime2 == null) {
            return null;
        }
        return FileInsert$$ExternalSyntheticOutline0.m$1(strTruncatedTimeAsStringWithTime, "-", strTruncatedTimeAsStringWithTime2);
    }

    public String timerAsString() {
        String strTruncatedTimeAsStringWithTime;
        if (this.timer.intValue() <= 0 || this.timer.intValue() > 86400 || (strTruncatedTimeAsStringWithTime = truncatedTimeAsStringWithTime(this.timer)) == null) {
            return null;
        }
        String strConcat = "P".concat(strTruncatedTimeAsStringWithTime);
        Integer num = this.randomTime;
        if (num == null || num.intValue() <= 0) {
            return strConcat;
        }
        String strRandomTimeAsStringWithTime = randomTimeAsStringWithTime(this.randomTime);
        if (strRandomTimeAsStringWithTime != null) {
            return strConcat.concat(strRandomTimeAsStringWithTime);
        }
        return null;
    }

    public String truncatedTimeAsStringWithTime(Integer num) {
        if (num.intValue() <= 0 || num.intValue() > 86400) {
            return null;
        }
        return String.format(new Locale("nl_NL"), "T%02d:%02d:%02d", Integer.valueOf((int) Math.floor(num.intValue() / 3600)), Integer.valueOf((int) Math.floor((num.intValue() % 3600) / 60)), Integer.valueOf((num.intValue() % 3600) % 60));
    }

    public static PHDateTimePattern patternWithTimeString(String str) {
        return patternWithTimeString(str, TimeZone.getDefault());
    }
}
