package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzbkk {
    public static final zzbka zza;

    static {
        zzbka.zzc("gads:csi_reporting_ratio", 0.05d);
        zza = new zzbka("gads:sdk_csi_server", "https://csi.gstatic.com/csi", 4);
        zzbka.zza("gads:enabled_sdk_csi", false);
    }
}
