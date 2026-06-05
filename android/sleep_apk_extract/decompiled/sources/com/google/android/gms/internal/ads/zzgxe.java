package com.google.android.gms.internal.ads;

import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
final class zzgxe extends zzgza {
    private final Object zza;
    private boolean zzb;

    public zzgxe(Object obj) {
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
