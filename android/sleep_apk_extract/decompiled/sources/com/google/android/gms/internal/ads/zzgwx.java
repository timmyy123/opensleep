package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class zzgwx extends zzgws {
    public final zzgwx zzb(Object obj, Object... objArr) {
        List listAsList = Arrays.asList(objArr);
        if (obj == null) {
            Iterator it = listAsList.iterator();
            StringBuilder sb = new StringBuilder("[");
            boolean z = true;
            while (it.hasNext()) {
                if (!z) {
                    sb.append(", ");
                }
                sb.append(it.next());
                z = false;
            }
            sb.append(']');
            throw new NullPointerException("null key in entry: null=".concat(sb.toString()));
        }
        Iterator it2 = listAsList.iterator();
        if (it2.hasNext()) {
            zzgwh zzgwhVarZzt = (zzgwh) zza().get(obj);
            if (zzgwhVarZzt == null) {
                zzgwhVarZzt = zzgww.zzt(listAsList instanceof Set ? Math.max(4, ((Set) listAsList).size()) : 4);
                zza().put(obj, zzgwhVarZzt);
            }
            while (it2.hasNext()) {
                Object next = it2.next();
                zzgvi.zza(obj, next);
                zzgwhVarZzt.zzd(next);
            }
        }
        return this;
    }

    public final zzgwz zzc() {
        Map map = this.zza;
        if (map == null) {
            return zzgwa.zza;
        }
        Set<Map.Entry> setEntrySet = map.entrySet();
        if (setEntrySet.isEmpty()) {
            return zzgwa.zza;
        }
        zzgwo zzgwoVar = new zzgwo(setEntrySet.size());
        int size = 0;
        for (Map.Entry entry : setEntrySet) {
            Object key = entry.getKey();
            zzgww zzgwwVarZzp = zzgww.zzp(((zzgwv) entry.getValue()).zzh());
            if (!zzgwwVarZzp.isEmpty()) {
                zzgwoVar.zza(key, zzgwwVarZzp);
                size += zzgwwVarZzp.size();
            }
        }
        return new zzgwz(zzgwoVar.zzc(), size, null);
    }
}
