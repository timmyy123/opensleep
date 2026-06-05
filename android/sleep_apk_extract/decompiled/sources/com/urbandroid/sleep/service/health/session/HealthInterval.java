package com.urbandroid.sleep.service.health.session;

import com.urbandroid.sleep.domain.TimeRecord;
import com.urbandroid.sleep.domain.interval.EventInterval;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\f\u001a\u0004\u0018\u00010\rH&R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\t¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Lcom/urbandroid/sleep/service/health/session/HealthInterval;", "Lcom/urbandroid/sleep/domain/TimeRecord;", "activity", "", "getActivity", "()Ljava/lang/String;", "fromInMillis", "", "getFromInMillis", "()J", "toInMillis", "getToInMillis", "toWalkingEventInterval", "Lcom/urbandroid/sleep/domain/interval/EventInterval;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface HealthInterval extends TimeRecord {
    String getActivity();

    long getFromInMillis();

    long getToInMillis();

    EventInterval toWalkingEventInterval();
}
