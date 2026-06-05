package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcui implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzcui(zzind zzindVar, zzind zzindVar2, zzind zzindVar3) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
    }

    public static zzcui zza(zzind zzindVar, zzind zzindVar2, zzind zzindVar3) {
        return new zzcui(zzindVar, zzindVar2, zzindVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzben zzbenVar = (zzben) this.zza.zzb();
        return new zzcub(zzbenVar.zzd(), (zzbur) this.zzb.zzb(), zzfnw.zzc());
    }
}
