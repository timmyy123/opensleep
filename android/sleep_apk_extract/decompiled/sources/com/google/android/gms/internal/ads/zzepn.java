package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* JADX INFO: loaded from: classes3.dex */
public final class zzepn implements zzimu {
    private final zzepm zza;
    private final zzind zzb;
    private final zzind zzc;
    private final zzind zzd;
    private final zzind zze;

    private zzepn(zzepm zzepmVar, zzind zzindVar, zzind zzindVar2, zzind zzindVar3, zzind zzindVar4) {
        this.zza = zzepmVar;
        this.zzb = zzindVar;
        this.zzc = zzindVar2;
        this.zzd = zzindVar3;
        this.zze = zzindVar4;
    }

    public static zzepn zza(zzepm zzepmVar, zzind zzindVar, zzind zzindVar2, zzind zzindVar3, zzind zzindVar4) {
        return new zzepn(zzepmVar, zzindVar, zzindVar2, zzindVar3, zzindVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* synthetic */ Object zzb() {
        return this.zza.zzb((Clock) this.zzb.zzb(), ((zzepg) this.zzc).zzb(), (zzelx) this.zzd.zzb(), (zzfsc) this.zze.zzb());
    }
}
