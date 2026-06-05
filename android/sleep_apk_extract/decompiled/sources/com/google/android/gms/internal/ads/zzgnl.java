package com.google.android.gms.internal.ads;

import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public final class zzgnl implements zzimu {
    private final zzind zza;

    private zzgnl(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzgnl zza(zzind zzindVar) {
        return new zzgnl(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new File(new File((File) this.zza.zzb(), "drgd"), "pmtd.d");
    }
}
