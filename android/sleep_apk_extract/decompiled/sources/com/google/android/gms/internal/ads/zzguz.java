package com.google.android.gms.internal.ads;

import adamb.ogg.OggIO$$ExternalSyntheticBUOutline0;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
abstract class zzguz extends AbstractCollection {
    final Object zza;
    Collection zzb;
    final zzguz zzc;
    final Collection zzd;
    final /* synthetic */ zzgvc zze;

    public zzguz(zzgvc zzgvcVar, Object obj, Collection collection, zzguz zzguzVar) {
        Objects.requireNonNull(zzgvcVar);
        this.zze = zzgvcVar;
        this.zza = obj;
        this.zzb = collection;
        this.zzc = zzguzVar;
        this.zzd = zzguzVar == null ? null : zzguzVar.zzb;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean add(Object obj) {
        zza();
        boolean zIsEmpty = this.zzb.isEmpty();
        boolean zAdd = this.zzb.add(obj);
        if (zAdd) {
            zzgvc zzgvcVar = this.zze;
            zzgvcVar.zzq(zzgvcVar.zzp() + 1);
            if (zIsEmpty) {
                zzc();
                return true;
            }
        }
        return zAdd;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean addAll(Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean zAddAll = this.zzb.addAll(collection);
        if (zAddAll) {
            int size2 = this.zzb.size();
            zzgvc zzgvcVar = this.zze;
            zzgvcVar.zzq(zzgvcVar.zzp() + (size2 - size));
            if (size == 0) {
                zzc();
                return true;
            }
        }
        return zAddAll;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        int size = size();
        if (size == 0) {
            return;
        }
        this.zzb.clear();
        zzgvc zzgvcVar = this.zze;
        zzgvcVar.zzq(zzgvcVar.zzp() - size);
        zzb();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        zza();
        return this.zzb.contains(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean containsAll(Collection collection) {
        zza();
        return this.zzb.containsAll(collection);
    }

    @Override // java.util.Collection
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        zza();
        return this.zzb.equals(obj);
    }

    @Override // java.util.Collection
    public final int hashCode() {
        zza();
        return this.zzb.hashCode();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        zza();
        return new zzguy(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean remove(Object obj) {
        zza();
        boolean zRemove = this.zzb.remove(obj);
        if (zRemove) {
            this.zze.zzq(r0.zzp() - 1);
            zzb();
        }
        return zRemove;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean removeAll(Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean zRemoveAll = this.zzb.removeAll(collection);
        if (zRemoveAll) {
            int size2 = this.zzb.size();
            zzgvc zzgvcVar = this.zze;
            zzgvcVar.zzq(zzgvcVar.zzp() + (size2 - size));
            zzb();
        }
        return zRemoveAll;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean retainAll(Collection collection) {
        collection.getClass();
        int size = size();
        boolean zRetainAll = this.zzb.retainAll(collection);
        if (zRetainAll) {
            int size2 = this.zzb.size();
            zzgvc zzgvcVar = this.zze;
            zzgvcVar.zzq(zzgvcVar.zzp() + (size2 - size));
            zzb();
        }
        return zRetainAll;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        zza();
        return this.zzb.size();
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        zza();
        return this.zzb.toString();
    }

    public final void zza() {
        zzguz zzguzVar = this.zzc;
        if (zzguzVar != null) {
            zzguzVar.zza();
            if (zzguzVar.zzb == this.zzd) {
                return;
            }
            OggIO$$ExternalSyntheticBUOutline0.m();
            return;
        }
        if (this.zzb.isEmpty()) {
            zzgvc zzgvcVar = this.zze;
            Collection collection = (Collection) zzgvcVar.zzo().get(this.zza);
            if (collection != null) {
                this.zzb = collection;
            }
        }
    }

    public final void zzb() {
        zzguz zzguzVar = this.zzc;
        if (zzguzVar != null) {
            zzguzVar.zzb();
        } else if (this.zzb.isEmpty()) {
            zzgvc zzgvcVar = this.zze;
            zzgvcVar.zzo().remove(this.zza);
        }
    }

    public final void zzc() {
        zzguz zzguzVar = this.zzc;
        if (zzguzVar != null) {
            zzguzVar.zzc();
            return;
        }
        zzgvc zzgvcVar = this.zze;
        zzgvcVar.zzo().put(this.zza, this.zzb);
    }
}
