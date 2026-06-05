package com.urbandroid.sleep.service.google.fit;

import android.content.Context;
import com.urbandroid.sleep.persistence.ISleepRecordRepository;
import com.urbandroid.sleep.service.google.fit.session.GoogleFitSession;
import com.urbandroid.sleep.service.health.HealthSynchronization;
import com.urbandroid.sleep.service.health.HealthSynchronizationFactory;
import com.urbandroid.sleep.service.health.api.HealthApi;

/* JADX INFO: loaded from: classes5.dex */
public class GoogleFitSynchronizationFactory implements HealthSynchronizationFactory<GoogleFitSession> {
    private static HealthSynchronizationFactory<GoogleFitSession> instance = new GoogleFitSynchronizationFactory();

    public static HealthSynchronizationFactory<GoogleFitSession> getInstance() {
        return instance;
    }

    @Override // com.urbandroid.sleep.service.health.HealthSynchronizationFactory
    public HealthSynchronization create(Context context, HealthApi<GoogleFitSession> healthApi, ISleepRecordRepository iSleepRecordRepository) {
        return new GoogleFitSynchronization(context, healthApi, iSleepRecordRepository);
    }
}
