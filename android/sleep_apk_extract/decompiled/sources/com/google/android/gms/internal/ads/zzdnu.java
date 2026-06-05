package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbhv$zza;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdnu implements zzimu {
    private final zzind zza;
    private final zzind zzb;
    private final zzind zzc;
    private final zzind zzd;
    private final zzind zze;
    private final zzind zzf;

    private zzdnu(zzind zzindVar, zzind zzindVar2, zzind zzindVar3, zzind zzindVar4, zzind zzindVar5, zzind zzindVar6) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
        this.zzc = zzindVar3;
        this.zzd = zzindVar4;
        this.zze = zzindVar5;
        this.zzf = zzindVar6;
    }

    public static zzdnu zza(zzind zzindVar, zzind zzindVar2, zzind zzindVar3, zzind zzindVar4, zzind zzindVar5, zzind zzindVar6) {
        return new zzdnu(zzindVar, zzindVar2, zzindVar3, zzindVar4, zzindVar5, zzindVar6);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdnt(((zzdmu) this.zza).zzb(), ((zzcns) this.zzb).zza(), (zzcdz) this.zzc.zzb(), ((zzdmi) this.zzd).zza(), (zzbhv$zza.zza) this.zze.zzb(), ((zzcyk) this.zzf).zza());
    }
}
