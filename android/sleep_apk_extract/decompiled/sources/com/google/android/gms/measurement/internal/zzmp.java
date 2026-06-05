package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
final class zzmp implements Runnable {
    final /* synthetic */ zzbh zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ com.google.android.gms.internal.measurement.zzcs zzc;
    final /* synthetic */ zznl zzd;

    public zzmp(zznl zznlVar, zzbh zzbhVar, String str, com.google.android.gms.internal.measurement.zzcs zzcsVar) {
        this.zza = zzbhVar;
        this.zzb = str;
        this.zzc = zzcsVar;
        Objects.requireNonNull(zznlVar);
        this.zzd = zznlVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.gms.internal.measurement.zzcs zzcsVar;
        zzpp zzppVarZzk;
        zznl zznlVar;
        zzgb zzgbVarZzZ;
        byte[] bArrZzk = null;
        try {
            try {
                zznlVar = this.zzd;
                zzgbVarZzZ = zznlVar.zzZ();
            } catch (RemoteException e) {
                this.zzd.zzu.zzaW().zzb().zzb("Failed to send event to the service to bundle", e);
            }
            if (zzgbVarZzZ == null) {
                zzic zzicVar = zznlVar.zzu;
                zzicVar.zzaW().zzb().zza("Discarding data. Failed to send event to service to bundle");
                zzppVarZzk = zzicVar.zzk();
                zzcsVar = this.zzc;
                zzppVarZzk.zzar(zzcsVar, bArrZzk);
            }
            bArrZzk = zzgbVarZzZ.zzk(this.zza, this.zzb);
            zznlVar.zzV();
            zznl zznlVar2 = this.zzd;
            zzcsVar = this.zzc;
            zzppVarZzk = zznlVar2.zzu.zzk();
            zzppVarZzk.zzar(zzcsVar, bArrZzk);
        } catch (Throwable th) {
            zznl zznlVar3 = this.zzd;
            zznlVar3.zzu.zzk().zzar(this.zzc, null);
            throw th;
        }
    }
}
