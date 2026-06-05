package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfsd implements zzimu {
    private final zzind zza;
    private final zzind zzb;
    private final zzind zzc;
    private final zzind zzd;
    private final zzind zze;
    private final zzind zzf;

    private zzfsd(zzind zzindVar, zzind zzindVar2, zzind zzindVar3, zzind zzindVar4, zzind zzindVar5, zzind zzindVar6, zzind zzindVar7) {
        this.zza = zzindVar;
        this.zzb = zzindVar3;
        this.zzc = zzindVar4;
        this.zzd = zzindVar5;
        this.zze = zzindVar6;
        this.zzf = zzindVar7;
    }

    public static zzfsd zza(zzind zzindVar, zzind zzindVar2, zzind zzindVar3, zzind zzindVar4, zzind zzindVar5, zzind zzindVar6, zzind zzindVar7) {
        return new zzfsd(zzindVar, zzindVar2, zzindVar3, zzindVar4, zzindVar5, zzindVar6, zzindVar7);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzfsc(((zzcns) this.zza).zza(), zzfoa.zzc(), (zzhch) this.zzb.zzb(), (com.google.android.gms.ads.internal.util.client.zzu) this.zzc.zzb(), (zzfru) this.zzd.zzb(), (zzfqj) this.zze.zzb(), (zzcng) this.zzf.zzb());
    }
}
