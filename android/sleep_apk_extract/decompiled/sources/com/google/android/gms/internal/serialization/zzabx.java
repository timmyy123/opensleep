package com.google.android.gms.internal.serialization;

import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes3.dex */
abstract class zzabx {
    final Unsafe zza;

    public zzabx(Unsafe unsafe) {
        this.zza = unsafe;
    }

    public abstract void zza(Object obj, long j, byte b);

    public abstract boolean zzb(Object obj, long j);

    public abstract void zzc(Object obj, long j, boolean z);

    public abstract float zzd(Object obj, long j);

    public abstract void zze(Object obj, long j, float f);

    public abstract double zzf(Object obj, long j);

    public abstract void zzg(Object obj, long j, double d);
}
