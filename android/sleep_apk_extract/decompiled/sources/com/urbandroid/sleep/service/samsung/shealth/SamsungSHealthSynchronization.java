package com.urbandroid.sleep.service.samsung.shealth;

import android.content.Context;
import com.urbandroid.sleep.persistence.ISleepRecordRepository;
import com.urbandroid.sleep.service.health.AbstractHealthSynchronization;
import com.urbandroid.sleep.service.health.HealthServiceProvider;
import com.urbandroid.sleep.service.health.HealthSynchronizationDataContext;
import com.urbandroid.sleep.service.health.HealthSynchronizationDataContextWrapper;
import com.urbandroid.sleep.service.samsung.shealth.api.SamsungSHealthApi;
import com.urbandroid.sleep.service.samsung.shealth.session.SamsungSHealthSession;
import java.util.Calendar;
import java.util.Date;

/* JADX INFO: loaded from: classes5.dex */
public class SamsungSHealthSynchronization extends AbstractHealthSynchronization<SamsungSHealthSession> {
    private final HealthServiceProvider serviceProvider;

    public SamsungSHealthSynchronization(Context context, SamsungSHealthApi samsungSHealthApi, ISleepRecordRepository iSleepRecordRepository) {
        super(context, samsungSHealthApi, iSleepRecordRepository);
        this.serviceProvider = HealthServiceProvider.SamsungSHealth.INSTANCE;
    }

    private SamsungSHealthApi getApi() {
        return (SamsungSHealthApi) this.healthApi;
    }

    @Override // com.urbandroid.sleep.service.health.AbstractHealthSynchronization
    public boolean cleanUpOverlapsWithCloudTag() {
        return true;
    }

    @Override // com.urbandroid.sleep.service.health.AbstractHealthSynchronization
    public HealthServiceProvider getServiceProvider() {
        return this.serviceProvider;
    }

    @Override // com.urbandroid.sleep.service.health.AbstractHealthSynchronization
    public boolean hasDeleteAllSleepHealthRecords() {
        return false;
    }

    @Override // com.urbandroid.sleep.service.health.AbstractHealthSynchronization
    public boolean isExportHeartRatesSupported() {
        return false;
    }

    @Override // com.urbandroid.sleep.service.health.AbstractHealthSynchronization
    public boolean isImportHeartRatesEnabled() {
        return true;
    }

    @Override // com.urbandroid.sleep.service.health.AbstractHealthSynchronization
    public boolean isImportWalkingStepsEnabled() {
        return getApi() != null && getApi().hasPermissions(SamsungSHealthApi.STEPS_PERMISSIONS);
    }

    @Override // com.urbandroid.sleep.service.health.AbstractHealthSynchronization
    public void synchronizeHeartRates(HealthSynchronizationDataContext<SamsungSHealthSession> healthSynchronizationDataContext) {
        super.synchronizeHeartRates(new HealthSynchronizationDataContextWrapper<SamsungSHealthSession>(healthSynchronizationDataContext) { // from class: com.urbandroid.sleep.service.samsung.shealth.SamsungSHealthSynchronization.1
            @Override // com.urbandroid.sleep.service.health.HealthSynchronizationDataContextWrapper, com.urbandroid.sleep.service.health.HealthSynchronizationDataContext
            public Date getFrom() {
                Date from = super.getFrom();
                Calendar calendar = Calendar.getInstance();
                calendar.add(6, -7);
                return from.before(calendar.getTime()) ? calendar.getTime() : from;
            }
        });
    }
}
