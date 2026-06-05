package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzftc implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzftc(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
    }

    public static zzftc zza(zzind zzindVar, zzind zzindVar2) {
        return new zzftc(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzftb((zzfth) this.zza.zzb(), (zzfss) this.zzb.zzb());
    }
}
