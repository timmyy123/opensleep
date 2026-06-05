package com.urbandroid.sleep.service.health.session.idresolver;

import com.urbandroid.sleep.service.health.session.HealthSession;
import com.urbandroid.sleep.service.health.session.HealthSessionSegment;
import com.urbandroid.util.Md5Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class HealthSessionMd5Builder {
    private boolean doSegments = true;
    private boolean doTimes = true;

    private String getMD5SourceString(HealthSession healthSession) {
        StringBuilder sb = new StringBuilder();
        nullSafeAppend(sb, String.valueOf(1));
        if (this.doTimes) {
            nullSafeDateAppend(sb, healthSession.getFrom());
            nullSafeDateAppend(sb, healthSession.getTo());
        }
        if (this.doSegments) {
            List<HealthSessionSegment> segments = healthSession.getSegments();
            if (!segments.isEmpty()) {
                ArrayList<HealthSessionSegment> arrayList = new ArrayList(segments);
                Collections.sort(arrayList, new Comparator<HealthSessionSegment>() { // from class: com.urbandroid.sleep.service.health.session.idresolver.HealthSessionMd5Builder.1
                    @Override // java.util.Comparator
                    public int compare(HealthSessionSegment healthSessionSegment, HealthSessionSegment healthSessionSegment2) {
                        return Long.valueOf(healthSessionSegment.getFromInMillis()).compareTo(Long.valueOf(healthSessionSegment2.getFromInMillis()));
                    }
                });
                for (HealthSessionSegment healthSessionSegment : arrayList) {
                    sb.append(healthSessionSegment.getSleepSegmentType().normalize());
                    sb.append(healthSessionSegment.getFromInMillis());
                    sb.append(healthSessionSegment.getToInMillis());
                }
            }
        }
        return sb.toString();
    }

    private <T> void nullSafeAppend(StringBuilder sb, T t) {
        if (t == null) {
            t = (T) "NULL";
        }
        sb.append(t);
    }

    private void nullSafeDateAppend(StringBuilder sb, Date date) {
        sb.append(date == null ? "NULL" : Long.valueOf(date.getTime()));
    }

    public String getMD5(HealthSession healthSession) {
        return Md5Util.md5(getMD5SourceString(healthSession));
    }
}
