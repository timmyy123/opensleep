package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public final class zzepr implements zzimu {
    private final zzind zza;
    private final zzind zzb;
    private final zzind zzc;

    private zzepr(zzind zzindVar, zzind zzindVar2, zzind zzindVar3) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
        this.zzc = zzindVar3;
    }

    public static zzepr zza(zzind zzindVar, zzind zzindVar2, zzind zzindVar3) {
        return new zzepr(zzindVar, zzindVar2, zzindVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzepq((Context) this.zza.zzb(), (Executor) this.zzb.zzb(), (zzdvr) this.zzc.zzb());
    }
}
