package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzecs implements zzimu {
    private final zzind zza;

    private zzecs(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzecs zza(zzind zzindVar) {
        return new zzecs(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzecd(((zzcns) this.zza).zza());
    }
}
