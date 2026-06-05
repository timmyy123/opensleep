package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdus {
    private final zzdcp zza;
    private final zzddy zzb;
    private final zzdel zzc;
    private final zzdfc zzd;
    private final zzdhv zze;
    private final zzfkf zzf;
    private final zzfki zzg;
    private final zzctj zzh;

    public zzdus(zzdcp zzdcpVar, zzddy zzddyVar, zzdel zzdelVar, zzdfc zzdfcVar, zzdhv zzdhvVar, zzfkf zzfkfVar, zzfki zzfkiVar, zzctj zzctjVar) {
        this.zza = zzdcpVar;
        this.zzb = zzddyVar;
        this.zzc = zzdelVar;
        this.zzd = zzdfcVar;
        this.zze = zzdhvVar;
        this.zzf = zzfkfVar;
        this.zzg = zzfkiVar;
        this.zzh = zzctjVar;
    }

    public final void zza(zzdux zzduxVar) {
        final zzddy zzddyVar = this.zzb;
        zzdul zzdulVarZzk = zzduxVar.zzk();
        Objects.requireNonNull(zzddyVar);
        zzdulVarZzk.zzm(this.zza, this.zzc, this.zzd, this.zze, new com.google.android.gms.ads.internal.overlay.zzad() { // from class: com.google.android.gms.internal.ads.zzdur
            @Override // com.google.android.gms.ads.internal.overlay.zzad
            public final /* synthetic */ void zzl() {
                zzddyVar.zzb();
            }
        });
        zzduxVar.zzg(this.zzf, this.zzg, this.zzh);
    }
}
