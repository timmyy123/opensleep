package com.urbandroid.sleep.service.google.calendar.session;

import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.domain.interval.EventInterval;
import com.urbandroid.sleep.service.google.calendar.FromToZeroMillisIdResolver;
import com.urbandroid.sleep.service.google.calendar.domain.GoogleCalendar;
import com.urbandroid.sleep.service.health.HealthDataSourceProvider;
import com.urbandroid.sleep.service.health.session.AbstractHealthSession;
import java.util.Date;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u0004\u0018\u00010\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/urbandroid/sleep/service/google/calendar/session/GoogleCalendarSession;", "Lcom/urbandroid/sleep/service/health/session/AbstractHealthSession;", "event", "Lcom/urbandroid/sleep/service/google/calendar/domain/GoogleCalendar$Event;", "<init>", "(Lcom/urbandroid/sleep/service/google/calendar/domain/GoogleCalendar$Event;)V", "getEvent", "()Lcom/urbandroid/sleep/service/google/calendar/domain/GoogleCalendar$Event;", "activity", "", "getActivity", "()Ljava/lang/String;", "toSleepRecord", "Lcom/urbandroid/sleep/domain/SleepRecord;", "toWalkingEventInterval", "Lcom/urbandroid/sleep/domain/interval/EventInterval;", "isSportActivity", "", "()Z", "isWalkingActivity", "isSleepActivity", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GoogleCalendarSession extends AbstractHealthSession {
    private final GoogleCalendar.Event event;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoogleCalendarSession(GoogleCalendar.Event event) {
        super(FromToZeroMillisIdResolver.INSTANCE.resolveId(event.getStart(), event.getEnd()), HealthDataSourceProvider.SLEEP, new Date(event.getStart()), new Date(event.getEnd()), null, 16, null);
        event.getClass();
        this.event = event;
    }

    @Override // com.urbandroid.sleep.service.health.session.HealthInterval
    public String getActivity() {
        return "sleep";
    }

    public final GoogleCalendar.Event getEvent() {
        return this.event;
    }

    @Override // com.urbandroid.sleep.service.health.session.HealthSession
    public boolean isSleepActivity() {
        return false;
    }

    @Override // com.urbandroid.sleep.service.health.session.HealthSession
    public boolean isSportActivity() {
        return false;
    }

    @Override // com.urbandroid.sleep.service.health.session.HealthSession
    public boolean isWalkingActivity() {
        return false;
    }

    @Override // com.urbandroid.sleep.service.health.session.HealthSession
    /* JADX INFO: renamed from: toSleepRecord */
    public SleepRecord getSleepRecord() {
        return new SleepRecord(getFrom(), getTo(), this.event.getStartTimezone());
    }

    @Override // com.urbandroid.sleep.service.health.session.AbstractHealthInterval, com.urbandroid.sleep.service.health.session.HealthInterval
    public EventInterval toWalkingEventInterval() {
        throw new IllegalStateException("Converting non walking activity into event interval");
    }
}
