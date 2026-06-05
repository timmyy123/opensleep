package com.urbandroid.sleep.service.samsung.shealth.session;

import androidx.fragment.app.Fragment$$ExternalSyntheticBUOutline0;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.domain.Event;
import com.urbandroid.sleep.domain.EventLabel;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.domain.interval.EventInterval;
import com.urbandroid.sleep.service.health.DataSourceProvider;
import com.urbandroid.sleep.service.health.HeathSyncKt;
import com.urbandroid.sleep.service.health.session.AbstractHealthSession;
import com.urbandroid.sleep.service.health.session.HealthSessionSegment;
import com.urbandroid.sleep.service.health.session.HealthSessionSegmentKt;
import com.urbandroid.sleep.service.health.session.SleepSegmentType;
import com.urbandroid.sleep.service.health.session.idresolver.FromToSegmentIdResolver;
import com.urbandroid.util.TimeZoneUtils;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public class SamsungSHealthSession extends AbstractHealthSession {
    private final String dataType;
    private final int exerciseType;
    private transient String id;
    private transient boolean needResolveId;
    private final String uuid;

    public SamsungSHealthSession(DataSourceProvider dataSourceProvider, String str, Date date, Date date2, long j, String str2, int i) {
        super(FromToSegmentIdResolver.resolveId(date.getTime(), date2.getTime()), dataSourceProvider, date, date2, TimeZoneUtils.resolve(j, TimeUnit.MILLISECONDS).getID());
        this.needResolveId = true;
        this.uuid = str;
        this.dataType = str2;
        this.exerciseType = i;
    }

    public void addSegment(SamsungSHealthSessionSegment samsungSHealthSessionSegment) {
        getSegments().add(samsungSHealthSessionSegment);
        this.needResolveId = true;
    }

    @Override // com.urbandroid.sleep.service.health.session.HealthInterval
    public String getActivity() {
        return this.dataType;
    }

    @Override // com.urbandroid.sleep.service.health.session.AbstractHealthSession, com.urbandroid.sleep.service.health.session.HealthSession
    public String getId() {
        if (this.needResolveId) {
            this.id = FromToSegmentIdResolver.resolveId(this);
            this.needResolveId = false;
        }
        return this.id;
    }

    public String getUuid() {
        return this.uuid;
    }

    @Override // com.urbandroid.sleep.service.health.session.HealthSession
    public boolean isSleepActivity() {
        return this.dataType.equals("com.samsung.health.sleep");
    }

    @Override // com.urbandroid.sleep.service.health.session.HealthSession
    public boolean isSportActivity() {
        return this.dataType.equals("com.samsung.health.exercise");
    }

    @Override // com.urbandroid.sleep.service.health.session.HealthSession
    public boolean isWalkingActivity() {
        return isSportActivity() && this.exerciseType == 1001;
    }

    @Override // com.urbandroid.sleep.service.health.session.HealthSession
    /* JADX INFO: renamed from: toSleepRecord */
    public SleepRecord getSleepRecord() {
        if (!isSleepActivity()) {
            Fragment$$ExternalSyntheticBUOutline0.m$1("Converting non sleep activity(", getActivity(), ") to Sleep Record");
            return null;
        }
        SleepRecord sleepRecord = new SleepRecord(getFrom(), getTo(), getTimeZoneId());
        long fromInMillis = getFromInMillis();
        long toInMillis = getToInMillis();
        for (HealthSessionSegment healthSessionSegment : getSegments()) {
            SleepSegmentType sleepSegmentType = healthSessionSegment.getSleepSegmentType();
            if (sleepSegmentType == null || !HealthSessionSegmentKt.isInside(healthSessionSegment, fromInMillis, toInMillis)) {
                Logger.logWarning("toSleepRecord: shealth wrong segment: " + HeathSyncKt.pretty(healthSessionSegment));
            } else {
                sleepRecord.addEventLabel(sleepSegmentType.getStartLabel(), Math.max(fromInMillis, healthSessionSegment.getFromInMillis()));
                sleepRecord.addEventLabel(sleepSegmentType.getEndLabel(), Math.min(toInMillis, healthSessionSegment.getToInMillis()));
            }
        }
        return sleepRecord;
    }

    @Override // com.urbandroid.sleep.service.health.session.AbstractHealthInterval, com.urbandroid.sleep.service.health.session.HealthInterval
    public EventInterval toWalkingEventInterval() {
        if (isWalkingActivity()) {
            return new EventInterval(new Event(getFromInMillis(), EventLabel.WALKING_START), new Event(getToInMillis(), EventLabel.WALKING_END));
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("Converting non walking activity into event interval");
        return null;
    }
}
