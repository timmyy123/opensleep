package com.urbandroid.sleep.service.health.session;

import com.urbandroid.sleep.domain.interval.Interval;
import java.util.Date;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\n\u0010\b\u001a\u00020\t*\u00020\u0002\u001a\u0012\u0010\n\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002\u001a\u0012\u0010\f\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007¨\u0006\r"}, d2 = {"duration", "", "Lcom/urbandroid/sleep/service/health/session/HealthInterval;", "getDuration", "(Lcom/urbandroid/sleep/service/health/session/HealthInterval;)J", "isValid", "", "(Lcom/urbandroid/sleep/service/health/session/HealthInterval;)Z", "toInterval", "Lcom/urbandroid/sleep/domain/interval/Interval;", "hasIntersection", "healthInterval", "isExceeding", "Sleep_prodRelease"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class HealthIntervalKt {
    public static final long getDuration(HealthInterval healthInterval) {
        healthInterval.getClass();
        return healthInterval.getToInMillis() - healthInterval.getFromInMillis();
    }

    public static final boolean hasIntersection(HealthInterval healthInterval, HealthInterval healthInterval2) {
        healthInterval.getClass();
        healthInterval2.getClass();
        long time = healthInterval.getFrom().getTime();
        Date to = healthInterval.getTo();
        if (to != null) {
            long time2 = to.getTime();
            long time3 = healthInterval2.getFrom().getTime();
            Date to2 = healthInterval2.getTo();
            if (to2 != null) {
                long time4 = to2.getTime();
                if (time == time3 && time2 == time4) {
                    return true;
                }
                if (time <= time3 && time3 <= time2) {
                    return true;
                }
                if (time3 <= time && time <= time4) {
                    return true;
                }
            }
        }
        return false;
    }

    public static final boolean isExceeding(HealthInterval healthInterval, HealthInterval healthInterval2) {
        healthInterval.getClass();
        healthInterval2.getClass();
        Date to = healthInterval.getTo();
        if (to != null) {
            long time = to.getTime();
            Date to2 = healthInterval2.getTo();
            if (to2 != null) {
                return healthInterval.getFrom().getTime() < healthInterval2.getFrom().getTime() || time > to2.getTime();
            }
        }
        return false;
    }

    public static final boolean isValid(HealthInterval healthInterval) {
        healthInterval.getClass();
        Date to = healthInterval.getTo();
        if (to != null) {
            return to.after(healthInterval.getFrom());
        }
        return false;
    }

    public static final Interval toInterval(HealthInterval healthInterval) {
        healthInterval.getClass();
        return new Interval(healthInterval.getFromInMillis(), healthInterval.getToInMillis());
    }
}
