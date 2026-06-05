package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzezq implements zzimu {
    private final zzind zza;

    private zzezq(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar2;
    }

    public static zzezq zzc(zzind zzindVar, zzind zzindVar2) {
        return new zzezq(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzezo zzb() {
        return new zzezo(zzfoa.zzc(), ((zzdci) this.zza).zza());
    }
}
