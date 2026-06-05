package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public final class zzeml implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzeml(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
    }

    public static zzeml zzc(zzind zzindVar, zzind zzindVar2) {
        return new zzeml(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzemk zzb() {
        return new zzemk((Context) this.zza.zzb(), (zzcuz) this.zzb.zzb());
    }
}
