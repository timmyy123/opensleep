package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public interface zzahk {
    void zzA(zzv zzvVar);

    default void zzO(long j) {
    }

    default int zza(zzj zzjVar, int i, boolean z) {
        return zzb(zzjVar, i, z, 0);
    }

    int zzb(zzj zzjVar, int i, boolean z, int i2);

    default void zzc(zzet zzetVar, int i) {
        zzd(zzetVar, i, 0);
    }

    void zzd(zzet zzetVar, int i, int i2);

    void zze(long j, int i, int i2, int i3, zzahj zzahjVar);
}
