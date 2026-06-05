package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcvt implements zzimu {
    private final zzcvs zza;
    private final zzind zzb;

    private zzcvt(zzcvs zzcvsVar, zzind zzindVar) {
        this.zza = zzcvsVar;
        this.zzb = zzindVar;
    }

    public static zzcvt zza(zzcvs zzcvsVar, zzind zzindVar) {
        return new zzcvt(zzcvsVar, zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* synthetic */ Object zzb() {
        return this.zza.zze(((zzing) this.zzb).zzb());
    }
}
