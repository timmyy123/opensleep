package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzehk implements zzefw {
    final /* synthetic */ zzehn zza;

    public zzehk(zzehn zzehnVar) {
        Objects.requireNonNull(zzehnVar);
        this.zza = zzehnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzefw
    public final void zza() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzpC)).booleanValue()) {
            zzdzk zzdzkVarZza = this.zza.zzd().zza();
            zzdzkVarZza.zzc("action", "ptard");
            zzdzkVarZza.zzc("ptard", "r");
            zzdzkVarZza.zzd();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzefw
    public final void zzb(RemoteException remoteException) {
        this.zza.zzc();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzpD)).booleanValue()) {
            com.google.android.gms.ads.internal.zzt.zzh().zzg(remoteException, "Preconnect Remote");
        }
    }
}
