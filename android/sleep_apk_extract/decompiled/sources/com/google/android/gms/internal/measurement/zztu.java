package com.google.android.gms.internal.measurement;

import com.google.common.base.Preconditions;
import java.util.HashMap;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public final class zztu {
    private Executor zza;
    private zzru zzb;
    private final zzvc zzd = zzvc.zza;
    private final HashMap zzc = new HashMap();

    public final zztu zza(Executor executor) {
        this.zza = executor;
        return this;
    }

    public final zztu zzb(zzru zzruVar) {
        this.zzb = zzruVar;
        return this;
    }

    public final zztu zzc(zzuw zzuwVar) {
        Preconditions.checkNotNull(zzti.ALLOWED);
        HashMap map = this.zzc;
        Preconditions.checkArgument(!map.containsKey("singleproc"), "There is already a factory registered for the ID %s", "singleproc");
        map.put("singleproc", zzuwVar);
        return this;
    }

    public final zztt zzd() {
        return new zztt(this.zza, this.zzb, this.zzd, this.zzc, null);
    }
}
