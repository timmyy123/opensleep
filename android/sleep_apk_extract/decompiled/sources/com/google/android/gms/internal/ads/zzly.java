package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public interface zzly {
    void zza(zzqf zzqfVar);

    void zzb(zzlx zzlxVar, zzzn zzznVar, zzaba[] zzabaVarArr);

    void zzc(zzqf zzqfVar);

    void zzd(zzqf zzqfVar);

    zzabl zze(zzqf zzqfVar);

    long zzf(zzqf zzqfVar);

    boolean zzg(zzqf zzqfVar);

    boolean zzh(zzlx zzlxVar);

    boolean zzi(zzlx zzlxVar);

    default boolean zzj(zzqf zzqfVar, zzbf zzbfVar, zzxk zzxkVar, long j) {
        zzeg.zzc("LoadControl", "shouldContinuePreloading needs to be implemented when playlist preloading is enabled");
        return false;
    }
}
