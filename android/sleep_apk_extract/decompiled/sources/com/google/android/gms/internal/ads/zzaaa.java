package com.google.android.gms.internal.ads;

import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class zzaaa implements Comparator {
    static final /* synthetic */ zzaaa zza = new zzaaa();

    private /* synthetic */ zzaaa() {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        return ((zzaao) ((List) obj).get(0)).compareTo((zzaao) ((List) obj2).get(0));
    }
}
