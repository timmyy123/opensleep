package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
abstract class zzgvc extends zzgvf implements Serializable {
    private final transient Map zza;
    private transient int zzb;

    public zzgvc(Map map) {
        zzgtj.zza(map.isEmpty());
        this.zza = map;
    }

    public abstract Collection zza(Collection collection);

    public abstract Collection zzb(Object obj, Collection collection);

    public abstract Collection zzc();

    @Override // com.google.android.gms.internal.ads.zzgxu
    public final int zzd() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzgxu
    public final boolean zze(Object obj, Object obj2) {
        Map map = this.zza;
        Collection collection = (Collection) map.get(obj);
        if (collection != null) {
            if (!collection.add(obj2)) {
                return false;
            }
            this.zzb++;
            return true;
        }
        Collection collectionZzc = zzc();
        if (!collectionZzc.add(obj2)) {
            Utf8$$ExternalSyntheticBUOutline0.m$1((Object) "New Collection violated the Collection spec");
            return false;
        }
        this.zzb++;
        map.put(obj, collectionZzc);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzgxu
    public final void zzf() {
        Map map = this.zza;
        Iterator it = map.values().iterator();
        while (it.hasNext()) {
            ((Collection) it.next()).clear();
        }
        map.clear();
        this.zzb = 0;
    }

    public final List zzg(Object obj, List list, zzguz zzguzVar) {
        return list instanceof RandomAccess ? new zzguv(this, obj, list, zzguzVar) : new zzgvb(this, obj, list, zzguzVar);
    }

    public final Set zzi() {
        Map map = this.zza;
        return map instanceof NavigableMap ? new zzguu(this, (NavigableMap) map) : map instanceof SortedMap ? new zzgux(this, (SortedMap) map) : new zzgus(this, map);
    }

    @Override // com.google.android.gms.internal.ads.zzgvf
    public final Collection zzj() {
        return new zzgve(this);
    }

    @Override // com.google.android.gms.internal.ads.zzgvf
    public final Iterator zzk() {
        return new zzgum(this);
    }

    public final Map zzm() {
        Map map = this.zza;
        return map instanceof NavigableMap ? new zzgut(this, (NavigableMap) map) : map instanceof SortedMap ? new zzguw(this, (SortedMap) map) : new zzgup(this, map);
    }

    public final /* synthetic */ void zzn(Object obj) {
        Object objRemove;
        try {
            objRemove = this.zza.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            objRemove = null;
        }
        Collection collection = (Collection) objRemove;
        if (collection != null) {
            int size = collection.size();
            collection.clear();
            this.zzb -= size;
        }
    }

    public final /* synthetic */ Map zzo() {
        return this.zza;
    }

    public final /* synthetic */ int zzp() {
        return this.zzb;
    }

    public final /* synthetic */ void zzq(int i) {
        this.zzb = i;
    }
}
