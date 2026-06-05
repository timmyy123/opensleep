package com.google.android.gms.internal.consent_sdk;

import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
final class zzdx extends zzeb {
    private final Object zza;
    private boolean zzb;

    public zzdx(Object obj) {
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
