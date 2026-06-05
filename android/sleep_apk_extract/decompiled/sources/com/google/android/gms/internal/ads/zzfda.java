package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfda implements zzimu {
    private final zzind zza;

    private zzfda(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar2;
    }

    public static zzfda zzc(zzind zzindVar, zzind zzindVar2) {
        return new zzfda(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzfcz zzb() {
        return new zzfcz(zzfoa.zzc(), ((zzcns) this.zza).zza());
    }
}
