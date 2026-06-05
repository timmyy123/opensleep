package com.google.android.gms.internal.ads;

import libcore.io.Memory;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes3.dex */
final class zzigx extends zzigz {
    public zzigx(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.gms.internal.ads.zzigz
    public final void zza(Object obj, long j, byte b) {
        if (zziha.zzb) {
            zziha.zzE(obj, j, b);
        } else {
            zziha.zzF(obj, j, b);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzigz
    public final boolean zzb(Object obj, long j) {
        return zziha.zzb ? zziha.zzv(obj, j) : zziha.zzw(obj, j);
    }

    /* JADX WARN: Failed to inline method: com.google.android.gms.internal.ads.zziha.zzx(java.lang.Object, long, boolean):void */
    /* JADX WARN: Failed to inline method: com.google.android.gms.internal.ads.zziha.zzy(java.lang.Object, long, boolean):void */
    /* JADX WARN: Unknown register number '(r4v0 'z' boolean)' in method call: com.google.android.gms.internal.ads.zziha.zzx(java.lang.Object, long, boolean):void */
    /* JADX WARN: Unknown register number '(r4v0 'z' boolean)' in method call: com.google.android.gms.internal.ads.zziha.zzy(java.lang.Object, long, boolean):void */
    @Override // com.google.android.gms.internal.ads.zzigz
    public final void zzc(Object obj, long j, boolean z) {
        if (zziha.zzb) {
            zziha.zzx(obj, j, z);
        } else {
            zziha.zzy(obj, j, z);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzigz
    public final float zzd(Object obj, long j) {
        return Float.intBitsToFloat(this.zza.getInt(obj, j));
    }

    @Override // com.google.android.gms.internal.ads.zzigz
    public final void zze(Object obj, long j, float f) {
        this.zza.putInt(obj, j, Float.floatToIntBits(f));
    }

    @Override // com.google.android.gms.internal.ads.zzigz
    public final double zzf(Object obj, long j) {
        return Double.longBitsToDouble(this.zza.getLong(obj, j));
    }

    @Override // com.google.android.gms.internal.ads.zzigz
    public final void zzg(Object obj, long j, double d) {
        this.zza.putLong(obj, j, Double.doubleToLongBits(d));
    }

    @Override // com.google.android.gms.internal.ads.zzigz
    public final byte zzh(long j) {
        return Memory.peekByte((int) j);
    }
}
