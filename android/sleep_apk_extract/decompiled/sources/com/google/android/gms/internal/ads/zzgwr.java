package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzgwr extends zzgza {
    final Iterator zza;
    Iterator zzb;
    final /* synthetic */ zzgwu zzc;

    public zzgwr(zzgwu zzgwuVar) {
        Objects.requireNonNull(zzgwuVar);
        this.zzc = zzgwuVar;
        this.zza = ((zzgwm) zzgwuVar.map.values()).listIterator(0);
        this.zzb = zzgxc.zza;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb.hasNext() || this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!this.zzb.hasNext()) {
            this.zzb = ((zzgwi) this.zza.next()).zza();
        }
        return this.zzb.next();
    }
}
