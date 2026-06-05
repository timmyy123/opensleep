package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class zzzy implements Comparator {
    static final /* synthetic */ zzzy zza = new zzzy();

    private /* synthetic */ zzzy() {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        return ((zzzx) Collections.max((List) obj)).compareTo((zzzx) Collections.max((List) obj2));
    }
}
