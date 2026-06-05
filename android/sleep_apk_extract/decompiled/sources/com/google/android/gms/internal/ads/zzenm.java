package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: classes3.dex */
final class zzenm implements zzdno {
    private final Context zza;
    private final VersionInfoParcel zzb;
    private final ListenableFuture zzc;
    private final zzfkf zzd;
    private final zzcku zze;
    private final zzfky zzf;
    private final zzbpt zzg;
    private final boolean zzh;
    private final zzekr zzi;
    private final zzdzl zzj;

    public zzenm(Context context, VersionInfoParcel versionInfoParcel, ListenableFuture listenableFuture, zzfkf zzfkfVar, zzcku zzckuVar, zzfky zzfkyVar, boolean z, zzbpt zzbptVar, zzekr zzekrVar, zzdzl zzdzlVar) {
        this.zza = context;
        this.zzb = versionInfoParcel;
        this.zzc = listenableFuture;
        this.zzd = zzfkfVar;
        this.zze = zzckuVar;
        this.zzf = zzfkyVar;
        this.zzg = zzbptVar;
        this.zzh = z;
        this.zzi = zzekrVar;
        this.zzj = zzdzlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdno
    public final void zza(boolean z, Context context, zzdde zzddeVar) {
        boolean z2;
        zzdma zzdmaVar = (zzdma) zzhbw.zzt(this.zzc);
        zzcku zzckuVar = this.zze;
        zzckuVar.zzag(true);
        boolean z3 = this.zzh;
        boolean z4 = false;
        boolean zZzc = z3 ? this.zzg.zzc(false) : false;
        com.google.android.gms.ads.internal.zzt.zzc();
        boolean zZzL = com.google.android.gms.ads.internal.util.zzs.zzL(this.zza);
        if (!z3) {
            z2 = z4;
        } else if (this.zzg.zzd()) {
            z4 = true;
            z2 = z4;
        } else {
            z2 = false;
            z4 = true;
        }
        float fZze = z4 ? this.zzg.zze() : 0.0f;
        zzfkf zzfkfVar = this.zzd;
        com.google.android.gms.ads.internal.zzl zzlVar = new com.google.android.gms.ads.internal.zzl(zZzc, zZzL, z2, fZze, -1, z, zzfkfVar.zzO, false);
        if (zzddeVar != null) {
            zzddeVar.zzb();
        }
        com.google.android.gms.ads.internal.zzt.zzb();
        zzdnd zzdndVarZzj = zzdmaVar.zzj();
        int i = zzfkfVar.zzQ;
        VersionInfoParcel versionInfoParcel = this.zzb;
        String str = zzfkfVar.zzB;
        zzfkk zzfkkVar = zzfkfVar.zzs;
        com.google.android.gms.ads.internal.overlay.zzn.zza(context, new AdOverlayInfoParcel(null, zzdndVarZzj, null, zzckuVar, i, versionInfoParcel, str, zzlVar, zzfkkVar.zzb, zzfkkVar.zza, this.zzf.zzg, zzddeVar, zzfkfVar.zzb() ? this.zzi : null, zzckuVar.zzn()), true, this.zzj);
    }

    @Override // com.google.android.gms.internal.ads.zzdno
    public final zzfkf zzb() {
        return this.zzd;
    }
}
