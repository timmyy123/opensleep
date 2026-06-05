package com.urbandroid.sleep.service.health.session;

import com.urbandroid.sleep.service.health.session.filter.HealthSessionFilter;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public abstract class HealthSessionUtil {
    public static <S extends HealthSession> List<S> filter(Collection<S> collection, HealthSessionFilter healthSessionFilter) {
        return (List<S>) new HealthSessionTransformer(collection).filter(healthSessionFilter).toCollection();
    }

    public static <S extends HealthSession> boolean isOverlap(S s, List<S> list) {
        Iterator<S> it = list.iterator();
        while (it.hasNext()) {
            if (HealthIntervalKt.hasIntersection(s, it.next())) {
                return true;
            }
        }
        return false;
    }
}
