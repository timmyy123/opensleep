package com.google.android.gms.internal.ads;

import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public final class zzgnm implements zzimu {
    private final zzind zza;

    private zzgnm(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzgnm zza(zzind zzindVar) {
        return new zzgnm(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new File(new File((File) this.zza.zzb(), "drgd"), "pcbc.d");
    }
}
