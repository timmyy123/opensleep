package com.google.android.gms.internal.ads;

import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzgth implements Serializable {
    public static zzgth zzc() {
        return zzgsq.zza;
    }

    public static zzgth zzd(Object obj) {
        return obj == null ? zzgsq.zza : new zzgto(obj);
    }

    public abstract Object zza(Object obj);

    public abstract zzgth zzb(zzgta zzgtaVar);
}
