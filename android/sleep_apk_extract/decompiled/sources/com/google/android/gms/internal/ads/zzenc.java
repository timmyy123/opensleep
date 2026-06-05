package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public final class zzenc implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzenc(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
    }

    public static zzenc zzc(zzind zzindVar, zzind zzindVar2) {
        return new zzenc(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzenb zzb() {
        return new zzenb((Context) this.zza.zzb(), (zzcwq) this.zzb.zzb());
    }
}
