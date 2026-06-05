package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfai implements zzimu {
    private final zzind zza;

    private zzfai(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzfai zzc(zzind zzindVar) {
        return new zzfai(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzfag zzb() {
        return new zzfag((zzfke) this.zza.zzb());
    }
}
