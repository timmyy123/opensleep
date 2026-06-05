package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzeal implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzeal(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
    }

    public static zzeal zza(zzind zzindVar, zzind zzindVar2) {
        return new zzeal(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzeak((zzdzy) this.zza.zzb(), (zzcnj) this.zzb.zzb());
    }
}
