package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdmu implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzdmu(zzdmd zzdmdVar, zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
    }

    public static zzdmu zzc(zzdmd zzdmdVar, zzind zzindVar, zzind zzindVar2) {
        return new zzdmu(zzdmdVar, zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzcdw zzb() {
        return new zzcdw(((zzcns) this.zza).zza(), ((zzdci) this.zzb).zza().zzg);
    }
}
