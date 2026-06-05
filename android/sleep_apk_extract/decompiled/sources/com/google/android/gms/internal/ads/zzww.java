package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
final class zzww {
    private final Map zza = new HashMap();
    private final Map zzb = new HashMap();
    private zzho zzc;

    public zzww(zzage zzageVar, zzanj zzanjVar) {
    }

    public final void zza(zzho zzhoVar) {
        if (zzhoVar != this.zzc) {
            this.zzc = zzhoVar;
            this.zza.clear();
            this.zzb.clear();
        }
    }
}
