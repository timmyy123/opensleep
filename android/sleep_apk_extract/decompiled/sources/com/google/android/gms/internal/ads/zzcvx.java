package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcvx implements zzimu {
    private final zzind zza;

    private zzcvx(zzcvs zzcvsVar, zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzcvx zza(zzcvs zzcvsVar, zzind zzindVar) {
        return new zzcvx(zzcvsVar, zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return zzgww.zzi(new zzdkq((zzcxi) this.zza.zzb(), zzcfr.zzh));
    }
}
