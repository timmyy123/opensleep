package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdfw implements zzimu {
    private final zzind zza;

    private zzdfw(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzdfw zzc(zzind zzindVar) {
        return new zzdfw(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzdfv zzb() {
        return new zzdfv(((zzing) this.zza).zzb());
    }
}
