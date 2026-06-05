package com.google.android.gms.internal.ads;

import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public final class zzgnv implements zzimu {
    private final zzind zza;

    private zzgnv(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzgnv zza(zzind zzindVar) {
        return new zzgnv(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new File(new File((File) this.zza.zzb(), "drgd"), "pcam.jar.tmp");
    }
}
