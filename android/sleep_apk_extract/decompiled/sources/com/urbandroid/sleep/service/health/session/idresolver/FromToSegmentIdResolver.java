package com.urbandroid.sleep.service.health.session.idresolver;

import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.service.health.session.HealthSession;
import com.urbandroid.sleep.service.health.session.SleepRecordHealthSession;

/* JADX INFO: loaded from: classes5.dex */
public class FromToSegmentIdResolver implements IdResolver {
    public static String resolveId(long j, long j2) {
        return String.valueOf(j) + String.valueOf(j2);
    }

    public static String resolveId(HealthSession healthSession) {
        return new HealthSessionMd5Builder().getMD5(healthSession);
    }

    @Override // com.urbandroid.sleep.service.health.session.idresolver.IdResolver
    public String resolveId(SleepRecord sleepRecord) {
        return resolveId(new SleepRecordHealthSession(sleepRecord, new FromToIdResolver()));
    }
}
