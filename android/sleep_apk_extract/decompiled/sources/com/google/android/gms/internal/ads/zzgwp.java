package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzgwp<K, V> implements Map<K, V>, Serializable {
    private transient zzgww zza;
    private transient zzgww zzb;
    private transient zzgwi zzc;

    public static zzgwp zza() {
        return zzgym.zza;
    }

    public static zzgwp zzb(Object obj, Object obj2) {
        zzgvi.zza("dialog_not_shown_reason", obj2);
        return zzgym.zzk(1, new Object[]{"dialog_not_shown_reason", obj2}, null);
    }

    public static zzgwp zzc(Map map) {
        if ((map instanceof zzgwp) && !(map instanceof SortedMap)) {
            zzgwp zzgwpVar = (zzgwp) map;
            zzgwpVar.zzj();
            return zzgwpVar;
        }
        Set<Map.Entry<K, V>> setEntrySet = map.entrySet();
        zzgwo zzgwoVar = new zzgwo(setEntrySet != null ? setEntrySet.size() : 4);
        zzgwoVar.zzb(setEntrySet);
        return zzgwoVar.zzc();
    }

    @Override // java.util.Map
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        return zzgxt.zzb(this, obj);
    }

    @Override // java.util.Map
    public abstract Object get(Object obj);

    @Override // java.util.Map
    public final Object getOrDefault(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    @Override // java.util.Map
    public final int hashCode() {
        return zzgyw.zzc(entrySet());
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    @Deprecated
    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final Object remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final String toString() {
        int size = size();
        zzgvi.zzb(size, "size");
        StringBuilder sb = new StringBuilder((int) Math.min(((long) size) * 8, 1073741824L));
        sb.append('{');
        boolean z = true;
        for (Map.Entry<K, V> entry : entrySet()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(entry.getKey());
            sb.append('=');
            sb.append(entry.getValue());
            z = false;
        }
        sb.append('}');
        return sb.toString();
    }

    @Override // java.util.Map
    /* JADX INFO: renamed from: zzd, reason: merged with bridge method [inline-methods] */
    public final zzgww entrySet() {
        zzgww zzgwwVar = this.zza;
        if (zzgwwVar != null) {
            return zzgwwVar;
        }
        zzgww zzgwwVarZze = zze();
        this.zza = zzgwwVarZze;
        return zzgwwVarZze;
    }

    public abstract zzgww zze();

    @Override // java.util.Map
    /* JADX INFO: renamed from: zzf, reason: merged with bridge method [inline-methods] */
    public final zzgww keySet() {
        zzgww zzgwwVar = this.zzb;
        if (zzgwwVar != null) {
            return zzgwwVar;
        }
        zzgww zzgwwVarZzg = zzg();
        this.zzb = zzgwwVarZzg;
        return zzgwwVarZzg;
    }

    public abstract zzgww zzg();

    @Override // java.util.Map
    /* JADX INFO: renamed from: zzh, reason: merged with bridge method [inline-methods] */
    public final zzgwi values() {
        zzgwi zzgwiVar = this.zzc;
        if (zzgwiVar != null) {
            return zzgwiVar;
        }
        zzgwi zzgwiVarZzi = zzi();
        this.zzc = zzgwiVarZzi;
        return zzgwiVarZzi;
    }

    public abstract zzgwi zzi();

    public abstract boolean zzj();
}
