package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcxx implements zzimu {
    private final zzind zza;

    private zzcxx(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzcxx zza(zzind zzindVar) {
        return new zzcxx(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzcxv(((zzimy) this.zza).zzb());
    }
}
