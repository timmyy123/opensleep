package com.urbandroid.sleep.service.google.calendar;

import com.urbandroid.sleep.alarmclock.Alarm;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bR,\u0010\u0010\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r\u0012\u0004\u0012\u00020\u000f0\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/urbandroid/sleep/service/google/calendar/LastCalendarAlarmChecker;", "", "<init>", "()V", "Lcom/urbandroid/sleep/alarmclock/Alarm;", "alarm", "", "wasRecentlyChecked", "(Lcom/urbandroid/sleep/alarmclock/Alarm;)Z", "", "checked", "(Lcom/urbandroid/sleep/alarmclock/Alarm;)V", "", "Lkotlin/Pair;", "", "", "map", "Ljava/util/Map;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class LastCalendarAlarmChecker {
    public static final LastCalendarAlarmChecker INSTANCE = new LastCalendarAlarmChecker();
    private static final Map<Pair<Integer, Long>, Long> map = new LinkedHashMap();

    private LastCalendarAlarmChecker() {
    }

    public final void checked(Alarm alarm) {
        alarm.getClass();
        map.put(TuplesKt.to(Integer.valueOf(alarm.id), Long.valueOf(alarm.time)), Long.valueOf(System.currentTimeMillis()));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean wasRecentlyChecked(Alarm alarm) {
        alarm.getClass();
        Long l = map.get(TuplesKt.to(Integer.valueOf(alarm.id), Long.valueOf(alarm.time)));
        if (l != null) {
            if (System.currentTimeMillis() - l.longValue() >= 1000) {
                l = null;
            }
        }
        return l != null;
    }
}
