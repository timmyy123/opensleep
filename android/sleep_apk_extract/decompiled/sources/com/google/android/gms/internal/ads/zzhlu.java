package com.google.android.gms.internal.ads;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzhlu {
    private final Class zza;
    private final Class zzb;

    public /* synthetic */ zzhlu(Class cls, Class cls2, byte[] bArr) {
        this.zza = cls;
        this.zzb = cls2;
    }

    public static zzhlu zzd(zzhlt zzhltVar, Class cls, Class cls2) {
        return new zzhls(cls, cls2, zzhltVar);
    }

    public abstract zzhns zza(zzhdq zzhdqVar, @Nullable zzhel zzhelVar);

    public final Class zzb() {
        return this.zza;
    }

    public final Class zzc() {
        return this.zzb;
    }
}
