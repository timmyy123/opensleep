package com.google.android.gms.internal.fitness;

import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
final class zzeu extends zzff {
    private final Object zza;
    private boolean zzb;

    public zzeu(Object obj) {
        this.zza = obj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return !this.zzb;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.zzb) {
            Types$$ExternalSyntheticBUOutline0.m();
            return null;
        }
        this.zzb = true;
        return this.zza;
    }
}
