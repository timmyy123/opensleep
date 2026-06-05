package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhot {
    public static final zzhot zza = new zzhot("SHA1");
    public static final zzhot zzb = new zzhot("SHA224");
    public static final zzhot zzc = new zzhot("SHA256");
    public static final zzhot zzd = new zzhot("SHA384");
    public static final zzhot zze = new zzhot("SHA512");
    private final String zzf;

    private zzhot(String str) {
        this.zzf = str;
    }

    public final String toString() {
        return this.zzf;
    }
}
