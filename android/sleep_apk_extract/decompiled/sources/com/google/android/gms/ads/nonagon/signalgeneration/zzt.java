package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzdzq;
import com.google.android.gms.internal.ads.zzimu;
import com.google.android.gms.internal.ads.zzind;

/* JADX INFO: loaded from: classes3.dex */
public final class zzt implements zzimu {
    private final zzind zza;

    private zzt(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzt zza(zzind zzindVar) {
        return new zzt(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzq((zzdzq) this.zza.zzb());
    }
}
