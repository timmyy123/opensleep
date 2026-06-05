package com.google.android.gms.internal.serialization;

import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzgk {
    private static final zzgg zza = new zzgi();
    private static final zzgf zzb = new zzgj();

    public static zzgd zza(Set set) {
        zzgd zzgdVar = new zzgd(zza, null);
        zzgdVar.zza(zzb);
        Iterator it = set.iterator();
        while (it.hasNext()) {
            zzgdVar.zzb((zzfc) it.next());
        }
        return zzgdVar;
    }
}
