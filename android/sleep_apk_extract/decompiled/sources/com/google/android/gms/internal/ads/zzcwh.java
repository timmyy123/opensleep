package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcwh implements zzimu {
    private final zzind zza;

    private zzcwh(zzcvs zzcvsVar, zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
    }

    public static zzcwh zza(zzcvs zzcvsVar, zzind zzindVar, zzind zzindVar2) {
        return new zzcwh(zzcvsVar, zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdkq((zzcxp) this.zza.zzb(), zzfoa.zzc());
    }
}
