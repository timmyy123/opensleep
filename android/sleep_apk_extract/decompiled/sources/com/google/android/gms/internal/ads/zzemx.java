package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public final class zzemx implements zzimu {
    private final zzind zza;
    private final zzind zzb;
    private final zzind zzc;

    private zzemx(zzind zzindVar, zzind zzindVar2, zzind zzindVar3) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
        this.zzc = zzindVar3;
    }

    public static zzemx zza(zzind zzindVar, zzind zzindVar2, zzind zzindVar3) {
        return new zzemx(zzindVar, zzindVar2, zzindVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzemw((Context) this.zza.zzb(), (zzcwq) this.zzb.zzb(), (Executor) this.zzc.zzb());
    }
}
