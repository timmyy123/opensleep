package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzect implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzect(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
    }

    public static zzect zza(zzind zzindVar, zzind zzindVar2) {
        return new zzect(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzecm((zzebw) this.zza.zzb(), (zzdwz) this.zzb.zzb());
    }
}
