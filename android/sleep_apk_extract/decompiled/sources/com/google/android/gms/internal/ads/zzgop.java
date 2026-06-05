package com.google.android.gms.internal.ads;

import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public final class zzgop implements zzimu {
    private final zzind zza;

    private zzgop(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzgop zza(zzind zzindVar) {
        return new zzgop(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new File(new File((File) this.zza.zzb(), "ocs"), "pcbc");
    }
}
