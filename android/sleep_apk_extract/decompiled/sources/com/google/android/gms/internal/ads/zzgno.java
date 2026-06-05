package com.google.android.gms.internal.ads;

import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public final class zzgno implements zzimu {
    private final zzind zza;

    private zzgno(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzgno zza(zzind zzindVar) {
        return new zzgno(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new File(new File((File) this.zza.zzb(), "drgd"), "pcam.jar.d");
    }
}
