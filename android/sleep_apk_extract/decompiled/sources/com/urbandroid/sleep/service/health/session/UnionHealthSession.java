package com.urbandroid.sleep.service.health.session;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.domain.interval.EventInterval;
import com.urbandroid.sleep.domain.interval.Interval;
import com.urbandroid.sleep.service.health.DataSourceProvider;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class UnionHealthSession implements HealthSession {
    private final List<HealthSession> sessions;
    private boolean isBroken = false;
    private boolean isDuplicate = false;
    private final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public UnionHealthSession(HealthSession... healthSessionArr) {
        this.sessions = healthSessionArr == null ? new ArrayList() : new ArrayList(Arrays.asList(healthSessionArr));
    }

    public UnionHealthSession add(HealthSession healthSession) {
        this.sessions.add(healthSession);
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof HealthSession) && getId().equals(((HealthSession) obj).getId());
    }

    @Override // com.urbandroid.sleep.domain.TimeRecord
    public Date getFrom() {
        Date from = null;
        if (this.sessions.isEmpty()) {
            return null;
        }
        for (HealthSession healthSession : this.sessions) {
            if (from == null || from.after(healthSession.getFrom())) {
                from = healthSession.getFrom();
            }
        }
        return from;
    }

    @Override // com.urbandroid.sleep.service.health.session.HealthInterval
    public long getFromInMillis() {
        if (this.sessions.isEmpty()) {
            return 0L;
        }
        Iterator<HealthSession> it = this.sessions.iterator();
        long jMin = Long.MAX_VALUE;
        while (it.hasNext()) {
            jMin = Math.min(jMin, it.next().getFromInMillis());
        }
        return jMin;
    }

    @Override // com.urbandroid.sleep.service.health.session.HealthSession
    public String getId() {
        if (this.sessions.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<HealthSession> it = this.sessions.iterator();
        while (it.hasNext()) {
            sb.append(it.next().getId());
        }
        return sb.toString();
    }

    @Override // com.urbandroid.sleep.service.health.session.HealthSession
    public DataSourceProvider getProvider() {
        if (this.sessions.isEmpty()) {
            return null;
        }
        return this.sessions.get(0).getProvider();
    }

    @Override // com.urbandroid.sleep.service.health.session.HealthSession
    public List<HealthSessionSegment> getSegments() {
        if (this.sessions.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<HealthSession> it = this.sessions.iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().getSegments());
        }
        return arrayList;
    }

    @Override // com.urbandroid.sleep.service.health.session.HealthSession
    public String getTimeZoneId() {
        if (this.sessions.isEmpty()) {
            return null;
        }
        return this.sessions.get(0).getTimeZoneId();
    }

    @Override // com.urbandroid.sleep.domain.TimeRecord
    public Date getTo() {
        Date to = null;
        if (this.sessions.isEmpty()) {
            return null;
        }
        for (HealthSession healthSession : this.sessions) {
            if (to == null || to.before(healthSession.getTo())) {
                to = healthSession.getTo();
            }
        }
        return to;
    }

    @Override // com.urbandroid.sleep.service.health.session.HealthInterval
    public long getToInMillis() {
        if (this.sessions.isEmpty()) {
            return 0L;
        }
        Iterator<HealthSession> it = this.sessions.iterator();
        long jMax = Long.MIN_VALUE;
        while (it.hasNext()) {
            jMax = Math.max(jMax, it.next().getToInMillis());
        }
        return jMax;
    }

    @Override // com.urbandroid.sleep.service.health.session.HealthSession
    public boolean hasSegments() {
        Iterator<HealthSession> it = this.sessions.iterator();
        while (it.hasNext()) {
            if (it.next().hasSegments()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return getId().hashCode() + (super.hashCode() * 31);
    }

    @Override // com.urbandroid.sleep.service.health.session.HealthSession
    /* JADX INFO: renamed from: isBroken */
    public boolean getIsBroken() {
        return this.isBroken;
    }

    @Override // com.urbandroid.sleep.service.health.session.HealthSession
    /* JADX INFO: renamed from: isDuplicate */
    public boolean getIsDuplicate() {
        return this.isDuplicate;
    }

    @Override // com.urbandroid.sleep.service.health.session.HealthSession
    /* JADX INFO: renamed from: isFinished */
    public boolean getIsFinished() {
        return true;
    }

    @Override // com.urbandroid.sleep.service.health.session.HealthSession
    public boolean isSleepActivity() {
        Iterator<HealthSession> it = this.sessions.iterator();
        while (it.hasNext()) {
            if (!it.next().isSleepActivity()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.urbandroid.sleep.service.health.session.HealthSession
    public boolean isSportActivity() {
        Iterator<HealthSession> it = this.sessions.iterator();
        while (it.hasNext()) {
            if (!it.next().isSportActivity()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.urbandroid.sleep.service.health.session.HealthSession
    public boolean isWalkingActivity() {
        Iterator<HealthSession> it = this.sessions.iterator();
        while (it.hasNext()) {
            if (!it.next().isWalkingActivity()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.urbandroid.sleep.service.health.session.HealthSession
    public void markAsDuplicate() {
        this.isDuplicate = true;
    }

    @Override // com.urbandroid.sleep.service.health.session.HealthSession
    public HealthSession toCutSession(Interval interval) {
        throw new UnsupportedOperationException();
    }

    @Override // com.urbandroid.sleep.service.health.session.HealthSession
    public SleepRecord toSleepRecord() {
        SleepRecord sleepRecord = new SleepRecord(getFrom(), getTo(), getTimeZoneId());
        for (HealthSessionSegment healthSessionSegment : getSegments()) {
            SleepSegmentType sleepSegmentType = healthSessionSegment.getSleepSegmentType();
            if (sleepSegmentType != null) {
                sleepRecord.addEventLabel(sleepSegmentType.getStartLabel(), healthSessionSegment.getFromInMillis());
                sleepRecord.addEventLabel(sleepSegmentType.getEndLabel(), healthSessionSegment.getToInMillis());
            }
        }
        return sleepRecord;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("UnionHealthSession{, from=");
        sb.append(getFromInMillis());
        sb.append(" ");
        sb.append(this.format.format(getFrom()));
        sb.append(", to=");
        sb.append(getToInMillis());
        sb.append(" ");
        sb.append(this.format.format(getTo()));
        sb.append("sessions=");
        sb.append(this.sessions);
        sb.append(", isBroken=");
        return Fragment$$ExternalSyntheticOutline1.m(sb, this.isBroken, '}');
    }

    @Override // com.urbandroid.sleep.service.health.session.HealthInterval
    public EventInterval toWalkingEventInterval() {
        throw new UnsupportedOperationException();
    }
}
