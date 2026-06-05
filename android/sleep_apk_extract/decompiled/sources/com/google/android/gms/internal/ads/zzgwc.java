package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzgwc extends zzgwd implements Map {
    @Override // java.util.Map
    public final void clear() {
        zza().clear();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return zza().containsKey(obj);
    }

    @Override // java.util.Map
    public abstract Set entrySet();

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        return zza().put(obj, obj2);
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        zza().putAll(map);
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        return zza().remove(obj);
    }

    @Override // java.util.Map
    public int size() {
        return zza().size();
    }

    @Override // java.util.Map
    public final Collection values() {
        return zza().values();
    }

    public abstract Map zza();

    public final boolean zzc(Object obj) {
        zzgxo zzgxoVar = new zzgxo(entrySet().iterator());
        if (obj == null) {
            while (zzgxoVar.hasNext()) {
                if (zzgxoVar.next() == null) {
                    return true;
                }
            }
            return false;
        }
        while (zzgxoVar.hasNext()) {
            if (obj.equals(zzgxoVar.next())) {
                return true;
            }
        }
        return false;
    }

    public final boolean zzd(Object obj) {
        return zzgxt.zzb(this, obj);
    }

    public final int zze() {
        return zzgyw.zzc(entrySet());
    }
}
