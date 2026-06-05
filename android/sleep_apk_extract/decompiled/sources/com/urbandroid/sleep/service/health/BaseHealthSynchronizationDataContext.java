package com.urbandroid.sleep.service.health;

import android.app.Activity;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.service.health.HealthSynchronization;
import com.urbandroid.sleep.service.health.session.HealthSession;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class BaseHealthSynchronizationDataContext<S extends HealthSession> implements HealthSynchronizationDataContext<S> {
    private final Activity activity;
    private final Date from;
    private final HealthSynchronization.ProgressListener listener;
    private final Collection<S> otherAppsHealthSessions;
    private final Collection<S> ourAppHealthSessions;
    private final List<HealthSession> sleepRecords;

    public BaseHealthSynchronizationDataContext(Activity activity, HealthSynchronization.ProgressListener progressListener, Date date, List<HealthSession> list, Collection<S> collection, Collection<S> collection2) {
        this.activity = activity;
        this.listener = progressListener;
        this.from = date;
        this.sleepRecords = list;
        this.ourAppHealthSessions = collection;
        this.otherAppsHealthSessions = collection2;
    }

    @Override // com.urbandroid.sleep.service.health.HealthSynchronizationDataContext
    public Activity getActivity() {
        return this.activity;
    }

    @Override // com.urbandroid.sleep.service.health.HealthSynchronizationDataContext
    public Date getFrom() {
        return this.from;
    }

    @Override // com.urbandroid.sleep.service.health.HealthSynchronizationDataContext
    public HealthSynchronization.ProgressListener getListener() {
        return this.listener;
    }

    @Override // com.urbandroid.sleep.service.health.HealthSynchronizationDataContext
    public List<SleepRecord> getNativeSleepRecords() {
        return HeathSyncKt.toSleepRecords(this.sleepRecords);
    }

    @Override // com.urbandroid.sleep.service.health.HealthSynchronizationDataContext
    public Collection<S> getOtherAppsHealthSessions() {
        return this.otherAppsHealthSessions;
    }

    @Override // com.urbandroid.sleep.service.health.HealthSynchronizationDataContext
    public Collection<S> getOurAppHealthSessions() {
        return this.ourAppHealthSessions;
    }

    @Override // com.urbandroid.sleep.service.health.HealthSynchronizationDataContext
    public List<HealthSession> getSleepRecords() {
        return this.sleepRecords;
    }
}
