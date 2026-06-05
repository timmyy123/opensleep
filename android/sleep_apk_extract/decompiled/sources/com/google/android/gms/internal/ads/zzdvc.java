package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdvc {
    private final zzdcp zza;
    private final zzddy zzb;
    private final zzdel zzc;
    private final zzdfc zzd;
    private final zzdhv zze;
    private final zzdkw zzf;
    private final zzdzl zzg;
    private final zzfsc zzh;
    private final zzekg zzi;
    private final zzctj zzj;

    public zzdvc(zzdcp zzdcpVar, zzddy zzddyVar, zzdel zzdelVar, zzdfc zzdfcVar, zzdhv zzdhvVar, zzdkw zzdkwVar, zzdzl zzdzlVar, zzfsc zzfscVar, zzekg zzekgVar, zzctj zzctjVar) {
        this.zza = zzdcpVar;
        this.zzb = zzddyVar;
        this.zzc = zzdelVar;
        this.zzd = zzdfcVar;
        this.zze = zzdhvVar;
        this.zzf = zzdkwVar;
        this.zzg = zzdzlVar;
        this.zzh = zzfscVar;
        this.zzi = zzekgVar;
        this.zzj = zzctjVar;
    }

    public final void zza(zzdvd zzdvdVar, zzcku zzckuVar) {
        zzdva zzdvaVarZzb = zzdvdVar.zzb();
        final zzddy zzddyVar = this.zzb;
        Objects.requireNonNull(zzddyVar);
        zzdvaVarZzb.zzn(this.zza, this.zzc, this.zzd, this.zze, new com.google.android.gms.ads.internal.overlay.zzad() { // from class: com.google.android.gms.internal.ads.zzdvb
            @Override // com.google.android.gms.ads.internal.overlay.zzad
            public final /* synthetic */ void zzl() {
                zzddyVar.zzb();
            }
        }, this.zzf);
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzlC)).booleanValue() || zzckuVar == null || zzckuVar.zzP() == null) {
            return;
        }
        zzcms zzcmsVarZzP = zzckuVar.zzP();
        zzctj zzctjVar = this.zzj;
        zzekg zzekgVar = this.zzi;
        zzcmsVarZzP.zzd(zzctjVar, zzekgVar, this.zzh);
        zzcmsVarZzP.zze(zzctjVar, zzekgVar, this.zzg);
    }
}
