package com.google.android.gms.ads;

/* JADX INFO: loaded from: classes5.dex */
public final class AdValue {
    private final int zza;
    private final String zzb;
    private final long zzc;

    private AdValue(int i, String str, long j) {
        this.zza = i;
        this.zzb = str;
        this.zzc = j;
    }

    public static AdValue zza(int i, String str, long j) {
        return new AdValue(i, str, j);
    }

    public String getCurrencyCode() {
        return this.zzb;
    }

    public long getValueMicros() {
        return this.zzc;
    }
}
