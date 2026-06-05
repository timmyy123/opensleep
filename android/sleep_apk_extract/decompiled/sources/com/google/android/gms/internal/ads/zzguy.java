package com.google.android.gms.internal.ads;

import adamb.ogg.OggIO$$ExternalSyntheticBUOutline0;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
class zzguy implements Iterator {
    final Iterator zza;
    final Collection zzb;
    final /* synthetic */ zzguz zzc;

    public zzguy(zzguz zzguzVar) {
        Objects.requireNonNull(zzguzVar);
        this.zzc = zzguzVar;
        Collection collection = zzguzVar.zzb;
        this.zzb = collection;
        this.zza = collection instanceof List ? ((List) collection).listIterator() : collection.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        zza();
        return this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        zza();
        return this.zza.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.zza.remove();
        zzguz zzguzVar = this.zzc;
        zzguzVar.zze.zzq(r0.zzp() - 1);
        zzguzVar.zzb();
    }

    public final void zza() {
        zzguz zzguzVar = this.zzc;
        zzguzVar.zza();
        if (zzguzVar.zzb == this.zzb) {
            return;
        }
        OggIO$$ExternalSyntheticBUOutline0.m();
    }

    public zzguy(zzguz zzguzVar, Iterator it) {
        Objects.requireNonNull(zzguzVar);
        this.zzc = zzguzVar;
        this.zzb = zzguzVar.zzb;
        this.zza = it;
    }
}
