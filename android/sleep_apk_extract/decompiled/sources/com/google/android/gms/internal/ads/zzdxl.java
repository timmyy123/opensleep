package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.ads.zzbhv$zza;
import com.google.android.gms.internal.ads.zzbhv$zzar;
import com.google.android.gms.internal.ads.zzbhv$zzm;
import com.google.android.gms.internal.ads.zzbhv$zzt;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdxl implements zzimu {
    private final zzind zza;
    private final zzind zzb;
    private final zzind zzc;
    private final zzind zzd;
    private final zzind zze;

    private zzdxl(zzind zzindVar, zzind zzindVar2, zzind zzindVar3, zzind zzindVar4, zzind zzindVar5) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
        this.zzc = zzindVar3;
        this.zzd = zzindVar4;
        this.zze = zzindVar5;
    }

    public static zzdxl zza(zzind zzindVar, zzind zzindVar2, zzind zzindVar3, zzind zzindVar4, zzind zzindVar5) {
        return new zzdxl(zzindVar, zzindVar2, zzindVar3, zzindVar4, zzindVar5);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        Context contextZza = ((zzcns) this.zza).zza();
        final String strZzb = ((zzeey) this.zzb).zzb();
        VersionInfoParcel versionInfoParcelZza = ((zzcoi) this.zzc).zza();
        final zzbhv$zza.zza zzaVar = (zzbhv$zza.zza) this.zzd.zzb();
        final String str = (String) this.zze.zzb();
        zzbhp zzbhpVar = new zzbhp(new zzbhu(contextZza));
        zzbhv$zzar.zza zzaVarZzs = zzbhv$zzar.zzs();
        zzaVarZzs.zzc(versionInfoParcelZza.buddyApkVersion);
        zzaVarZzs.zzg(versionInfoParcelZza.clientJarVersion);
        zzaVarZzs.zzk(true != versionInfoParcelZza.isClientJar ? 2 : 0);
        final zzbhv$zzar zzbhv_zzarZzbm = zzaVarZzs.zzbm();
        zzbhpVar.zzb(new zzbho() { // from class: com.google.android.gms.internal.ads.zzdxk
            @Override // com.google.android.gms.internal.ads.zzbho
            public final /* synthetic */ void zza(zzbhv$zzt.zza zzaVar2) {
                zzbhv$zza.zzb zzbVarZzbp = zzaVar2.zzY().zzbp();
                zzbVarZzbp.zzc(zzaVar);
                zzaVar2.zzaa(zzbVarZzbp);
                zzbhv$zzm.zza zzaVarZzbp = zzaVar2.zzG().zzbp();
                zzaVarZzbp.zzd(strZzb);
                zzaVarZzbp.zzs(zzbhv_zzarZzbm);
                zzaVar2.zzI(zzaVarZzbp);
                zzaVar2.zzh(str);
            }
        });
        return zzbhpVar;
    }
}
