package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzekh implements zzimu {
    private final zzind zza;

    private zzekh(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
    }

    public static zzekh zza(zzind zzindVar, zzind zzindVar2) {
        return new zzekh(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzekg(((zzcns) this.zza).zza(), zzfoa.zzc());
    }
}
