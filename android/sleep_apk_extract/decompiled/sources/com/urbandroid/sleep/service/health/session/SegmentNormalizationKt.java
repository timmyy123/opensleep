package com.urbandroid.sleep.service.health.session;

import java.util.Date;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0019\u0010\u0003\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/urbandroid/sleep/service/health/session/HealthInterval;", "healthInterval", "", "isDirectNeighbor", "(Lcom/urbandroid/sleep/service/health/session/HealthInterval;Lcom/urbandroid/sleep/service/health/session/HealthInterval;)Z", "Sleep_prodRelease"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class SegmentNormalizationKt {
    public static final boolean isDirectNeighbor(HealthInterval healthInterval, HealthInterval healthInterval2) {
        healthInterval.getClass();
        healthInterval2.getClass();
        long time = healthInterval.getFrom().getTime();
        Date to = healthInterval.getTo();
        if (to != null) {
            long time2 = to.getTime();
            long time3 = healthInterval2.getFrom().getTime();
            Date to2 = healthInterval2.getTo();
            if (to2 != null) {
                return time2 + 1 == time3 || to2.getTime() + 1 == time;
            }
        }
        return false;
    }
}
