package com.google.android.gms.internal.ads;

import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdmi implements zzimu {
    private final zzdmd zza;

    private zzdmi(zzdmd zzdmdVar) {
        this.zza = zzdmdVar;
    }

    public static zzdmi zzc(zzdmd zzdmdVar) {
        return new zzdmi(zzdmdVar);
    }

    public final View zza() {
        return this.zza.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* synthetic */ Object zzb() {
        return this.zza.zzd();
    }
}
