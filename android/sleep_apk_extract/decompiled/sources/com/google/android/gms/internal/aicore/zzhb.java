package com.google.android.gms.internal.aicore;

import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes3.dex */
abstract class zzhb {
    final Unsafe zza;

    public zzhb(Unsafe unsafe) {
        this.zza = unsafe;
    }

    public abstract boolean zza(Object obj, long j);

    public abstract void zzb(Object obj, long j, boolean z);

    public abstract float zzc(Object obj, long j);

    public abstract void zzd(Object obj, long j, float f);

    public abstract double zze(Object obj, long j);

    public abstract void zzf(Object obj, long j, double d);
}
