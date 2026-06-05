package com.urbandroid.sleep.service.health.session.filter;

import com.urbandroid.sleep.service.health.session.HealthIntervalKt;
import com.urbandroid.sleep.service.health.session.HealthSession;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/urbandroid/sleep/service/health/session/filter/HealthSessionDurationFilter;", "Lcom/urbandroid/sleep/service/health/session/filter/HealthSessionFilter;", "minDuration", "", "maxDuration", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;)V", "Ljava/lang/Long;", "accept", "", "session", "Lcom/urbandroid/sleep/service/health/session/HealthSession;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class HealthSessionDurationFilter implements HealthSessionFilter {
    private final Long maxDuration;
    private final Long minDuration;

    public HealthSessionDurationFilter(Long l, Long l2) {
        this.minDuration = l;
        this.maxDuration = l2;
    }

    @Override // com.urbandroid.sleep.service.health.session.filter.HealthSessionFilter
    public boolean accept(HealthSession session) {
        session.getClass();
        long duration = HealthIntervalKt.getDuration(session);
        Long l = this.minDuration;
        if (l != null && duration < l.longValue()) {
            return false;
        }
        Long l2 = this.maxDuration;
        return l2 == null || duration <= l2.longValue();
    }
}
