package com.google.android.gms.internal.ads;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes3.dex */
final class zzgxw extends zzgya {
    final /* synthetic */ Comparator zza;

    public zzgxw(Comparator comparator) {
        this.zza = comparator;
    }

    @Override // com.google.android.gms.internal.ads.zzgya
    public final Map zza() {
        return new TreeMap(this.zza);
    }
}
