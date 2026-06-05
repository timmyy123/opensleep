package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfaq implements zzimu {
    private final zzind zza;

    private zzfaq(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar2;
    }

    public static zzfaq zzc(zzind zzindVar, zzind zzindVar2) {
        return new zzfaq(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzfao zzb() {
        return new zzfao(zzfoa.zzc(), ((zzcns) this.zza).zza());
    }
}
