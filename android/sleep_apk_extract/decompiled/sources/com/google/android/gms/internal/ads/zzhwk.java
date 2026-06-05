package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhwk {
    public static final zzhwk zza = new zzhwk("SHA256");
    public static final zzhwk zzb = new zzhwk("SHA384");
    public static final zzhwk zzc = new zzhwk("SHA512");
    private final String zzd;

    private zzhwk(String str) {
        this.zzd = str;
    }

    public final String toString() {
        return this.zzd;
    }
}
