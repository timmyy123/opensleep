package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzimu;
import com.google.android.gms.internal.ads.zzinc;

/* JADX INFO: loaded from: classes3.dex */
public final class zzav implements zzimu {
    private final zzat zza;

    private zzav(zzat zzatVar) {
        this.zza = zzatVar;
    }

    public static zzav zza(zzat zzatVar) {
        return new zzav(zzatVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* synthetic */ Object zzb() {
        String strZzb = this.zza.zzb();
        zzinc.zzb(strZzb);
        return strZzb;
    }
}
