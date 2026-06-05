package com.urbandroid.sleep.addon.stats.model.socialjetlag;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import j$.util.DesugarTimeZone;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0016\u0018\u00002\u00020\u0001B;\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0019\u0010\u0014J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001d\u001a\u0004\b \u0010\u001fR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010\u0007\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010!\u001a\u0004\b$\u0010#R\u0017\u0010\b\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\b\u0010!\u001a\u0004\b%\u0010#R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010&\u001a\u0004\b'\u0010(R\u0017\u0010)\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b)\u0010!\u001a\u0004\b*\u0010#R\u0017\u0010+\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b+\u0010!\u001a\u0004\b,\u0010#R\u0017\u0010-\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b-\u0010!\u001a\u0004\b\u0010\u0010#R\u0017\u0010.\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b.\u0010!\u001a\u0004\b/\u0010#¨\u00060"}, d2 = {"Lcom/urbandroid/sleep/addon/stats/model/socialjetlag/ChronoRecord;", "", "Ljava/util/Date;", "from", "to", "", "fromHour", "toHour", "length", "Ljava/util/TimeZone;", "timeZone", "<init>", "(Ljava/util/Date;Ljava/util/Date;FFFLjava/util/TimeZone;)V", "d", "getHourUTC", "(Ljava/util/Date;)F", "getMidSleep", "(FF)F", "", "getEndDayOfWeek", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Ljava/util/Date;", "getFrom", "()Ljava/util/Date;", "getTo", "F", "getFromHour", "()F", "getToHour", "getLength", "Ljava/util/TimeZone;", "getTimeZone", "()Ljava/util/TimeZone;", "fromHourUTC", "getFromHourUTC", "toHourUTC", "getToHourUTC", "midSleep", "midSleepUTC", "getMidSleepUTC", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ChronoRecord {
    private final Date from;
    private final float fromHour;
    private final float fromHourUTC;
    private final float length;
    private final float midSleep;
    private final float midSleepUTC;
    private final TimeZone timeZone;
    private final Date to;
    private final float toHour;
    private final float toHourUTC;

    public ChronoRecord(Date date, Date date2, float f, float f2, float f3, TimeZone timeZone) {
        date.getClass();
        date2.getClass();
        timeZone.getClass();
        this.from = date;
        this.to = date2;
        this.fromHour = f;
        this.toHour = f2;
        this.length = f3;
        this.timeZone = timeZone;
        float hourUTC = getHourUTC(date);
        this.fromHourUTC = hourUTC;
        float hourUTC2 = getHourUTC(date2);
        this.toHourUTC = hourUTC2;
        this.midSleep = getMidSleep(f, f2);
        this.midSleepUTC = getMidSleep(hourUTC, hourUTC2);
        if (date.getTime() > date2.getTime()) {
            throw new IllegalArgumentException(date + " > " + date2);
        }
        if (date2.getTime() - date.getTime() > 72000000) {
            throw new IllegalArgumentException(date2 + " - " + date + " > one day");
        }
        if (f < 0.0f || f >= 24.0f) {
            Events$$ExternalSyntheticBUOutline0.m("Invalid fromHour: ", f);
            throw null;
        }
        if (f2 < 0.0f || f2 >= 24.0f) {
            Events$$ExternalSyntheticBUOutline0.m("Invalid toHour: ", f2);
            throw null;
        }
    }

    private final float getHourUTC(Date d) {
        Calendar calendar = Calendar.getInstance(DesugarTimeZone.getTimeZone("UTC"));
        calendar.setTime(d);
        return (calendar.get(13) / 3600.0f) + (calendar.get(12) / 60.0f) + calendar.get(11);
    }

    private final float getMidSleep(float fromHour, float toHour) {
        if (fromHour <= toHour) {
            return (fromHour + toHour) / 2.0f;
        }
        float f = ((fromHour + toHour) / 2.0f) + 12.0f;
        return f < 24.0f ? f : f - 24.0f;
    }

    public boolean equals(Object other) {
        return (other instanceof ChronoRecord) && Intrinsics.areEqual(((ChronoRecord) other).to, this.to);
    }

    public final int getEndDayOfWeek() {
        Calendar calendar = Calendar.getInstance(this.timeZone);
        calendar.setTime(this.to);
        return calendar.get(7);
    }

    public final float getFromHour() {
        return this.fromHour;
    }

    public final float getLength() {
        return this.length;
    }

    public final float getMidSleepUTC() {
        return this.midSleepUTC;
    }

    public final Date getTo() {
        return this.to;
    }

    public final float getToHour() {
        return this.toHour;
    }

    public int hashCode() {
        return this.to.hashCode();
    }

    public String toString() {
        return "ChronoRecord(from=" + this.from + ", to=" + this.to + ", length=" + this.length + ", midSleep=" + this.midSleep + ")";
    }

    public final float getMidSleep() {
        return this.midSleep;
    }
}
