package com.urbandroid.sleep.service.health;

import android.content.Context;
import com.urbandroid.sleep.persistence.ISleepRecordRepository;
import com.urbandroid.sleep.service.health.api.HealthApi;
import com.urbandroid.sleep.service.health.session.HealthSession;

/* JADX INFO: loaded from: classes5.dex */
public interface HealthSynchronizationFactory<S extends HealthSession> {
    HealthSynchronization create(Context context, HealthApi<S> healthApi, ISleepRecordRepository iSleepRecordRepository);
}
