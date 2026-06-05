package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdcq implements zzimu {
    private final zzind zza;

    private zzdcq(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzdcq zza(zzind zzindVar) {
        return new zzdcq(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdcp(((zzing) this.zza).zzb());
    }
}
