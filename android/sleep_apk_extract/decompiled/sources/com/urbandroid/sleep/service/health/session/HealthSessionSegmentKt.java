package com.urbandroid.sleep.service.health.session;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u0006"}, d2 = {"isInside", "", "Lcom/urbandroid/sleep/service/health/session/HealthSessionSegment;", "from", "", "to", "Sleep_prodRelease"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class HealthSessionSegmentKt {
    public static final boolean isInside(HealthSessionSegment healthSessionSegment, long j, long j2) {
        healthSessionSegment.getClass();
        if (!HealthIntervalKt.isValid(healthSessionSegment)) {
            return false;
        }
        long fromInMillis = healthSessionSegment.getFromInMillis();
        if (j > fromInMillis || fromInMillis > j2) {
            return false;
        }
        long toInMillis = healthSessionSegment.getToInMillis();
        return j <= toInMillis && toInMillis <= j2;
    }
}
