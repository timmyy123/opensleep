package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzbh;

/* JADX INFO: loaded from: classes3.dex */
public final class zzetp {
    private final zzdqd zza;
    private final zzetc zzb;
    private final zzdcu zzc;

    public zzetp(zzdqd zzdqdVar, zzdzl zzdzlVar) {
        this.zza = zzdqdVar;
        final zzetc zzetcVar = new zzetc(zzdzlVar);
        this.zzb = zzetcVar;
        final zzbsk zzbskVarZze = zzdqdVar.zze();
        this.zzc = new zzdcu() { // from class: com.google.android.gms.internal.ads.zzeto
            @Override // com.google.android.gms.internal.ads.zzdcu
            public final /* synthetic */ void zzdJ(com.google.android.gms.ads.internal.client.zze zzeVar) {
                zzetcVar.zzdJ(zzeVar);
                zzbsk zzbskVar = zzbskVarZze;
                if (zzbskVar != null) {
                    try {
                        zzbskVar.zzg(zzeVar);
                    } catch (RemoteException e) {
                        com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
                    }
                }
                if (zzbskVar != null) {
                    try {
                        zzbskVar.zzf(zzeVar.zza);
                    } catch (RemoteException e2) {
                        com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e2);
                    }
                }
            }
        };
    }

    public final void zza(zzbh zzbhVar) {
        this.zzb.zzl(zzbhVar);
    }

    public final zzdnx zzb() {
        return new zzdnx(this.zza, this.zzb.zzi());
    }

    public final zzetc zzc() {
        return this.zzb;
    }

    public final zzdef zzd() {
        return this.zzb;
    }

    public final zzdcu zze() {
        return this.zzc;
    }
}
