package com.urbandroid.sleep.domain.interval;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.urbandroid.sleep.domain.Event;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ$\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0016\u001a\u0004\b\u0019\u0010\u0018¨\u0006\u001a"}, d2 = {"Lcom/urbandroid/sleep/domain/interval/EventInterval;", "", "Lcom/urbandroid/sleep/domain/Event;", "from", "to", "<init>", "(Lcom/urbandroid/sleep/domain/Event;Lcom/urbandroid/sleep/domain/Event;)V", "Lcom/urbandroid/sleep/domain/interval/Interval;", "toInterval", "()Lcom/urbandroid/sleep/domain/interval/Interval;", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "copy", "(Lcom/urbandroid/sleep/domain/Event;Lcom/urbandroid/sleep/domain/Event;)Lcom/urbandroid/sleep/domain/interval/EventInterval;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/urbandroid/sleep/domain/Event;", "getFrom", "()Lcom/urbandroid/sleep/domain/Event;", "getTo", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class EventInterval {
    private final Event from;
    private final Event to;

    public EventInterval(Event event, Event event2) {
        event.getClass();
        event2.getClass();
        this.from = event;
        this.to = event2;
    }

    public static /* synthetic */ EventInterval copy$default(EventInterval eventInterval, Event event, Event event2, int i, Object obj) {
        if ((i & 1) != 0) {
            event = eventInterval.from;
        }
        if ((i & 2) != 0) {
            event2 = eventInterval.to;
        }
        return eventInterval.copy(event, event2);
    }

    public final EventInterval copy(Event from, Event to) {
        from.getClass();
        to.getClass();
        return new EventInterval(from, to);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EventInterval)) {
            return false;
        }
        EventInterval eventInterval = (EventInterval) other;
        return Intrinsics.areEqual(this.from, eventInterval.from) && Intrinsics.areEqual(this.to, eventInterval.to);
    }

    public final Event getFrom() {
        return this.from;
    }

    public final Event getTo() {
        return this.to;
    }

    public int hashCode() {
        return this.to.hashCode() + (this.from.hashCode() * 31);
    }

    public final Interval toInterval() {
        return new Interval(this.from.getTimestamp(), this.to.getTimestamp());
    }

    public String toString() {
        return this.from.toString() + " - " + toInterval() + " - " + this.to;
    }
}
