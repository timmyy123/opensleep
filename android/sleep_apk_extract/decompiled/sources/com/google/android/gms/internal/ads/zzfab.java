package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfab implements zzimu {
    private final zzind zza;

    private zzfab(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar2;
    }

    public static zzfab zzc(zzind zzindVar, zzind zzindVar2) {
        return new zzfab(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzezz zzb() {
        return new zzezz(zzfoa.zzc(), (zzecr) this.zza.zzb());
    }
}
