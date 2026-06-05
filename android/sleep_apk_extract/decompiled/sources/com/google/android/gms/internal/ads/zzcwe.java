package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcwe implements zzimu {
    private final zzcvs zza;
    private final zzind zzb;

    private zzcwe(zzcvs zzcvsVar, zzind zzindVar) {
        this.zza = zzcvsVar;
        this.zzb = zzindVar;
    }

    public static zzcwe zza(zzcvs zzcvsVar, zzind zzindVar) {
        return new zzcwe(zzcvsVar, zzindVar);
    }

    public static zzdkq zzc(zzcvs zzcvsVar, zzcxg zzcxgVar) {
        return new zzdkq(zzcxgVar, zzcfr.zzf);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return zzc(this.zza, (zzcxg) this.zzb.zzb());
    }
}
