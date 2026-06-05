package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcsk implements zzimu {
    private final zzind zza;

    private zzcsk(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzcsk zza(zzind zzindVar) {
        return new zzcsk(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzcsj(((zzcns) this.zza).zza());
    }
}
