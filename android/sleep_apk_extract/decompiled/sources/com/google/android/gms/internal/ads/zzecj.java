package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzecj implements zzimu {
    private final zzind zza;
    private final zzind zzb;
    private final zzind zzc;

    private zzecj(zzind zzindVar, zzind zzindVar2, zzind zzindVar3) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
        this.zzc = zzindVar3;
    }

    public static zzecj zza(zzind zzindVar, zzind zzindVar2, zzind zzindVar3) {
        return new zzecj(zzindVar, zzindVar2, zzindVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzecf((zzecr) this.zza.zzb(), ((zzdci) this.zzb).zza(), (String) this.zzc.zzb());
    }
}
