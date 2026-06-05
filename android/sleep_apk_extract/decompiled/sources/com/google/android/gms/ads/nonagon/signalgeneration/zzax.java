package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzdkq;
import com.google.android.gms.internal.ads.zzfoa;
import com.google.android.gms.internal.ads.zzimu;
import com.google.android.gms.internal.ads.zzind;

/* JADX INFO: loaded from: classes3.dex */
public final class zzax implements zzimu {
    private final zzind zza;

    private zzax(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
    }

    public static zzax zza(zzind zzindVar, zzind zzindVar2) {
        return new zzax(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdkq((zzr) this.zza.zzb(), zzfoa.zzc());
    }
}
