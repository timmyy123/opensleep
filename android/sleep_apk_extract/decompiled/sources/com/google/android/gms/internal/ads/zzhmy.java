package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzhmy {
    private final Class zza;
    private final Class zzb;

    public /* synthetic */ zzhmy(Class cls, Class cls2, byte[] bArr) {
        this.zza = cls;
        this.zzb = cls2;
    }

    public static zzhmy zzd(zzhmx zzhmxVar, Class cls, Class cls2) {
        return new zzhmw(cls, cls2, zzhmxVar);
    }

    public abstract zzhns zza(zzheh zzhehVar);

    public final Class zzb() {
        return this.zza;
    }

    public final Class zzc() {
        return this.zzb;
    }
}
