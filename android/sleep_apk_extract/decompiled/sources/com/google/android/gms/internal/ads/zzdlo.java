package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdlo implements zzimu {
    private final zzind zza;

    private zzdlo(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzdlo zza(zzind zzindVar) {
        return new zzdlo(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdln(((zzing) this.zza).zzb());
    }
}
