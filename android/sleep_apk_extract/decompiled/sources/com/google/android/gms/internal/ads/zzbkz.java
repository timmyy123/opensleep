package com.google.android.gms.internal.ads;

import oauth.signpost.OAuth;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzbkz {
    public static final zzbka zza = zzbka.zzb("gads:dynamite_load:fail:sample_rate", 10000);
    public static final zzbka zzb = zzbka.zza("gads:report_dynamite_crash_in_background_thread", false);
    public static final zzbka zzc = new zzbka("gads:public_beta:traffic_multiplier", OAuth.VERSION_1_0, 4);
    public static final zzbka zzd = new zzbka("gads:sdk_crash_report_class_prefix", "com.google.", 4);
    public static final zzbka zze;
    public static final zzbka zzf;

    static {
        zzbka.zza("gads:sdk_crash_report_enabled", false);
        zze = zzbka.zza("gads:sdk_crash_report_full_stacktrace", false);
        zzf = zzbka.zzc("gads:trapped_exception_sample_rate", 0.01d);
    }
}
