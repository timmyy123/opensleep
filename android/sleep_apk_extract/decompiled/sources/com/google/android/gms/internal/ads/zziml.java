package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zziml extends AbstractList {
    private static final zzimm zzc = zzimm.zzb(zziml.class);
    final List zza;
    final Iterator zzb;

    public zziml(List list, Iterator it) {
        this.zza = list;
        this.zzb = it;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        List list = this.zza;
        if (list.size() > i) {
            return list.get(i);
        }
        Iterator it = this.zzb;
        if (it.hasNext()) {
            list.add(it.next());
            return get(i);
        }
        Types$$ExternalSyntheticBUOutline0.m();
        return null;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return new zzimk(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        zzimm zzimmVar = zzc;
        zzimmVar.zza("potentially expensive size() call");
        zzimmVar.zza("blowup running");
        while (true) {
            Iterator it = this.zzb;
            boolean zHasNext = it.hasNext();
            List list = this.zza;
            if (!zHasNext) {
                return list.size();
            }
            list.add(it.next());
        }
    }
}
