package com.google.android.gms.internal.measurement;

import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes3.dex */
final class zzage extends zzagf {
    public zzage(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.gms.internal.measurement.zzagf
    public final void zza(Object obj, long j, byte b) {
        if (zzagg.zzb) {
            zzagg.zzC(obj, j, b);
        } else {
            zzagg.zzD(obj, j, b);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzagf
    public final boolean zzb(Object obj, long j) {
        return zzagg.zzb ? zzagg.zzt(obj, j) : zzagg.zzu(obj, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzagf
    public final void zzc(Object obj, long j, boolean z) {
        if (zzagg.zzb) {
            zzagg.zzC(obj, j, z ? (byte) 1 : (byte) 0);
        } else {
            zzagg.zzD(obj, j, z ? (byte) 1 : (byte) 0);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzagf
    public final float zzd(Object obj, long j) {
        return Float.intBitsToFloat(this.zza.getInt(obj, j));
    }

    @Override // com.google.android.gms.internal.measurement.zzagf
    public final void zze(Object obj, long j, float f) {
        this.zza.putInt(obj, j, Float.floatToIntBits(f));
    }

    @Override // com.google.android.gms.internal.measurement.zzagf
    public final double zzf(Object obj, long j) {
        return Double.longBitsToDouble(this.zza.getLong(obj, j));
    }

    @Override // com.google.android.gms.internal.measurement.zzagf
    public final void zzg(Object obj, long j, double d) {
        this.zza.putLong(obj, j, Double.doubleToLongBits(d));
    }
}
