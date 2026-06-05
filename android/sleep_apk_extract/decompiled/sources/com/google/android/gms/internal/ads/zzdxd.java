package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdxd implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzdxd(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
    }

    public static zzdxd zza(zzind zzindVar, zzind zzindVar2) {
        return new zzdxd(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdxc(((zzcrc) this.zza).zzb(), (zzdwz) this.zzb.zzb());
    }
}
