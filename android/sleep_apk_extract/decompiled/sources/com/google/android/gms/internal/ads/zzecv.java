package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzecv implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzecv(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
    }

    public static zzecv zza(zzind zzindVar, zzind zzindVar2) {
        return new zzecv(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzedc(((zzcns) this.zza).zza(), ((zzcoi) this.zzb).zza());
    }
}
