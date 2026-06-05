package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhfe {
    public static final zzhfe zza = new zzhfe("SHA1");
    public static final zzhfe zzb = new zzhfe("SHA224");
    public static final zzhfe zzc = new zzhfe("SHA256");
    public static final zzhfe zzd = new zzhfe("SHA384");
    public static final zzhfe zze = new zzhfe("SHA512");
    private final String zzf;

    private zzhfe(String str) {
        this.zzf = str;
    }

    public final String toString() {
        return this.zzf;
    }
}
