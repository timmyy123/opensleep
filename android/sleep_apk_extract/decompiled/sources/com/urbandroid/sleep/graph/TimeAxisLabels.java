package com.urbandroid.sleep.graph;

import android.content.Context;
import com.urbandroid.common.util.DateUtil;
import com.urbandroid.sleep.service.Settings;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public class TimeAxisLabels extends StaticAxisLabels<Float> {
    private final DateFormat format;
    private final DateFormat format2;
    private final Date from;
    private int minutes;
    private final int pointsCount;
    private final Date to;
    private static SimpleDateFormat hours24hFormat = new SimpleDateFormat("H");
    private static SimpleDateFormat hours12hFormat = new SimpleDateFormat("h");
    private static SimpleDateFormat hoursMinutes24hFormat = new SimpleDateFormat("H:mm");
    private static SimpleDateFormat hoursMinutes12hFormat = new SimpleDateFormat("h:mm");

    public TimeAxisLabels(Context context, Date date, Date date2, String str, int i, int i2) {
        this.minutes = 60;
        if (date == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$3();
            throw null;
        }
        if (date2 == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$3();
            throw null;
        }
        boolean zIs24HourFormat = new Settings(context).is24HourFormat();
        SimpleDateFormat simpleDateFormat = zIs24HourFormat ? hours24hFormat : hours12hFormat;
        this.format = simpleDateFormat;
        SimpleDateFormat simpleDateFormat2 = zIs24HourFormat ? hoursMinutes24hFormat : hoursMinutes12hFormat;
        this.format2 = simpleDateFormat2;
        if (str != null) {
            simpleDateFormat.setTimeZone(DateUtil.getTimeZone(str));
            simpleDateFormat2.setTimeZone(DateUtil.getTimeZone(str));
        }
        this.from = date;
        this.to = date2;
        this.pointsCount = Math.max(i, 1);
        this.minutes = i2;
        precalculatePositions();
    }

    private void addInitialTime() {
        super.addLabel(Float.valueOf(0.0f), this.format2.format(this.from));
    }

    private void addLastTime() {
        super.addLabel(Float.valueOf(Math.max(this.pointsCount - 1, 1.0f)), this.format2.format(this.to));
    }

    private void precalculatePositions() {
        long time = this.from.getTime();
        long time2 = this.to.getTime();
        long j = (time2 - time) / ((long) this.pointsCount);
        Calendar calendar = Calendar.getInstance();
        long jNextFullHourTimestamp = nextFullHourTimestamp(time);
        while (jNextFullHourTimestamp < time2) {
            Date date = new Date(jNextFullHourTimestamp);
            float f = (jNextFullHourTimestamp - time) / j;
            calendar.setTimeInMillis(jNextFullHourTimestamp);
            String str = ".";
            if ((this.minutes != 15 || calendar.get(12) != 15) && calendar.get(12) != 45 && ((this.minutes != 30 || calendar.get(12) != 30) && this.minutes != -1)) {
                str = (calendar.get(12) == 0 ? this.format : this.format2).format(date);
            }
            super.addLabel(Float.valueOf(f), str);
            jNextFullHourTimestamp = nextFullHourTimestamp(jNextFullHourTimestamp);
        }
        addInitialTime();
        addLastTime();
    }

    public long nextFullHourTimestamp(long j) {
        long millis = TimeUnit.MINUTES.toMillis(this.minutes);
        return ((j / millis) * millis) + millis;
    }

    public TimeAxisLabels(Context context, Date date, Date date2, String str, int i) {
        this(context, date, date2, str, i, 60);
    }
}
