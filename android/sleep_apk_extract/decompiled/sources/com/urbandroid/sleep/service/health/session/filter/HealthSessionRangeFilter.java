package com.urbandroid.sleep.service.health.session.filter;

import com.urbandroid.sleep.domain.interval.Interval;
import com.urbandroid.sleep.service.health.session.HealthIntervalKt;
import com.urbandroid.sleep.service.health.session.HealthSession;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/urbandroid/sleep/service/health/session/filter/HealthSessionRangeFilter;", "Lcom/urbandroid/sleep/service/health/session/filter/HealthSessionFilter;", "interval", "Lcom/urbandroid/sleep/domain/interval/Interval;", "acceptOverlapSession", "", "<init>", "(Lcom/urbandroid/sleep/domain/interval/Interval;Z)V", "accept", "session", "Lcom/urbandroid/sleep/service/health/session/HealthSession;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class HealthSessionRangeFilter implements HealthSessionFilter {
    private final boolean acceptOverlapSession;
    private final Interval interval;

    public HealthSessionRangeFilter(Interval interval, boolean z) {
        interval.getClass();
        this.interval = interval;
        this.acceptOverlapSession = z;
    }

    @Override // com.urbandroid.sleep.service.health.session.filter.HealthSessionFilter
    public boolean accept(HealthSession session) {
        session.getClass();
        if (!HealthIntervalKt.toInterval(session).hasIntersection(this.interval)) {
            return false;
        }
        if (this.acceptOverlapSession) {
            return true;
        }
        Interval union = HealthIntervalKt.toInterval(session).getUnion(this.interval);
        union.getClass();
        return Intrinsics.areEqual(union, this.interval);
    }
}
