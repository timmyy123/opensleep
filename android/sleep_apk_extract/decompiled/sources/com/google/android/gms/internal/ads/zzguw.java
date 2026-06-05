package com.google.android.gms.internal.ads;

import java.util.Comparator;
import java.util.Objects;
import java.util.SortedMap;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes3.dex */
class zzguw extends zzgup implements SortedMap {
    SortedSet zzd;
    final /* synthetic */ zzgvc zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzguw(zzgvc zzgvcVar, SortedMap sortedMap) {
        super(zzgvcVar, sortedMap);
        Objects.requireNonNull(zzgvcVar);
        this.zze = zzgvcVar;
    }

    @Override // java.util.SortedMap
    public final Comparator comparator() {
        return zzg().comparator();
    }

    @Override // java.util.SortedMap
    public final Object firstKey() {
        return zzg().firstKey();
    }

    public SortedMap headMap(Object obj) {
        return new zzguw(this.zze, zzg().headMap(obj));
    }

    @Override // java.util.SortedMap
    public final Object lastKey() {
        return zzg().lastKey();
    }

    public SortedMap subMap(Object obj, Object obj2) {
        return new zzguw(this.zze, zzg().subMap(obj, obj2));
    }

    public SortedMap tailMap(Object obj) {
        return new zzguw(this.zze, zzg().tailMap(obj));
    }

    public SortedSet zze() {
        return new zzgux(this.zze, zzg());
    }

    @Override // com.google.android.gms.internal.ads.zzgup, java.util.AbstractMap, java.util.Map
    /* JADX INFO: renamed from: zzf, reason: merged with bridge method [inline-methods] */
    public SortedSet keySet() {
        SortedSet sortedSet = this.zzd;
        if (sortedSet != null) {
            return sortedSet;
        }
        SortedSet sortedSetZze = zze();
        this.zzd = sortedSetZze;
        return sortedSetZze;
    }

    public SortedMap zzg() {
        return (SortedMap) ((zzgup) this).zza;
    }
}
