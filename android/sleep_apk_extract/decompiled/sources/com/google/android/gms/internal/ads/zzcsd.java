package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcsd implements zzimu {
    private final zzind zza;

    private zzcsd(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzcsd zza(zzind zzindVar) {
        return new zzcsd(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzcsc(((zzelr) this.zza).zzb());
    }
}
