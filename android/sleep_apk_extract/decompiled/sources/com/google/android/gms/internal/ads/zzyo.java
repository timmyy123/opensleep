package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
final class zzyo {
    public final int zza;
    public final boolean zzb;

    public zzyo(int i, boolean z) {
        this.zza = i;
        this.zzb = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzyo.class == obj.getClass()) {
            zzyo zzyoVar = (zzyo) obj;
            if (this.zza == zzyoVar.zza && this.zzb == zzyoVar.zzb) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.zza * 31) + (this.zzb ? 1 : 0);
    }
}
