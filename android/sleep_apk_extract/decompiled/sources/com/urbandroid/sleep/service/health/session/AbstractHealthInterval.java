package com.urbandroid.sleep.service.health.session;

import com.urbandroid.sleep.domain.interval.EventInterval;
import java.util.Date;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0019\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\r\u001a\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/urbandroid/sleep/service/health/session/AbstractHealthInterval;", "Lcom/urbandroid/sleep/service/health/session/HealthInterval;", "Ljava/util/Date;", "from", "to", "<init>", "(Ljava/util/Date;Ljava/util/Date;)V", "Lcom/urbandroid/sleep/domain/interval/EventInterval;", "toWalkingEventInterval", "()Lcom/urbandroid/sleep/domain/interval/EventInterval;", "", "hashCode", "()I", "Ljava/util/Date;", "getFrom", "()Ljava/util/Date;", "getTo", "", "getFromInMillis", "()J", "fromInMillis", "getToInMillis", "toInMillis", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class AbstractHealthInterval implements HealthInterval {
    private final Date from;
    private final Date to;

    public AbstractHealthInterval(Date date, Date date2) {
        date.getClass();
        date2.getClass();
        this.from = date;
        this.to = date2;
    }

    @Override // com.urbandroid.sleep.domain.TimeRecord
    public Date getFrom() {
        return this.from;
    }

    @Override // com.urbandroid.sleep.service.health.session.HealthInterval
    public long getFromInMillis() {
        return getFrom().getTime();
    }

    @Override // com.urbandroid.sleep.domain.TimeRecord
    public Date getTo() {
        return this.to;
    }

    @Override // com.urbandroid.sleep.service.health.session.HealthInterval
    public long getToInMillis() {
        return getTo().getTime();
    }

    public int hashCode() {
        return getTo().hashCode() + (getFrom().hashCode() * 31);
    }

    @Override // com.urbandroid.sleep.service.health.session.HealthInterval
    public EventInterval toWalkingEventInterval() {
        throw new UnsupportedOperationException();
    }
}
