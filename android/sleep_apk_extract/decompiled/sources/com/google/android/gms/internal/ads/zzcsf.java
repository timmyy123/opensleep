package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcsf implements zzimu {
    private final zzind zza;

    private zzcsf(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzcsf zza(zzind zzindVar) {
        return new zzcsf(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzcse((zzecr) this.zza.zzb());
    }
}
