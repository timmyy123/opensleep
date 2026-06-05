package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
final class zzfhc implements zzfnh {
    public final zzfhv zza;
    public final zzfhx zzb;
    public final com.google.android.gms.ads.internal.client.zzm zzc;
    public final String zzd;
    public final Executor zze;
    public final com.google.android.gms.ads.internal.client.zzx zzf;
    public final zzfmx zzg;

    public zzfhc(zzfhv zzfhvVar, zzfhx zzfhxVar, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, Executor executor, com.google.android.gms.ads.internal.client.zzx zzxVar, zzfmx zzfmxVar) {
        this.zza = zzfhvVar;
        this.zzb = zzfhxVar;
        this.zzc = zzmVar;
        this.zzd = str;
        this.zze = executor;
        this.zzf = zzxVar;
        this.zzg = zzfmxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfnh
    public final Executor zza() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzfnh
    public final zzfmx zzb() {
        return this.zzg;
    }
}
