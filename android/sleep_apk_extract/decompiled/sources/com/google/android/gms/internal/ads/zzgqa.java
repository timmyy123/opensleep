package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes3.dex */
public final class zzgqa implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzgqa(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
    }

    public static zzgqa zza(zzind zzindVar, zzind zzindVar2) {
        return new zzgqa(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzgpz((Context) this.zza.zzb(), (ExecutorService) this.zzb.zzb());
    }
}
