package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcnd implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzcnd(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
    }

    public static zzcnd zza(zzind zzindVar, zzind zzindVar2) {
        return new zzcnd(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzcnc((zzcmt) this.zza.zzb(), (zzdzl) this.zzb.zzb());
    }
}
