package com.google.android.gms.internal.vision;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
final class zzjw extends zzju {
    private static final Class<?> zza = Collections.unmodifiableList(Collections.EMPTY_LIST).getClass();

    private zzjw() {
        super();
    }

    private static <L> List<L> zza(Object obj, long j, int i) {
        List<L> listZzc = zzc(obj, j);
        if (listZzc.isEmpty()) {
            List<L> zzjsVar = listZzc instanceof zzjv ? new zzjs(i) : ((listZzc instanceof zzkw) && (listZzc instanceof zzjl)) ? ((zzjl) listZzc).zza(i) : new ArrayList<>(i);
            zzma.zza(obj, j, zzjsVar);
            return zzjsVar;
        }
        if (zza.isAssignableFrom(listZzc.getClass())) {
            ArrayList arrayList = new ArrayList(listZzc.size() + i);
            arrayList.addAll(listZzc);
            zzma.zza(obj, j, arrayList);
            return arrayList;
        }
        if (listZzc instanceof zzlz) {
            zzjs zzjsVar2 = new zzjs(listZzc.size() + i);
            zzjsVar2.addAll((zzlz) listZzc);
            zzma.zza(obj, j, zzjsVar2);
            return zzjsVar2;
        }
        if ((listZzc instanceof zzkw) && (listZzc instanceof zzjl)) {
            zzjl zzjlVar = (zzjl) listZzc;
            if (!zzjlVar.zza()) {
                zzjl zzjlVarZza = zzjlVar.zza(listZzc.size() + i);
                zzma.zza(obj, j, zzjlVarZza);
                return zzjlVarZza;
            }
        }
        return listZzc;
    }

    private static <E> List<E> zzc(Object obj, long j) {
        return (List) zzma.zzf(obj, j);
    }

    @Override // com.google.android.gms.internal.vision.zzju
    public final void zzb(Object obj, long j) {
        Object objUnmodifiableList;
        List list = (List) zzma.zzf(obj, j);
        if (list instanceof zzjv) {
            objUnmodifiableList = ((zzjv) list).zze();
        } else {
            if (zza.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof zzkw) && (list instanceof zzjl)) {
                zzjl zzjlVar = (zzjl) list;
                if (zzjlVar.zza()) {
                    zzjlVar.zzb();
                    return;
                }
                return;
            }
            objUnmodifiableList = Collections.unmodifiableList(list);
        }
        zzma.zza(obj, j, objUnmodifiableList);
    }

    @Override // com.google.android.gms.internal.vision.zzju
    public final <E> void zza(Object obj, Object obj2, long j) {
        List listZzc = zzc(obj2, j);
        List listZza = zza(obj, j, listZzc.size());
        int size = listZza.size();
        int size2 = listZzc.size();
        if (size > 0 && size2 > 0) {
            listZza.addAll(listZzc);
        }
        if (size > 0) {
            listZzc = listZza;
        }
        zzma.zza(obj, j, listZzc);
    }
}
