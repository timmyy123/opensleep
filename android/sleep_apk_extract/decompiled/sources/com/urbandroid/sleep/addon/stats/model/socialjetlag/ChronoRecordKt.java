package com.urbandroid.sleep.addon.stats.model.socialjetlag;

import com.urbandroid.sleep.addon.stats.model.StatRecord;
import java.util.Date;
import java.util.TimeZone;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/urbandroid/sleep/addon/stats/model/StatRecord;", "Lcom/urbandroid/sleep/addon/stats/model/socialjetlag/ChronoRecord;", "toChronoRecord", "(Lcom/urbandroid/sleep/addon/stats/model/StatRecord;)Lcom/urbandroid/sleep/addon/stats/model/socialjetlag/ChronoRecord;", "Sleep_prodRelease"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class ChronoRecordKt {
    public static final ChronoRecord toChronoRecord(StatRecord statRecord) {
        statRecord.getClass();
        try {
            Date fromDate = statRecord.getFromDate();
            fromDate.getClass();
            Date toDate = statRecord.getToDate();
            toDate.getClass();
            float fromHour = (float) statRecord.getFromHour();
            float toHour = (float) statRecord.getToHour();
            float trackLengthInHours = statRecord.getTrackLengthInHours();
            TimeZone timeZone = statRecord.getTimeZone();
            if (timeZone == null) {
                timeZone = TimeZone.getDefault();
            }
            TimeZone timeZone2 = timeZone;
            timeZone2.getClass();
            return new ChronoRecord(fromDate, toDate, fromHour, toHour, trackLengthInHours, timeZone2);
        } catch (RuntimeException unused) {
            return null;
        }
    }
}
