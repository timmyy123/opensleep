package com.google.android.gms.internal.ads;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzhlr {
    private final zziaz zza;
    private final Class zzb;

    public /* synthetic */ zzhlr(zziaz zziazVar, Class cls, byte[] bArr) {
        this.zza = zziazVar;
        this.zzb = cls;
    }

    public static zzhlr zzd(zzhlq zzhlqVar, zziaz zziazVar, Class cls) {
        return new zzhlp(zziazVar, cls, zzhlqVar);
    }

    public abstract zzhdq zza(zzhns zzhnsVar, @Nullable zzhel zzhelVar);

    public final zziaz zzb() {
        return this.zza;
    }

    public final Class zzc() {
        return this.zzb;
    }
}
