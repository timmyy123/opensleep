package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public final class zzduz implements zzimu {
    private final zzind zza;
    private final zzind zzb;
    private final zzind zzc;
    private final zzind zzd;
    private final zzind zze;
    private final zzind zzf;
    private final zzind zzg;
    private final zzind zzh;
    private final zzind zzi;
    private final zzind zzj;

    private zzduz(zzind zzindVar, zzind zzindVar2, zzind zzindVar3, zzind zzindVar4, zzind zzindVar5, zzind zzindVar6, zzind zzindVar7, zzind zzindVar8, zzind zzindVar9, zzind zzindVar10, zzind zzindVar11) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
        this.zzc = zzindVar3;
        this.zzd = zzindVar4;
        this.zze = zzindVar5;
        this.zzf = zzindVar7;
        this.zzg = zzindVar8;
        this.zzh = zzindVar9;
        this.zzi = zzindVar10;
        this.zzj = zzindVar11;
    }

    public static zzduz zza(zzind zzindVar, zzind zzindVar2, zzind zzindVar3, zzind zzindVar4, zzind zzindVar5, zzind zzindVar6, zzind zzindVar7, zzind zzindVar8, zzind zzindVar9, zzind zzindVar10, zzind zzindVar11) {
        return new zzduz(zzindVar, zzindVar2, zzindVar3, zzindVar4, zzindVar5, zzindVar6, zzindVar7, zzindVar8, zzindVar9, zzindVar10, zzindVar11);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzduv(((zzcns) this.zza).zza(), (Executor) this.zzb.zzb(), (zzbap) this.zzc.zzb(), ((zzcoi) this.zzd).zza(), ((zzcqg) this.zze).zza(), zzcqz.zza(), (zzekg) this.zzf.zzb(), (zzfsc) this.zzg.zzb(), (zzdzl) this.zzh.zzb(), (zzekr) this.zzi.zzb(), (zzflc) this.zzj.zzb());
    }
}
