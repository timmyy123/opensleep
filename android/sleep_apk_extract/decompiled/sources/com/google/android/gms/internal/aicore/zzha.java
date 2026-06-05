package com.google.android.gms.internal.aicore;

import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes3.dex */
final class zzha extends zzhb {
    public zzha(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.gms.internal.aicore.zzhb
    public final boolean zza(Object obj, long j) {
        return zzhc.zza ? zzhc.zzr(obj, j) : zzhc.zzs(obj, j);
    }

    @Override // com.google.android.gms.internal.aicore.zzhb
    public final void zzb(Object obj, long j, boolean z) {
        if (zzhc.zza) {
            zzhc.zzt(obj, j, z);
        } else {
            zzhc.zzu(obj, j, z);
        }
    }

    @Override // com.google.android.gms.internal.aicore.zzhb
    public final float zzc(Object obj, long j) {
        return Float.intBitsToFloat(this.zza.getInt(obj, j));
    }

    @Override // com.google.android.gms.internal.aicore.zzhb
    public final void zzd(Object obj, long j, float f) {
        this.zza.putInt(obj, j, Float.floatToIntBits(f));
    }

    @Override // com.google.android.gms.internal.aicore.zzhb
    public final double zze(Object obj, long j) {
        return Double.longBitsToDouble(this.zza.getLong(obj, j));
    }

    @Override // com.google.android.gms.internal.aicore.zzhb
    public final void zzf(Object obj, long j, double d) {
        this.zza.putLong(obj, j, Double.doubleToLongBits(d));
    }
}
