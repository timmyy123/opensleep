package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzgws {
    Map zza;

    public final Map zza() {
        Map map = this.zza;
        if (map != null) {
            return map;
        }
        zzgvt zzgvtVar = new zzgvt();
        this.zza = zzgvtVar;
        return zzgvtVar;
    }
}
