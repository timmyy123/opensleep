package com.urbandroid.sleep.service.google.fit.api;

import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.service.health.session.HealthSession;
import com.urbandroid.sleep.service.health.session.UnionHealthSession;
import com.urbandroid.util.Experiments;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class GoogleFitSessionPostMerger {
    private final boolean removeOldestOne;

    public GoogleFitSessionPostMerger(boolean z) {
        this.removeOldestOne = z;
    }

    public List<? extends HealthSession> merge(List<? extends HealthSession> list) {
        if (list.size() < 2) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        Collections.sort(list, new Comparator<HealthSession>() { // from class: com.urbandroid.sleep.service.google.fit.api.GoogleFitSessionPostMerger.1
            @Override // java.util.Comparator
            public int compare(HealthSession healthSession, HealthSession healthSession2) {
                return Long.valueOf(healthSession.getFromInMillis()).compareTo(Long.valueOf(healthSession2.getFromInMillis()));
            }
        });
        boolean z = false;
        HealthSession healthSession = null;
        UnionHealthSession unionHealthSession = null;
        UnionHealthSession unionHealthSession2 = null;
        for (HealthSession healthSession2 : list) {
            if (healthSession != null) {
                if (Experiments.getInstance().isXiaomiMergeSessionFix()) {
                    if (healthSession2.getFromInMillis() == healthSession.getFromInMillis() && healthSession2.getToInMillis() == healthSession.getToInMillis()) {
                        Logger.logWarning("Same sessions: session1: " + healthSession.toString() + " session2: " + healthSession2);
                    } else if (healthSession2.getFromInMillis() < healthSession.getToInMillis()) {
                        Logger.logWarning("Merge conflict: session1: " + healthSession.toString() + " session2: " + healthSession2);
                    }
                }
                if (healthSession.getToInMillis() == healthSession2.getFromInMillis()) {
                    z = true;
                    if (unionHealthSession == null) {
                        unionHealthSession = new UnionHealthSession(healthSession);
                        unionHealthSession2 = unionHealthSession;
                    }
                    unionHealthSession.add(healthSession2);
                } else {
                    if (unionHealthSession != null) {
                        arrayList.add(unionHealthSession);
                        unionHealthSession = null;
                    } else {
                        arrayList.add(healthSession);
                    }
                    z = false;
                }
            }
            healthSession = healthSession2;
        }
        if (!z) {
            arrayList.add(healthSession);
        }
        if (unionHealthSession != null) {
            arrayList.add(unionHealthSession);
        }
        if (this.removeOldestOne && unionHealthSession2 != null) {
            arrayList.remove(0);
        }
        Logger.logWarning("Merge done: " + arrayList.size());
        return arrayList;
    }
}
