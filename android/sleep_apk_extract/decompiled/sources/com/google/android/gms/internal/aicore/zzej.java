package com.google.android.gms.internal.aicore;

/* JADX INFO: loaded from: classes3.dex */
final class zzej {
    private final Object zza;
    private final int zzb;

    public zzej(Object obj, int i) {
        this.zza = obj;
        this.zzb = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzej)) {
            return false;
        }
        zzej zzejVar = (zzej) obj;
        return this.zza == zzejVar.zza && this.zzb == zzejVar.zzb;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.zza) * 65535) + this.zzb;
    }
}
