package com.google.android.gms.internal.consent_sdk;

import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes3.dex */
final class zzst extends zzsv {
    public zzst(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzsv
    public final double zza(Object obj, long j) {
        return Double.longBitsToDouble(this.zza.getLong(obj, j));
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzsv
    public final float zzb(Object obj, long j) {
        return Float.intBitsToFloat(this.zza.getInt(obj, j));
    }

    /* JADX WARN: Failed to inline method: com.google.android.gms.internal.consent_sdk.zzsw.zzi(java.lang.Object, long, boolean):void */
    /* JADX WARN: Failed to inline method: com.google.android.gms.internal.consent_sdk.zzsw.zzj(java.lang.Object, long, boolean):void */
    /* JADX WARN: Unknown register number '(r4v0 'z' boolean)' in method call: com.google.android.gms.internal.consent_sdk.zzsw.zzi(java.lang.Object, long, boolean):void */
    /* JADX WARN: Unknown register number '(r4v0 'z' boolean)' in method call: com.google.android.gms.internal.consent_sdk.zzsw.zzj(java.lang.Object, long, boolean):void */
    @Override // com.google.android.gms.internal.consent_sdk.zzsv
    public final void zzc(Object obj, long j, boolean z) {
        if (zzsw.zzb) {
            zzsw.zzi(obj, j, z);
        } else {
            zzsw.zzj(obj, j, z);
        }
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzsv
    public final void zzd(Object obj, long j, byte b) {
        if (zzsw.zzb) {
            zzsw.zzD(obj, j, b);
        } else {
            zzsw.zzE(obj, j, b);
        }
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzsv
    public final void zze(Object obj, long j, double d) {
        this.zza.putLong(obj, j, Double.doubleToLongBits(d));
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzsv
    public final void zzf(Object obj, long j, float f) {
        this.zza.putInt(obj, j, Float.floatToIntBits(f));
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzsv
    public final boolean zzg(Object obj, long j) {
        return zzsw.zzb ? zzsw.zzt(obj, j) : zzsw.zzu(obj, j);
    }
}
