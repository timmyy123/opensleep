package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
final class zzidn {
    private final Object zza;
    private final int zzb;

    public zzidn(Object obj, int i) {
        this.zza = obj;
        this.zzb = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzidn)) {
            return false;
        }
        zzidn zzidnVar = (zzidn) obj;
        return this.zza == zzidnVar.zza && this.zzb == zzidnVar.zzb;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.zza) * 65535) + this.zzb;
    }
}
