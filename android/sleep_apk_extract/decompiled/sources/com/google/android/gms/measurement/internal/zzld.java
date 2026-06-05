package com.google.android.gms.measurement.internal;

import java.util.Comparator;

/* JADX INFO: loaded from: classes4.dex */
final /* synthetic */ class zzld implements Comparator {
    static final /* synthetic */ zzld zza = new zzld();

    private /* synthetic */ zzld() {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        return Long.compare(((Long) obj).longValue(), ((Long) obj2).longValue());
    }
}
