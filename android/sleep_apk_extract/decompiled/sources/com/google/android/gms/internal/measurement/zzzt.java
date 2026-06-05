package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzzt {
    private static final zzzp zza = new zzzr();
    private static final zzzo zzb = new zzzs();

    public static zzzm zza(Set set) {
        zzzm zzzmVar = new zzzm(zza, null);
        zzzmVar.zza(zzb);
        Iterator it = set.iterator();
        while (it.hasNext()) {
            zzzmVar.zzb((zzyl) it.next());
        }
        return zzzmVar;
    }
}
