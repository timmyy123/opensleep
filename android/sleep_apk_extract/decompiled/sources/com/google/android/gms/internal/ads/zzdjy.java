package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdjy implements zzimu {
    private final zzind zza;

    private zzdjy(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzdjy zzc(zzind zzindVar) {
        return new zzdjy(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzdjx zzb() {
        return new zzdjx(((zzing) this.zza).zzb());
    }
}
