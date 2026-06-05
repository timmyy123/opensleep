package com.google.android.gms.internal.serialization;

import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes3.dex */
final class zzabw extends zzabx {
    public zzabw(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.gms.internal.serialization.zzabx
    public final void zza(Object obj, long j, byte b) {
        if (zzaby.zzb) {
            zzaby.zzG(obj, j, b);
        } else {
            zzaby.zzH(obj, j, b);
        }
    }

    @Override // com.google.android.gms.internal.serialization.zzabx
    public final boolean zzb(Object obj, long j) {
        return zzaby.zzb ? zzaby.zzx(obj, j) : zzaby.zzy(obj, j);
    }

    /* JADX WARN: Failed to inline method: com.google.android.gms.internal.home.zzaby.zzA(java.lang.Object, long, boolean):void */
    /* JADX WARN: Failed to inline method: com.google.android.gms.internal.home.zzaby.zzz(java.lang.Object, long, boolean):void */
    /* JADX WARN: Unknown register number '(r4v0 'z' boolean)' in method call: com.google.android.gms.internal.home.zzaby.zzA(java.lang.Object, long, boolean):void */
    /* JADX WARN: Unknown register number '(r4v0 'z' boolean)' in method call: com.google.android.gms.internal.home.zzaby.zzz(java.lang.Object, long, boolean):void */
    @Override // com.google.android.gms.internal.serialization.zzabx
    public final void zzc(Object obj, long j, boolean z) {
        if (zzaby.zzb) {
            zzaby.zzz(obj, j, z);
        } else {
            zzaby.zzA(obj, j, z);
        }
    }

    @Override // com.google.android.gms.internal.serialization.zzabx
    public final float zzd(Object obj, long j) {
        return Float.intBitsToFloat(this.zza.getInt(obj, j));
    }

    @Override // com.google.android.gms.internal.serialization.zzabx
    public final void zze(Object obj, long j, float f) {
        this.zza.putInt(obj, j, Float.floatToIntBits(f));
    }

    @Override // com.google.android.gms.internal.serialization.zzabx
    public final double zzf(Object obj, long j) {
        return Double.longBitsToDouble(this.zza.getLong(obj, j));
    }

    @Override // com.google.android.gms.internal.serialization.zzabx
    public final void zzg(Object obj, long j, double d) {
        this.zza.putLong(obj, j, Double.doubleToLongBits(d));
    }
}
