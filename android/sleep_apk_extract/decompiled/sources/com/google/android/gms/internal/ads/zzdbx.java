package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdbx implements zzimu {
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

    private zzdbx(zzind zzindVar, zzind zzindVar2, zzind zzindVar3, zzind zzindVar4, zzind zzindVar5, zzind zzindVar6, zzind zzindVar7, zzind zzindVar8, zzind zzindVar9, zzind zzindVar10, zzind zzindVar11, zzind zzindVar12) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
        this.zzc = zzindVar3;
        this.zzd = zzindVar4;
        this.zze = zzindVar6;
        this.zzf = zzindVar7;
        this.zzg = zzindVar8;
        this.zzh = zzindVar9;
        this.zzi = zzindVar10;
        this.zzj = zzindVar11;
        this.zzk = zzindVar12;
    }

    public static zzdbx zzc(zzind zzindVar, zzind zzindVar2, zzind zzindVar3, zzind zzindVar4, zzind zzindVar5, zzind zzindVar6, zzind zzindVar7, zzind zzindVar8, zzind zzindVar9, zzind zzindVar10, zzind zzindVar11, zzind zzindVar12) {
        return new zzdbx(zzindVar, zzindVar2, zzindVar3, zzindVar4, zzindVar5, zzindVar6, zzindVar7, zzindVar8, zzindVar9, zzindVar10, zzindVar11, zzindVar12);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzdbw zzb() {
        return new zzdbw((zzfpk) this.zza.zzb(), ((zzcoi) this.zzb).zza(), (ApplicationInfo) this.zzc.zzb(), ((zzeey) this.zzd).zzb(), zzexr.zzc(), (PackageInfo) this.zze.zzb(), zzimt.zzc(this.zzf), ((zzcnm) this.zzg).zzb(), (String) this.zzh.zzb(), ((zzfco) this.zzi).zzb(), ((zzdci) this.zzj).zza(), (zzdik) this.zzk.zzb());
    }
}
