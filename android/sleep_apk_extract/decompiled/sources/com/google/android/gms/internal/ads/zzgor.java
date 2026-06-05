package com.google.android.gms.internal.ads;

import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public final class zzgor implements zzimu {
    private final zzind zza;

    private zzgor(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzgor zza(zzind zzindVar) {
        return new zzgor(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new File(new File((File) this.zza.zzb(), "ocs"), "pcam.jar");
    }
}
