package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzgpb implements zzimu {
    private final zzind zza;
    private final zzind zzb;
    private final zzind zzc;

    private zzgpb(zzind zzindVar, zzind zzindVar2, zzind zzindVar3) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
        this.zzc = zzindVar3;
    }

    public static zzgpb zza(zzind zzindVar, zzind zzindVar2, zzind zzindVar3) {
        return new zzgpb(zzindVar, zzindVar2, zzindVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzgpa((zzgcn) this.zza.zzb(), (zzgqh) this.zzb.zzb(), ((zzgdf) this.zzc.zzb()).zzk().zzb());
    }
}
