package com.urbandroid.sleep.service.health.session.idresolver;

import com.urbandroid.sleep.domain.SleepRecord;

/* JADX INFO: loaded from: classes5.dex */
public class FromToIdResolver implements IdResolver {
    public static String resolveId(long j, long j2) {
        return String.valueOf(j) + String.valueOf(j2);
    }

    @Override // com.urbandroid.sleep.service.health.session.idresolver.IdResolver
    public String resolveId(SleepRecord sleepRecord) {
        return resolveId(sleepRecord.getFrom().getTime(), sleepRecord.getTo().getTime());
    }
}
