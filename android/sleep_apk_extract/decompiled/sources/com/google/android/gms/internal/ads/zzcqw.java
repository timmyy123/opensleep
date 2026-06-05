package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcqw implements zzimu {
    private final zzind zza;

    private zzcqw(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzcqw zza(zzind zzindVar) {
        return new zzcqw(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new com.google.android.gms.ads.internal.util.zzbl(((zzcns) this.zza).zza());
    }
}
