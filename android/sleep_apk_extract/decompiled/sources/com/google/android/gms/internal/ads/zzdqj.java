package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdqj implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzdqj(zzdqe zzdqeVar, zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
    }

    public static zzdqj zzc(zzdqe zzdqeVar, zzind zzindVar, zzind zzindVar2) {
        return new zzdqj(zzdqeVar, zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzcdw zzb() {
        return new zzcdw(((zzcns) this.zza).zza(), ((zzdci) this.zzb).zza().zzg);
    }
}
