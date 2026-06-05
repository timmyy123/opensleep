package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzimv implements zzimu, zzimo {
    private static final zzimv zza = new zzimv(null);
    private final Object zzb;

    private zzimv(Object obj) {
        this.zzb = obj;
    }

    public static zzimu zza(Object obj) {
        zzinc.zza(obj, "instance cannot be null");
        return new zzimv(obj);
    }

    public static zzimu zzc(Object obj) {
        return obj == null ? zza : new zzimv(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final Object zzb() {
        return this.zzb;
    }
}
