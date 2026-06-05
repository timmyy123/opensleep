package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzeiu implements zzimu {
    private final zzind zza;

    private zzeiu(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
    }

    public static zzeiu zza(zzind zzindVar, zzind zzindVar2) {
        return new zzeiu(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdkq(((zzejq) this.zza).zzb(), zzfoa.zzc());
    }
}
