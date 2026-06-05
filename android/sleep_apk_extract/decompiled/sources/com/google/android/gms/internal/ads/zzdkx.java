package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdkx implements zzimu {
    private final zzind zza;

    private zzdkx(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzdkx zza(zzind zzindVar) {
        return new zzdkx(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdkw(((zzing) this.zza).zzb());
    }
}
