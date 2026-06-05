package com.urbandroid.sleep.service.samsung.shealth.session;

import com.urbandroid.sleep.service.health.HealthDataSourceProvider;
import com.urbandroid.sleep.service.health.session.AbstractWalkingSensorSession;

/* JADX INFO: loaded from: classes5.dex */
public class SamsungSHealthWalkingSensorSession extends AbstractWalkingSensorSession {
    public SamsungSHealthWalkingSensorSession(long j, long j2, int i) {
        super(j, j2, i, HealthDataSourceProvider.SAMSUNG);
    }

    @Override // com.urbandroid.sleep.service.health.session.HealthInterval
    public String getActivity() {
        return "com.samsung.health.step_count";
    }
}
