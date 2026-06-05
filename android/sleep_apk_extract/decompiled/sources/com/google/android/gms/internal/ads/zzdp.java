package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdp {
    public static final zzdp zza = new zzdp(0, 0, false);
    private final int zzb;
    private final int zzc;
    private final boolean zzd;

    private zzdp(int i, int i2, boolean z) {
        this.zzd = z;
        this.zzb = i;
        this.zzc = i2;
    }

    public final int zza() {
        zzgtj.zzi(this.zzd);
        return this.zzb;
    }

    public final int zzb() {
        zzgtj.zzi(this.zzd);
        return this.zzc;
    }

    public final boolean zzc() {
        return this.zzd;
    }

    public zzdp(int i, int i2) {
        this(i, i2, true);
    }
}
