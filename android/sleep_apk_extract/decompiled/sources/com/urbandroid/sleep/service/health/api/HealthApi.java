package com.urbandroid.sleep.service.health.api;

import android.app.Activity;
import com.urbandroid.sleep.domain.IEvent;
import com.urbandroid.sleep.service.health.ResultStatus;
import com.urbandroid.sleep.service.health.api.SensorRecord;
import com.urbandroid.sleep.service.health.session.HealthSession;
import com.urbandroid.sleep.service.health.session.WalkingSensorSessionContainer;
import com.urbandroid.sleep.service.health.session.idresolver.IdResolver;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public interface HealthApi<S extends HealthSession> {

    public interface Listener {
        void deleted(int i);
    }

    boolean connect();

    int count();

    ResultStatus delete(Collection<S> collection);

    ResultStatus delete(Collection<S> collection, Listener listener);

    void disconnect();

    Collection<S> find(Date date, Date date2);

    IdResolver getIdResolver();

    int getMaxRecordSyncCount();

    HealthUserProfile getUserProfile();

    ResultStatus insert(HealthSession healthSession);

    ResultStatus insertHeartRateData(long j, List<IEvent> list);

    ResultStatus insertSPO2Data(long j, List<IEvent> list);

    boolean isConnected();

    List<SensorRecord.HeartRate> readHeartRateData(Activity activity, long j, long j2);

    List<SensorRecord.SPO2> readSPO2Data(Activity activity, long j, long j2);

    WalkingSensorSessionContainer<?> readStepsData(HealthSession healthSession);
}
