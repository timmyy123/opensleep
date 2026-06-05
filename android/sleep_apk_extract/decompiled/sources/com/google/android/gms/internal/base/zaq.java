package com.google.android.gms.internal.base;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zaq {
    private static final zao zaa;
    private static volatile zao zab;

    static {
        zap zapVar = new zap(null);
        zaa = zapVar;
        zab = zapVar;
    }

    public static zao zaa() {
        return zab;
    }
}
