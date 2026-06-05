package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzbkw {
    public static final zzbka zza = zzbka.zza("gads:adapter_initialization:red_button", false);
    public static final zzbka zzb = zzbka.zza("gads:adapter_settings:red_button", false);
    public static final zzbka zzc;
    public static final zzbka zzd;
    public static final zzbka zze;
    public static final zzbka zzf;
    public static final zzbka zzg;

    static {
        zzbka.zza("gads:ads_service_force_stop:red_button", true);
        zzc = zzbka.zza("gads:mediation_serving_domain:red_button", false);
        zzd = zzbka.zza("gads:banner_refresh_sequential_caching:red_button", false);
        zzbka.zza("gads:ad_serving:enabled", true);
        zzbka.zza("gads:ad_preloading:enabled", true);
        zze = zzbka.zza("gads:adaptive_banner:fail_invalid_ad_size", true);
        zzbka.zza("gads:return_null_ads_preloader_from_remote_creator", false);
        zzbka.zza("gads:sdk_use_dynamic_module", true);
        zzf = zzbka.zza("gads:signal_adapters:red_button", false);
        zzg = zzbka.zza("gads:use_non_templated_client_sdkcore:enabled", false);
        zzbka.zza("gads:use_non_templated_mediation_client_sdkcore:enabled", false);
    }
}
