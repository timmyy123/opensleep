package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes3.dex */
public final class zzctw implements zzimu {
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
    private final zzind zzm;
    private final zzind zzn;
    private final zzind zzo;
    private final zzind zzp;

    private zzctw(zzind zzindVar, zzind zzindVar2, zzind zzindVar3, zzind zzindVar4, zzind zzindVar5, zzind zzindVar6, zzind zzindVar7, zzind zzindVar8, zzind zzindVar9, zzind zzindVar10, zzind zzindVar11, zzind zzindVar12, zzind zzindVar13, zzind zzindVar14, zzind zzindVar15, zzind zzindVar16, zzind zzindVar17, zzind zzindVar18) {
        this.zza = zzindVar;
        this.zzb = zzindVar3;
        this.zzc = zzindVar4;
        this.zzd = zzindVar5;
        this.zze = zzindVar6;
        this.zzf = zzindVar7;
        this.zzg = zzindVar8;
        this.zzh = zzindVar9;
        this.zzi = zzindVar10;
        this.zzj = zzindVar11;
        this.zzk = zzindVar12;
        this.zzl = zzindVar14;
        this.zzm = zzindVar15;
        this.zzn = zzindVar16;
        this.zzo = zzindVar17;
        this.zzp = zzindVar18;
    }

    public static zzctw zza(zzind zzindVar, zzind zzindVar2, zzind zzindVar3, zzind zzindVar4, zzind zzindVar5, zzind zzindVar6, zzind zzindVar7, zzind zzindVar8, zzind zzindVar9, zzind zzindVar10, zzind zzindVar11, zzind zzindVar12, zzind zzindVar13, zzind zzindVar14, zzind zzindVar15, zzind zzindVar16, zzind zzindVar17, zzind zzindVar18) {
        return new zzctw(zzindVar, zzindVar2, zzindVar3, zzindVar4, zzindVar5, zzindVar6, zzindVar7, zzindVar8, zzindVar9, zzindVar10, zzindVar11, zzindVar12, zzindVar13, zzindVar14, zzindVar15, zzindVar16, zzindVar17, zzindVar18);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzctv(((zzcns) this.zza).zza(), zzfoa.zzc(), (Executor) this.zzb.zzb(), (ScheduledExecutorService) this.zzc.zzb(), ((zzcyn) this.zzd).zza(), ((zzcyk) this.zze).zza(), (zzfry) this.zzf.zzb(), (zzfll) this.zzg.zzb(), (View) this.zzh.zzb(), (zzcku) this.zzi.zzb(), (zzbap) this.zzj.zzb(), (zzbjx) this.zzk.zzb(), zzcqh.zzc(), (zzfqg) this.zzl.zzb(), ((zzdcf) this.zzm).zza(), (zzdfg) this.zzn.zzb(), (zzdbn) this.zzo.zzb(), ((zzing) this.zzp).zzb());
    }
}
