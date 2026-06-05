package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzebb implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzebb(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
    }

    public static zzebb zza(zzind zzindVar, zzind zzindVar2) {
        return new zzebb(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzeba((zzebd) this.zza.zzb(), ((zzeaz) this.zzb).zzb());
    }
}
