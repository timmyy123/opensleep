package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdld implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzdld(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
    }

    public static zzdld zza(zzind zzindVar, zzind zzindVar2) {
        return new zzdld(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdlc(((zzcyk) this.zza).zza(), (zzfsc) this.zzb.zzb());
    }
}
