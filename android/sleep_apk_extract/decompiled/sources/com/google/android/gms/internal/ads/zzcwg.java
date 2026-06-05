package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcwg implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzcwg(zzcvs zzcvsVar, zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
    }

    public static zzcwg zzc(zzcvs zzcvsVar, zzind zzindVar, zzind zzindVar2) {
        return new zzcwg(zzcvsVar, zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzcdw zzb() {
        return new zzcdw(((zzcns) this.zza).zza(), ((zzdci) this.zzb).zza().zzg);
    }
}
