package com.urbandroid.sleep.service.health.session;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001a\u00020\u0007H\u0016R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/urbandroid/sleep/service/health/session/HealthSessionSegment;", "Lcom/urbandroid/sleep/service/health/session/HealthInterval;", "sleepSegmentType", "Lcom/urbandroid/sleep/service/health/session/SleepSegmentType;", "getSleepSegmentType", "()Lcom/urbandroid/sleep/service/health/session/SleepSegmentType;", "short", "", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface HealthSessionSegment extends HealthInterval {
    SleepSegmentType getSleepSegmentType();

    /* JADX INFO: renamed from: short */
    default String mo2047short() {
        SleepSegmentType sleepSegmentType = getSleepSegmentType();
        char code = sleepSegmentType != null ? sleepSegmentType.getCode() : 'N';
        long duration = HealthIntervalKt.getDuration(this) / 60000;
        StringBuilder sb = new StringBuilder();
        sb.append(code);
        sb.append(duration);
        return sb.toString();
    }
}
