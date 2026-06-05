package com.urbandroid.sleep.service.health.session.filter;

import com.urbandroid.sleep.service.health.DataSourceProvider;
import com.urbandroid.sleep.service.health.session.HealthSession;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/urbandroid/sleep/service/health/session/filter/HealthSessionPackageFilter;", "Lcom/urbandroid/sleep/service/health/session/filter/HealthSessionFilter;", "packageName", "", "<init>", "(Ljava/lang/String;)V", "accept", "", "session", "Lcom/urbandroid/sleep/service/health/session/HealthSession;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class HealthSessionPackageFilter implements HealthSessionFilter {
    private final String packageName;

    public HealthSessionPackageFilter(String str) {
        str.getClass();
        this.packageName = str;
    }

    @Override // com.urbandroid.sleep.service.health.session.filter.HealthSessionFilter
    public boolean accept(HealthSession session) {
        session.getClass();
        String str = this.packageName;
        DataSourceProvider provider = session.getProvider();
        return Intrinsics.areEqual(str, provider != null ? provider.getPackageName() : null);
    }
}
