package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzcns;
import com.google.android.gms.internal.ads.zzdzq;
import com.google.android.gms.internal.ads.zzfoa;
import com.google.android.gms.internal.ads.zzimu;
import com.google.android.gms.internal.ads.zzind;

/* JADX INFO: loaded from: classes3.dex */
public final class zzm implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzm(zzind zzindVar, zzind zzindVar2, zzind zzindVar3) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
    }

    public static zzm zza(zzind zzindVar, zzind zzindVar2, zzind zzindVar3) {
        return new zzm(zzindVar, zzindVar2, zzindVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzj(((zzcns) this.zza).zza(), (zzdzq) this.zzb.zzb(), zzfoa.zzc());
    }
}
