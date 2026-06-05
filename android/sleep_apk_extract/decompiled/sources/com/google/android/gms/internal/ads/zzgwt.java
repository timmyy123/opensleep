package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
final class zzgwt extends zzgwi {
    private final transient zzgwu zza;

    public zzgwt(zzgwu zzgwuVar) {
        this.zza = zzgwuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgwi, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.zza.zzr(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new zzgwr(this.zza);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        return this.zza.size;
    }

    @Override // com.google.android.gms.internal.ads.zzgwi
    public final zzgza zza() {
        return new zzgwr(this.zza);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzgwi
    public final int zzg(Object[] objArr, int i) {
        zzgzb zzgzbVarListIterator = ((zzgwm) this.zza.map.values()).listIterator(0);
        while (zzgzbVarListIterator.hasNext()) {
            i = ((zzgwi) zzgzbVarListIterator.next()).zzg(objArr, i);
        }
        return i;
    }
}
