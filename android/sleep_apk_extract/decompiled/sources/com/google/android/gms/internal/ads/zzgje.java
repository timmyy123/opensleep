package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageManager;

/* JADX INFO: loaded from: classes3.dex */
public final class zzgje {
    private final Context zza;
    private final zzgqh zzb;
    private final zzgha zzc;
    private final String zzd;

    public zzgje(Context context, zzgqh zzgqhVar, zzgha zzghaVar, zzgdf zzgdfVar) {
        this.zza = context;
        this.zzb = zzgqhVar;
        this.zzc = zzghaVar;
        this.zzd = zzgdfVar.zzd();
    }

    public final String zza(boolean z, long j) {
        try {
            this.zzb.zza(55).zza();
            zzayx zzayxVarZza = zzayy.zza();
            zzayxVarZza.zzb(this.zzd);
            zzayxVarZza.zza("0.878096153");
            zzayxVarZza.zzd(this.zza.getPackageName());
            zzayxVarZza.zzc(System.currentTimeMillis() / 1000);
            zzayxVarZza.zzf((System.currentTimeMillis() - j) / 1000);
            try {
                zzayxVarZza.zze(r0.getPackageManager().getPackageInfo(r0.getPackageName(), 0).versionCode);
            } catch (PackageManager.NameNotFoundException unused) {
                zzayxVarZza.zze(-1L);
            }
            zzgha zzghaVar = this.zzc;
            if (!zzghaVar.zzc()) {
                zzghaVar.zza();
            }
            zzaze zzazeVarZzf = zzghaVar.zzf(((zzayy) zzayxVarZza.zzbm()).zzaN(), null);
            zzazeVarZzf.zzc(5);
            zzazeVarZzf.zzd(2);
            return zzgea.zza(((zzazf) zzazeVarZzf.zzbm()).zzaN(), true);
        } finally {
        }
    }
}
