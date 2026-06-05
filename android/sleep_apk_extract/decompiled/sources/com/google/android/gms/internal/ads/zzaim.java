package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
abstract class zzaim {
    protected final zzahk zza;

    public zzaim(zzahk zzahkVar) {
        this.zza = zzahkVar;
    }

    public abstract boolean zza(zzet zzetVar);

    public abstract boolean zzb(zzet zzetVar, long j);

    public final boolean zzf(zzet zzetVar, long j) {
        return zza(zzetVar) && zzb(zzetVar, j);
    }
}
