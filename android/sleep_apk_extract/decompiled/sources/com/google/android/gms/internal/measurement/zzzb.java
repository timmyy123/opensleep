package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes3.dex */
public enum zzzb {
    GENERAL(false, true),
    BOOLEAN(false, false),
    CHARACTER(false, false),
    INTEGRAL(true, false),
    FLOAT(true, true);

    private final boolean zzf;

    zzzb(boolean z, boolean z2) {
        this.zzf = z2;
    }

    public final boolean zza() {
        return this.zzf;
    }
}
