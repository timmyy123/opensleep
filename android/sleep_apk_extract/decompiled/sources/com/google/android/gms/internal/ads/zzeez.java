package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public final class zzeez implements zzimu {
    private final zzind zza;

    private zzeez(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
    }

    public static zzeez zzc(zzind zzindVar, zzind zzindVar2) {
        return new zzeez(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzefv zzb() {
        return new zzefv((Context) this.zza.zzb(), zzfoa.zzc());
    }
}
