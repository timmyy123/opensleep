package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdvv implements zzimu {
    private final zzind zza;

    private zzdvv(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzdvv zza(zzind zzindVar) {
        return new zzdvv(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return ((zzdci) this.zza).zza().zzp.zza == 3 ? "rewarded_interstitial" : "rewarded";
    }
}
