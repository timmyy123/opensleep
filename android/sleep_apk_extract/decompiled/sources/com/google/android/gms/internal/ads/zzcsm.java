package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcsm implements zzimu {
    private final zzind zza;

    private zzcsm(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzcsm zza(zzind zzindVar) {
        return new zzcsm(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzcsl(((zzcnm) this.zza).zzb());
    }
}
