package com.google.android.gms.internal.ads;

import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public final class zzgoo implements zzimu {
    private final zzind zza;

    private zzgoo(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzgoo zza(zzind zzindVar) {
        return new zzgoo(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new File(new File((File) this.zza.zzb(), "ocs"), "pmtd");
    }
}
