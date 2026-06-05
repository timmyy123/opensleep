package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcvy implements zzimu {
    private final zzcvs zza;
    private final zzind zzb;

    private zzcvy(zzcvs zzcvsVar, zzind zzindVar) {
        this.zza = zzcvsVar;
        this.zzb = zzindVar;
    }

    public static zzcvy zzc(zzcvs zzcvsVar, zzind zzindVar) {
        return new zzcvy(zzcvsVar, zzindVar);
    }

    public static zzcvl zzd(zzcvs zzcvsVar, Object obj) {
        return (zzcvo) obj;
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzcvl zzb() {
        return ((zzcvp) this.zzb).zzb();
    }
}
