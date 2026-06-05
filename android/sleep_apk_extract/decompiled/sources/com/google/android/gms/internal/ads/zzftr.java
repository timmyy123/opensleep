package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzftr implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ com.google.android.gms.ads.internal.client.zzdx zzb;
    final /* synthetic */ zzfub zzc;

    public zzftr(zzfub zzfubVar, long j, com.google.android.gms.ads.internal.client.zzdx zzdxVar) {
        this.zza = j;
        this.zzb = zzdxVar;
        Objects.requireNonNull(zzfubVar);
        this.zzc = zzfubVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfub zzfubVar = this.zzc;
        if (zzfubVar.zzN() != null) {
            long j = this.zza;
            String strZzV = zzfub.zzV(this.zzb);
            int iZzs = zzfubVar.zzs();
            int iZzt = zzfubVar.zzt();
            String strZzM = zzfubVar.zzM();
            zzfubVar.zzN().zzi(j, strZzV, zzfubVar.zzP(), iZzs, iZzt, strZzM);
        }
    }
}
