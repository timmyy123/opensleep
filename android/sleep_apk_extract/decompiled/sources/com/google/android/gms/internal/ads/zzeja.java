package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzeja implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzeja(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
    }

    public static zzeja zzc(zzind zzindVar, zzind zzindVar2) {
        return new zzeja(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzeiz zzb() {
        return new zzeiz(((zzeiw) this.zza).zzb(), (zzhcg) this.zzb.zzb());
    }
}
