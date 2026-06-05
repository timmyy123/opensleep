package com.urbandroid.sleep.service.health.session.idresolver;

import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.domain.SleepRecordMd5Builder;

/* JADX INFO: loaded from: classes4.dex */
public class MD5IdResolver implements IdResolver {
    @Override // com.urbandroid.sleep.service.health.session.idresolver.IdResolver
    public String resolveId(SleepRecord sleepRecord) {
        return new SleepRecordMd5Builder().setDoEventLabels(true).setDoTimes(true).getMD5(sleepRecord);
    }
}
