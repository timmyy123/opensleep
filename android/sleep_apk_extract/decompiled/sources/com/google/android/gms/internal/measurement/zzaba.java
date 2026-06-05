package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Objects;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
final class zzaba implements Iterator {
    final /* synthetic */ zzabb zza;
    private int zzb;

    public zzaba(zzabb zzabbVar) {
        Objects.requireNonNull(zzabbVar);
        this.zza = zzabbVar;
        this.zzb = 0;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i = this.zzb;
        zzabb zzabbVar = this.zza;
        return i < zzabbVar.zzc() - zzabbVar.zzb();
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i = this.zzb;
        zzabb zzabbVar = this.zza;
        if (i >= zzabbVar.zzc() - zzabbVar.zzb()) {
            Types$$ExternalSyntheticBUOutline0.m();
            return null;
        }
        zzabc zzabcVar = zzabbVar.zzb;
        Object obj = zzabcVar.zzb()[zzabbVar.zzb() + i];
        this.zzb = i + 1;
        return obj;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
