package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzblf {
    public static final zzbka zza = zzbka.zza("gads:trustless_token_for_decagon:enabled", true);
    public static final zzbka zzb;

    static {
        zzbka.zza("gads:invalidate_token_at_refresh_start", true);
        zzbka.zza("gms:expose_token_for_gma:enabled", true);
        zzbka.zza("gads:referesh_rate_limit", false);
        zzb = zzbka.zzb("gads:timeout_for_trustless_token:millis", 2000L);
        zzbka.zza("gads:token_anonymization:enabled", true);
        zzbka.zzb("gads:cached_token:ttl_millis", 10800000L);
    }
}
