package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcud implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzcud(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
    }

    public static zzcud zza(zzind zzindVar, zzind zzindVar2) {
        return new zzcud(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzcuc(((zzcns) this.zza).zza(), (zzben) this.zzb.zzb());
    }
}
