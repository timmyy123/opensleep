package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzewn implements zzimu {
    private final zzind zza;

    private zzewn(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzewn zzc(zzind zzindVar) {
        return new zzewn(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzewl zzb() {
        return new zzewl(((zzdci) this.zza).zza());
    }
}
