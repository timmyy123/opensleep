package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
final class zzmo implements Runnable {
    final /* synthetic */ zzr zza;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ zzbf zzc;
    final /* synthetic */ Bundle zzd;
    final /* synthetic */ zznl zze;

    public zzmo(zznl zznlVar, boolean z, zzr zzrVar, boolean z2, zzbf zzbfVar, Bundle bundle) {
        this.zza = zzrVar;
        this.zzb = z2;
        this.zzc = zzbfVar;
        this.zzd = bundle;
        Objects.requireNonNull(zznlVar);
        this.zze = zznlVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zznl zznlVar = this.zze;
        zzgb zzgbVarZzZ = zznlVar.zzZ();
        zzic zzicVar = zznlVar.zzu;
        if (zzgbVarZzZ == null) {
            zza$$ExternalSyntheticOutline0.m(zzicVar, "Failed to send default event parameters to service");
            return;
        }
        boolean zZzp = zzicVar.zzc().zzp(null, zzfy.zzaW);
        zzr zzrVar = this.zza;
        if (zZzp) {
            Preconditions.checkNotNull(zzrVar);
            zznlVar.zzm(zzgbVarZzZ, this.zzb ? null : this.zzc, zzrVar);
            return;
        }
        try {
            Preconditions.checkNotNull(zzrVar);
            zzgbVarZzZ.zzu(this.zzd, zzrVar);
            zznlVar.zzV();
        } catch (RemoteException e) {
            this.zze.zzu.zzaW().zzb().zzb("Failed to send default event parameters to service", e);
        }
    }
}
