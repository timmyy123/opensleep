package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcqx implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzcqx(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
    }

    public static zzcqx zza(zzind zzindVar, zzind zzindVar2) {
        return new zzcqx(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new com.google.android.gms.ads.internal.util.client.zzu(((zzcns) this.zza).zza(), (String) this.zzb.zzb());
    }
}
