package com.google.android.gms.internal.fido;

import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
final class zzav extends zzaz {
    boolean zza;
    final /* synthetic */ Object zzb;

    public zzav(Object obj) {
        this.zzb = obj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return !this.zza;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.zza) {
            Types$$ExternalSyntheticBUOutline0.m();
            return null;
        }
        this.zza = true;
        return this.zzb;
    }
}
