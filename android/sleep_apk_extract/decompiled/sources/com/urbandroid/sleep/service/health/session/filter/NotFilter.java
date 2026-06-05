package com.urbandroid.sleep.service.health.session.filter;

import com.urbandroid.sleep.service.health.session.HealthSession;

/* JADX INFO: loaded from: classes5.dex */
public class NotFilter implements HealthSessionFilter {
    private final HealthSessionFilter filter;

    public NotFilter(HealthSessionFilter healthSessionFilter) {
        this.filter = healthSessionFilter;
    }

    @Override // com.urbandroid.sleep.service.health.session.filter.HealthSessionFilter
    public boolean accept(HealthSession healthSession) {
        return !this.filter.accept(healthSession);
    }
}
