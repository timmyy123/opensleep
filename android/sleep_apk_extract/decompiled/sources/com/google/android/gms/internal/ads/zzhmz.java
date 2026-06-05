package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzhmz implements Iterable {
    final /* synthetic */ List zza;
    final /* synthetic */ List zzb;

    public zzhmz(zzhnc zzhncVar, List list, List list2) {
        this.zza = list;
        this.zzb = list2;
        Objects.requireNonNull(zzhncVar);
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new zzhnb(this.zza.iterator(), this.zzb.iterator(), null);
    }
}
