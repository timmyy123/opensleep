package com.google.android.gms.internal.ads;

import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public final class zzgns implements zzimu {
    private final zzind zza;

    private zzgns(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzgns zza(zzind zzindVar) {
        return new zzgns(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new File(new File(new File((File) this.zza.zzb(), "drgd"), "v"), "pcopt");
    }
}
