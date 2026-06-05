package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes3.dex */
public final class zzepl implements zzimu {
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
    private final zzind zzk;
    private final zzind zzl;

    private zzepl(zzind zzindVar, zzind zzindVar2, zzind zzindVar3, zzind zzindVar4, zzind zzindVar5, zzind zzindVar6, zzind zzindVar7, zzind zzindVar8, zzind zzindVar9, zzind zzindVar10, zzind zzindVar11, zzind zzindVar12, zzind zzindVar13) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
        this.zzc = zzindVar3;
        this.zzd = zzindVar4;
        this.zze = zzindVar5;
        this.zzf = zzindVar6;
        this.zzg = zzindVar7;
        this.zzh = zzindVar9;
        this.zzi = zzindVar10;
        this.zzj = zzindVar11;
        this.zzk = zzindVar12;
        this.zzl = zzindVar13;
    }

    public static zzepl zzc(zzind zzindVar, zzind zzindVar2, zzind zzindVar3, zzind zzindVar4, zzind zzindVar5, zzind zzindVar6, zzind zzindVar7, zzind zzindVar8, zzind zzindVar9, zzind zzindVar10, zzind zzindVar11, zzind zzindVar12, zzind zzindVar13) {
        return new zzepl(zzindVar, zzindVar2, zzindVar3, zzindVar4, zzindVar5, zzindVar6, zzindVar7, zzindVar8, zzindVar9, zzindVar10, zzindVar11, zzindVar12, zzindVar13);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzepk zzb() {
        return new zzepk(((zzcns) this.zza).zza(), (zzfpk) this.zzb.zzb(), (zzepd) this.zzc.zzb(), (zzdct) this.zzd.zzb(), (zzfry) this.zze.zzb(), (zzfsc) this.zzf.zzb(), (zzcxw) this.zzg.zzb(), zzfoa.zzc(), (ScheduledExecutorService) this.zzh.zzb(), (zzelx) this.zzi.zzb(), (zzfqg) this.zzj.zzb(), ((zzeop) this.zzk).zzb(), (zzdzg) this.zzl.zzb());
    }
}
