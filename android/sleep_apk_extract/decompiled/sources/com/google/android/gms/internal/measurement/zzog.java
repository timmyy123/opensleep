package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes3.dex */
public final class zzog {
    private final String zza = "com.google.android.gms.measurement";
    private final zzph zzb;

    public zzog(String str, zzph zzphVar) {
        this.zzb = zzphVar;
    }

    public final zzom zza(String str, boolean z) {
        return new zznx(this.zza, str, this.zzb, z);
    }

    public final zzom zzb(String str, long j) {
        return new zzob(this.zza, str, this.zzb, j);
    }

    public final zzom zzc(String str, double d) {
        return new zznz(this.zza, "measurement.test.double_flag", this.zzb, -3.0d);
    }

    public final zzom zzd(String str, String str2) {
        return new zzod(this.zza, str, this.zzb, str2);
    }
}
