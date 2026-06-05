package com.google.android.gms.internal.base;

import com.google.android.gms.common.Feature;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zad {
    public static final Feature zaa;
    public static final Feature zab;
    public static final Feature[] zac;

    static {
        Feature feature = new Feature("CLIENT_TELEMETRY", 1L, true);
        zaa = feature;
        Feature feature2 = new Feature("CLIENT_NOTIFICATION_TELEMETRY", 1L, true);
        zab = feature2;
        zac = new Feature[]{feature, feature2};
    }
}
