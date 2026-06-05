package com.google.android.gms.internal.serialization;

import com.google.home.Home$$ExternalSyntheticBUOutline0;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class zzaak<K, V> extends LinkedHashMap<K, V> {
    private static final zzaak zzb;
    private boolean zza;

    static {
        zzaak zzaakVar = new zzaak();
        zzb = zzaakVar;
        zzaakVar.zza = false;
    }

    private zzaak() {
        this.zza = true;
    }

    public static zzaak zza() {
        return zzb;
    }

    private static int zzf(Object obj) {
        if (!(obj instanceof byte[])) {
            if (!(obj instanceof zzzk)) {
                return obj.hashCode();
            }
            Home$$ExternalSyntheticBUOutline0.m$1();
            return 0;
        }
        byte[] bArr = (byte[]) obj;
        int length = bArr.length;
        int iZzc = zzzt.zzc(length, bArr, 0, length);
        if (iZzc == 0) {
            return 1;
        }
        return iZzc;
    }

    private final void zzg() {
        if (this.zza) {
            return;
        }
        Home$$ExternalSyntheticBUOutline0.m$1();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void clear() {
        zzg();
        super.clear();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        return isEmpty() ? Collections.EMPTY_SET : super.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (this == map) {
            return true;
        }
        if (size() != map.size()) {
            return false;
        }
        for (Map.Entry<K, V> entry : entrySet()) {
            if (!map.containsKey(entry.getKey())) {
                return false;
            }
            V value = entry.getValue();
            Object obj2 = map.get(entry.getKey());
            if (!(((value instanceof byte[]) && (obj2 instanceof byte[])) ? Arrays.equals((byte[]) value, (byte[]) obj2) : value.equals(obj2))) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int iZzf = 0;
        for (Map.Entry<K, V> entry : entrySet()) {
            iZzf += zzf(entry.getValue()) ^ zzf(entry.getKey());
        }
        return iZzf;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        zzg();
        byte[] bArr = zzzt.zzb;
        obj.getClass();
        obj2.getClass();
        return super.put(obj, obj2);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void putAll(Map map) {
        zzg();
        for (K k : map.keySet()) {
            byte[] bArr = zzzt.zzb;
            k.getClass();
            map.get(k).getClass();
        }
        super.putAll(map);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        zzg();
        return super.remove(obj);
    }

    public final void zzb(zzaak zzaakVar) {
        zzg();
        if (zzaakVar.isEmpty()) {
            return;
        }
        putAll(zzaakVar);
    }

    public final zzaak zzc() {
        return isEmpty() ? new zzaak() : new zzaak(this);
    }

    public final void zzd() {
        this.zza = false;
    }

    public final boolean zze() {
        return this.zza;
    }

    private zzaak(Map map) {
        super(map);
        this.zza = true;
    }
}
