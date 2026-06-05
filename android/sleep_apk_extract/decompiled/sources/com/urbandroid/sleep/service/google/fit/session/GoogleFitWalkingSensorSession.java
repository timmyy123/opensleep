package com.urbandroid.sleep.service.google.fit.session;

import com.urbandroid.sleep.service.health.HealthDataSourceProvider;
import com.urbandroid.sleep.service.health.session.AbstractWalkingSensorSession;

/* JADX INFO: loaded from: classes5.dex */
public class GoogleFitWalkingSensorSession extends AbstractWalkingSensorSession {
    public GoogleFitWalkingSensorSession(long j, long j2, int i) {
        super(j, j2, i, HealthDataSourceProvider.GOOGLE);
    }

    @Override // com.urbandroid.sleep.service.health.session.HealthInterval
    public String getActivity() {
        return "walking";
    }
}
