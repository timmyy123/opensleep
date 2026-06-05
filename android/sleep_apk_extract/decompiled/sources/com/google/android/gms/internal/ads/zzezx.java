package com.google.android.gms.internal.ads;

import android.content.Intent;

/* JADX INFO: loaded from: classes3.dex */
public final class zzezx implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzezx(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
    }

    public static zzezx zzc(zzind zzindVar, zzind zzindVar2) {
        return new zzezx(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzezv zzb() {
        return new zzezv(((zzcns) this.zza).zza(), (Intent) this.zzb.zzb());
    }
}
