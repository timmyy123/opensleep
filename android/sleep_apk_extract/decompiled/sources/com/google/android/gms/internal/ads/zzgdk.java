package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzgdk implements zzind {
    final /* synthetic */ zzgdl zza;

    public zzgdk(zzgdl zzgdlVar) {
        Objects.requireNonNull(zzgdlVar);
        this.zza = zzgdlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzgds(this.zza.zza(), null);
    }
}
