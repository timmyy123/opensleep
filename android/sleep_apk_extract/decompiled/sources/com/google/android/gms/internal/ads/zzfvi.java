package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfvi {
    private static final zzfvi zza = new zzfvi();
    private final ArrayList zzb = new ArrayList();
    private final ArrayList zzc = new ArrayList();

    private zzfvi() {
    }

    public static zzfvi zza() {
        return zza;
    }

    public final void zzb(zzfuo zzfuoVar) {
        this.zzb.add(zzfuoVar);
    }

    public final void zzc(zzfuo zzfuoVar) {
        ArrayList arrayList = this.zzc;
        boolean zZzg = zzg();
        arrayList.add(zzfuoVar);
        if (zZzg) {
            return;
        }
        zzfvq.zza().zzc();
    }

    public final void zzd(zzfuo zzfuoVar) {
        ArrayList arrayList = this.zzb;
        boolean zZzg = zzg();
        arrayList.remove(zzfuoVar);
        this.zzc.remove(zzfuoVar);
        if (!zZzg || zzg()) {
            return;
        }
        zzfvq.zza().zze();
    }

    public final Collection zze() {
        return Collections.unmodifiableCollection(this.zzb);
    }

    public final Collection zzf() {
        return Collections.unmodifiableCollection(this.zzc);
    }

    public final boolean zzg() {
        return this.zzc.size() > 0;
    }
}
