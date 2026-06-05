package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzeuc implements zzimu {
    private final zzind zza;

    private zzeuc(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzeuc zzc(zzind zzindVar) {
        return new zzeuc(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzeua zzb() {
        return new zzeua(((zzcns) this.zza).zza());
    }
}
