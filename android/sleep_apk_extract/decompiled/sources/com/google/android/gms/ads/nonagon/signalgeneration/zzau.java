package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzbhv$zza;
import com.google.android.gms.internal.ads.zzimu;
import com.google.android.gms.internal.ads.zzinc;

/* JADX INFO: loaded from: classes3.dex */
public final class zzau implements zzimu {
    private final zzat zza;

    private zzau(zzat zzatVar) {
        this.zza = zzatVar;
    }

    public static zzau zza(zzat zzatVar) {
        return new zzau(zzatVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* synthetic */ Object zzb() {
        zzbhv$zza.zza zzaVarZzc = this.zza.zzc();
        zzinc.zzb(zzaVarZzc);
        return zzaVarZzc;
    }
}
