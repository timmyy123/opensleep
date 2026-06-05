package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdwi {
    private final Context zza;
    private final zzbap zzb;
    private final zzbjx zzc;
    private final VersionInfoParcel zzd;
    private final com.google.android.gms.ads.internal.zza zze;
    private final zzbhp zzf;
    private final zzdfs zzg;
    private final zzekr zzh;
    private final zzflc zzi;
    private final zzdzl zzj;
    private final zzcmt zzk;

    public zzdwi(zzclk zzclkVar, Context context, zzbap zzbapVar, zzbjx zzbjxVar, VersionInfoParcel versionInfoParcel, com.google.android.gms.ads.internal.zza zzaVar, zzbhp zzbhpVar, zzdfs zzdfsVar, zzekr zzekrVar, zzflc zzflcVar, zzdzl zzdzlVar, zzcmt zzcmtVar) {
        this.zza = context;
        this.zzb = zzbapVar;
        this.zzc = zzbjxVar;
        this.zzd = versionInfoParcel;
        this.zze = zzaVar;
        this.zzf = zzbhpVar;
        this.zzg = zzdfsVar;
        this.zzh = zzekrVar;
        this.zzi = zzflcVar;
        this.zzj = zzdzlVar;
        this.zzk = zzcmtVar;
    }

    public final zzcku zza(com.google.android.gms.ads.internal.client.zzr zzrVar, zzfkf zzfkfVar, zzfki zzfkiVar) throws zzclj {
        zzcne zzcneVarZza = zzcne.zza(zzrVar);
        String str = zzrVar.zza;
        zzdvx zzdvxVar = new zzdvx(this);
        zzbap zzbapVar = this.zzb;
        zzekr zzekrVar = this.zzh;
        zzcku zzckuVarZza = zzclk.zza(this.zza, zzcneVarZza, str, false, false, zzbapVar, this.zzc, this.zzd, null, zzdvxVar, this.zze, this.zzf, zzfkfVar, zzfkiVar, zzekrVar, this.zzi, this.zzj);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzpz)).booleanValue()) {
            this.zzk.zza(zzckuVarZza.zzD());
        }
        return zzckuVarZza;
    }

    public final /* synthetic */ zzdfs zzb() {
        return this.zzg;
    }
}
