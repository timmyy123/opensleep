package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
final class zzimk implements Iterator {
    int zza = 0;
    final /* synthetic */ zziml zzb;

    public zzimk(zziml zzimlVar) {
        this.zzb = zzimlVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i = this.zza;
        zziml zzimlVar = this.zzb;
        return i < zzimlVar.zza.size() || zzimlVar.zzb.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i = this.zza;
        zziml zzimlVar = this.zzb;
        List list = zzimlVar.zza;
        if (i >= list.size()) {
            list.add(zzimlVar.zzb.next());
            return next();
        }
        int i2 = this.zza;
        this.zza = i2 + 1;
        return list.get(i2);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
