package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzgem implements zzimu {
    private final zzind zza;
    private final zzind zzb;
    private final zzind zzc;

    private zzgem(zzind zzindVar, zzind zzindVar2, zzind zzindVar3) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
        this.zzc = zzindVar3;
    }

    public static zzgem zza(zzind zzindVar, zzind zzindVar2, zzind zzindVar3) {
        return new zzgem(zzindVar, zzindVar2, zzindVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzgel zzgelVar = ((zzgdf) this.zzc.zzb()).zzv() ? (zzgel) zzimt.zzc(this.zza).zzb() : (zzgel) zzimt.zzc(this.zzb).zzb();
        zzinc.zzb(zzgelVar);
        return zzgelVar;
    }
}
