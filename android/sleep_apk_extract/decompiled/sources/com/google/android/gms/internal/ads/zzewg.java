package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzewg implements zzimu {
    private final zzind zza;

    private zzewg(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
    }

    public static zzewg zzc(zzind zzindVar, zzind zzindVar2) {
        return new zzewg(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzewe zzb() {
        return new zzewe(((zzcoi) this.zza).zza(), zzfoa.zzc());
    }
}
