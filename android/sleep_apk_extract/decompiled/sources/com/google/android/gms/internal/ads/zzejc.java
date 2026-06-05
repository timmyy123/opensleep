package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzejc implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzejc(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
    }

    public static zzejc zza(zzind zzindVar, zzind zzindVar2) {
        return new zzejc(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzejb(((zzejn) this.zza).zzb(), ((zzcnm) this.zzb).zzb());
    }
}
