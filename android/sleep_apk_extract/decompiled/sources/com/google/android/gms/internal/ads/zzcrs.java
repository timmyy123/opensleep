package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcrs implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzcrs(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
    }

    public static zzcrs zzc(zzind zzindVar, zzind zzindVar2) {
        return new zzcrs(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzcrr zzb() {
        return new zzcrr(((zzimy) this.zza).zzb(), ((zzimy) this.zzb).zzb());
    }
}
