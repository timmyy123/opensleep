package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcwt implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzcwt(zzind zzindVar, zzind zzindVar2, zzind zzindVar3) {
        this.zza = zzindVar2;
        this.zzb = zzindVar3;
    }

    public static zzcwt zza(zzind zzindVar, zzind zzindVar2, zzind zzindVar3) {
        return new zzcwt(zzindVar, zzindVar2, zzindVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* synthetic */ Object zzb() {
        return true == Boolean.valueOf(zzcwr.zza()).booleanValue() ? ((zzeow) this.zza).zzb() : ((zzeqv) this.zzb).zzb();
    }
}
