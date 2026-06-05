package com.urbandroid.sleep.service.health;

import com.urbandroid.sleep.service.health.session.HealthSession;
import java.util.Date;

/* JADX INFO: loaded from: classes5.dex */
public interface HealthSynchronization<S extends HealthSession> {

    public interface ProgressListener {

        public enum Event {
            LOCAL_DB_READ,
            HEALTH_CONNECT,
            HEALTH_READ,
            HEALTH_DELETE,
            HEALTH_INSERT,
            LOCAL_DB_INSERT,
            WALKING_AWAKE_PHASE_INSERT,
            SPORT_TAG_INSERT,
            HEALTH_DISCONNECT,
            HEALTH_READ_HEART_RATE,
            HEALTH_INSERT_HEART_RATE,
            HEALTH_EXPORT_HEART_RATE,
            HEALTH_READ_SPO2,
            HEALTH_INSERT_SPO2,
            HEALTH_EXPORT_SPO2,
            HEALTH_USER_PROFILE
        }

        void end(HealthServiceProvider healthServiceProvider);

        void end(HealthServiceProvider healthServiceProvider, Event event);

        void progress(HealthServiceProvider healthServiceProvider, int i, int i2);

        void start(HealthServiceProvider healthServiceProvider);

        void start(HealthServiceProvider healthServiceProvider, Event event, int i);
    }

    void interrupt();

    void setImportMode(boolean z);

    void setManual(boolean z);

    void synchronize(Date date, ProgressListener progressListener);
}
