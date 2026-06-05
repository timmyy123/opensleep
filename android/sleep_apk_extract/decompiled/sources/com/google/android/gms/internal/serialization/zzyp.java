package com.google.android.gms.internal.serialization;

import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class zzyp {
    static final zzyp zza = new zzyp(true);
    private final Map zzd = Collections.EMPTY_MAP;

    public zzyp(boolean z) {
    }

    public final zzze zza(zzaaq zzaaqVar, int i) {
        return (zzze) this.zzd.get(new zzyo(zzaaqVar, i));
    }
}
