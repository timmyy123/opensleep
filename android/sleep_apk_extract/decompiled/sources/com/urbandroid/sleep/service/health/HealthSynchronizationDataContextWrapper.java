package com.urbandroid.sleep.service.health;

import android.app.Activity;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.service.health.HealthSynchronization;
import com.urbandroid.sleep.service.health.session.HealthSession;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public abstract class HealthSynchronizationDataContextWrapper<S extends HealthSession> implements HealthSynchronizationDataContext<S> {
    private final HealthSynchronizationDataContext<S> context;

    public HealthSynchronizationDataContextWrapper(HealthSynchronizationDataContext<S> healthSynchronizationDataContext) {
        this.context = healthSynchronizationDataContext;
    }

    @Override // com.urbandroid.sleep.service.health.HealthSynchronizationDataContext
    public Activity getActivity() {
        return this.context.getActivity();
    }

    @Override // com.urbandroid.sleep.service.health.HealthSynchronizationDataContext
    public Date getFrom() {
        return this.context.getFrom();
    }

    @Override // com.urbandroid.sleep.service.health.HealthSynchronizationDataContext
    public HealthSynchronization.ProgressListener getListener() {
        return this.context.getListener();
    }

    @Override // com.urbandroid.sleep.service.health.HealthSynchronizationDataContext
    public List<SleepRecord> getNativeSleepRecords() {
        return this.context.getNativeSleepRecords();
    }

    @Override // com.urbandroid.sleep.service.health.HealthSynchronizationDataContext
    public Collection<S> getOtherAppsHealthSessions() {
        return this.context.getOtherAppsHealthSessions();
    }

    @Override // com.urbandroid.sleep.service.health.HealthSynchronizationDataContext
    public Collection<S> getOurAppHealthSessions() {
        return this.context.getOurAppHealthSessions();
    }

    @Override // com.urbandroid.sleep.service.health.HealthSynchronizationDataContext
    public List<HealthSession> getSleepRecords() {
        return this.context.getSleepRecords();
    }
}
