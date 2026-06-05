package com.google.android.gms.internal.ads;

import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
final class zzgyt extends zzgys implements SortedSet {
    public zzgyt(SortedSet sortedSet, zzgtk zzgtkVar) {
        super(sortedSet, zzgtkVar);
    }

    @Override // java.util.SortedSet
    public final Comparator comparator() {
        return ((SortedSet) this.zza).comparator();
    }

    @Override // java.util.SortedSet
    public final Object first() {
        Iterator it = this.zza.iterator();
        it.getClass();
        zzgtk zzgtkVar = this.zzb;
        zzgtkVar.getClass();
        while (it.hasNext()) {
            Object next = it.next();
            if (zzgtkVar.zza(next)) {
                return next;
            }
        }
        Types$$ExternalSyntheticBUOutline0.m();
        return null;
    }

    @Override // java.util.SortedSet
    public final SortedSet headSet(Object obj) {
        return new zzgyt(((SortedSet) this.zza).headSet(obj), this.zzb);
    }

    @Override // java.util.SortedSet
    public final Object last() {
        SortedSet sortedSetHeadSet = (SortedSet) this.zza;
        while (true) {
            zzgtk zzgtkVar = this.zzb;
            Object objLast = sortedSetHeadSet.last();
            if (zzgtkVar.zza(objLast)) {
                return objLast;
            }
            sortedSetHeadSet = sortedSetHeadSet.headSet(objLast);
        }
    }

    @Override // java.util.SortedSet
    public final SortedSet subSet(Object obj, Object obj2) {
        return new zzgyt(((SortedSet) this.zza).subSet(obj, obj2), this.zzb);
    }

    @Override // java.util.SortedSet
    public final SortedSet tailSet(Object obj) {
        return new zzgyt(((SortedSet) this.zza).tailSet(obj), this.zzb);
    }
}
