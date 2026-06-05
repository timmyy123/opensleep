package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdlx implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzdlx(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
    }

    public static zzdlx zza(zzind zzindVar, zzind zzindVar2) {
        return new zzdlx(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdlw((zzdwu) this.zza.zzb(), ((zzcym) this.zzb).zza());
    }
}
