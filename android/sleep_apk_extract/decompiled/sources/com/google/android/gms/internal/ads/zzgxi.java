package com.google.android.gms.internal.ads;

import java.util.ListIterator;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzgxi extends zzgyz {
    final /* synthetic */ zzgxj zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzgxi(zzgxj zzgxjVar, ListIterator listIterator) {
        super(listIterator);
        Objects.requireNonNull(zzgxjVar);
        this.zza = zzgxjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgyy
    public final Object zza(Object obj) {
        return this.zza.zzb.apply(obj);
    }
}
