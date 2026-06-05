package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
abstract class zzaaq {
    public final int zza;
    public final zzbg zzb;
    public final int zzc;
    public final zzv zzd;

    public zzaaq(int i, zzbg zzbgVar, int i2) {
        this.zza = i;
        this.zzb = zzbgVar;
        this.zzc = i2;
        this.zzd = zzbgVar.zza(i2);
    }

    public abstract int zza();

    public abstract boolean zzc(zzaaq zzaaqVar);
}
