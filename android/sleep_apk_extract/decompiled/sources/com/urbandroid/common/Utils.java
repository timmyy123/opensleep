package com.urbandroid.common;

import java.util.Calendar;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"com/urbandroid/common/Utils__CommonsKt", "com/urbandroid/common/Utils__TimetypesKt"}, k = 4, mv = {1, 9, 0}, xi = 48)
public abstract class Utils {
    public static final <T> void doAsyncThrowOnUI(T t, Function2<? super AsyncContext<T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Utils__CommonsKt.doAsyncThrowOnUI(t, function2);
    }

    public static final String format(Calendar calendar) {
        return Utils__CommonsKt.format(calendar);
    }

    public static final Calendar getCalendar(long j) {
        return Utils__CommonsKt.getCalendar(j);
    }

    public static final long getDays(int i) {
        return Utils__TimetypesKt.getDays(i);
    }

    public static final long getHours(int i) {
        return Utils__TimetypesKt.getHours(i);
    }

    public static final long getHoursInMillis(int i) {
        return Utils__CommonsKt.getHoursInMillis(i);
    }

    public static final long getHoursInMinutes(int i) {
        return Utils__CommonsKt.getHoursInMinutes(i);
    }

    public static final long getMillis(long j) {
        return Utils__TimetypesKt.getMillis(j);
    }

    public static final long getMinutes(int i) {
        return Utils__TimetypesKt.getMinutes(i);
    }

    public static final long getMinutesInMillis(int i) {
        return Utils__CommonsKt.getMinutesInMillis(i);
    }

    public static final String getPrettyDate(long j) {
        return Utils__CommonsKt.getPrettyDate(j);
    }

    public static final long getSeconds(int i) {
        return Utils__TimetypesKt.getSeconds(i);
    }

    public static final long getSecondsInMillis(int i) {
        return Utils__CommonsKt.getSecondsInMillis(i);
    }

    public static final long now() {
        return Utils__CommonsKt.now();
    }

    public static final Calendar plusDays(Calendar calendar, int i) {
        return Utils__CommonsKt.plusDays(calendar, i);
    }

    public static final Calendar toCalendar(String str, String str2) {
        return Utils__CommonsKt.toCalendar(str, str2);
    }

    public static final <T> Object uiThread(AsyncContext<T> asyncContext, Function1<? super T, Unit> function1, Continuation<? super Boolean> continuation) {
        return Utils__CommonsKt.uiThread(asyncContext, function1, continuation);
    }

    public static final String format(Calendar calendar, String str) {
        return Utils__CommonsKt.format(calendar, str);
    }

    public static final long getHoursInMillis(long j) {
        return Utils__CommonsKt.getHoursInMillis(j);
    }

    public static final long getHoursInMinutes(long j) {
        return Utils__CommonsKt.getHoursInMinutes(j);
    }

    public static final long getMinutesInMillis(long j) {
        return Utils__CommonsKt.getMinutesInMillis(j);
    }

    public static final long getSecondsInMillis(long j) {
        return Utils__CommonsKt.getSecondsInMillis(j);
    }

    public static final Calendar toCalendar(Date date) {
        return Utils__CommonsKt.toCalendar(date);
    }
}
