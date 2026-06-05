package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzhmv {
    private final zziaz zza;
    private final Class zzb;

    public /* synthetic */ zzhmv(zziaz zziazVar, Class cls, byte[] bArr) {
        this.zza = zziazVar;
        this.zzb = cls;
    }

    public static zzhmv zzd(zzhmu zzhmuVar, zziaz zziazVar, Class cls) {
        return new zzhmt(zziazVar, cls, zzhmuVar);
    }

    public abstract zzheh zza(zzhns zzhnsVar);

    public final zziaz zzb() {
        return this.zza;
    }

    public final Class zzc() {
        return this.zzb;
    }
}
