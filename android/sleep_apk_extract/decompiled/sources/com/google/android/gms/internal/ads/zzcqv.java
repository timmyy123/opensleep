package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcqv implements zzimu {
    private final zzind zza;

    private zzcqv(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzcqv zza(zzind zzindVar) {
        return new zzcqv(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzfxq(((zzcns) this.zza).zza(), com.google.android.gms.ads.internal.zzt.zzs().zza());
    }
}
