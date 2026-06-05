package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzzv implements Iterator {
    final /* synthetic */ zzzw zza;
    private int zzb;

    public zzzv(zzzw zzzwVar) {
        Objects.requireNonNull(zzzwVar);
        this.zza = zzzwVar;
        this.zzb = 0;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb < this.zza.zza.zzg();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        int i = this.zzb;
        this.zzb = i + 1;
        zzzy zzzyVar = this.zza.zza;
        return zzzyVar.zzd(zzzyVar.zzf()[i] & 31);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
