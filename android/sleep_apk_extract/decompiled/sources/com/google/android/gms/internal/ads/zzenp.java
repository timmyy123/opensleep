package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public final class zzenp implements zzimu {
    private final zzind zza;
    private final zzind zzb;
    private final zzind zzc;
    private final zzind zzd;
    private final zzind zze;
    private final zzind zzf;
    private final zzind zzg;
    private final zzind zzh;
    private final zzind zzi;

    private zzenp(zzind zzindVar, zzind zzindVar2, zzind zzindVar3, zzind zzindVar4, zzind zzindVar5, zzind zzindVar6, zzind zzindVar7, zzind zzindVar8, zzind zzindVar9, zzind zzindVar10) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
        this.zzc = zzindVar3;
        this.zzd = zzindVar4;
        this.zze = zzindVar5;
        this.zzf = zzindVar6;
        this.zzg = zzindVar8;
        this.zzh = zzindVar9;
        this.zzi = zzindVar10;
    }

    public static zzenp zza(zzind zzindVar, zzind zzindVar2, zzind zzindVar3, zzind zzindVar4, zzind zzindVar5, zzind zzindVar6, zzind zzindVar7, zzind zzindVar8, zzind zzindVar9, zzind zzindVar10) {
        return new zzenp(zzindVar, zzindVar2, zzindVar3, zzindVar4, zzindVar5, zzindVar6, zzindVar7, zzindVar8, zzindVar9, zzindVar10);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzeno((Context) this.zza.zzb(), ((zzcoi) this.zzb).zza(), ((zzdci) this.zzc).zza(), (Executor) this.zzd.zzb(), (zzdng) this.zze.zzb(), (zzdwi) this.zzf.zzb(), new zzbpt(), (zzekr) this.zzg.zzb(), (zzdzg) this.zzh.zzb(), (zzdzl) this.zzi.zzb());
    }
}
