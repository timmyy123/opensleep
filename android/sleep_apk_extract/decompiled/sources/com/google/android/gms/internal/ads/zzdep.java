package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdep implements zzimu {
    private final zzind zza;

    private zzdep(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzdep zza(zzind zzindVar) {
        return new zzdep(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdeo(((zzing) this.zza).zzb());
    }
}
