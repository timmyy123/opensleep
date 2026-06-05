package com.urbandroid.sleep.service.health;

import android.app.Activity;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.service.health.HealthSynchronization;
import com.urbandroid.sleep.service.health.session.HealthSession;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public interface HealthSynchronizationDataContext<S extends HealthSession> {
    Activity getActivity();

    Date getFrom();

    HealthSynchronization.ProgressListener getListener();

    List<SleepRecord> getNativeSleepRecords();

    Collection<S> getOtherAppsHealthSessions();

    Collection<S> getOurAppHealthSessions();

    List<HealthSession> getSleepRecords();
}
