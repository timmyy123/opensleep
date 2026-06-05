package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzegl implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzegl(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
    }

    public static zzegl zzc(zzind zzindVar, zzind zzindVar2) {
        return new zzegl(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzegk zzb() {
        return new zzegk(((zzcns) this.zza).zza(), (zzcdz) this.zzb.zzb());
    }
}
