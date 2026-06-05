package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzevt implements zzimu {
    private final zzind zza;

    private zzevt(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar2;
    }

    public static zzevt zzc(zzind zzindVar, zzind zzindVar2) {
        return new zzevt(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzevr zzb() {
        return new zzevr(zzfoa.zzc(), (zzcfd) this.zza.zzb());
    }
}
