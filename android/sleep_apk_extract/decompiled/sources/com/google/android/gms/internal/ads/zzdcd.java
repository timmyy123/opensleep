package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdcd implements zzimu {
    private final zzdcb zza;
    private final zzind zzb;

    private zzdcd(zzdcb zzdcbVar, zzind zzindVar) {
        this.zza = zzdcbVar;
        this.zzb = zzindVar;
    }

    public static zzdcd zza(zzdcb zzdcbVar, zzind zzindVar) {
        return new zzdcd(zzdcbVar, zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        Context contextZzf = this.zza.zzf(((zzcns) this.zzb).zza());
        zzinc.zzb(contextZzf);
        return contextZzf;
    }
}
