package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcnr implements zzimu {
    private final zzind zza;

    private zzcnr(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzcnr zza(zzind zzindVar) {
        return new zzcnr(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        ApplicationInfo applicationInfo = ((zzcns) this.zza).zza().getApplicationInfo();
        zzinc.zzb(applicationInfo);
        return applicationInfo;
    }
}
