package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdem implements zzimu {
    private final zzind zza;

    private zzdem(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzdem zza(zzind zzindVar) {
        return new zzdem(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdel(((zzing) this.zza).zzb());
    }
}
