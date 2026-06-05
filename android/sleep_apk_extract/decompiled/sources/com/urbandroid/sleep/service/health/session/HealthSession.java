package com.urbandroid.sleep.service.health.session;

import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.domain.interval.Interval;
import com.urbandroid.sleep.service.health.DataSourceProvider;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u000f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u000f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00058&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0007R\u0014\u0010\u0016\u001a\u00020\u00058&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0007R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00178&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010 \u001a\u00020\u00058&X¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u0007R\u0014\u0010!\u001a\u00020\u00058&X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0007R\u0014\u0010\"\u001a\u00020\u00058&X¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u0007R\u0014\u0010#\u001a\u00020\u00058&X¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u0007¨\u0006$À\u0006\u0003"}, d2 = {"Lcom/urbandroid/sleep/service/health/session/HealthSession;", "Lcom/urbandroid/sleep/service/health/session/HealthInterval;", "", "markAsDuplicate", "()V", "", "hasSegments", "()Z", "Lcom/urbandroid/sleep/domain/SleepRecord;", "toSleepRecord", "()Lcom/urbandroid/sleep/domain/SleepRecord;", "Lcom/urbandroid/sleep/domain/interval/Interval;", "cutInterval", "toCutSession", "(Lcom/urbandroid/sleep/domain/interval/Interval;)Lcom/urbandroid/sleep/service/health/session/HealthSession;", "", "getId", "()Ljava/lang/String;", "id", "getTimeZoneId", "timeZoneId", "isBroken", "isDuplicate", "Lcom/urbandroid/sleep/service/health/DataSourceProvider;", "getProvider", "()Lcom/urbandroid/sleep/service/health/DataSourceProvider;", "provider", "", "Lcom/urbandroid/sleep/service/health/session/HealthSessionSegment;", "getSegments", "()Ljava/util/List;", "segments", "isSportActivity", "isWalkingActivity", "isSleepActivity", "isFinished", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface HealthSession extends HealthInterval {
    String getId();

    DataSourceProvider getProvider();

    List<HealthSessionSegment> getSegments();

    String getTimeZoneId();

    boolean hasSegments();

    boolean isBroken();

    boolean isDuplicate();

    boolean isFinished();

    boolean isSleepActivity();

    boolean isSportActivity();

    boolean isWalkingActivity();

    void markAsDuplicate();

    HealthSession toCutSession(Interval cutInterval);

    SleepRecord toSleepRecord();
}
