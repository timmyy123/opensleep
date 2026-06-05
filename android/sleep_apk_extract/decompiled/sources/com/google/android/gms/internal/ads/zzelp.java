package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzelp implements zzimu {
    private final zzind zza;

    private zzelp(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzelp zza(zzind zzindVar) {
        return new zzelp(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzelo(((zzcns) this.zza).zza());
    }
}
