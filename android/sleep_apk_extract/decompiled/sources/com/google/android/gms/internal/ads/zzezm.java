package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzezm implements zzimu {
    private final zzind zza;

    private zzezm(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar2;
    }

    public static zzezm zzc(zzind zzindVar, zzind zzindVar2) {
        return new zzezm(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzezk zzb() {
        return new zzezk(zzfoa.zzc(), ((zzcns) this.zza).zza());
    }
}
