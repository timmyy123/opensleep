package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzzs {
    public final long zza;
    public final long zzb;

    public zzzs(long j, long j2) {
        this.zza = j;
        this.zzb = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzzs)) {
            return false;
        }
        zzzs zzzsVar = (zzzs) obj;
        return this.zza == zzzsVar.zza && this.zzb == zzzsVar.zzb;
    }

    public final int hashCode() {
        return (((int) this.zza) * 31) + ((int) this.zzb);
    }
}
