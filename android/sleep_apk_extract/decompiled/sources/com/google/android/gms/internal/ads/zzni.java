package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzni {
    public static final zzni zza;
    public static final zzni zzb;
    public static final zzni zzc;
    public final long zzd;
    public final long zze;

    static {
        zzni zzniVar = new zzni(0L, 0L);
        zza = zzniVar;
        new zzni(Long.MAX_VALUE, Long.MAX_VALUE);
        zzb = new zzni(Long.MAX_VALUE, 0L);
        new zzni(0L, Long.MAX_VALUE);
        zzc = zzniVar;
    }

    public zzni(long j, long j2) {
        zzgtj.zza(j >= 0);
        zzgtj.zza(j2 >= 0);
        this.zzd = j;
        this.zze = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzni.class == obj.getClass()) {
            zzni zzniVar = (zzni) obj;
            if (this.zzd == zzniVar.zzd && this.zze == zzniVar.zze) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((int) this.zzd) * 31) + ((int) this.zze);
    }
}
