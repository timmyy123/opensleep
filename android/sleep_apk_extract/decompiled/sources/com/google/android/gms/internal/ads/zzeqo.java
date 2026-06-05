package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzeqo implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzeqo(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
    }

    public static zzeqo zzc(zzind zzindVar, zzind zzindVar2) {
        return new zzeqo(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzeqn zzb() {
        return new zzeqn((zzerr) this.zza.zzb(), (zzdxc) this.zzb.zzb());
    }
}
