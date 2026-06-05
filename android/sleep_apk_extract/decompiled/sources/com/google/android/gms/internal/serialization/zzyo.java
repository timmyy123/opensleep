package com.google.android.gms.internal.serialization;

/* JADX INFO: loaded from: classes3.dex */
final class zzyo {
    private final Object zza;
    private final int zzb;

    public zzyo(Object obj, int i) {
        this.zza = obj;
        this.zzb = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzyo)) {
            return false;
        }
        zzyo zzyoVar = (zzyo) obj;
        return this.zza == zzyoVar.zza && this.zzb == zzyoVar.zzb;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.zza) * 65535) + this.zzb;
    }
}
