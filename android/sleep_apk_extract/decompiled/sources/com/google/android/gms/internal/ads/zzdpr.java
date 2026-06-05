package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdpr implements zzimu {
    private final zzind zza;

    private zzdpr(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzdpr zza(zzind zzindVar) {
        return new zzdpr(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdpq(((zzdpc) this.zza).zzb());
    }
}
