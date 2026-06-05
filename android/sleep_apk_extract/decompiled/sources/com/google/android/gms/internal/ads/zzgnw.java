package com.google.android.gms.internal.ads;

import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public final class zzgnw implements zzimu {
    private final zzind zza;

    private zzgnw(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzgnw zza(zzind zzindVar) {
        return new zzgnw(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new File(new File(new File((File) this.zza.zzb(), "drgd"), "v"), "pcam.jar");
    }
}
