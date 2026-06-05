package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public final class zzenw implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzenw(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
    }

    public static zzenw zzc(zzind zzindVar, zzind zzindVar2) {
        return new zzenw(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzenv zzb() {
        return new zzenv((Context) this.zza.zzb(), (zzdng) this.zzb.zzb());
    }
}
