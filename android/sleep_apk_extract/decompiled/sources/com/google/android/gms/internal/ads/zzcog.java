package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcog implements zzimu {
    private final zzind zza;

    private zzcog(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzcog zza(zzind zzindVar) {
        return new zzcog(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        Context contextZza = ((zzcns) this.zza).zza();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzmS)).booleanValue()) {
            return com.google.android.gms.ads.internal.util.client.zzf.zzf(contextZza);
        }
        return null;
    }
}
