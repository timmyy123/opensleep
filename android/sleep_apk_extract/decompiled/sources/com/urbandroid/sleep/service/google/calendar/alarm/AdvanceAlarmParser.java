package com.urbandroid.sleep.service.google.calendar.alarm;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.urbandroid.sleep.service.google.calendar.domain.GoogleCalendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0004\b\u0007\u0010\u000bR\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/urbandroid/sleep/service/google/calendar/alarm/AdvanceAlarmParser;", "", "<init>", "()V", "Lcom/urbandroid/sleep/service/google/calendar/domain/GoogleCalendar$Event;", "event", "", "parse", "(Lcom/urbandroid/sleep/service/google/calendar/domain/GoogleCalendar$Event;)Ljava/lang/Long;", "", "str", "(Ljava/lang/String;)Ljava/lang/Long;", "Ljava/util/regex/Pattern;", "pattern", "Ljava/util/regex/Pattern;", "getPattern", "()Ljava/util/regex/Pattern;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AdvanceAlarmParser {
    public static final AdvanceAlarmParser INSTANCE = new AdvanceAlarmParser();
    private static final Pattern pattern;

    static {
        Pattern patternCompile = Pattern.compile("[#]alarm([-|+][0-9]+[h|m]?)([:]?[0-9]+[m]?)?", 2);
        patternCompile.getClass();
        pattern = patternCompile;
    }

    private AdvanceAlarmParser() {
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Long parse(String str) {
        if (str == null) {
            return null;
        }
        Matcher matcher = pattern.matcher(str);
        if (!matcher.find()) {
            return null;
        }
        String strGroup = matcher.group(1);
        String strGroup2 = matcher.group(2);
        TimeUnit timeUnit = TimeUnit.HOURS;
        TimeUnit timeUnit2 = TimeUnit.MINUTES;
        if (strGroup != null) {
            String lowerCase = strGroup.toLowerCase(Locale.ROOT);
            lowerCase.getClass();
            if (StringsKt__StringsJVMKt.endsWith$default(lowerCase, "m", false, 2, null)) {
                strGroup = Fragment$$ExternalSyntheticOutline1.m(1, 0, strGroup);
            } else if (strGroup != null) {
                String lowerCase2 = strGroup.toLowerCase(Locale.ROOT);
                lowerCase2.getClass();
                if (StringsKt__StringsJVMKt.endsWith$default(lowerCase2, "h", false, 2, null)) {
                    strGroup = Fragment$$ExternalSyntheticOutline1.m(1, 0, strGroup);
                    timeUnit2 = timeUnit;
                }
            }
        }
        if (strGroup2 == null || !StringsKt.contains$default(strGroup2, ":")) {
            timeUnit = timeUnit2;
        }
        long minutes = timeUnit.toMinutes(strGroup != null ? Long.parseLong(strGroup) : 0L);
        if (strGroup2 == null) {
            return Long.valueOf((-1) * minutes);
        }
        if (StringsKt.startsWith$default(strGroup2, ":")) {
            strGroup2 = strGroup2.substring(1);
        }
        Locale locale = Locale.ROOT;
        String lowerCase3 = strGroup2.toLowerCase(locale);
        lowerCase3.getClass();
        if (!StringsKt__StringsJVMKt.endsWith$default(lowerCase3, "m", false, 2, null)) {
            String lowerCase4 = strGroup2.toLowerCase(locale);
            lowerCase4.getClass();
            if (StringsKt__StringsJVMKt.endsWith$default(lowerCase4, "h", false, 2, null)) {
                strGroup2 = Fragment$$ExternalSyntheticOutline1.m(1, 0, strGroup2);
            }
        }
        return Long.valueOf(((Long.parseLong(strGroup2) * ((long) Long.signum(minutes))) + minutes) * (-1));
    }

    public static final Long parse(GoogleCalendar.Event event) {
        event.getClass();
        Long l = parse(event.getTitle());
        return l == null ? parse(event.getDescription()) : l;
    }
}
