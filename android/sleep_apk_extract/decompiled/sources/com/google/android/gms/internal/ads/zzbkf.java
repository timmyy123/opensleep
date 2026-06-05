package com.google.android.gms.internal.ads;

import com.facebook.AuthenticationTokenClaims;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzbkf {
    public static final zzbka zza = zzbka.zzb("gads:app_permissions_caching_expiry_ms:expiry", 60000);
    public static final zzbka zzb = zzbka.zzb("gads:audio_caching_expiry_ms:expiry", 5000);
    public static final zzbka zzc = zzbka.zzb("gads:battery_caching_expiry_ms:expiry", 10000);
    public static final zzbka zzd = zzbka.zzb("gads:device_info_caching_expiry_ms:expiry", 300000);
    public static final zzbka zze = zzbka.zzb("gads:hsdp_caching_expiry_ms:expiry", AuthenticationTokenClaims.MAX_TIME_SINCE_TOKEN_ISSUED);
    public static final zzbka zzf = zzbka.zzb("gads:memory_caching_expiry_ms:expiry", 5000);
    public static final zzbka zzg = zzbka.zzb("gads:sdk_environment_caching_expiry_ms:expiry", AuthenticationTokenClaims.MAX_TIME_SINCE_TOKEN_ISSUED);
    public static final zzbka zzh = zzbka.zzb("gads:telephony_caching_expiry_ms:expiry", 5000);
}
