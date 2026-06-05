package com.google.android.gms.internal.clearcut;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
final class zzda extends zzcy {
    private static final Class<?> zzlv = Collections.unmodifiableList(Collections.EMPTY_LIST).getClass();

    private zzda() {
        super();
    }

    private static <E> List<E> zzb(Object obj, long j) {
        return (List) zzfd.zzo(obj, j);
    }

    @Override // com.google.android.gms.internal.clearcut.zzcy
    public final <E> void zza(Object obj, Object obj2, long j) {
        List list;
        List list2;
        List listZzb = zzb(obj2, j);
        int size = listZzb.size();
        List listZzb2 = zzb(obj, j);
        if (listZzb2.isEmpty()) {
            List zzcwVar = listZzb2 instanceof zzcx ? new zzcw(size) : new ArrayList(size);
            zzfd.zza(obj, j, zzcwVar);
            list2 = zzcwVar;
        } else {
            if (zzlv.isAssignableFrom(listZzb2.getClass())) {
                ArrayList arrayList = new ArrayList(listZzb2.size() + size);
                arrayList.addAll(listZzb2);
                list = arrayList;
            } else {
                boolean z = listZzb2 instanceof zzfa;
                list2 = listZzb2;
                if (z) {
                    zzcw zzcwVar2 = new zzcw(listZzb2.size() + size);
                    zzcwVar2.addAll((zzfa) listZzb2);
                    list = zzcwVar2;
                }
            }
            zzfd.zza(obj, j, list);
            list2 = list;
        }
        int size2 = list2.size();
        int size3 = listZzb.size();
        if (size2 > 0 && size3 > 0) {
            list2.addAll(listZzb);
        }
        if (size2 > 0) {
            listZzb = list2;
        }
        zzfd.zza(obj, j, listZzb);
    }

    @Override // com.google.android.gms.internal.clearcut.zzcy
    public final void zza(Object obj, long j) {
        Object objUnmodifiableList;
        List list = (List) zzfd.zzo(obj, j);
        if (list instanceof zzcx) {
            objUnmodifiableList = ((zzcx) list).zzbu();
        } else if (zzlv.isAssignableFrom(list.getClass())) {
            return;
        } else {
            objUnmodifiableList = Collections.unmodifiableList(list);
        }
        zzfd.zza(obj, j, objUnmodifiableList);
    }
}
