package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcdp implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzcdp(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
    }

    public static zzcdp zza(zzind zzindVar, zzind zzindVar2) {
        return new zzcdp(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzcdo((Context) this.zza.zzb(), (com.google.android.gms.ads.internal.util.zzg) this.zzb.zzb());
    }
}
