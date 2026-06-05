package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzgvn extends zzgvp {
    final /* synthetic */ zzgvt zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzgvn(zzgvt zzgvtVar) {
        super(zzgvtVar, null);
        Objects.requireNonNull(zzgvtVar);
        this.zza = zzgvtVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgvp
    public final Object zza(int i) {
        return this.zza.zzp(i);
    }
}
