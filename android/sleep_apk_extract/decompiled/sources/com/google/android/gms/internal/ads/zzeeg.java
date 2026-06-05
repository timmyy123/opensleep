package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzeeg implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzeeg(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
    }

    public static zzeeg zza(zzind zzindVar, zzind zzindVar2) {
        return new zzeeg(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzeef(((zzcns) this.zza).zza(), (zzdzl) this.zzb.zzb());
    }
}
