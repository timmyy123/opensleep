package com.urbandroid.sleep.service.health.api;

import android.app.Activity;
import com.urbandroid.sleep.domain.IEvent;
import com.urbandroid.sleep.service.health.ResultStatus;
import com.urbandroid.sleep.service.health.api.HealthApi;
import com.urbandroid.sleep.service.health.api.SensorRecord;
import com.urbandroid.sleep.service.health.session.HealthSession;
import com.urbandroid.sleep.service.health.session.WalkingSensorSessionContainer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractHealthApi<S extends HealthSession> implements HealthApi<S> {
    @Override // com.urbandroid.sleep.service.health.api.HealthApi
    public int count() {
        return -1;
    }

    @Override // com.urbandroid.sleep.service.health.api.HealthApi
    public ResultStatus delete(Collection<S> collection, HealthApi.Listener listener) {
        return delete(collection);
    }

    @Override // com.urbandroid.sleep.service.health.api.HealthApi
    public int getMaxRecordSyncCount() {
        return Integer.MAX_VALUE;
    }

    @Override // com.urbandroid.sleep.service.health.api.HealthApi
    public HealthUserProfile getUserProfile() {
        return null;
    }

    @Override // com.urbandroid.sleep.service.health.api.HealthApi
    public ResultStatus insertHeartRateData(long j, List<IEvent> list) {
        return ResultStatus.SUCCESS;
    }

    @Override // com.urbandroid.sleep.service.health.api.HealthApi
    public ResultStatus insertSPO2Data(long j, List<IEvent> list) {
        return ResultStatus.SUCCESS;
    }

    @Override // com.urbandroid.sleep.service.health.api.HealthApi
    public List<SensorRecord.HeartRate> readHeartRateData(Activity activity, long j, long j2) {
        return new ArrayList();
    }

    @Override // com.urbandroid.sleep.service.health.api.HealthApi
    public List<SensorRecord.SPO2> readSPO2Data(Activity activity, long j, long j2) {
        return new ArrayList();
    }

    @Override // com.urbandroid.sleep.service.health.api.HealthApi
    public WalkingSensorSessionContainer readStepsData(HealthSession healthSession) {
        return null;
    }
}
