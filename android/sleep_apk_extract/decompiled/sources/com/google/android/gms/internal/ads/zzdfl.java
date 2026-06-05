package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdfl implements zzimu {
    private final zzind zza;

    private zzdfl(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzdfl zza(zzind zzindVar) {
        return new zzdfl(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdfk(((zzing) this.zza).zzb());
    }
}
