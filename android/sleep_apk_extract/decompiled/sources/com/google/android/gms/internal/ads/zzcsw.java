package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcsw implements zzimu {
    private final zzind zza;

    private zzcsw(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzcsw zza(zzind zzindVar) {
        return new zzcsw(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzcsv((Context) this.zza.zzb());
    }
}
