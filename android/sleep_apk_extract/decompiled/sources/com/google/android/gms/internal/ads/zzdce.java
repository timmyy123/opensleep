package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdce implements zzimu {
    private final zzdcb zza;

    private zzdce(zzdcb zzdcbVar) {
        this.zza = zzdcbVar;
    }

    public static zzdce zzc(zzdcb zzdcbVar) {
        return new zzdce(zzdcbVar);
    }

    public final Bundle zza() {
        return this.zza.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* synthetic */ Object zzb() {
        return this.zza.zzd();
    }
}
